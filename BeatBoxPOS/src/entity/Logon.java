package entity;

/*
Author: Braeden Palomino
Date: 10/03/24
Description: An object created from Logon table data
 */
public class Logon {

    private int logonID;
    private int personID;
    private String logonName;
    private String password;
    private int firstChallengeQuestion;
    private String firstChallengeAnswer;
    private int secondChallengeQuestion;
    private String secondChallengeAnswer;
    private int thirdChallengeQuestion;
    private String thirdChallengeAnswer;
    private String positionTitle;
    private Boolean accountDisabled;
    private Boolean accountDeleted;

    public Logon(int logonID, int personID, String logonName, String password, int firstChallengeQuestion, String firstChallengeAnswer, int secondChallengeQuestion, String secondChallengeAnswer, int thirdChallengeQuestion, String thirdChallengeAnswer, String positionTitle, Boolean accountDisabled, Boolean accountDeleted) {
        this.logonID = logonID;
        this.personID = personID;
        this.logonName = logonName;
        this.password = password;
        this.firstChallengeQuestion = firstChallengeQuestion;
        this.firstChallengeAnswer = firstChallengeAnswer;
        this.secondChallengeQuestion = secondChallengeQuestion;
        this.secondChallengeAnswer = secondChallengeAnswer;
        this.thirdChallengeQuestion = thirdChallengeQuestion;
        this.thirdChallengeAnswer = thirdChallengeAnswer;
        this.positionTitle = positionTitle;
        this.accountDisabled = accountDisabled;
        this.accountDeleted = accountDeleted;
    }

    public Logon() {
        
    }
    
    public int getLogonID() {
        return logonID;
    }

    public void setLogonID(int logonID) {
        this.logonID = logonID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getLogonName() {
        return logonName;
    }

    public void setLogonName(String logonName) {
        this.logonName = logonName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFirstChallengeQuestion() {
        return firstChallengeQuestion;
    }

    public void setFirstChallengeQuestion(int firstChallengeQuestion) {
        this.firstChallengeQuestion = firstChallengeQuestion;
    }

    public String getFirstChallengeAnswer() {
        return firstChallengeAnswer;
    }

    public void setFirstChallengeAnswer(String firstChallengeAnswer) {
        this.firstChallengeAnswer = firstChallengeAnswer;
    }

    public int getSecondChallengeQuestion() {
        return secondChallengeQuestion;
    }

    public void setSecondChallengeQuestion(int secondChallengeQuestion) {
        this.secondChallengeQuestion = secondChallengeQuestion;
    }

    public String getSecondChallengeAnswer() {
        return secondChallengeAnswer;
    }

    public void setSecondChallengeAnswer(String secondChallengeAnswer) {
        this.secondChallengeAnswer = secondChallengeAnswer;
    }

    public int getThirdChallengeQuestion() {
        return thirdChallengeQuestion;
    }

    public void setThirdChallengeQuestion(int thirdChallengeQuestion) {
        this.thirdChallengeQuestion = thirdChallengeQuestion;
    }

    public String getThirdChallengeAnswer() {
        return thirdChallengeAnswer;
    }

    public void setThirdChallengeAnswer(String thirdChallengeAnswer) {
        this.thirdChallengeAnswer = thirdChallengeAnswer;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public Boolean isAccountDisabled() {
        return accountDisabled;
    }

    public void setAccountDisabled(Boolean accountDisabled) {
        this.accountDisabled = accountDisabled;
    }

    public Boolean isAccountDeleted() {
        return accountDeleted;
    }

    public void setAccountDeleted(Boolean accountDeleted) {
        this.accountDeleted = accountDeleted;
    }

    @Override
    public String toString() {
        return "Logon{" + "logonID=" + logonID + ", personID=" + personID + ", logonName=" + logonName + ", password=" + password + ", firstChallengeQuestion=" + firstChallengeQuestion + ", firstChallengeAnswer=" + firstChallengeAnswer + ", secondChallengeQuestion=" + secondChallengeQuestion + ", secondChallengeAnswer=" + secondChallengeAnswer + ", thirdChallengeQuestion=" + thirdChallengeQuestion + ", thirdChallengeAnswer=" + thirdChallengeAnswer + ", positionTitle=" + positionTitle + ", accountDisabled=" + accountDisabled + ", accountDeleted=" + accountDeleted + '}';
    }

    
    
}
