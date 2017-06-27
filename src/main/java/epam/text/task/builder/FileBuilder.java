package epam.text.task.builder;

import epam.text.task.entity.part.*;
import epam.text.task.filler.Filler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by User on 27.06.2017.
 */
public class FileBuilder {
    private static final String SPACE = " ";
    private static final String ENTER = "\n";
    private static final String FILENAME = "NewTextFile.txt";

    public static void buildFile() throws IOException {
        File file = new File(FILENAME);
        FileOutputStream outFile = new FileOutputStream(file);

        for(Paragraph paragraph : Filler.getFileText().getList()){

            for(Sentence sentence : paragraph.getList()){

                for(Word word : sentence.getList()){

                    for (Symbol symbol : word.getList()){
                        outFile.write(symbol.getText().getBytes());         //writing symbols from the word
                    }
                    if(word.getPunctMark() != null){
                        outFile.write(word.getPunctMark().getText().getBytes()); // if there is punct, add to the file
                    }
                    outFile.write(SPACE.getBytes());  // adding spaces after words

                }
            }
            outFile.write(ENTER.getBytes());        //adding enters after paragraphs
        }
        outFile.close();
    }
}
