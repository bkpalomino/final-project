package entity;

/*
Author: Braeden Palomino
Date: 10/03/24
Description: Object created from Position table.
 */
public class Position {

    private int positionID;
    private String positionTitle;

    public Position(int positionID, String positionTitle) {
        this.positionID = positionID;
        this.positionTitle = positionTitle;
    }

    public Position(int positionID) {
        this.positionID = positionID;
        this.positionTitle = "All Positions";
    }

    public int getPositionID() {
        return positionID;
    }

    public void setPositionID(int positionID) {
        this.positionID = positionID;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    @Override
    public String toString() {
        return positionTitle;
    }

}
