package unitTest;


import static org.junit.Assert.*;

import org.junit.Test;

public class ArithmeticTest {
    @Test
    public void testMultiply() {
        assertEquals(4, Arithmetic.multiply(2,2));
        assertEquals(-15, Arithmetic.multiply(3,-5));
    }
    @Test
    public void testIsPositive() {
        assertTrue(Arithmetic.isPositive(5));
        assertFalse(Arithmetic.isPositive(-5));
        assertFalse(Arithmetic.isPositive(0));
    }

    // verifying equality of objects, MUST BE "public boolean equals(Object obj){}" to work 

    // public boolean equals(Object something){
    //     Person p = (Person)something;
    //     return this.name == p.name;
    // }
}
