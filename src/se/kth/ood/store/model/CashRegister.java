package se.kth.ood.store.model;

/**
 * Represents the cash register
 */
public class CashRegister {
    private float balance = 0;

    /**
     * Increases balance in the register
     * @param amount to increase balance with
     */
    public void addToBalance(float amount){
        balance += amount;

    }
    public float getBalance()
    {
        return balance;
    }
}
