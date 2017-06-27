package epam.text.task.entity.part;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.06.2017.
 */
public class Text extends Entity {

    private List<Paragraph> list = new ArrayList();
    public Text(String text) {
        super(text);
    }

    public List<Paragraph> getList() {
        return list;
    }

    public void setList(List<Paragraph> list) {
        this.list = list;
    }
}
