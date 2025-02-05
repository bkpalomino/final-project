package util;

import entity.Logon;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;


/*
Author: Braeden Palomino
Date: 10/03/24
Description: Util class that handles all validation for user input.
 */
public class ValidationManager {

    public static ArrayList<Boolean> validateUsername(String user) {
        ArrayList<Boolean> validityChecks = new ArrayList<>();

        char[] usernameArray = user.toCharArray();

        try {
            // Req 1: check first character
            if (!Character.isDigit(usernameArray[0])) {
                validityChecks.add(true);
            } else {
                validityChecks.add(false);
            }

            // Req 2: check characters
            boolean allLettersOrDigits = true;
            for (char c : usernameArray) {
                if (!Character.isLetterOrDigit(c)) {
                    allLettersOrDigits = false;
                    break;
                }
            }
            validityChecks.add(allLettersOrDigits);

            // Req 3: check length
            if (usernameArray.length >= 8 && usernameArray.length <= 20) {
                validityChecks.add(true);
            } else {
                validityChecks.add(false);
            }
        } catch (Exception ex) {
            validityChecks.clear();
            validityChecks.add(false);
            validityChecks.add(false);
            validityChecks.add(false);
        }

        return validityChecks;
    }

    public static boolean usernameExists(String user) {
        boolean result = false;

        ArrayList<String> allUsernames = DatabaseManager.getAllUsernames();

        for (String uName : allUsernames) {
            if (user.toLowerCase().equals(uName.toLowerCase())) {
                result = true;
            }
        }

        return result;
    }

    public static ArrayList<Boolean> validatePassword(String pass) {
        ArrayList<Boolean> validityChecks = new ArrayList<>();
        boolean check = false;

        char[] passwordArray = pass.toCharArray();

        try {
            // Req 1: check length (REQUIRED)
            if (passwordArray.length >= 8 && passwordArray.length <= 20) {
                check = true;
            }

            validityChecks.add(check);

            // Req 2: check for uppercase characters
            check = false;
            for (char c : passwordArray) {
                if (Character.isUpperCase(c)) {
                    check = true;
                    break;
                }
            }

            validityChecks.add(check);

            // Req 3: check for lowercase characters
            check = false;
            for (char c : passwordArray) {
                if (Character.isLowerCase(c)) {
                    check = true;
                    break;
                }
            }

            validityChecks.add(check);

            // Req 4: check for digits
            check = false;
            for (char c : passwordArray) {
                if (Character.isDigit(c)) {
                    check = true;
                    break;
                }
            }

            validityChecks.add(check);

            // Req 5: check for special characters
            check = false;
            for (char c : passwordArray) {
                if (!Character.isLetterOrDigit(c)) {
                    if (c == '(' || c == ')' || c == '!' || c == '@' || c == '#' || c == '$'
                            || c == '%' || c == '^' || c == '&' || c == '&' || c == '*') {
                        check = true;
                    } else {
                        throw new Exception();
                    }
                }
            }

            validityChecks.add(check);

        } catch (Exception ex) {
            validityChecks.clear();
            validityChecks.add(false);
            validityChecks.add(false);
            validityChecks.add(false);
            validityChecks.add(false);
            validityChecks.add(false);
        }

        return validityChecks;
    }

    public static boolean validateResetPassword(String currentPassword, String newPassword) {
        boolean valid = true;

        if (currentPassword.equals(newPassword)) {
            valid = false;
        }

        return valid;
    }

    public static ArrayList<Boolean> validateSecurityQuestions(String aOne, String aTwo, String aThree) {
        ArrayList<Boolean> validityChecks = new ArrayList<>();

        // Validate Question Answer One
        if (!aOne.isBlank() || !aOne.isEmpty()) {
            validityChecks.add(true);
        } else {
            validityChecks.add(false);
        }

        // Validate Question Answer Two
        if (!aTwo.isBlank() || !aTwo.isEmpty()) {
            validityChecks.add(true);
        } else {
            validityChecks.add(false);
        }

        // Validate Question Answer Three
        if (!aThree.isBlank() || !aThree.isEmpty()) {
            validityChecks.add(true);
        } else {
            validityChecks.add(false);
        }

        return validityChecks;
    }

