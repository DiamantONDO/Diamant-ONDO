package AdvancedStockManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class Warehouse {

    private String warehouseId;
    private String location;
    private int capacity; // maximum number of items
    private String managerName;
    private List<StockItem> inventory;

    public Warehouse(String warehouseId, String location, int capacity, String managerName) {
        this.warehouseId = warehouseId;
        this.location = location;
        this.capacity = capacity;
        this.managerName = managerName;
        this.inventory = new ArrayList<>();
    }

    public boolean addItem(StockItem item) {
        if (inventory.size() < capacity) {
            inventory.add(item);
            System.out.println("Item added to warehouse: " + item.itemName);
            return true;
        } else {
            System.out.println("Warehouse is at full capacity. Cannot add more items.");
            return false;
        }
    }

    public boolean removeItem(StockItem item) {
        if (inventory.remove(item)) {
            System.out.println("Item removed from warehouse: " + item.itemName);
            return true;
        } else {
            System.out.println("Item not found in warehouse.");
            return false;
        }
    }

    public void trackInventory() {
        System.out.println("=== Warehouse Inventory Report ===");
        System.out.println("Warehouse ID: " + warehouseId);
        System.out.println("Location: " + location);
        System.out.println("Manager: " + managerName);
        System.out.println("Capacity: " + capacity);
        System.out.println("Current Inventory Count: " + inventory.size());
        for (StockItem item : inventory) {
            System.out.println("- " + item.itemName + " (" + item.category + ")");
        }
    }
}
