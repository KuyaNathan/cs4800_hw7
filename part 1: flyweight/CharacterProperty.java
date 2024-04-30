public class CharacterProperty {
    private String font;
    private double size;
    private String color;

    public CharacterProperty(String font, double size, String color){
        this.font = font;
        this.size = size;
        this.color = color;
    }

    public String getFont(){
        return font;
    }

    public double getSize(){
        return size;
    }

    public String getColor(){
        return color;
    }

    public void setFont(String font){
        this.font = font;
    }

    public void setSize(double size){
        this.size = size;
    }

    public void setColor(String color){
        this.color = color;
    }

    public String toString(){
        return("font: " + getFont() + ", size: " + getSize() + ", color: " + getColor());
    }
}
