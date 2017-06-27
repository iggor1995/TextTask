package epam.text.task.entity.part;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.06.2017.
 */
public class Sentence extends Entity {

    private List<Word> list = new ArrayList();
    private int serial;
    public Sentence(String text, int serial) {
        super(text);
        this.serial = serial;
    }

    public void setList(List<Word> list) {
        this.list = list;
    }

    public List<Word> getList() {
        return list;
    }
}
