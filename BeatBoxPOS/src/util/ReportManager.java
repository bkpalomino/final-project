package util;

import entity.InventoryItem;
import entity.Logon;
import entity.Order;
import entity.Person;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
Author: Braeden Palomino
Date: 11/14/24
Description: Util static class that serves as an html report generator. 
 */
public class ReportManager {

    // Generates customer html receipt. Params : CartManager object
    public static void generateCustomerReceipt(CartManager cart) {
        // Load in the template resource. Instantiate all elements for template
        InputStream inputStream = ResourceLoader.getResourceInputStream("templates/receipt.html");

        // Generate all Html and string vals
        Person customer = cart.getCustomerPanel().getCustomer();

        String strOrderDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String strOrderDateAlt = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        String strOrderID = String.valueOf(DatabaseManager.getLatestOrderID());
        String strCustomerName = customer.getNameFirst() + " " + customer.getNameLast();
        String strCustomerAddress = customer.getAddressOne();
        String strCustomerZipcode = customer.getZipcode();
        String strOrderSubtotal = CartManager.doubleAsCurrency(cart.getSubtotal(false));
        String strTaxRate = CartManager.doubleAsPercantage(cart.getTaxRate());
        String strOrderTax = CartManager.doubleAsCurrency(cart.getTax());
        String strOrderTotal = CartManager.doubleAsCurrency(cart.getTotal());
        StringBuilder tableHtml = new StringBuilder();
        String tableRowBlock = """
                               <tr>
                               <td>{ITEM-NAME}</td>
                               <td>{ITEM-COST}</td>
                               <td>{ITEM-QTY}</td>
                               <td class="text-end">{ITEM-TOTAL}</td>
                               </tr>
                               """;
        String discountBlock = """
                               <tr>
                                  <td class="text-bold" colspan="4" style="text-align: end">Code "{CODE}": {DESCRIPTION}</td>
                               </tr>
                               """;
        String finalDiscountBlock = """
                                    <div class="invoice-body-info-item border-bottom">
                                         <div class="info-item-td text-end text-bold">Discount {DISCOUNT-TYPE}</div>
                                         <div class="info-item-td text-end">-({DISCOUNT-SAVED})</div>
                                   </div>
                                   <div class="invoice-body-info-item border-bottom">
                                        <div class="info-item-td text-end text-bold">Discounted Subtotal:</div>
                                        <div class="info-item-td text-end">{DISCOUNT-SUBTOTAL}</div>
                                   </div>
                                   """;
        Person curUser = StateManager.getCurrentUser();
        String strEmployee = (curUser.getLogon().getPositionTitle().equals("Employee")
                || curUser.getLogon().getPositionTitle().equals("Manager")) ? curUser.getNameFirst() + " " + curUser.getNameLast() : "None";

        // Since the amount of products varies, we will loop through the carts items to generate the html
        for (String[] strArray : cart.getCartStringValues()) {
            String filledTableRowBlock = "";

            switch (strArray[0]) {
                case "Item":
                    filledTableRowBlock = tableRowBlock.replace("{ITEM-NAME}", strArray[1]);
                    filledTableRowBlock = filledTableRowBlock.replace("{ITEM-COST}", strArray[3]);
                    filledTableRowBlock = filledTableRowBlock.replace("{ITEM-QTY}", strArray[4]);
                    filledTableRowBlock = filledTableRowBlock.replace("{ITEM-TOTAL}", strArray[5]);
                    break;

                case "Discount":
                    filledTableRowBlock = discountBlock.replace("{CODE}", strArray[1]);
                    filledTableRowBlock = filledTableRowBlock.replace("{DESCRIPTION}", strArray[2]);
                    break;
            }

            tableHtml.append(filledTableRowBlock);

        }

        // Now we can start reading and writing
        try {
            // Create all files, writers, readers, and folders.
            String reportFileName = "receipt_" + strOrderDateAlt + "_" + strOrderID + ".html";
            File documentsDir = new File(System.getProperty("user.home"), "Documents");
            File receiptsFolder = new File(documentsDir, "BeatBOX_Receipts");

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder templateBuilder = new StringBuilder();

            // If the receipts folder doesn't exist, create it.
            if (!receiptsFolder.exists()) {
                receiptsFolder.mkdir();
            }

            // Read in the template and get it into a string
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains("<!-- Discounted Subtotal -->") && cart.isDiscountUsed()) {
                    String dis = cart.getDiscount().getDiscountTypeStr();
                    String sav = CartManager.doubleAsCurrency(cart.getTotalSaved());
                    String tot = CartManager.doubleAsCurrency(cart.getSubtotal(true));

                    line = finalDiscountBlock.replace("{DISCOUNT-TYPE}", dis);
                    line = line.replace("{DISCOUNT-SAVED}", sav);
                    line = line.replace("{DISCOUNT-SUBTOTAL}", tot);
                }

                templateBuilder.append(line).append("\n");
            }
            reader.close();

