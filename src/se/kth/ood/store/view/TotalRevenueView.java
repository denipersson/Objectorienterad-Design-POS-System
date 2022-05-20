package se.kth.ood.store.view;

import se.kth.ood.store.model.TotalRevenueObserver;

/**
 * Observer class for the total revenue from start to finish of session
 */
public class TotalRevenueView implements TotalRevenueObserver {

    private float totalRevenue = 0;

    /**
     * Prints total revenue so far
     * @param payment value for increasing the total revenue
     */
    @Override
    public void updateTotalAndDisplay(float payment) {
        totalRevenue += payment;
        System.out.println("[TOTAL REVENUE VIEW]\nTotal revenue: " + totalRevenue);
    }
}
