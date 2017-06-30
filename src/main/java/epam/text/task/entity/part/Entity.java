package epam.text.task.entity.part;

public abstract class Entity {

    private String text;

    public Entity(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

}
