package Flyweight;

public class Font {

    private String fontName;

    public Font(String fontName) {
        this.fontName = fontName;
    }

    public Font getFont() {
        return new Font(fontName);
    }

}
