package epam.text.task.builder;

import epam.text.task.entity.part.*;
import epam.text.task.filler.Filler;

import java.io.*;

public class FileBuilder {
    private static final String SPACE = " ";
    private static final String ENTER = "\r\n";
    private static final String FILENAME = "NewTextFile.txt";

    public static void buildFile() throws IOException {
        File file = new File(FILENAME);
        FileOutputStream outFile = new FileOutputStream(file);
        String s = "";
        for(Paragraph paragraph : Filler.getFileText().getList()){

            for(Sentence sentence : paragraph.getList()){

                for(Word word : sentence.getList()){

                    for (Symbol symbol : word.getList()){
                        s += symbol.getText();
                    }
                    if(word.getPunctMark() != null){
                        s += word.getPunctMark().getText();
                    }
                    s += SPACE;
                }
            }
            s = s.trim();
            s += ENTER;
        }
        s = s.trim();
        outFile.write(s.getBytes());
        outFile.close();
    }
}
