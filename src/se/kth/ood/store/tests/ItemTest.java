package se.kth.ood.store.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ood.store.model.Item;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {
    Item firstItem;
    Item secondItem;
    @BeforeEach
    void setUp() {
        firstItem = new Item("Apple", 10, 0.1f);
        secondItem = new Item("Apple", 10, 0.1f);
    }

    @AfterEach
    void tearDown() {
        firstItem = null;
        secondItem = null;
    }
    @Test
    void testEquals(){
        assertEquals(firstItem.toString(), secondItem.toString());
    }
}