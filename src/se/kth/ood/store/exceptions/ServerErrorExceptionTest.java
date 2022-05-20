package se.kth.ood.store.exceptions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ood.store.integration.ExternalInventorySystem;
import se.kth.ood.store.model.Item;

import static org.junit.jupiter.api.Assertions.*;

class ServerErrorExceptionTest {

    private ExternalInventorySystem externalInventorySystem;
    private int serverErrorItemID = 404;

    @BeforeEach
    void setUp() {
        externalInventorySystem = new ExternalInventorySystem();
    }

    @AfterEach
    void tearDown() {
        externalInventorySystem = null;
    }
    @Test
    void testException(){
        try{
            externalInventorySystem.getItemByID(serverErrorItemID, 1);
            fail("Server error was not caught");
        }
        catch(ServerErrorException e){
            assertTrue(e.isServerError(), "Server error: " + e.isServerError() +
                        ", exception occurred despite no server error.");
        }
    }
}