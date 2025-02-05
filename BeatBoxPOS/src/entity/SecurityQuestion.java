package entity;

public class SecurityQuestion implements Comparable<SecurityQuestion> {
    
    private int questionID;
    private int setID;
    private String questionPrompt;

    public SecurityQuestion(int questionID, int setID, String questionPrompt) {
        this.questionID = questionID;
        this.setID = setID;
        this.questionPrompt = questionPrompt;
    }

    public SecurityQuestion() {
        
    }
    
    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public int getSetID() {
        return setID;
    }

    public void setSetID(int setID) {
        this.setID = setID;
    }

    public String getQuestionPrompt() {
        return questionPrompt;
    }

    public void setQuestionPrompt(String questionPrompt) {
        this.questionPrompt = questionPrompt;
    }

    @Override
    public String toString() {
        return questionPrompt;
    }


    @Override
    public int compareTo(SecurityQuestion sq) {
        return Integer.compare(this.getSetID(), sq.setID);
    }
    
    
    
}
