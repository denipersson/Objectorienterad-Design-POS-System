package se.kth.ood.store;

import se.kth.ood.store.model.Item;

/**
 * Data transfer object for the Item Class
 */
public class ItemDTO {
    private String name;
    private float price;
    private int quantity;
    private float VATrate;

    /**
     * a data transfer object for the Item class
     * @param item to use in data transfer
     */
    public ItemDTO(Item item){

        name = item.getName();
        price = item.getPrice();
        quantity = item.getQuantity();
        VATrate = item.getVATrate();

    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getVATrate() {
        return VATrate;
    }
}
