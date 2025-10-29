package FlyweightTests;

import Flyweight.Character;
import Flyweight.Color;
import Flyweight.Font;
import Flyweight.Size;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CharacterTest {

    char c= 'c';
    Font font = new Font("Arial");
    Color color = new Color("Red");
    Size size = new Size("12");
    Character testCharacter = new Character(c,font ,color,size);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }


    @Test
    public void testGetCharacter(){
        char expected = 'c';
        char actual = testCharacter.getCharacter();
        assertEquals(expected,actual);
    }

    @Test
    public void testGetFont(){
        Font expected = font;
        Font actual = testCharacter.getFont();
        assertEquals(expected,actual);
    }

    @Test
    public void testGetColor(){
        Color expected = color;
        Color actual = testCharacter.getColor();
        assertEquals(expected,actual);
    }

    @Test
    public void testGetSize(){
        Size expected = size;
        Size actual = testCharacter.getSize();
        assertEquals(expected,actual);
    }


    @Test
    public void testSetFont(){
        Font expected = new Font("Verdana");
        testCharacter.setFont(expected);
        Font actual = testCharacter.getFont();
        assertEquals(expected,actual);
    }

    @Test
    public void testSetColor(){
        Color expected = new Color("Blue");
        testCharacter.setColor(expected);
        Color actual = testCharacter.getColor();
        assertEquals(expected,actual);
    }

    @Test
    public void testSetSize(){
        Size expected = new Size("14");
        testCharacter.setSize(expected);
        Size actual = testCharacter.getSize();
        assertEquals(expected,actual);
    }

    @Test
    public void testDisplayCharacter(){
        String expected = "c";
        testCharacter.displayCharacter();
        String actual = outContent.toString().trim();
        assertEquals(expected,actual);
    }
}
