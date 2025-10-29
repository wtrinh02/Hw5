package FlyweightTests;
import Flyweight.CharacterPropertiesFactory;
import org.junit.jupiter.api.Test;

import Flyweight.Color;
import Flyweight.Font;
import Flyweight.Size;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterPropertiesFactoryTests {


    CharacterPropertiesFactory characterPropertiesFactory = new CharacterPropertiesFactory();

    @Test
    public void testGetFontCreatesInstance() {

        Font actual = characterPropertiesFactory.getFont("Arial");
        assertNotNull(actual);
    }
    @Test
    public void testGetFontInstanceName() {
        Font actual = characterPropertiesFactory.getFont("Arial");
        String expected = "Arial";
        assertEquals(expected,actual.getFont());
    }

    @Test
    public void testGetFontReturnsSameInstance(){
        Font font1 = characterPropertiesFactory.getFont("Arial");
        Font font2 = characterPropertiesFactory.getFont("Arial");

        assertSame(font1,font2);

    }

    @Test
    public void testGetFontReturnsDifferentInstance(){
        Font font1 = characterPropertiesFactory.getFont("Arial");
        Font font2 = characterPropertiesFactory.getFont("Verdana");

        assertNotSame(font1,font2);

    }

    @Test
    public void testGetColorCreatesInstance() {

        Color actual = characterPropertiesFactory.getColor("Red");
        assertNotNull(actual);
    }
    @Test
    public void testGetColorInstanceName() {
        Color actual = characterPropertiesFactory.getColor("Red");
        String expected = "Red";
        assertEquals(expected,actual.getColor());
    }

    @Test
    public void testGetColorReturnsSameInstance(){
        Color color1 = characterPropertiesFactory.getColor("Red");
        Color color2 = characterPropertiesFactory.getColor("Red");

        assertSame(color1,color2);

    }

    @Test
    public void testGetColorReturnsDifferentInstance(){
        Color color1 = characterPropertiesFactory.getColor("Arial");
        Color color2 = characterPropertiesFactory.getColor("Verdana");

        assertNotSame(color1,color2);

    }

    @Test
    public void testGetSizeCreatesInstance() {

        Size actual = characterPropertiesFactory.getSize("12");
        assertNotNull(actual);
    }
    @Test
    public void testGetSizeInstanceName() {
        Size actual = characterPropertiesFactory.getSize("12");
        String expected = "12";
        assertEquals(expected,actual.getSize());
    }

    @Test
    public void testGetSizeReturnsSameInstance(){
        Size size1 = characterPropertiesFactory.getSize("12");
        Size size2 = characterPropertiesFactory.getSize("12");

        assertSame(size1,size2);

    }

    @Test
    public void testGetSizeReturnsDifferentInstance(){
        Size size1 = characterPropertiesFactory.getSize("12");
        Size size2 = characterPropertiesFactory.getSize("14");

        assertNotSame(size1,size2);

    }


}
