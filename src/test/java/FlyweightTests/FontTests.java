package FlyweightTests;


import Flyweight.Font;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FontTests {

    @Test
    public void testGetFont()
    {
        Font font = new Font("Arial");
        String expected = "Arial";
        String actual = font.getFont();
        assertEquals(expected, actual);
    }
}