    public static boolean validateSecurityAnswers(Logon targetedAccount, String aOne, String aTwo, String aThree) {
        boolean valid = true;

        // Validate Question Answers
        if (!targetedAccount.getFirstChallengeAnswer().equalsIgnoreCase(aOne)) {
            valid = false;
        }
        if (!targetedAccount.getSecondChallengeAnswer().equalsIgnoreCase(aTwo)) {
            valid = false;
        }
        if (!targetedAccount.getThirdChallengeAnswer().equalsIgnoreCase(aThree)) {
            valid = false;
        }

        return valid;
    }

    public static ArrayList<Boolean> validateContactInformation(String title, String fName, String lName, String email, String phoneOne, String phoneTwo) {
        ArrayList<Boolean> validityChecks = new ArrayList<>();
        boolean validTitle;
        boolean validName;
        boolean validEmail;
        boolean validPhone;

        String regexPattern;
        Pattern pattern;
        Matcher matcher;

        // Title check
        validTitle = true;

        if (title.length() > 0) {
            regexPattern = "^[A-Z](?:[a-zA-Z]\\.|[a-zA-Z])*$"; // Aabcd
            pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(title);

            validTitle = matcher.find();
        }

        validityChecks.add(validTitle);

        // First Name check
        regexPattern = "^[A-Z][a-z]+$"; // Aabcd
        pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(fName);

        validName = matcher.find();

        validityChecks.add(validName);

        // Last Name check 
        regexPattern = "^[A-Za-z]+(?:\\s[A-Za-z]+)?$"; // Aabcd
        pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(lName);

        validName = matcher.find();

        validityChecks.add(validName);

        // Email check (OPTIONAL)
        validEmail = true;
        // check if email is greater than 0
        if (email.length() > 0) {

            regexPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
            pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(email);
            validEmail = matcher.find();

        }

        validityChecks.add(validEmail);

        // Phone checks
        validPhone = true;

        if (phoneOne.length() > 0) {
            regexPattern = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$"; // Aabcd
            pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(phoneOne);
            validPhone = matcher.find();
        }

        validityChecks.add(validPhone);

        // Phone 2
        validPhone = true;

        if (phoneTwo.length() > 0) {
            regexPattern = "^[0-9]{3}-[0-9]{3}-[0-9]{4}$"; // Aabcd
            pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(phoneTwo);
            validPhone = matcher.find();
        }

        validityChecks.add(validPhone);

        return validityChecks;
    }

    public static ArrayList<Boolean> validateShippingInformation(String adr1, String adr2, String adr3, String city, String zipcode) {
        ArrayList<Boolean> validityChecks = new ArrayList<>();
        boolean validAdr, validCity, validZipcode;
        String regexPattern;
        Pattern pattern;
        Matcher matcher;

        // Address 1 check (Name/Action Title)
        regexPattern = "^[A-Za-z]+(?:\\s[A-Za-z0-9()-]+)*(?:,\\s[A-Za-z]+(?:\\s[A-Za-z]+)*)?$"; // Can Contain multiple sequences (abc), (abc, abc), (abc abc) can contain 123 as well after initial abc
        pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(adr1);
        validAdr = matcher.find();

        validityChecks.add(validAdr);

        // Address 2 check (PO Box) 
        validAdr = true;
        if (adr2.length() > 0) {
            regexPattern = "^Box\\s[0-9]+"; // Must contain Box folowed by space and 5 digits
            pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(adr2);

            validAdr = matcher.find();
        }

        validityChecks.add(validAdr);

        // Address 3 check 
        validAdr = true;
        if (adr3.length() > 0) {
            regexPattern = "^(?:CPR|OPC|PSC|UPR|UNIT)\\s[0-9]{1,4}\\sBOX\\s[0-9]{2,3}$"; // try for military first
            pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
            matcher = pattern.matcher(adr3);

            validAdr = matcher.find();

            if (validAdr == false) {
                regexPattern = "^[0-9]{3,4}(?:\\s[A-Za-z]+)+\\s[0-9]{1,4}[A-Z]?$|^[0-9]{3,4}(?:\\s[A-Za-z]+)+$"; // try for regular address next
                pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(adr3);

                validAdr = matcher.find();
            }
        }

        validityChecks.add(validAdr);

        // City check
        regexPattern = "^[A-Z][a-z]+$"; // Aabcd
        pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(city);
        validCity = matcher.find();

        validityChecks.add(validCity);

        // Zipcode check        
        regexPattern = "^[0-9]{5}(?:-[0-9]{4})?$";
        pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(zipcode);
        validZipcode = matcher.find();

        validityChecks.add(validZipcode);

        return validityChecks;
    }

