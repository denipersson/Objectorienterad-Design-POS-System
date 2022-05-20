package se.kth.ood.store.exceptions;

/**
 * Exception class for the cases where an invalid amount of items (less than 1) are entered
 */
public class InvalidAmountException extends RuntimeException{
    private int amount;

    /**
     * Constructor for the exception
     * @param amount that was entered
     */
    public InvalidAmountException(int amount)
    {
        super("Invalid amount (" + amount + ") entered.");
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }
}
