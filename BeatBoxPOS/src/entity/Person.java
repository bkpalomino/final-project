package entity;

import com.mysql.cj.jdbc.Blob;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import util.ImageManager;
import util.ResourceLoader;

/*
Author: Braeden Palomino
Date: 10/03/24
Description: Object created from Person table.
 */
public class Person {

    private int personID;
    private String title;
    private String nameFirst;
    private String nameMiddle;
    private String nameLast;
    private String suffix;
    private String addressOne;
    private String addressTwo;
    private String addressThree;
    private String city;
    private String zipcode;
    private String state;
    private String email;
    private String phonePrimary;
    private String phoneSecondary;
    private Blob image;
    private Boolean personDeleted;

    private Logon logon;

    public Person(int personID, String title, String nameFirst, String nameMiddle, String nameLast, String suffix, String addressOne, String addressTwo, String addressThree, String city, String zipcode, String state, String email, String phonePrimary, String phoneSecondary, Blob image, Boolean personDeleted) {
        this.personID = personID;
        this.title = title;
        this.nameFirst = nameFirst;
        this.nameMiddle = nameMiddle;
        this.nameLast = nameLast;
        this.suffix = suffix;
        this.addressOne = addressOne;
        this.addressTwo = addressTwo;
        this.addressThree = addressThree;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
        this.email = email;
        this.phonePrimary = phonePrimary;
        this.phoneSecondary = phoneSecondary;
        this.image = image;
        this.personDeleted = personDeleted;
        
        logon = null;
    }

    public Person(int personID) {
        this.personID = personID;
    }

    public Person() {
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameMiddle() {
        return nameMiddle;
    }

    public void setNameMiddle(String nameMiddle) {
        this.nameMiddle = nameMiddle;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getAddressOne() {
        return addressOne;
    }

    public void setAddressOne(String addressOne) {
        this.addressOne = addressOne;
    }

    public String getAddressTwo() {
        return addressTwo;
    }

    public void setAddressTwo(String addressTwo) {
        this.addressTwo = addressTwo;
    }

    public String getAddressThree() {
        return addressThree;
    }

    public void setAddressThree(String addressThree) {
        this.addressThree = addressThree;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String City) {
        this.city = City;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String Zipcode) {
        this.zipcode = Zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String State) {
        this.state = State;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String Email) {
        this.email = Email;
    }

    public String getPhonePrimary() {
        return phonePrimary;
    }

    public void setPhonePrimary(String PhonePrimary) {
        this.phonePrimary = PhonePrimary;
    }

    public String getPhoneSecondary() {
        return phoneSecondary;
    }

    public void setPhoneSecondary(String PhoneSecondary) {
        this.phoneSecondary = PhoneSecondary;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Boolean isPersonDeleted() {
        return personDeleted;
    }

    public void setPersonDeleted(Boolean personDeleted) {
        this.personDeleted = personDeleted;
    }

    public Logon getLogon() {
        return logon;
    }

    public void setLogon(Logon logon) {
        this.logon = logon;
    }

    public ImageIcon getImageIcon(int size) {

        ImageIcon icon = (image != null)
                ? ImageManager.getScaledImageIcon(getByteArrayFromImage(), size)
                : ResourceLoader.getResourceIcon("icons/no-image.jpg", size);

        return icon;
    }

    public InputStream getInputStreamFromImage() {
        InputStream inputStream = null;
        if (image != null) {
            try {
                inputStream = image.getBinaryStream();
            } catch (SQLException ex) {
                Logger.getLogger(Person.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return inputStream;
    }

    public byte[] getByteArrayFromImage() {
        byte[] array = null;

        try {
            array = image.getBytes(1, (int) image.length());
        } catch (SQLException ex) {

        }

        return array;
    }

    public String toStringExtended() {
        return "Person{" + "\n personID=" + personID + "\n title='" + title + '\'' + 
                "\n nameFirst='" + nameFirst + '\'' + "\n nameMiddle='" + nameMiddle + '\''
                + "\n nameLast='" + nameLast + '\'' + "\n suffix='" + suffix + '\'' + "\n addressOne='"
                + addressOne + '\'' + "\n addressTwo='" + addressTwo + '\'' + "\n addressThree='" 
                + addressThree + '\'' + "\n city='" + city + '\'' + "\n zipcode='" + zipcode + '\''
                + "\n state='" + state + '\'' + "\n email='" + email + '\'' + "\n phonePrimary='" 
                + phonePrimary + '\'' + "\n phoneSecondary='" + phoneSecondary +"}";
    }

    @Override
    public String toString() {
        String str = "";

        if (personID == -1) {
            str = "No Customer Selected";
        } else if (personID == -2) {
            str = "All Customers";
        } else if (personID == -3) {
            str = "None";
        } else if (logon != null) {
            str = nameFirst + " " + nameLast + " | ID: " + personID;
        }

        return str;
    }

}
