public class Document {
    private String name;
    private String content;
    private CharacterProperty style;

    public Document(String name, CharacterProperty style, String content){
        this.name = name;
        this.style = style;
        this.content = content;
    }

    public String getName(){
        return name;
    }

    public CharacterProperty getStyle(){
        return style;
    }

    public String getContent(){
        return content;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setStyle(CharacterProperty style){
        this.style = style;
    }

    public void setContent(String content){
        this.content = content;
    }

    public void addContent(String contentToAdd){
        this.content = this.content.concat(contentToAdd);
    }

    public String toString(){
        return (getName() + ":\nProperties: " + getStyle().toString() + "\nContent: " + getContent() + "\n");
    }

    public void showDocumentDetails(){
        System.out.println(toString());
    }
}
