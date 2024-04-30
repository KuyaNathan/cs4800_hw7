import java.util.ArrayList;

public class CharacterPropertyFactory {
    private ArrayList<CharacterProperty> characterPropertiesList = new ArrayList<>();
    public CharacterProperty makeCharacterProperty(String font, double size, String color){
        for(CharacterProperty charProp : characterPropertiesList){
            if((font.equalsIgnoreCase(charProp.getFont())) && (size == charProp.getSize()) && (color.equalsIgnoreCase(charProp.getColor()))){
                return charProp;
            }
        }

        CharacterProperty newProperty = new CharacterProperty(font, size, color);
        characterPropertiesList.add(newProperty);
        return newProperty;
    }

    public ArrayList<CharacterProperty> showExistingProperties(){
        return characterPropertiesList;
    }

    public int showNumberExistingProperties(){
        return characterPropertiesList.size();
    }
}
