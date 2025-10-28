package Flyweight;
import java.util.HashMap;
import java.util.Map;

public class CharacterPropertiesFactory {

    private HashMap<String, Font> fonts;
    private HashMap<String, Color> colors;
    private HashMap<String, Size> sizes;

    public CharacterPropertiesFactory(){
        fonts = new HashMap<>();
        colors = new HashMap<>();
        sizes = new HashMap<>();
    }

    public Font getFont(String fontName) {
        if (fonts.containsKey(fontName)){
            return fonts.get(fontName);
        }
        else{
            Font font = new Font(fontName);
            fonts.put(fontName, font);
            return font;
        }
    }

    public Color getColor(String color) {
        if (colors.containsKey(color)){
            return colors.get(color);
        }
        else{
            Color newColor = new Color(color);
            colors.put(color, newColor);
            return newColor;
        }
    }

    public Size getSize(String size) {
        if (sizes.containsKey(size)){
            return sizes.get(size);
        }
        else{
            Size newSize = new Size(size);
            sizes.put(size, newSize);
            return newSize;
        }
    }
}

