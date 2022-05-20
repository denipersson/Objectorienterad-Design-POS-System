package se.kth.ood.store.model;

/**
 * Interface for an observer of the total revenue of all purchases
 */
public interface TotalRevenueObserver {
    /**
     * This method to update the total revenue and display it in someway is in the contract
     * @param payment
     */
    void updateTotalAndDisplay(float payment);
}
