package util;

import com.mysql.cj.jdbc.Blob;
import entity.Category;
import entity.Discount;
import entity.InventoryItem;
import entity.Logon;
import entity.Notification;
import entity.Order;
import entity.OrderDetail;
import entity.Person;
import entity.Position;
import entity.SecurityQuestion;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

/*
Author: Braeden Palomino
Date: 10/03/24
Description: Handles all connections and CRUD to database. Contains constants pertaining to sql.
 */
public class DatabaseManager {

    private static final String URL = "jdbc:mysql://13.58.236.216:3306/bpalominofa24";
    private static final String USERNAME = "bpalominofa24";
    private static final String PASSWORD = "cpt_Tstc1";

    private static final String SCHEMA_NAME = "bpalominofa24";

    public static final String DISCOUNT_START_DATE = "StartDate";
    public static final String DISCOUNT_EXPIRATION_DATE = "ExpirationDate";

    // ESTABLISH A CONNECTION
    public static Connection getConnection() {
        Connection connection = null;

        try {
            // Attempt to get connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException ex) {
            System.out.println("Cannot Establish Connection: " + ex.getMessage());
        }

        return connection;
    }

    // ------------------------------------------------------------------------------------
    //                            ----- RETRIEVE -----
    //------------------------------------------------------------------------------------
    // LOGON
    public static Logon getLogon(String logonName, String password) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Logon logon = null; // create null category

        String query = "SELECT * FROM " + SCHEMA_NAME + ".Logon WHERE LogonName = ? AND BINARY Password = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, logonName);
            ps.setString(2, password);

            rs = ps.executeQuery();

            // Loop through result set to create category
            if (rs.next()) {
                int logonID = rs.getInt("LogonID");
                int personID = rs.getInt("PersonID");
                String logName = rs.getString("LogonName");
                String pass = rs.getString("Password");
                int firstChalQ = rs.getInt("FirstChallengeQuestion");
                String firstChalA = rs.getString("FirstChallengeAnswer");
                int secondChalQ = rs.getInt("SecondChallengeQuestion");
                String secondChalA = rs.getString("SecondChallengeAnswer");
                int thirdChalQ = rs.getInt("ThirdChallengeQuestion");
                String thirdChalA = rs.getString("ThirdChallengeAnswer");
                String positionTitle = rs.getString("PositionTitle");
                boolean accountDisabled = rs.getBoolean("AccountDisabled");
                boolean accountDeleted = rs.getBoolean("AccountDeleted");

                logon = new Logon(logonID, personID, logName, pass, firstChalQ, firstChalA, secondChalQ, secondChalA, thirdChalQ, thirdChalA, positionTitle, accountDisabled, accountDeleted);
            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Username/Password Don't Match");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return logon;
    }

    public static Logon getLogon(String logonName) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Logon logon = null; // create null category

        String query = "SELECT * FROM " + SCHEMA_NAME + ".Logon WHERE LogonName = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, logonName);

            rs = ps.executeQuery();

            // Loop through result set to create category
            if (rs.next()) {
                int logonID = rs.getInt("LogonID");
                int personID = rs.getInt("PersonID");
                String logName = rs.getString("LogonName");
                String pass = rs.getString("Password");
                int firstChalQ = rs.getInt("FirstChallengeQuestion");
                String firstChalA = rs.getString("FirstChallengeAnswer");
                int secondChalQ = rs.getInt("SecondChallengeQuestion");
                String secondChalA = rs.getString("SecondChallengeAnswer");
                int thirdChalQ = rs.getInt("ThirdChallengeQuestion");
                String thirdChalA = rs.getString("ThirdChallengeAnswer");
                String positionTitle = rs.getString("PositionTitle");
                boolean accountDisabled = rs.getBoolean("AccountDisabled");
                boolean accountDeleted = rs.getBoolean("AccountDeleted");

                logon = new Logon(logonID, personID, logName, pass,
                        firstChalQ, firstChalA,
                        secondChalQ, secondChalA,
                        thirdChalQ, thirdChalA,
                        positionTitle, accountDisabled, accountDeleted);

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Username/Password Don't Match");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return logon;
    }

    public static Logon getLogon(int personID) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Logon logon = null; // create null category

        String query = "SELECT * FROM " + SCHEMA_NAME + ".Logon WHERE PersonID = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, personID);

            rs = ps.executeQuery();

            // Loop through result set to create category
            if (rs.next()) {
                int logonID = rs.getInt("LogonID");
                int pID = rs.getInt("PersonID");
                String logName = rs.getString("LogonName");
                String pass = rs.getString("Password");
                int firstChalQ = rs.getInt("FirstChallengeQuestion");
                String firstChalA = rs.getString("FirstChallengeAnswer");
                int secondChalQ = rs.getInt("SecondChallengeQuestion");
                String secondChalA = rs.getString("SecondChallengeAnswer");
                int thirdChalQ = rs.getInt("ThirdChallengeQuestion");
                String thirdChalA = rs.getString("ThirdChallengeAnswer");
                String positionTitle = rs.getString("PositionTitle");
                boolean accountDisabled = rs.getBoolean("AccountDisabled");
                boolean accountDeleted = rs.getBoolean("AccountDeleted");

                logon = new Logon(logonID, pID, logName, pass,
                        firstChalQ, firstChalA,
                        secondChalQ, secondChalA,
                        thirdChalQ, thirdChalA,
                        positionTitle, accountDisabled, accountDeleted);

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't retrieve Logon: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return logon;
    }

    public static ArrayList<String> getAllUsernames() {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<String> uList = new ArrayList<>();

        String query = "SELECT LogonName FROM " + SCHEMA_NAME + ".Logon";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                String logonName = rs.getString("LogonName");

                uList.add(logonName);
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println("Could Not Collect Usernames");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return uList;
    }

    // PERSON
    public static Person getPerson(int personID) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Person person = null; // create null category

        String query = "SELECT * FROM " + SCHEMA_NAME + ".Person WHERE PersonID = ?";