    public static ArrayList<Boolean> validateCardInformation(String holderName, String cardNumber, String expirationDate, String cvc, ArrayList<JLabel> labels) {
        ArrayList<Boolean> validityChecks = new ArrayList<>();
        boolean validHolder, validCard, validExpiration, validCvc;
        String regexPattern;
        Pattern pattern;
        Matcher matcher;

        // Holder Name check
        regexPattern = "^[A-Z][a-z]+\\s[A-Za-z]+(?:\\s[A-Za-z]+)?$";
        pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(holderName);
        validHolder = matcher.find();

        if (validHolder) {
            labels.get(0).setText(" ");
        } else {
            labels.get(0).setText("Incorrect format. Must follow \"Abc Xyz\". EX: \"John Doe\"");
        }

        validityChecks.add(validHolder);

        // Card Number check
        regexPattern = "^(?:\\d{4}[-]+){3}\\d{4}$";
        pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(cardNumber);
        validCard = matcher.find();

        if (validCard) {
            labels.get(1).setText(" ");
        } else {
            labels.get(1).setText("Incorrect format. Must follow ####-####-####-####");
        }

        validityChecks.add(validCard);

        // Valid Expiration Date
        regexPattern = "^(?:[0][1-9]|[1][0-2])\\/(?:20\\d{2}|[1-9]\\d{1})$";
        pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(expirationDate);
        validExpiration = matcher.find();

        String expirationText = (validExpiration) ? " " : "Incorrect Format. Must follow \"MM/yy or MM/yyyy\"";

        if (validExpiration) {
            String[] dateParts = expirationDate.split("/");
            int enteredMonth = Integer.parseInt(dateParts[0]);
            int enteredYear = (dateParts[1].length() == 2) ? 2000 + Integer.parseInt(dateParts[1]) : Integer.parseInt(dateParts[1]);

            LocalDate currentDate = LocalDate.now();
            LocalDate enteredDate = LocalDate.of(enteredYear, enteredMonth, 1);

            LocalDate fiveYearsAgo = currentDate.minusYears(5);
            
            if (enteredDate.isBefore(fiveYearsAgo)) {
                expirationText = "Out of date. Oldest date allowed is 5 years from the current date.";
                validExpiration = false;
            }
        }

        if (validExpiration) {
            labels.get(2).setText(" ");
        } else {
            labels.get(2).setText(expirationText);
        }

        validityChecks.add(validExpiration);

        // Valid CVC
        regexPattern = "^\\d{3}$";
        pattern = Pattern.compile(regexPattern, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(cvc);
        validCvc = matcher.find();

        validityChecks.add(validCvc);

        if (validCvc) {
            labels.get(3).setText(" ");
        } else {
            labels.get(3).setText("Incorrect Format. Must follow ###. Ex: \"123\"");
        }

        return validityChecks;
    }

    public static ArrayList<Boolean> validateItemEdits(String name, String retailPrice, String cost, String quantity, String restockThreshold, String description) {
        ArrayList<Boolean> validityChecks = new ArrayList<>();
        boolean validName, validRetailCost, validCost, validQuantity, validRestockThreshold, validDescription;

        // Name check       
        validName = !name.isEmpty();

        // Retail price check
        try {
            Double.parseDouble(retailPrice);
            validRetailCost = true;
        } catch (Exception ex) {
            validRetailCost = false;
        }

        // Cost check
        try {
            Double.parseDouble(cost);
            validCost = true;
        } catch (Exception ex) {
            validCost = false;
        }

        // Quantity check
        try {
            Integer.parseInt(quantity);                 
            validQuantity = true;
        } catch (Exception ex) {
            validQuantity = false;
        }
        
        // Restock Threshold check
        try {
            Integer.parseInt(restockThreshold);
            validRestockThreshold = true;
        } catch (Exception ex) {
            validRestockThreshold = false;
        }
        
        // Description check       
        validDescription = !description.isEmpty();
        
        
        
        validityChecks.add(validName);
        validityChecks.add(validRetailCost);
        validityChecks.add(validCost);
        validityChecks.add(validQuantity);
        validityChecks.add(validRestockThreshold);
        validityChecks.add(validDescription);
        
        
        return validityChecks;
    }
    
}
