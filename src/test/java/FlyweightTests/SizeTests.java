package FlyweightTests;

import Flyweight.Size;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SizeTests {

    @Test
    public void testGetSize()
    {
        Size size = new Size("12");
        String expected = "12";
        String actual = size.getSize();
        assertEquals(expected, actual);
    }
}
