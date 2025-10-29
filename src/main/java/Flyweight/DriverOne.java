package Flyweight;

public class DriverOne {

    public static void main(String[] args) {
        CharacterPropertiesFactory factory = new CharacterPropertiesFactory();

        //Saving Documents

        Document document = new Document(factory);

        String word = "HelloWorldCS5800";

        //Variation 1
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            document.addCharacter(c, "Arial", "Red", "12");
        }
        System.out.println("Variation 1: ");
        document.displayDocument();
        try{
            document.saveDocument("Variation1.txt");
        }catch(Exception e){
            System.out.println(e);
        }

        //Variation 2
        document = new Document(factory);
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            document.addCharacter(c, "Calibri", "Blue", "14");
        }
        System.out.println("Variation 2: ");
        document.displayDocument();
        try{
            document.saveDocument("Variation2.txt");
        }catch(Exception e){
            System.out.println(e);
        }

        //Variation 3
        document = new Document(factory);
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            document.addCharacter(c, "Verdana", "Black", "16");
        }
        System.out.println("Variation 3: ");
        document.displayDocument();
        try{
            document.saveDocument("Variation3.txt");
        }catch(Exception e){
            System.out.println(e);
        }

        //Variation 4
        document = new Document(factory);
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            document.addCharacter(c, "Calibri", "Red", "16");
        }
        System.out.println("Variation 4: ");
        document.displayDocument();
        try{
            document.saveDocument("Variation4.txt");
        }catch(Exception e){
            System.out.println(e);
        }
        System.out.println("------------------------------------------");
        //Loading Documents

        try{
            Document loadedDocument1 = new Document(factory);
            loadedDocument1.loadDocument("Variation1.txt");
            System.out.println("Loaded document 1: ");
            loadedDocument1.displayDocument();

            Document loadedDocument2 = new Document(factory);
            loadedDocument2.loadDocument("Variation2.txt");
            System.out.println("Loaded document 2: ");
            loadedDocument2.displayDocument();

            Document loadedDocument3 = new Document(factory);
            loadedDocument3.loadDocument("Variation3.txt");
            System.out.println("Loaded document 3: ");
            loadedDocument3.displayDocument();

            Document loadedDocument4 = new Document(factory);
            loadedDocument4.loadDocument("Variation4.txt");
            System.out.println("Loaded document 4: ");
            loadedDocument4.displayDocument();

            System.out.println("------------------------------------------");
            loadedDocument4.changeCharacterProperties(0,"Arial","Blue","14");
            System.out.println("Changed document 4 1st character Properties: ");
            loadedDocument4.displayDocument();
            loadedDocument4.saveDocument("Variation4.txt");
        }
        catch(Exception e){
            System.out.println(e);
        }


    }




}
