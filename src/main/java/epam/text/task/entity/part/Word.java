package epam.text.task.entity.part;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 27.06.2017.
 */
public class Word extends Entity{

    private List<Symbol> list = new ArrayList();
    private int serial;
    private Symbol punctMark;
    public Word(String text, int serial, Symbol punctMark) {
        super(text);
        this.serial = serial;
        this.punctMark = punctMark;
    }
    public Word(String text, int serial) {
        super(text);
        this.serial = serial;
    }

    public void setList(List<Symbol> list) {
        this.list = list;
    }

    public List<Symbol> getList() {
        return list;
    }

    public Symbol getPunctMark() {
        return punctMark;
    }
}
