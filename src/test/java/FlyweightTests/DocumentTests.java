package FlyweightTests;

import Flyweight.Character;
import Flyweight.CharacterPropertiesFactory;
import Flyweight.Document;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DocumentTests {

    CharacterPropertiesFactory characterPropertiesFactory ;
    Document document ;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setup(){
        characterPropertiesFactory = new CharacterPropertiesFactory();
        document = new Document(characterPropertiesFactory);
        System.setOut(new PrintStream(outContent));

    }
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void testGetDisplayedCharactersSize(){
        document.addCharacter('a',"Arial", "Red", "12");
        List<Character> characters = document.getDisplayedCharacters();

        assertEquals(1,characters.size());
    }
    @Test
    public void testAddCharacter()
    {
        document.addCharacter('a',"Arial", "Red", "12");

        List<Character> characters = document.getDisplayedCharacters();
        assertEquals(1,characters.size());
        Character character = characters.get(0);
        assertEquals('a',character.getCharacter());
        assertEquals("Arial",character.getFont().getFont());
        assertEquals("Red",character.getColor().getColor());
        assertEquals("12",character.getSize().getSize());
    }

    @Test
    public void testDisplayDocument(){
        document.addCharacter('a',"Arial", "Red", "12");
        String expected = "a";
        document.displayDocument();
        String actual = outContent.toString().trim();
        assertEquals(expected,actual);

    }

    @Test
    public void testDisplayDocumentMultipleAdd(){
        document.addCharacter('a',"Arial", "Red", "12");
        document.addCharacter('b',"Verdana", "Blue", "16");
        document.addCharacter('c',"Calibri", "Black", "14");
        String expected = "abc";
        document.displayDocument();
        String actual = outContent.toString().trim();
        assertEquals(expected,actual);

    }

    @Test
    public void testCharacterProperties(){
        document.addCharacter('a',"Arial", "Red", "12");
        document.changeCharacterProperties(0,"Verdana", "Blue", "16");

        List<Character> characters = document.getDisplayedCharacters();
        Character character = characters.get(0);
        assertEquals('a',character.getCharacter());
        assertEquals("Verdana",character.getFont().getFont());
        assertEquals("Blue",character.getColor().getColor());
        assertEquals("16",character.getSize().getSize());

    }

    @Test
    public void testSaveDocument() throws IOException {
        document.addCharacter('a',"Arial", "Red", "12");
        String filename = "testSaveDocument.txt";
        document.saveDocument(filename);
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line =  reader.readLine();
        reader.close();
        assertTrue(line.contains("a"));
    }

    @Test
    public void testSaveDocumentMultipleAdds() throws IOException {
        document.addCharacter('a',"Arial", "Red", "12");
        document.addCharacter('b',"Calibri", "Blue", "12");
        String filename = "testSaveDocument.txt";
        document.saveDocument(filename);
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line1 =  reader.readLine();
        String line2 =  reader.readLine();
        reader.close();
        assertTrue(line1.contains("a"));
        assertTrue(line2.contains("b"));
    }

    @Test
    public void testLoadDocument() throws IOException {
        String filename = "testLoadDocument.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        writer.write("a|Arial|Red|12");
        writer.close();

        Document loadedDocument = new Document(characterPropertiesFactory);
        loadedDocument.loadDocument(filename);
        List<Character> characters = loadedDocument.getDisplayedCharacters();
        Character character = characters.get(0);
        assertEquals('a',character.getCharacter());
        assertEquals("Arial",character.getFont().getFont());
        assertEquals("Red",character.getColor().getColor());
        assertEquals("12",character.getSize().getSize());
    }
}
