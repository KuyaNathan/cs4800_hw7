
import org.junit.Test;
import static org.junit.Assert.*;
public class FlyweightTest {
    @Test
    public void testMakeCharacterProperty(){
        CharacterPropertyFactory factory = new CharacterPropertyFactory();

        CharacterProperty one = factory.makeCharacterProperty("roboto", 10, "blue");
        CharacterProperty two = factory.makeCharacterProperty("roboto", 10, "blue");
        CharacterProperty three = factory.makeCharacterProperty("arial", 12, "red");

        assertSame(one, two);
        assertNotSame(one, three);
    }

    @Test
    public void testCreateDocument(){
        CharacterPropertyFactory factory = new CharacterPropertyFactory();

        CharacterProperty one = factory.makeCharacterProperty("times", 12, "black");

        String content = "testing one two three";

        Document doc1 = new Document("tester", one, content);

        assertNotNull(doc1);
        assertEquals("times", doc1.getStyle().getFont());
        assertEquals(12, doc1.getStyle().getSize(), 0.001);
        assertEquals("black", doc1.getStyle().getColor());
        assertEquals("testing one two three", doc1.getContent());
    }
}
