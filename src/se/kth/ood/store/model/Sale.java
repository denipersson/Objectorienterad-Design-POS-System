package se.kth.ood.store.model;

import se.kth.ood.store.ItemDTO;

import java.lang.reflect.Array;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Sale class
 */
public class Sale {
    private LocalTime saleTime;
    private ArrayList<Item> itemsInSale = new ArrayList<Item>();

    /**
     * item to add to the sale
     * @param item to add
     */
    public void addItemToSale(Item item)
    {
        for(int i = 0; i < itemsInSale.size(); i ++) {
            if (itemsInSale.get(i).getName() == item.getName())
            {
                increaseItemQuantity(item.getName(), item.getQuantity());
                return;
            }
        }
        itemsInSale.add(item);
    }


    /**
     * sets the time of sale to current time
     */
    private void setTimeOfSale(){
        saleTime = LocalTime.now();
    }

    /**
     * Calculates the current running total in the sale
     * @return returns the value after calculation
     */
    public float getRunningTotal(){
        float total = 0;

        for(int i = 0; i < itemsInSale.size(); i++){
            Item currentItem = itemsInSale.get(i);
            total += (currentItem.getPrice() + currentItem.getPrice()*currentItem.getVATrate()) * currentItem.getQuantity();
        }

        return total;
    }

    /**
     * total rounded up
     * @return total rounded up
     */
    public int roundedTotal(){
        return Math.round(getRunningTotal());
    }

    /**
     * creates an array with data transfer objects for items
     * @return array with DTOS
     */
    public ItemDTO[] getItemDTOSInSale(){
        ItemDTO[] itemDTOS = new ItemDTO[itemsInSale.size()];
        for(int i = 0; i < itemsInSale.size(); i++){
            itemDTOS[i] = new ItemDTO(itemsInSale.get(i));
        }
        return itemDTOS;
    }

    /**
     * Ends sale by setting time of sale and returns the total price
     * @return total price
     */
    public float endSale(){
        setTimeOfSale();
        return getRunningTotal();
    }

    /**
     * Increases the quantity of an item already in the sale
     * @param name of the item
     * @param addedQuantity to increase by
     */
    public void increaseItemQuantity(String name, int addedQuantity){
        for(int i = 0; i < itemsInSale.size(); i++)
        {
            if(itemsInSale.get(i).getName().equals(name))
            {
                itemsInSale.get(i).setQuantity(itemsInSale.get(i).getQuantity() + addedQuantity);
                break;
            }
        }
    }
    public String getSaleTime(){

        return saleTime.toString();
    }

    /**
     * discount added to sale
     * @param discount to add
     */
    private void addDiscount(Discount discount){
    }

}
