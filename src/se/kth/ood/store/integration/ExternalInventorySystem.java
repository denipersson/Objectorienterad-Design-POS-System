package se.kth.ood.store.integration;

import se.kth.ood.store.exceptions.InvalidAmountException;
import se.kth.ood.store.exceptions.ItemMissingException;
import se.kth.ood.store.exceptions.ServerErrorException;
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

    private final int serverDownItemID = 404;

    private final int minimumItemQuantity = 1;

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
     * @param quantity
     * @return returns a copy
     * @throws ItemMissingException occurs when an unrecognized item ID is entered
     * @throws InvalidAmountException occurs when an invalid quantity is entered
     * @throws ServerErrorException occurs when servers are not responding
     */
    public Item getItemByID(int id, int quantity) throws ItemMissingException, InvalidAmountException, ServerErrorException{
        Item itemCopy = null;

        if(id == serverDownItemID){
            throw new ServerErrorException();
        }

        if(!itemHashMap.containsKey(id)) {
            throw new ItemMissingException(id);
        }

        if(quantity < minimumItemQuantity)
            throw new InvalidAmountException(quantity);

        itemCopy = new Item(itemHashMap.get(id), quantity);

        return itemCopy;
    }

    /**
     * Represents updating of the inventory system
     */
    public void updateInventorySystem(){
    }

}