        try {
            connection = getConnection();

            ps = connection.prepareStatement(query);

            ps.setInt(1, personID);

            rs = ps.executeQuery();

            // Loop through result set to create category
            if (rs.next()) {
                int pID = rs.getInt("PersonID");
                String title = rs.getString("Title");
                String nameFirst = rs.getString("NameFirst");
                String nameMiddle = rs.getString("NameMiddle");
                String nameLast = rs.getString("NameLast");
                String suffix = rs.getString("Suffix");
                String addressOne = rs.getString("Address1");
                String addressTwo = rs.getString("Address2");
                String addressThree = rs.getString("Address3");
                String city = rs.getString("City");
                String zipcode = rs.getString("Zipcode");
                String state = rs.getString("State");
                String email = rs.getString("Email");
                String phonePrimary = rs.getString("PhonePrimary");
                String phoneSecondary = rs.getString("PhoneSecondary");
                Blob image = (Blob) rs.getBlob("Image");
                boolean personDeleted = rs.getBoolean("PersonDeleted");

                person = new Person(pID, title, nameFirst, nameMiddle, nameLast, suffix, addressOne, addressTwo,
                        addressThree, city, zipcode, state, email, phonePrimary, phoneSecondary, image, personDeleted);

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Username/Password Don't Match");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return person;
    }

    public static ArrayList<Person> getPeople(String search, String position) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Person> peopleList = new ArrayList<>();

        String searchString = (!search.isEmpty() && !search.isBlank())
                ? "NameFirst LIKE '%" + search + "%' OR NameLast LIKE '%" + search + "%' OR LogonName LIKE '%" + search + "%' OR Email LIKE '%" + search + "%'" : "";
        String positionString = (!position.equals("All Positions")) ? "PositionTitle = '" + position + "'" : "";

        StringBuilder query = new StringBuilder("SELECT Person.*, Logon.* FROM ").append(SCHEMA_NAME).append(".Person JOIN ").append(SCHEMA_NAME).append(".Logon ")
                .append("ON Logon.PersonID = Person.PersonID ");

        // Construct the query
        if (!searchString.isEmpty() && !positionString.isEmpty()) {
            query.append("WHERE ").append(searchString).append(" AND ").append(positionString);
        } else if (!searchString.isEmpty()) {
            query.append("WHERE ").append(searchString);
        } else if (!positionString.isEmpty()) {
            query.append("WHERE ").append(positionString);
        }

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                int pID = rs.getInt("PersonID");

                if (pID == StateManager.getCurrentUser().getPersonID()) {
                    continue;
                }

                String title = rs.getString("Title");
                String nameFirst = rs.getString("NameFirst");
                String nameMiddle = rs.getString("NameMiddle");
                String nameLast = rs.getString("NameLast");
                String suffix = rs.getString("Suffix");
                String addressOne = rs.getString("Address1");
                String addressTwo = rs.getString("Address2");
                String addressThree = rs.getString("Address3");
                String city = rs.getString("City");
                String zipcode = rs.getString("Zipcode");
                String state = rs.getString("State");
                String email = rs.getString("Email");
                String phonePrimary = rs.getString("PhonePrimary");
                String phoneSecondary = rs.getString("PhoneSecondary");
                Blob image = (Blob) rs.getBlob("Image");
                boolean personDeleted = rs.getBoolean("PersonDeleted");

                int logonID = rs.getInt("LogonID");
                String logName = rs.getString("LogonName");
                String pass = rs.getString("Password");
                int firstChalQ = rs.getInt("FirstChallengeQuestion");
                String firstChalA = rs.getString("FirstChallengeAnswer");
                int secondChalQ = rs.getInt("SecondChallengeQuestion");
                String secondChalA = rs.getString("SecondChallengeAnswer");
                int thirdChalQ = rs.getInt("ThirdChallengeQuestion");
                String thirdChalA = rs.getString("ThirdChallengeAnswer");
                String positionTitle = rs.getString("PositionTitle");
                boolean accountDisabled = rs.getBoolean("AccountDisabled");
                boolean accountDeleted = rs.getBoolean("AccountDeleted");

                Person person = new Person(pID, title, nameFirst, nameMiddle, nameLast, suffix, addressOne, addressTwo,
                        addressThree, city, zipcode, state, email, phonePrimary, phoneSecondary, image, personDeleted);

                Logon logon = new Logon(logonID, pID, logName, pass,
                        firstChalQ, firstChalA,
                        secondChalQ, secondChalA,
                        thirdChalQ, thirdChalA,
                        positionTitle, accountDisabled, accountDeleted);

                person.setLogon(logon);

                peopleList.add(person);
            }
        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Could Not Collect People: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return peopleList;
    }

    public static ArrayList<Person> getCustomersWithTitle(String title) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Person> people = new ArrayList<>(); // create null category

        String query = "SELECT * FROM " + SCHEMA_NAME + ".Logon WHERE PositionTitle = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, title);

            rs = ps.executeQuery();

            // Loop through result set to create category
            while (rs.next()) {
                int logID = rs.getInt("LogonID");
                int perID = rs.getInt("PersonID");
                String logName = rs.getString("LogonName");
                String pass = rs.getString("Password");
                int firstChalQ = rs.getInt("FirstChallengeQuestion");
                String firstChalA = rs.getString("FirstChallengeAnswer");
                int secondChalQ = rs.getInt("SecondChallengeQuestion");
                String secondChalA = rs.getString("SecondChallengeAnswer");
                int thirdChalQ = rs.getInt("ThirdChallengeQuestion");
                String thirdChalA = rs.getString("ThirdChallengeAnswer");
                String positionTitle = rs.getString("PositionTitle");
                boolean accountDisabled = rs.getBoolean("AccountDisabled");
                boolean accountDeleted = rs.getBoolean("AccountDeleted");

                if (accountDisabled || accountDeleted) {
                    continue;
                } else {
                    Logon logon = new Logon(logID, perID, logName, pass,
                            firstChalQ, firstChalA,
                            secondChalQ, secondChalA,
                            thirdChalQ, thirdChalA,
                            positionTitle, accountDisabled, accountDeleted);
                    Person person = getPerson(perID);

                    if (person != null) {
                        person.setLogon(logon);
                        people.add(person);
                    }

                }

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather customers");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return people;
    }

    // SECURITY QUESTION
    public static ArrayList<SecurityQuestion> getSecurityQuestion(Logon logon) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<SecurityQuestion> qList = new ArrayList<>();

        String query = "SELECT * FROM " + SCHEMA_NAME + ".SecurityQuestions WHERE QuestionID IN (?, ?, ?)";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, logon.getFirstChallengeQuestion());
            ps.setInt(2, logon.getSecondChallengeQuestion());
            ps.setInt(3, logon.getThirdChallengeQuestion());

            rs = ps.executeQuery();

            while (rs.next()) {
                int questionID = rs.getInt("QuestionID");
                int setID = rs.getInt("SetID");
                String questionPrompt = rs.getString("QuestionPrompt");

                qList.add(new SecurityQuestion(questionID, setID, questionPrompt));
            }
        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Could Not Collect Security Questions");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return qList;
    }

    public static ArrayList<SecurityQuestion> getAllSecurityQuestions() {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<SecurityQuestion> qList = new ArrayList<>();

        String query = "SELECT * FROM " + SCHEMA_NAME + ".SecurityQuestions";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int questionID = rs.getInt("QuestionID");
                int setID = rs.getInt("SetID");
                String questionPrompt = rs.getString("QuestionPrompt");

                qList.add(new SecurityQuestion(questionID, setID, questionPrompt));
            }
        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Could Not Collect Security Questions");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return qList;
    }

    // POSITION
    public static ArrayList<Position> getAllPositions() {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Position> pList = new ArrayList<>();

        String query = "SELECT * FROM " + SCHEMA_NAME + ".Position";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int positionID = rs.getInt("PositionID");
                String title = rs.getString("PositionTitle");

                pList.add(new Position(positionID, title));
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println("Could Not Collect Positions");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return pList;
    }

    // CATEGORY
    public static ArrayList<Category> getAllCategories() {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Category> categoryList = new ArrayList<>();

        String query = "SELECT * FROM " + SCHEMA_NAME + ".Categories";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next()) {
                int categoryID = rs.getInt("CategoryID");
                String categoryName = rs.getString("CategoryName");
                String categoryDescription = rs.getString("CategoryDescription");

                categoryList.add(new Category(categoryID, categoryName, categoryDescription));
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            System.out.println("Could Not Collect categories");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return categoryList;
    }

    // INVENTORY ITEM
    public static ArrayList<InventoryItem> getInventoryItems(String search, int categoryID, int limit, String orderBy, int offset) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<InventoryItem> itemList = new ArrayList<>();

        String searchString = (!search.isEmpty() && !search.isBlank()) ? "ItemName LIKE '%" + search + "%' OR ITemDescription LIKE '%" + search + "%'" : "";
        String categoryString = (categoryID >= 0) ? "CategoryID = " + String.valueOf(categoryID) : "";
        String[] orderParts = (!orderBy.equals("None")) ? orderBy.split(" ") : null;

        StringBuilder query = new StringBuilder("SELECT * FROM ").append(SCHEMA_NAME).append(".Inventory ");

        // Construct the query
        if (!searchString.isEmpty() && !categoryString.isEmpty()) {
            query.append("WHERE ").append(searchString).append(" AND ").append(categoryString);
        } else if (!searchString.isEmpty()) {
            query.append("WHERE ").append(searchString);
        } else if (!categoryString.isEmpty()) {
            query.append("WHERE ").append(categoryString);
        }
        if (orderParts != null) {
            String operator = (orderParts[0].equals("Highest")) ? " DESC" : " ASC";

            query.append(" ORDER BY ").append(orderParts[1]).append(operator);
        }
        query.append(" LIMIT ").append(limit).append(" OFFSET ").append(offset);

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                int inventoryID = rs.getInt("InventoryID");
                String itemName = rs.getString("ItemName");
                String itemDescription = rs.getString("ItemDescription");
                double retailPrice = rs.getDouble("RetailPrice");
                double cost = rs.getDouble("Cost");
                int quantity = rs.getInt("Quantity");
                int restockThreshold = rs.getInt("RestockThreshold");
                Blob itemImage = (Blob) rs.getBlob("ItemImage");
                boolean discontinued = rs.getBoolean("Discontinued");
                int categoryId = rs.getInt("CategoryId");

                itemList.add(new InventoryItem(inventoryID, itemName, itemDescription, retailPrice, cost, quantity, restockThreshold, itemImage, discontinued, categoryId));
            }
        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Could Not Collect Inventory Items");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return itemList;
    }

    public static InventoryItem getInventoryItem(int inventoryID) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        InventoryItem item = null;

        String query = "SELECT InventoryID, ItemName, ItemDescription, CategoryID, RetailPrice, Cost, Quantity, RestockThreshold, ItemImage, Discontinued"
                + " FROM " + SCHEMA_NAME + ".Inventory WHERE InventoryID = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, inventoryID);

            rs = ps.executeQuery();

            // Loop through result set to create category
            if (rs.next()) {
                int iID = rs.getInt("InventoryID");
                String itemName = rs.getString("ItemName");
                String itemDescription = rs.getString("ItemDescription");
                double retailPrice = rs.getDouble("RetailPrice");
                double cost = rs.getDouble("Cost");
                int quantity = rs.getInt("Quantity");
                int restockThreshold = rs.getInt("RestockThreshold");
                Blob itemImage = (Blob) rs.getBlob("ItemImage");
                boolean discontinued = rs.getBoolean("Discontinued");
                int categoryId = rs.getInt("CategoryId");

                item = new InventoryItem(iID, itemName, itemDescription, retailPrice, cost, quantity, restockThreshold, itemImage, discontinued, categoryId);
            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather count");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return item;
    }

    public static int getStockCount(int inventoryID) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int count = 0;

        String query = "SELECT Quantity FROM " + SCHEMA_NAME + ".Inventory WHERE InventoryID = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, inventoryID);

            rs = ps.executeQuery();

            // Loop through result set to create category
            if (rs.next()) {
                count = rs.getInt("Quantity");
            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather count");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return count;

    }

    public static ArrayList<Notification> getStockNotifications() {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Notification> notifications = new ArrayList<>();

        String query = "SELECT InventoryID, ItemName, Quantity, RestockThreshold FROM " + SCHEMA_NAME + ".Inventory WHERE Quantity < RestockThreshold;";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            // Loop through result set to create category
            while (rs.next()) {
                Notification notification = new Notification();

                notification.setTitle("Low Stock Warning");
                notification.setMessage("The item " + "\"" + rs.getString("ItemName") + "\" has fallen below the restock threshold of "
                        + rs.getInt("RestockThreshold") + " with a quantity of " + rs.getInt("Quantity") + " remaining");

                notifications.add(notification);
            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather notifications");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return notifications;
    }

    // DISCOUNTS
    public static Discount getDiscount(String promoCode) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Discount discount = null;

        String query = "SELECT * FROM " + SCHEMA_NAME + ".Discounts WHERE DiscountCode = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, promoCode);

            rs = ps.executeQuery();

            // Loop through result set to create category
            if (rs.next()) {
                int discountID = rs.getInt("DiscountID");
                String discountCode = rs.getString("DiscountCode");
                String description = rs.getString("Description");
                int discountLevel = rs.getInt("DiscountLevel");
                int inventoryID = rs.getInt("InventoryID");
                int discountType = rs.getInt("DiscountType");
                double discountPercentage = rs.getDouble("DiscountPercentage");
                double disountDollarAmount = rs.getDouble("DiscountDollarAmount");
                Date startDate = rs.getDate("StartDate");
                Date expirationDate = rs.getDate("ExpirationDate");
                Boolean unavailable = rs.getBoolean("Unavailable");

                Date today = Date.valueOf(LocalDate.now());

                if (startDate != null) {
                    if (today.before(startDate) || today.after(expirationDate)) {
                        discount = null;
                    } else {
                        discount = new Discount(discountID, discountCode, description, discountLevel, inventoryID,
                                discountType, discountPercentage, disountDollarAmount, startDate, expirationDate, unavailable);
                    }
                } else {
                    if (today.after(expirationDate)) {
                        discount = null;
                    } else {
                        discount = new Discount(discountID, discountCode, description, discountLevel, inventoryID,
                                discountType, discountPercentage, disountDollarAmount, startDate, expirationDate, unavailable);
                    }
                }

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("No Promo collected");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return discount;
    }

    public static Discount getDiscount(int discountID) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Discount discount = null;

        String query = "SELECT * FROM " + SCHEMA_NAME + ".Discounts WHERE DiscountID = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, discountID);

            rs = ps.executeQuery();

            // Loop through result set to create category
            if (rs.next()) {
                int dID = discountID;
                String discountCode = rs.getString("DiscountCode");
                String description = rs.getString("Description");
                int discountLevel = rs.getInt("DiscountLevel");
                int inventoryID = rs.getInt("InventoryID");
                int discountType = rs.getInt("DiscountType");
                double discountPercentage = rs.getDouble("DiscountPercentage");
                double disountDollarAmount = rs.getDouble("DiscountDollarAmount");
                Date startDate = rs.getDate("StartDate");
                Date expirationDate = rs.getDate("ExpirationDate");
                Boolean unavailable = rs.getBoolean("Unavailable");

                Date today = Date.valueOf(LocalDate.now());

                if (startDate != null) {
                    if (today.before(startDate) || today.after(expirationDate)) {
                        discount = null;
                    } else {
                        discount = new Discount(dID, discountCode, description, discountLevel, inventoryID,
                                discountType, discountPercentage, disountDollarAmount, startDate, expirationDate, unavailable);
                    }
                } else {
                    if (today.after(expirationDate)) {
                        discount = null;
                    } else {
                        discount = new Discount(dID, discountCode, description, discountLevel, inventoryID,
                                discountType, discountPercentage, disountDollarAmount, startDate, expirationDate, unavailable);
                    }
                }

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("No Promo collected");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return discount;
    }

    public static Date getDiscountDate(boolean latest, String columnDateType) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Date date = null;

        String query = (latest) ? "SELECT MAX(" + columnDateType + ") AS ? FROM " + SCHEMA_NAME + ".Discounts" : "SELECT MIN(" + columnDateType + ") AS ? FROM " + SCHEMA_NAME + ".Discounts";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setString(1, columnDateType);

            rs = ps.executeQuery();

            // Loop through result set
            if (rs.next()) {

                date = rs.getDate(columnDateType);

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather Date: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return date;
    }

    public static ArrayList<Discount> getDiscounts(String search) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Discount> discountList = new ArrayList<>();

        String searchString = (!search.isEmpty() && !search.isBlank())
                ? "DiscountCode LIKE '%" + search + "%' OR Description LIKE '%" + search + "%' OR StartDate LIKE '%" + search + "%' OR ExpirationDate LIKE '%" + search + "%'" : "";

        StringBuilder query = new StringBuilder("SELECT * FROM ").append(SCHEMA_NAME).append(".Discounts ");

        // Construct the query
        if (!searchString.isEmpty()) {
            query.append("WHERE ").append(searchString);
        }

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query.toString());
            rs = ps.executeQuery();

            while (rs.next()) {
                int discountID = rs.getInt("DiscountID");
                String discountCode = rs.getString("DiscountCode");
                String description = rs.getString("Description");
                int discountLevel = rs.getInt("DiscountLevel");
                Integer inventoryID = rs.getInt("InventoryID");
                int discountType = rs.getInt("DiscountType");
                double discountPercentage = rs.getDouble("DiscountPercentage");
                double disountDollarAmount = rs.getDouble("DiscountDollarAmount");
                Date startDate = rs.getDate("StartDate");
                Date expirationDate = rs.getDate("ExpirationDate");
                Boolean unavailable = rs.getBoolean("Unavailable");

                discountList.add(new Discount(discountID, discountCode, description, discountLevel, inventoryID,
                        discountType, discountPercentage, disountDollarAmount, startDate, expirationDate, unavailable));
            }
        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Could Not Collect Discounts: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return discountList;
    }

    // ORDERS
    public static int getLatestOrderID() {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        int id = 0;

        String query = "SELECT MAX(OrderID) AS 'Next' FROM " + SCHEMA_NAME + ".Orders";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            // Loop through result set to create category
            if (rs.next()) {
                id = rs.getInt("Next");

                id = (id == 0) ? 1 : id;
            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather results");
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return id;
    }

    public static ArrayList<Order> getOrders(Date start, Date end) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Order> orders = new ArrayList<>();

        String query = "SELECT " + SCHEMA_NAME + ".Orders.*, " + SCHEMA_NAME + ".OrderDetails.*\n"
                + "FROM Orders \n"
                + "JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID\n"
                + "WHERE OrderDate >= ? AND OrderDate <= ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setDate(1, start);
            ps.setDate(2, end);

            rs = ps.executeQuery();

            // Loop through result set
            ArrayList<OrderDetail> orderDetails = new ArrayList<>();
            Order curOrder = new Order();

            while (rs.next()) {
                int orderID = rs.getInt("OrderID");
                Integer discountID = rs.getInt("DiscountID");
                int personID = rs.getInt("PersonID");
                int employeeID = rs.getInt("EmployeeID");
                Date orderDate = rs.getDate("OrderDate");
                String cardNumber = rs.getString("CC_Number");
                String expDate = rs.getString("ExpDate");
                String ccv = rs.getString("CCV");

                int orderDetailsID = rs.getInt("OrderDetailsID");
                int inventoryID = rs.getInt("InventoryID");
                int quantity = rs.getInt("Quantity");

                if (curOrder.getOrderID()
                        == -1) {
                    curOrder.setOrderID(orderID);
                    curOrder.setEmployeeID(employeeID);
                    curOrder.setDiscountID(discountID);
                    curOrder.setPersonID(personID);
                    curOrder.setDate(orderDate.toLocalDate());
                    curOrder.setCardNumber(cardNumber);
                    curOrder.setExpDate(expDate);
                    curOrder.setCCV(ccv);

                } else if (curOrder.getOrderID()
                        != orderID) {
                    // Add the previous sale
                    curOrder.setDetails(new ArrayList(orderDetails));
                    orders.add(curOrder);

                    // set up a new sale
                    curOrder = new Order();
                    curOrder.setOrderID(orderID);
                    curOrder.setEmployeeID(employeeID);
                    curOrder.setDiscountID(discountID);
                    curOrder.setPersonID(personID);
                    curOrder.setDate(orderDate.toLocalDate());
                    curOrder.setCardNumber(cardNumber);
                    curOrder.setExpDate(expDate);
                    curOrder.setCCV(ccv);

                    orderDetails.clear();

                }

                orderDetails.add(new OrderDetail(orderDetailsID, orderID, inventoryID, discountID, quantity));

                if (rs.isLast()) {
                    curOrder.setDetails(orderDetails);
                    orders.add(curOrder);
                }

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather orders: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return orders;
    }

    public static ArrayList<Order> getOrders(int personID, Date start, Date end) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ArrayList<Order> orders = new ArrayList<>();

        String query = "SELECT " + SCHEMA_NAME + ".Orders.*, " + SCHEMA_NAME + ".OrderDetails.*\n"
                + "FROM Orders \n"
                + "JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID\n"
                + "WHERE OrderDate >= ? AND OrderDate <= ? AND PersonID = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setDate(1, start);
            ps.setDate(2, end);
            ps.setInt(3, personID);

            rs = ps.executeQuery();

            // Loop through result set
            ArrayList<OrderDetail> orderDetails = new ArrayList<>();
            Order curOrder = new Order();

            while (rs.next()) {
                int orderID = rs.getInt("OrderID");
                Integer discountID = rs.getInt("DiscountID");
                int pID = rs.getInt("PersonID");
                int employeeID = rs.getInt("EmployeeID");
                Date orderDate = rs.getDate("OrderDate");
                String cardNumber = rs.getString("CC_Number");
                String expDate = rs.getString("ExpDate");
                String ccv = rs.getString("CCV");

                int orderDetailsID = rs.getInt("OrderDetailsID");
                int inventoryID = rs.getInt("InventoryID");
                int quantity = rs.getInt("Quantity");

                if (curOrder.getOrderID()
                        == -1) {
                    curOrder.setOrderID(orderID);
                    curOrder.setEmployeeID(employeeID);
                    curOrder.setDiscountID(discountID);
                    curOrder.setPersonID(pID);
                    curOrder.setDate(orderDate.toLocalDate());
                    curOrder.setCardNumber(cardNumber);
                    curOrder.setExpDate(expDate);
                    curOrder.setCCV(ccv);

                } else if (curOrder.getOrderID()
                        != orderID) {
                    // Add the previous sale
                    curOrder.setDetails(new ArrayList(orderDetails));
                    orders.add(curOrder);

                    // set up a new sale
                    curOrder = new Order();
                    curOrder.setOrderID(orderID);
                    curOrder.setEmployeeID(employeeID);
                    curOrder.setDiscountID(discountID);
                    curOrder.setPersonID(pID);
                    curOrder.setDate(orderDate.toLocalDate());
                    curOrder.setCardNumber(cardNumber);
                    curOrder.setExpDate(expDate);
                    curOrder.setCCV(ccv);

                    orderDetails.clear();

                }

                orderDetails.add(new OrderDetail(orderDetailsID, orderID, inventoryID, discountID, quantity));

                if (rs.isLast()) {
                    curOrder.setDetails(orderDetails);
                    orders.add(curOrder);
                }

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather orders: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return orders;
    }

    public static Date getSaleDate(boolean latest) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Date date = null;

        String selectType = (latest) ? "SELECT MAX(OrderDate) AS 'OrderDate'\n" : "SELECT MIN(OrderDate) AS 'OrderDate'\n";
        String query = selectType
                + "FROM " + SCHEMA_NAME + ".Orders \n"
                + "JOIN " + SCHEMA_NAME + ".OrderDetails ON Orders.OrderID = OrderDetails.OrderID\n"
                + "JOIN " + SCHEMA_NAME + ".Inventory ON OrderDetails.InventoryID = Inventory.InventoryID";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            rs = ps.executeQuery();

            // Loop through result set
            if (rs.next()) {

                date = rs.getDate("OrderDate");

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather Date: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return date;
    }

    public static Date getSaleDate(int personID, boolean latest) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Date date = null;

        String selectType = (latest) ? "SELECT MAX(OrderDate) AS 'OrderDate'\n" : "SELECT MIN(OrderDate) AS 'OrderDate'\n";
        String query = selectType
                + "FROM " + SCHEMA_NAME + ".Orders \n"
                + "JOIN " + SCHEMA_NAME + ".OrderDetails ON Orders.OrderID = OrderDetails.OrderID\n"
                + "JOIN " + SCHEMA_NAME + ".Inventory ON OrderDetails.InventoryID = Inventory.InventoryID\n"
                + "WHERE PersonID = ?";

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, personID);

            rs = ps.executeQuery();

            // Loop through result set
            if (rs.next()) {

                date = rs.getDate("OrderDate");

            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather Date: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return date;
    }

    public static int getSalesCount(Date start, Date end) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT COUNT(OrderID) AS 'Count'\n"
                + "FROM " + SCHEMA_NAME + ".Orders \n"
                + "WHERE OrderDate >= ? AND OrderDate <= ?";

        int count = 0;

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setDate(1, start);
            ps.setDate(2, end);

            rs = ps.executeQuery();

            // Loop through result set
            if (rs.next()) {
                count = rs.getInt("Count");
            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather Sales: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return count;
    }

    public static int getSalesCount(int personID, Date start, Date end) {
        // Establish Connection
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT COUNT(OrderID) AS 'Count'\n"
                + "FROM " + SCHEMA_NAME + ".Orders \n"
                + "WHERE PersonID = ? AND OrderDate >= ? AND OrderDate <= ?";

        int count = 0;

        try {
            connection = getConnection();
            ps = connection.prepareStatement(query);

            ps.setInt(1, personID);
            ps.setDate(2, start);
            ps.setDate(3, end);

            rs = ps.executeQuery();

            // Loop through result set           
            if (rs.next()) {
                count = rs.getInt("Count");
            }

        } catch (SQLException ex) {
            // ex.printStackTrace();
            System.out.println("Couldn't gather Sales: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return count;
    }

    // ------------------------------------------------------------------------------------
    //                    ----- UPDATE AND CREATE (SAVE) -----
    // ------------------------------------------------------------------------------------
    // LOGON & PERSON
    public static boolean save(Person person, Logon logon) {
        Connection connection = null;
        PreparedStatement psPerson = null;
        PreparedStatement psLogon = null;
        ResultSet keys = null;
        boolean result = true;

        String personQuery = "INSERT INTO " + SCHEMA_NAME + ".Person (PersonID, Title, NameFirst, NameMiddle, NameLast, Suffix, Address1, Address2, Address3, City, Zipcode, State, Email, PhonePrimary, PhoneSecondary, Image, PersonDeleted) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "Title = VALUES(Title), "
                + "NameFirst = VALUES(NameFirst), "
                + "NameMiddle = VALUES(NameMiddle), "
                + "NameLast = VALUES(NameLast), "
                + "Suffix = VALUES(Suffix), "
                + "Address1 = VALUES(Address1), "
                + "Address2 = VALUES(Address2), "
                + "Address3 = VALUES(Address3), "
                + "City = VALUES(City), "
                + "Zipcode = VALUES(Zipcode), "
                + "State = VALUES(State), "
                + "Email = VALUES(Email), "
                + "PhonePrimary = VALUES(PhonePrimary), "
                + "PhoneSecondary = VALUES(PhoneSecondary), "
                + "Image = VALUES(Image), "
                + "PersonDeleted = VALUES(PersonDeleted)";

        String logonQuery = "INSERT INTO " + SCHEMA_NAME + ".Logon (LogonID, PersonID, LogonName, Password, FirstChallengeQuestion, FirstChallengeAnswer, "
                + "SecondChallengeQuestion, SecondChallengeAnswer, ThirdChallengeQuestion, ThirdChallengeAnswer, PositionTitle, AccountDisabled, AccountDeleted) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE "
                + "LogonName = VALUES(LogonName), "
                + "Password = VALUES(Password), "
                + "FirstChallengeQuestion = VALUES(FirstChallengeQuestion), "
                + "FirstChallengeAnswer = VALUES(FirstChallengeAnswer), "
                + "SecondChallengeQuestion = VALUES(SecondChallengeQuestion), "
                + "SecondChallengeAnswer = VALUES(SecondChallengeAnswer), "
                + "ThirdChallengeQuestion = VALUES(ThirdChallengeQuestion), "
                + "ThirdChallengeAnswer = VALUES(ThirdChallengeAnswer), "
                + "PositionTitle = VALUES(PositionTitle), "
                + "AccountDisabled = VALUES(AccountDisabled), "
                + "AccountDeleted = VALUES(AccountDeleted)";

        try {
            // Establish Connection
            connection = getConnection();

            // Must Insert person data first
            psPerson = connection.prepareStatement(personQuery, Statement.RETURN_GENERATED_KEYS);

            psPerson.setInt(1, person.getPersonID());
            psPerson.setString(2, person.getTitle());
            psPerson.setString(3, person.getNameFirst());
            psPerson.setString(4, person.getNameMiddle());
            psPerson.setString(5, person.getNameLast());
            psPerson.setString(6, person.getSuffix());
            psPerson.setString(7, person.getAddressOne());
            psPerson.setString(8, person.getAddressTwo());
            psPerson.setString(9, person.getAddressThree());
            psPerson.setString(10, person.getCity());
            psPerson.setString(11, person.getZipcode());
            psPerson.setString(12, person.getState());
            psPerson.setString(13, person.getEmail());
            psPerson.setString(14, person.getPhonePrimary());
            psPerson.setString(15, person.getPhoneSecondary());
            psPerson.setBinaryStream(16, person.getInputStreamFromImage());
            psPerson.setBoolean(17, person.isPersonDeleted());

            psPerson.executeUpdate();

            keys = psPerson.getGeneratedKeys();

            if (keys.next()) {
                int pID = keys.getInt(1);

                psLogon = connection.prepareStatement(logonQuery);

                connection.setAutoCommit(false);

                psLogon.setInt(1, logon.getLogonID());
                psLogon.setInt(2, pID);
                psLogon.setString(3, logon.getLogonName());
                psLogon.setString(4, logon.getPassword());
                psLogon.setInt(5, logon.getFirstChallengeQuestion());
                psLogon.setString(6, logon.getFirstChallengeAnswer());
                psLogon.setInt(7, logon.getSecondChallengeQuestion());
                psLogon.setString(8, logon.getSecondChallengeAnswer());
                psLogon.setInt(9, logon.getThirdChallengeQuestion());
                psLogon.setString(10, logon.getThirdChallengeAnswer());
                psLogon.setString(11, logon.getPositionTitle());
                psLogon.setBoolean(12, logon.isAccountDisabled());
                psLogon.setBoolean(13, logon.isAccountDeleted());

                psLogon.executeUpdate();

                connection.commit();
            } else {
                psLogon = connection.prepareStatement(logonQuery);

                psLogon.setInt(1, logon.getLogonID());
                psLogon.setInt(2, person.getPersonID());
                psLogon.setString(3, logon.getLogonName());
                psLogon.setString(4, logon.getPassword());
                psLogon.setInt(5, logon.getFirstChallengeQuestion());
                psLogon.setString(6, logon.getFirstChallengeAnswer());
                psLogon.setInt(7, logon.getSecondChallengeQuestion());
                psLogon.setString(8, logon.getSecondChallengeAnswer());
                psLogon.setInt(9, logon.getThirdChallengeQuestion());
                psLogon.setString(10, logon.getThirdChallengeAnswer());
                psLogon.setString(11, logon.getPositionTitle());
                psLogon.setBoolean(12, logon.isAccountDisabled());
                psLogon.setBoolean(13, logon.isAccountDeleted());

                psLogon.executeUpdate();
            }
        } catch (SQLException x) {
            result = false;
            // x.printStackTrace();
            System.out.println("Couldn't save user: " + x.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    // ex.printStackTrace();
                    System.out.println("Couldn't rollback: " + ex.getMessage());
                }
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                if (keys != null) {
                    keys.close();
                }
                if (psLogon != null) {
                    psLogon.close();
                }
                if (psPerson != null) {
                    psPerson.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                // ex.printStackTrace();
                System.out.println("Save user error: " + ex.getMessage());
            }
        }
        return result;
    }

    public static boolean save(Logon logon) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean result = true;

        String query = "UPDATE " + SCHEMA_NAME + ".Logon SET Password = ? WHERE LogonID = ?";

        try {
            // Establish Connection
            connection = getConnection();

            ps = connection.prepareStatement(query);

            ps.setString(1, logon.getPassword());
            ps.setInt(2, logon.getLogonID());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Could Not Reset Password.");
            result = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {

            }

        }

        return result;

    }

    // ORDERS & ORDER DETAILS
    public static boolean save(Order order, ArrayList<OrderDetail> details) {
        Connection connection = null;
        PreparedStatement psOrder = null;
        PreparedStatement psDetails = null;
        ResultSet keys = null;
        boolean result = true;

        String orderQuery = "INSERT INTO " + SCHEMA_NAME + ".Orders (DiscountID, PersonID, EmployeeID, OrderDate, CC_Number, ExpDate, CCV)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";

        String detailsQuery = "INSERT INTO " + SCHEMA_NAME + ".OrderDetails (OrderID, InventoryID, DiscountID, Quantity)"
                + "VALUES (?, ?, ?, ?)";

        try {
            // Establish Connection
            connection = getConnection();

            // Must Insert order data first
            psOrder = connection.prepareStatement(orderQuery, Statement.RETURN_GENERATED_KEYS);

            if (order.getDiscountID() == null) {
                psOrder.setNull(1, Types.NULL);
            } else {
                psOrder.setInt(1, order.getDiscountID());
            }
            psOrder.setInt(2, order.getPersonID());
            if (order.getEmployeeID() == null) {
                psOrder.setNull(3, Types.NULL);
            } else {
                psOrder.setInt(3, order.getEmployeeID());
            }
            psOrder.setDate(4, Date.valueOf(order.getDate()));
            psOrder.setString(5, order.getCardNumber());
            psOrder.setString(6, order.getExpDate());
            psOrder.setString(7, order.getCCV());

            psOrder.executeUpdate();

            keys = psOrder.getGeneratedKeys();

            if (keys.next()) {
                int oID = keys.getInt(1);

                psDetails = connection.prepareStatement(detailsQuery);

                connection.setAutoCommit(false);

                for (OrderDetail detail : details) {
                    psDetails.setInt(1, oID);
                    psDetails.setInt(2, detail.getInventoryID());
                    if (order.getDiscountID() == null) {
                        psDetails.setNull(3, Types.NULL);
                    } else {
                        psDetails.setInt(3, order.getDiscountID());
                    }
                    psDetails.setInt(4, detail.getQuantity());

                    psDetails.executeUpdate();
                }

                connection.commit();
            } else {
                throw new SQLException("Couldnt find key");
            }
        } catch (SQLException x) {
            result = false;
            x.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    // ex.printStackTrace();
                    System.out.println("Couldn't rollback");
                }
            }
        } finally {
            try {
                connection.setAutoCommit(true);
                if (keys != null) {
                    keys.close();
                }
                if (psDetails != null) {
                    psDetails.close();
                }
                if (psOrder != null) {
                    psOrder.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                // ex.printStackTrace();
            }
        }
        return result;
    }

    public static boolean updateItem(int inventoryID, int quantity) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean result = true;

        String updateQuery = "UPDATE " + SCHEMA_NAME + ".Inventory SET Quantity = ? WHERE InventoryID = ?";

        try {
            connection = getConnection();
            // Must Insert item data first
            ps = connection.prepareStatement(updateQuery);

            ps.setInt(1, quantity);
            ps.setInt(2, inventoryID);

            ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Couldn't update");
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {
                // x.printStackTrace();
            }
        }

        return result;
    }

    // DISCOUNTS
    public static boolean save(Discount discount) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean result = true;

        String query = "INSERT INTO Discounts (DiscountID, DiscountCode, Description, DiscountLevel, InventoryID, DiscountType, DiscountPercentage, DiscountDollarAmount, StartDate, ExpirationDate, Unavailable) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE DiscountCode = VALUES(DiscountCode), Description = VALUES(Description), DiscountLevel = VALUES(DiscountLevel), "
                + "InventoryID = VALUES(InventoryID), DiscountType = VALUES(DiscountType), DiscountPercentage = VALUES(DiscountPercentage), DiscountDollarAmount = VALUES(DiscountDollarAmount), "
                + "StartDate = VALUES(StartDate), ExpirationDate = VALUES(ExpirationDate), Unavailable = VALUES(Unavailable)";

        try {
            // Establish Connection
            connection = getConnection();

            ps = connection.prepareStatement(query);

            ps.setInt(1, discount.getDiscountID());
            ps.setString(2, discount.getDiscountCode());
            ps.setString(3, discount.getDescription());
            ps.setInt(4, discount.getDiscountLevel());
            if (discount.getInventoryID() == null) {
                ps.setNull(5, Types.INTEGER);
            } else {
                ps.setDouble(5, discount.getInventoryID());
            }
            ps.setInt(6, discount.getDiscountType());
            if (discount.getDiscountPercentage() == null) {
                ps.setNull(7, Types.DOUBLE);
            } else {
                ps.setDouble(7, discount.getDiscountPercentage());
            }
            if (discount.getDiscountDollarAmount() == null) {
                ps.setNull(8, Types.DOUBLE);
            } else {
                ps.setDouble(8, discount.getDiscountDollarAmount());
            }
            if (discount.getStartDate() == null) {
                ps.setNull(9, Types.DATE);
            } else {
                ps.setDate(9, (Date) discount.getStartDate());
            }
            ps.setDate(10, (Date) discount.getExpirationDate());
            ps.setBoolean(11, discount.getUnavailable());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Could Not save or insert item: " + ex.getMessage());
            result = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {

            }

        }

        return result;
    }

    // INVENTORY ITEMS    
    public static boolean save(InventoryItem item) {
        Connection connection = null;
        PreparedStatement ps = null;
        boolean result = true;

        String query = "INSERT INTO Inventory (InventoryID, ItemName, ItemDescription, CategoryID, RetailPrice, Cost, Quantity, RestockThreshold, ItemImage, Discontinued) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?) "
                + "ON DUPLICATE KEY UPDATE ItemName = VALUES(ItemName), ItemDescription = VALUES(ItemDescription), CategoryID = VALUES(CategoryID), "
                + "RetailPrice = VALUES(RetailPrice), Cost = VALUES(Cost), Quantity = VALUES(Quantity), RestockThreshold = VALUES(RestockThreshold), "
                + "ItemImage = VALUES(ItemImage), " + "Discontinued = VALUES(Discontinued)";

        try {
            // Establish Connection
            connection = getConnection();

            ps = connection.prepareStatement(query);

            ps.setInt(1, item.getInventoryID());
            ps.setString(2, item.getItemName());
            ps.setString(3, item.getItemDescription());
            ps.setInt(4, item.getCategoryId());
            ps.setDouble(5, item.getRetailPrice());
            ps.setDouble(6, item.getCost());
            ps.setInt(7, item.getQuantity());
            ps.setInt(8, item.getRestockThreshold());
            ps.setBlob(9, item.getItemImage());
            ps.setBoolean(10, item.isDiscontinued());

            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Could Not save or insert item: " + ex.getMessage());
            result = false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {

            }

        }

        return result;
    }
    // ------------------------------------------------------------------------------------
    //                          -----  DELETE ------
    // ------------------------------------------------------------------------------------

    public static boolean delete(InventoryItem item) {
        Connection connection = null;
        PreparedStatement psOrderDetails = null;
        PreparedStatement psOrder = null;
        PreparedStatement psInventory = null;
        boolean result = true;

        String queryOrderDetails = "DELETE FROM " + SCHEMA_NAME + ".OrderDetails WHERE InventoryID = ?";
        String queryOrders = "DELETE FROM " + SCHEMA_NAME + ".Orders WHERE OrderID IN (SELECT OrderID FROM " + SCHEMA_NAME + ".OrderDetails WHERE InventoryID = ?)";
        String queryInventory = "DELETE FROM " + SCHEMA_NAME + ".Inventory WHERE InventoryID = ?";

        try {
            // Establish Connection
            connection = getConnection();

            psOrderDetails = connection.prepareStatement(queryOrderDetails);
            psOrder = connection.prepareStatement(queryOrders);
            psInventory = connection.prepareStatement(queryInventory);

            psOrderDetails.setInt(1, item.getInventoryID());
            psOrder.setInt(1, item.getInventoryID());
            psInventory.setInt(1, item.getInventoryID());

            psOrderDetails.executeUpdate();
            psOrder.executeUpdate();
            psInventory.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Could Not Delete item: " + ex.getMessage());
            result = false;
        } finally {
            try {
                if (psOrderDetails != null) {
                    psOrderDetails.close();
                }
                if (psOrder != null) {
                    psOrder.close();
                }
                if (psInventory != null) {
                    psInventory.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {

            }

        }

        return result;
    }

    public static boolean delete(Person person) {
        Connection connection = null;
        PreparedStatement psOrderDetails = null;
        PreparedStatement psOrder = null;
        PreparedStatement psLogon = null;
        PreparedStatement psPerson = null;
        boolean result = true;

        String queryOrderDetails = "DELETE FROM " + SCHEMA_NAME + ".OrderDetails WHERE OrderID IN (SELECT OrderID FROM " + SCHEMA_NAME + ".Orders WHERE PersonID = ?)";
        String queryOrders = "DELETE FROM " + SCHEMA_NAME + ".Orders WHERE PersonID = ?";
        String queryLogon = "DELETE FROM " + SCHEMA_NAME + ".Logon WHERE PersonID = ?";
        String queryPerson = "DELETE FROM " + SCHEMA_NAME + ".Person WHERE PersonID = ?";

        try {
            // Establish Connection
            connection = getConnection();

            psOrderDetails = connection.prepareStatement(queryOrderDetails);
            psOrder = connection.prepareStatement(queryOrders);
            psLogon = connection.prepareStatement(queryLogon);
            psPerson = connection.prepareStatement(queryPerson);

            psOrderDetails.setInt(1, person.getPersonID());
            psOrder.setInt(1, person.getPersonID());
            psLogon.setInt(1, person.getPersonID());
            psPerson.setInt(1, person.getPersonID());

            psOrderDetails.executeUpdate();
            psOrder.executeUpdate();
            psLogon.executeUpdate();
            psPerson.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Could Not Delete Person: " + ex.getMessage());
            result = false;
        } finally {
            try {
                if (psOrderDetails != null) {
                    psOrderDetails.close();
                }
                if (psOrder != null) {
                    psOrder.close();
                }
                if (psLogon != null) {
                    psLogon.close();
                }
                if (psPerson != null) {
                    psPerson.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {

            }

        }

        return result;
    }

    public static boolean delete(Discount discount) {
        Connection connection = null;
        PreparedStatement psDiscount = null;
        PreparedStatement psOrderDetails = null;
        PreparedStatement psOrder = null;

        boolean result = true;

        String queryOrderDetails = "DELETE FROM " + SCHEMA_NAME + ".OrderDetails WHERE DiscountID = ?";
        String queryOrders = "DELETE FROM " + SCHEMA_NAME + ".Orders WHERE DiscountID = ?";
        String queryDiscount = "DELETE FROM " + SCHEMA_NAME + ".Discounts WHERE DiscountID = ?";

        try {
            // Establish Connection
            connection = getConnection();

            psOrderDetails = connection.prepareStatement(queryOrderDetails);
            psOrder = connection.prepareStatement(queryOrders);
            psDiscount = connection.prepareStatement(queryDiscount);

            psOrderDetails.setInt(1, discount.getDiscountID());
            psOrder.setInt(1, discount.getDiscountID());
            psDiscount.setInt(1, discount.getDiscountID());

            psOrderDetails.executeUpdate();
            psOrder.executeUpdate();
            psDiscount.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Could Not Delete Discount: " + ex.getMessage());
            result = false;
        } finally {
            try {
                if (psOrderDetails != null) {
                    psOrderDetails.close();
                }
                if (psOrder != null) {
                    psOrder.close();
                }
                if (psDiscount != null) {
                    psDiscount.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException x) {

            }

        }

        return result;
    }

}
