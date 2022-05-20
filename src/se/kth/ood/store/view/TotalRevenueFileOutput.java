package se.kth.ood.store.view;

import se.kth.ood.store.FileLogger;
import se.kth.ood.store.model.TotalRevenueObserver;

/**
 * This class is an observer, every time it is notified, it updates the total revenue and prints it to a log.txt file
 */
public class TotalRevenueFileOutput implements TotalRevenueObserver {

    private FileLogger logger = new FileLogger();
    private float total = 0;
    @Override
    public void updateTotalAndDisplay(float payment) {
        total += payment;
        logger.log("\nTotal revenue: " + total);
    }
}
