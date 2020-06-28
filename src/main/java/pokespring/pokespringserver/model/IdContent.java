package pokespring.pokespringserver.model;

public class IdContent {
    private String id;
    private String content;

    public IdContent(String id, String content) {
        this.id = id;
        this.content = content;
    }

    public IdContent() {
        this.id = "";
        this.content = "";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
