package pij.main;

import static org.junit.jupiter.api.Assertions.*;


import static org.junit.jupiter.api.Assertions.*;

class AddTestTest {
    void twoPlusTwoMustEqual4() {
        var calc = new AddTest();
        assertEquals(4, calc.add(2, 2));
    }

}