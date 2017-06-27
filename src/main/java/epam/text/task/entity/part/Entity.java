package epam.text.task.entity.part;

import java.util.ArrayList;
import java.util.List;

public abstract class Entity {

    private String text;

    public Entity(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
