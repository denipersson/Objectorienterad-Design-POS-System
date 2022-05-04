package se.kth.ood.store.model;

/**
 * Item class represents an item sold at the store
 */

public class Item {
    private String name;
    private float price;
    private int quantity;
    private float VATrate;

    /**
     *
     * @param name
     * @param price
     */
    public Item(String name, float price, float VATrate){
        this.name = name;
        this.price = price;
        this.VATrate = VATrate;
    }

    /**
     * Creates copy of existing item, and sets the quantity
     * @param item to copy
     */
    public Item(Item item, int quantity){
        name = item.getName();
        price = item.getPrice();
        VATrate = item.getVATrate();
        this.quantity = quantity;
    }

    /**
     * gets the price
     * @return
     */
    public float getPrice() {
        return price;
    }

    /**
     * gets VATrate
     * @return
     */
    public float getVATrate() {
        return VATrate;
    }

    /**
     * gets the name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * gets the quantity
     * @return
     */
    public int getQuantity() {
        return quantity;
    }
    public String toString(){
        return name + " " + price + " " + quantity + " " + getVATrate();
    }
}