            // Now that we have the template, fill it out using the generated data.
            String template = templateBuilder.toString();

            // Fill in the data account for any added rows by discount
            template = template.replace("{ORDER-DATE}", strOrderDate);
            template = template.replace("{ORDER-ID}", strOrderID);
            template = template.replace("{EMPLOYEE}", strEmployee);
            template = template.replace("{CUSTOMER-NAME}", strCustomerName);
            template = template.replace("{CUSTOMER-ADDRESS}", strCustomerAddress);
            template = template.replace("{CUSTOMER-ZIPCODE}", strCustomerZipcode);
            template = template.replace("{TABLE}", tableHtml.toString());
            template = template.replace("{SUBTOTAL}", strOrderSubtotal);
            template = template.replace("{TAXRATE}", strTaxRate);
            template = template.replace("{TAX}", strOrderTax);
            template = template.replace("{TOTAL}", strOrderTotal);

            // With the filled out template, we can now write to a new html file, save, and open
            File reportFile = new File(receiptsFolder, reportFileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile));
            writer.write(template);
            writer.close();

            // if the file exits, open it.
            if (reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            } else {
                System.out.println("Could not generate report, file not found");
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void generateSalesReport(Person customer, LocalDate start, LocalDate end, ArrayList<Order> orders, ArrayList<CartManager> sales) {
        // Load in the template resource. Instantiate all elements for template
        InputStream inputStream = ResourceLoader.getResourceInputStream("templates/sales-report.html");

        // Generate all Html and string vals
        String strGenerationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
        String strCustomerName = (customer != null) ? customer.getNameFirst() + " " + customer.getNameLast().substring(0, 1) : "All Customers";
        String strTimeRange = start.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy")) + " to " + end.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
        StringBuilder tableHtml = new StringBuilder();
        String tableRowBlock = """
                               <tr>
                                  <td>{ORDER-ID}</td>
                                  <td>{CUSTOMER-ID}</td>
                                  <td>{EMPLOYEE-ID}</td>
                                  <td>{DATE}</td>
                                  <td>{TOTAL-ITEMS}</td>
                                  <td>{TOTAL}</td>
                               </tr>
                               """;

        double totalInSales = 0.00;
        int totalNumberOfSales = orders.size();

        // Since the amount of products varies, we will loop through the carts items to generate the html
        for (int i = 0; i < orders.size(); i++) {
            Order order = orders.get(i);
            CartManager cart = sales.get(i);
            String filledTableRowBlock = "";

            int cartCount = cart.getCartCount();

            filledTableRowBlock = tableRowBlock.replace("{ORDER-ID}", String.valueOf(order.getOrderID()));
            filledTableRowBlock = filledTableRowBlock.replace("{CUSTOMER-ID}", String.valueOf(order.getPersonID()));
            filledTableRowBlock = filledTableRowBlock.replace("{EMPLOYEE-ID}", String.valueOf(order.getEmployeeID()));
            filledTableRowBlock = filledTableRowBlock.replace("{DATE}", order.getDate().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")));
            filledTableRowBlock = filledTableRowBlock.replace("{TOTAL-ITEMS}", String.valueOf(cart.getCartCount()));
            filledTableRowBlock = filledTableRowBlock.replace("{TOTAL}", String.valueOf(CartManager.doubleAsCurrency(cart.getTotal())));

            totalInSales += cart.getTotal();

            tableHtml.append(filledTableRowBlock);

        }

        // Now we can start reading and writing
        try {
            // Create all files, writers, readers, and folders.
            String reportFileName = "sales_report_" + strTimeRange + ".html";
            File documentsDir = new File(System.getProperty("user.home"), "Documents");
            File reportsFolder = new File(documentsDir, "BeatBOX_Reports");

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder templateBuilder = new StringBuilder();

            // If the receipts folder doesn't exist, create it.
            if (!reportsFolder.exists()) {
                reportsFolder.mkdir();
            }

            // Read in the template and get it into a string
            String line;
            while ((line = reader.readLine()) != null) {
                templateBuilder.append(line).append("\n");
            }
            reader.close();

            // Now that we have the template, fill it out using the generated data.
            String template = templateBuilder.toString();

            // Fill in the data account for any added rows by discount
            template = template.replace("{CUSTOMER-NAME}", strCustomerName);
            template = template.replace("{TIME-RANGE}", strTimeRange);
            template = template.replace("{TABLE-ORDER-DATA}", tableHtml.toString());
            template = template.replace("{TOTAL-SALES}", String.valueOf(totalNumberOfSales));
            template = template.replace("{TOTAL-AMOUNT}", CartManager.doubleAsCurrency(totalInSales));
            template = template.replace("{TODAYS-DATE}", strGenerationDate);

            // With the filled out template, we can now write to a new html file, save, and open
            File reportFile = new File(reportsFolder, reportFileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile));
            writer.write(template);
            writer.close();

            // if the file exits, open it.
            if (reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            } else {
                System.out.println("Could not generate report, file not found");
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void generatePersonReport(Person person) {
        // Load in the template resource. Instantiate all elements for template
        InputStream inputStream = ResourceLoader.getResourceInputStream("templates/person-report.html");

        Logon logon = person.getLogon();

        // Generate all Html and string vals
        String personID = String.valueOf(person.getPersonID());
        String title = (person.getTitle() != null) ? person.getTitle() : "N/A";
        String firstName = person.getNameFirst();
        String middleName = (person.getNameMiddle() != null) ? person.getNameMiddle() : "N/A";
        String lastName = person.getNameLast();
        String personName = firstName + " " + lastName.substring(0, 1);
        String suffix = (person.getSuffix() != null) ? person.getSuffix() : "N/A";
        String addressOne = person.getAddressOne();
        String addressTwo = (person.getAddressTwo() != null) ? person.getAddressTwo() : "N/A";
        String addressThree = (person.getAddressThree() != null) ? person.getAddressThree() : "N/A";
        String city = person.getCity();
        String zipcode = person.getZipcode();
        String state = person.getState();
        String email = (person.getEmail() != null) ? person.getEmail() : "N/A";
        String phonePrimary = (person.getPhonePrimary() != null) ? person.getPhonePrimary() : "N/A";
        String phoneSecondary = (person.getPhoneSecondary() != null) ? person.getPhoneSecondary() : "N/A";
        String personDeleted = (person.isPersonDeleted() != null) ? person.isPersonDeleted().toString() : "N/A";
        String image = "";

        try {
            InputStream is = person.getImage().getBinaryStream();
            byte[] imgBytes = is.readAllBytes();
            is.close();
            image = Base64.getEncoder().encodeToString(imgBytes);
        } catch (Exception ex) {
            System.out.println("Couldn't generate base 64 for image: " + ex.getMessage());
        }

        String logonID = String.valueOf(logon.getLogonID());
        String logonName = logon.getLogonName();
        String positionTitle = logon.getPositionTitle();
        String accountDisabled = (logon.isAccountDisabled() != null) ? logon.isAccountDisabled().toString() : "N/A";
        String accountDeleted = (logon.isAccountDeleted() != null) ? logon.isAccountDeleted().toString() : "N/A";

        String strGenerationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));

        // Now we can start reading and writing
        try {
            // Create all files, writers, readers, and folders.
            String reportFileName = positionTitle + "_info_report_ID_" + personID + ".html";
            File documentsDir = new File(System.getProperty("user.home"), "Documents");
            File reportsFolder = new File(documentsDir, "BeatBOX_Reports");

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder templateBuilder = new StringBuilder();

            // If the receipts folder doesn't exist, create it.
            if (!reportsFolder.exists()) {
                reportsFolder.mkdir();
            }

            // Read in the template and get it into a string
            String line;
            while ((line = reader.readLine()) != null) {
                templateBuilder.append(line).append("\n");
            }
            reader.close();

            // Now that we have the template, fill it out using the generated data.
            String template = templateBuilder.toString();

            // Additional placeholders for person data
            template = template.replace("{CUSTOMER-NAME}", personName);
            template = template.replace("{PERSON-ID}", personID);
            template = template.replace("{TITLE}", title);
            template = template.replace("{FIRST-NAME}", firstName);
            template = template.replace("{MIDDLE-NAME}", middleName);
            template = template.replace("{LAST-NAME}", lastName);
            template = template.replace("{SUFFIX}", suffix);
            template = template.replace("{ADDRESS-ONE}", addressOne);
            template = template.replace("{ADDRESS-TWO}", addressTwo);
            template = template.replace("{ADDRESS-THREE}", addressThree);
            template = template.replace("{CITY}", city);
            template = template.replace("{ZIPCODE}", zipcode);
            template = template.replace("{STATE}", state);
            template = template.replace("{EMAIL}", email);
            template = template.replace("{PHONE-PRIMARY}", phonePrimary);
            template = template.replace("{PHONE-SECONDARY}", phoneSecondary);
            template = template.replace("{IMAGE-TEST}", image);
            template = template.replace("{PERSON-DELETED}", personDeleted);

            // Additional placeholders for logon data
            template = template.replace("{LOGON-ID}", logonID);
            template = template.replace("{LOGON-NAME}", logonName);
            template = template.replace("{POSITION-TITLE}", positionTitle);
            template = template.replace("{ACCOUNT-DISABLED}", accountDisabled);
            template = template.replace("{ACCOUNT-DELETED}", accountDeleted);

            template = template.replace("{TODAYS-DATE}", strGenerationDate);

            // With the filled out template, we can now write to a new html file, save, and open
            File reportFile = new File(reportsFolder, reportFileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile));
            writer.write(template);
            writer.close();

            // if the file exits, open it.
            if (reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            } else {
                System.out.println("Could not generate report, file not found");
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void generateInventoryReport(ArrayList<InventoryItem> inventory) {
        // Load in the template resource. Instantiate all elements for template
        InputStream inputStream = ResourceLoader.getResourceInputStream("templates/inventory-report.html");

        // Generate all Html and string vals
        String strGenerationDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        StringBuilder tableHtml = new StringBuilder();
        String totalItems = String.valueOf(inventory.size());
        String tableRowBlock = """
                               <tr class="{CLASS}">
                                  <td>{ID}</td>
                                  <td>{NAME}</td>
                                  <td>{CATEGORY ID}</td>
                                  <td>{RETAIL PRICE}</td>
                                  <td>{COST}</td>
                                  <td>{QUANTITY}</td>
                                  <td>{RESTOCK THRESHOLD}</td>
                                  <td>{DISCONTINUED}</td>
                               </tr>
                               """;

        // Since the amount of products varies, we will loop through the carts items to generate the html
        int restockAmount = 0;
        for (InventoryItem item : inventory) {
            String filledTableRowBlock = "";

            filledTableRowBlock = tableRowBlock.replace("{ID}", String.valueOf(item.getInventoryID()));
            filledTableRowBlock = filledTableRowBlock.replace("{NAME}", item.getItemName());
            filledTableRowBlock = filledTableRowBlock.replace("{CATEGORY ID}", String.valueOf(item.getCategoryId()));
            filledTableRowBlock = filledTableRowBlock.replace("{RETAIL PRICE}", CartManager.doubleAsCurrency(item.getRetailPrice()));
            filledTableRowBlock = filledTableRowBlock.replace("{COST}", CartManager.doubleAsCurrency(item.getCost()));
            filledTableRowBlock = filledTableRowBlock.replace("{QUANTITY}", String.valueOf(item.getQuantity()));
            filledTableRowBlock = filledTableRowBlock.replace("{RESTOCK THRESHOLD}", String.valueOf(item.getRestockThreshold()));
            filledTableRowBlock = filledTableRowBlock.replace("{DISCONTINUED}", String.valueOf(item.isDiscontinued()));

            if (item.getQuantity() < item.getRestockThreshold()) {
                filledTableRowBlock = filledTableRowBlock.replace("{CLASS}", "stock-warning out");
                restockAmount++;
            } else if (item.getQuantity() < item.getRestockThreshold() + 5) {
                filledTableRowBlock = filledTableRowBlock.replace("{CLASS}", "stock-warning close");
            } else {
                filledTableRowBlock = filledTableRowBlock.replace("{CLASS}", "");
            }

            tableHtml.append(filledTableRowBlock);
        }

        String strRestockAmount = String.valueOf(restockAmount);
        double health = ((inventory.size() - restockAmount) * 100) / inventory.size();
        String inventoryHealth = CartManager.doubleAsPercantage(health / 100);

        // Now we can start reading and writing
        try {
            // Create all files, writers, readers, and folders.
            String reportFileName = "inventory_report" + strGenerationDate + ".html";
            File documentsDir = new File(System.getProperty("user.home"), "Documents");
            File reportsFolder = new File(documentsDir, "BeatBOX_Reports");

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder templateBuilder = new StringBuilder();

            // If the receipts folder doesn't exist, create it.
            if (!reportsFolder.exists()) {
                reportsFolder.mkdir();
            }

            // Read in the template and get it into a string
            String line;
            while ((line = reader.readLine()) != null) {
                templateBuilder.append(line).append("\n");
            }
            reader.close();

            // Now that we have the template, fill it out using the generated data.
            String template = templateBuilder.toString();

            // Fill in the data account for any added rows by discount
            template = template.replace("{TABLE-CONTENT}", tableHtml.toString());
            template = template.replace("{TOTAL-ITEMS}", totalItems);
            template = template.replace("{RESTOCK-COUNT}", strRestockAmount);
            template = template.replace("{INVENTORY-HEALTH}", inventoryHealth);
            template = template.replace("{TODAYS-DATE}", strGenerationDate);

            // With the filled out template, we can now write to a new html file, save, and open
            File reportFile = new File(reportsFolder, reportFileName);
            BufferedWriter writer = new BufferedWriter(new FileWriter(reportFile));
            writer.write(template);
            writer.close();

            // if the file exits, open it.
            if (reportFile.exists()) {
                Desktop.getDesktop().browse(reportFile.toURI());
            } else {
                System.out.println("Could not generate report, file not found");
            }
        } catch (IOException ex) {
            Logger.getLogger(ReportManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
