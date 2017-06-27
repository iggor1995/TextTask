package epam.text.task.filler;

import epam.text.task.entity.part.*;
import epam.text.task.operation.Splitter;

import java.io.FileInputStream;
import java.io.IOException;

public class Filler {

    private static Text fileText;

    public static Text getFileText() {
        return fileText;
    }

    public void fill() throws IOException {

        FileInputStream inFile = new FileInputStream("Text.txt");
        byte[] str = new byte[inFile.available()];
        inFile.read(str);
        inFile.close();
        String text = new String(str);

        fileText = new Text(text);
        fileText.setList(Splitter.getParList(fileText));

        for(Paragraph paragraph : fileText.getList()){
            paragraph.setList(Splitter.getSenList(paragraph));

            for(Sentence sentence : paragraph.getList()){
                sentence.setList(Splitter.getWordList(sentence));

                for(Word word : sentence.getList()){
                    word.setList(Splitter.getSymbList(word));
                }
            }
        }

    }

}
