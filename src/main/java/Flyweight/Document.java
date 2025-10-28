package Flyweight;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Document {
    private List<Character> displayedCharacters;
    private CharacterPropertiesFactory characterPropertiesFactory;

    public Document(CharacterPropertiesFactory characterPropertiesFactory) {
        this.displayedCharacters = new ArrayList<>();
        this.characterPropertiesFactory = characterPropertiesFactory;
    }

    public void addCharacter(char character, String font, String color, String size) {
        Font characterFont = characterPropertiesFactory.getFont(font);
        Color characterColor = characterPropertiesFactory.getColor(color);
        Size characterSize = characterPropertiesFactory.getSize(size);
        displayedCharacters.add(new Character(character,characterFont,characterColor,characterSize));
    }

    public void displayDocument() {
        for (Character character : displayedCharacters) {
            character.displayCharacter();
        }
        System.out.println();

    }

    public void changeCharacterProperties(int index, String font, String color, String size) {
        if(index >=0 && index < displayedCharacters.size()) {
            Font characterFont = characterPropertiesFactory.getFont(font);
            Color characterColor = characterPropertiesFactory.getColor(color);
            Size characterSize = characterPropertiesFactory.getSize(size);
            Character character = displayedCharacters.get(index);
            character.setFont(characterFont);
            character.setColor(characterColor);
            character.setSize(characterSize);
        }
    }

    public void saveDocument(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for(Character character : displayedCharacters) {
            String line = character.getCharacter() + "|" + character.getFont() + "|" + character.getColor() + "|" + character.getSize();
            writer.write(line);
            writer.newLine();
        }
        writer.close();
        System.out.println("Saved document to " + filename + "\n");
    }

    public void loadDocument(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        displayedCharacters.clear();

        while ((line = reader.readLine()) != null) {
            String [] data = line.split("\\|");

            char character = data[0].charAt(0);
            String fontName = data[1];
            String color = data[2];
            String size = data[3];

            Font font = characterPropertiesFactory.getFont(fontName);
            Color fontColor = characterPropertiesFactory.getColor(color);
            Size fontSize = characterPropertiesFactory.getSize(size);

            Character newLoadedCharacter = new Character(character,font,fontColor,fontSize);
            displayedCharacters.add(newLoadedCharacter);

        }
        reader.close();

    }
}
