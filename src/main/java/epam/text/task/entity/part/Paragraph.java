package epam.text.task.entity.part;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.06.2017.
 */
public class Paragraph extends Entity {

    private List<Sentence> list = new ArrayList();
    private int serial;
    public Paragraph(String text, int serial) {
        super(text);
        this.serial = serial;
    }

    public void setList(List<Sentence> list) {
        this.list = list;
    }

    public List<Sentence> getList() {
        return list;
    }
}
