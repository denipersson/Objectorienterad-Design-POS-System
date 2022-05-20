package se.kth.ood.store.exceptions;

/**
 * Exception class for the cases where an invalid itemID is entered
 */
public class ItemMissingException extends RuntimeException{
    private int itemID;

    /**
     * Constructor for the exception
     * @param itemID which is invalid
     */
    public ItemMissingException(int itemID){
        super("The item ID (" + itemID + ") is invalid.");
        this.itemID = itemID;
    }

    public int getItemID() {
        return itemID;
    }
}
