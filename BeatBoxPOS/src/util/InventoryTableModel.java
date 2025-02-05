package util;

import entity.InventoryItem;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class InventoryTableModel extends AbstractTableModel {

    private ArrayList<InventoryItem> items;
    private String[] columnNames = {"ID", "Item Name", "Retail Price", "Cost",
        "Quantity", "Restock Threshold", "Discontinued", "Category ID"};
    
    public InventoryTableModel(ArrayList<InventoryItem> items) {
        this.items = items;
    }

    @Override
    public int getRowCount() {
        return items.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "?";
        InventoryItem item = items.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = item.getInventoryID();
                break;
            case 1:
                value = item.getItemName();
                break;
            case 2:
                value = item.getRetailPrice();
                break;
            case 3:
                value = item.getCost();
                break;
            case 4:
                value = item.getQuantity();
                break;
            case 5:
                value = item.getRestockThreshold();
                break;
            case 6:
                value = item.isDiscontinued();
                break;
            case 7:
                value = item.getCategoryId();
                break;
        }

        return value;
    }

    public InventoryItem getItemAt(int row) {
        return items.get(row);
    }

    public ArrayList<InventoryItem> getItems() {
        return items;
    }
    
}
