package se.kth.ood.store.integration;

import se.kth.ood.store.model.Item;

import java.util.HashMap;

/**
 * This class represents the external inventory system
 */
public class ExternalInventorySystem {

    private HashMap<Integer, Item> itemHashMap = new HashMap<Integer, Item>();

    private final int appleID = 1;
    private final int magazineID = 2;

    private final String appleName = "Apple";
    private final String magazineName = "The Daily Bugle";

    private final float appleVATRate = 0.1f;
    private final float magazineVATRate = 0.25f;

    private final float applePrice = 10;
    private final float magazinePrice = 39.90f;


    /**
     * Constructor
     */
    public ExternalInventorySystem(){
        fillInventorySystem();
    }

    /**
     * fills the inventory system with all the items for sale at the store
     */
    private void fillInventorySystem(){
        itemHashMap.put(appleID, new Item(appleName, applePrice, appleVATRate));
        itemHashMap.put(magazineID, new Item(magazineName, magazinePrice, magazineVATRate));
    }

    /**
     * This method finds an item in the database hashmap using the ID as the key
     * @param id key for hashmap
     * @return returns a copy
     */
    public Item getItemByID(int id, int quantity){
        Item itemCopy = new Item(itemHashMap.get(id), quantity);
        return itemCopy;
    }

    /**
     * Updates the inventory system
     */
    public void updateInventorySystem(){
        System.out.println("External Inventory System UPDATED");
    }

}
