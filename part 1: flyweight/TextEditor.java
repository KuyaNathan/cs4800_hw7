import javax.print.Doc;
import java.util.ArrayList;

public class TextEditor {
    static CharacterPropertyFactory propertyFactory = new CharacterPropertyFactory();
    static ArrayList<CharacterProperty> existingProperties = new ArrayList<>();

    public static void main(String[] args){
        CharacterProperty times12black = propertyFactory.makeCharacterProperty("times new roman", 12, "black");
        CharacterProperty comic10blue = propertyFactory.makeCharacterProperty("comic sans", 10, "blue");
        CharacterProperty roboto20green = propertyFactory.makeCharacterProperty("roboto", 20, "green");
        CharacterProperty calibri8halfred = propertyFactory.makeCharacterProperty("calibri", 8.5, "red");
        CharacterProperty repeatCheck = propertyFactory.makeCharacterProperty("calibri", 8.5, "red");

        String content = "HelloWorldCS4800";

        Document doc1 = new Document("doc1", times12black, content);
        Document doc2 = new Document("doc2", comic10blue, content);
        Document doc3 = new Document("doc3", roboto20green, content);
        Document doc4 = new Document("doc4", calibri8halfred, content);

        Document repeatPropertyDoc = new Document("repeat property check", repeatCheck, content);

        System.out.println();
        System.out.println("---No new properties created if same components exist in an already created property---");
        System.out.println(propertyFactory.showExistingProperties());
        System.out.println("Number of existing properties: " + propertyFactory.showNumberExistingProperties());
        System.out.println();

        System.out.println("---Documents and their properties---");
        doc1.showDocumentDetails();
        doc2.showDocumentDetails();
        doc3.showDocumentDetails();
        doc4.showDocumentDetails();

        System.out.println("Repeat property check doc uses the repeatCheck property" +
                ",\nwhich holds the same properties as calibri8halfred but \ndoes not " +
                "create an entirely new property.\n");
        repeatPropertyDoc.showDocumentDetails();
    }
}
