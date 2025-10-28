package Flyweight;

public class Character {

    private char character;
    private Font font;
    private Color color;
    private Size size;

    public Character(char character, Font font, Color color, Size size){
        this.character = character;
        this.font = font;
        this.color = color;
        this.size = size;
    }
    public char getCharacter() {
        return character;
    }

    public Font getFont() {
        return font;
    }

    public Color getColor() {
        return color;
    }

    public Size getSize() {
        return size;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public void displayCharacter(){
        System.out.print(character);
    }
}
