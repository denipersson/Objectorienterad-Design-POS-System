package se.kth.ood.store.controller;

import se.kth.ood.store.ItemDTO;
import se.kth.ood.store.exceptions.*;
import se.kth.ood.store.integration.ExternalInventorySystem;
import se.kth.ood.store.integration.Printer;
import se.kth.ood.store.model.*;

/**
 * Controller class handles logic and method calls from other classes in integration and model
 */
public class Controller {
    private Sale sale;
    private ExternalInventorySystem externalInventorySystem = new ExternalInventorySystem();
    private SaleLog saleLog = new SaleLog();
    private Printer printer = new Printer();
    private CashRegister register = new CashRegister();


    /**
     * defines an empty Sale-object
     */
    public void startSale(){
        sale = new Sale();
    }

    /**
     * Scans an item
     * @param itemID the ID/barcode of the item scanned
     * @param quantity quantity of the item scanned
     */
    public ItemDTO scanItem(int itemID, int quantity) throws InvalidAmountException, ItemMissingException, ServerErrorException{

        Item scannedItem = externalInventorySystem.getItemByID(itemID, quantity);

        sale.addItemToSale(scannedItem);

        ItemDTO scannedItemDTO = new ItemDTO(scannedItem);
        return scannedItemDTO;
    }

    /**
     * find discount in database
     */
    public Discount checkDiscount(){
        return null;
    }

    /**
     * Ends the current sale
     * @return returns total price to view
     */
    public float endSale(){
        float finalPrice = sale.endSale();
        return finalPrice;
    }

    /**
     * Gets the current running total of ongoing sale
     * @return returns it to view
     */
    public float getRunningTotal(){
        return sale.getRunningTotal();
    }

    /**
     *
     * Adds a new observer for the total revenue
     * @param o observer to add
     */
    public void addTotalRevenueObserver(TotalRevenueObserver o)
    {
        register.addTotalRevenueObserver(o);
    }

    /**
     amount paid by customer
     @param total the amount
    */
    public void enterAmountPaid(float total){
        register.addToBalance(total);
    }

    /**
     * System finish after receiving payment - creates receipt, logs sale and updates inventory system
     */
    public void finish()
    {
        Receipt receipt = new Receipt(sale);
        printer.printReceipt(receipt);
        saleLog.logSale(sale);
        externalInventorySystem.updateInventorySystem();
    }
}
