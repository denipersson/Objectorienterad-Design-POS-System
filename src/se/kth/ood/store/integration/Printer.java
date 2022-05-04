package se.kth.ood.store.integration;

import se.kth.ood.store.model.Receipt;

/**
 * Represents an imaginary external printer
 */
public class Printer {
    /**
     * Prints the receipt
     * @param receipt to print
     */
    public void printReceipt(Receipt receipt)
    {
        System.out.println(receipt.toString());
    }
}
