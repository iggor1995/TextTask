package epam.text.task.entity.part;

/**
 * Created by User on 27.06.2017.
 */
public class Symbol extends Entity {

    private int serial;
    public Symbol(String text, int serial) {
        super(text);
        this.serial = serial;
    }

}
