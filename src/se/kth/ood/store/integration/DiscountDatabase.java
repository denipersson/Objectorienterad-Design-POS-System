package se.kth.ood.store.integration;

import se.kth.ood.store.model.Discount;

import java.util.HashMap;

/**
 * Discount Database
 */
public class DiscountDatabase {
    HashMap<Integer, Discount> discountMap = new HashMap<Integer, Discount>();

    /**
     * Constructor
     */
    public DiscountDatabase(){

    }

    /**
     * Finds discount in database and returns it
     * @param customerID ID of the customer to match with a discount in database
     * @return
     */
    public Discount findDiscountbyCustomerID(int customerID){
        return discountMap.get(customerID);
    }
}
