package FlyweightTests;

import Flyweight.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorTests {

    @Test
    public void testGetColor()
    {
        Color color = new Color("Red");
        String expected = "Red";
        String actual = color.getColor();
        assertEquals(expected, actual);
    }
}
