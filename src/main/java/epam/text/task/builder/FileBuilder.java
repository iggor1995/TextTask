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
        String newText = "";
        for(Paragraph paragraph : Filler.getFileText().getList()){

            for(Sentence sentence : paragraph.getList()){

                for(Word word : sentence.getList()){

                    for (Symbol symbol : word.getList()){
                        newText += symbol.getText();
                    }
                    if(word.getPunctMark() != null){
                        newText += word.getPunctMark().getText();
                    }
                    newText += SPACE;
                }
            }
            newText = newText.trim();
            newText += ENTER;
        }
        newText = newText.trim();
        outFile.write(newText.getBytes());
        outFile.close();
    }
}
