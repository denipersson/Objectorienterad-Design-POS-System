package se.kth.ood.store.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ood.store.model.CashRegister;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {
    private CashRegister register;
    @BeforeEach
    void setUp() {
        register = new CashRegister();
    }

    @AfterEach
    void tearDown() {
        register = null;
    }

    @Test
    void addToBalance() {
        float amountToAdd = 10;
        float amountBefore = register.getBalance();
        float expectedBalance = amountBefore + amountToAdd;


        register.addToBalance(amountToAdd);
        float realBalance = register.getBalance();

        assertEquals(realBalance, expectedBalance, "The expected balance is DIFFERENT from the actual balance.");
    }
}