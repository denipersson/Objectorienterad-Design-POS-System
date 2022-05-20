package se.kth.ood.store.model;

import java.util.ArrayList;

/**
 * SaleLog class, contains all past sales
 */
public class SaleLog {

    private ArrayList<Sale> loggedSales = new ArrayList<Sale>();

    /**
     * Logs sale by adding it to a list
     * @param sale to add
     */
    public void logSale(Sale sale){
        if(sale != null) {
            loggedSales.add(sale);
        }
    }
}
