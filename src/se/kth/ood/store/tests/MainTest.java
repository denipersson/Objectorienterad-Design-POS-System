package se.kth.ood.store.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.ood.store.startup.Main;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    @Test
    void main() {
        String[] args = null;
        Main.main(args);
    }
}