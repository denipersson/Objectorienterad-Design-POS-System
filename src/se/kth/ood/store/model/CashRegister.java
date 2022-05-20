package se.kth.ood.store.model;

import java.util.ArrayList;

/**
 * Represents the cash register
 */
public class CashRegister {
    private float balance = 0;
    private ArrayList<TotalRevenueObserver> observers = new ArrayList<TotalRevenueObserver>();

    /**
     * Increases balance in the register
     * @param amount to increase balance with
     */
    public void addToBalance(float amount){
        balance += amount;

        notifyObservers(amount);

    }

    /**
     * Adds an observer to send information of the total revenue so far, back to the view
     * @param o observer to add
     */
    public void addTotalRevenueObserver(TotalRevenueObserver o){
        observers.add(o);
    }

    /**
     * Notify all observers of a revenue increase
     * @param payment to add to total
     */
    private void notifyObservers(float payment){
        for (TotalRevenueObserver o: observers) {
            o.updateTotalAndDisplay(payment);
        }
    }

    public float getBalance()
    {
        return balance;
    }
}
