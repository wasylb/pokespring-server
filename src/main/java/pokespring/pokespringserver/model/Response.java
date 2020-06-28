package pokespring.pokespringserver.model;

public class Response extends IdContent {

    private String id;
    private String content;
    private String classRelated;


    public Response(String id, String content, String classRelated) {
        super(id, content);
        this.classRelated = classRelated;
    }

    public Response() {
        super();
        this.classRelated = "";
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

    public String getClassRelated() {
        return classRelated;
    }

    public void setClassRelated(String classRelated) {
        this.classRelated = classRelated;
    }
}
