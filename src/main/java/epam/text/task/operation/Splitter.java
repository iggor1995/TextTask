package epam.text.task.operation;

import epam.text.task.entity.part.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Splitter {

    private static final String DOTC = "~dot.";
    private static final String EXPOINTC = "~expoint!";
    private static final String QUESTMARKC = "~questmark?";

    public static List<Paragraph> getParList(Entity entity) {
        List<Paragraph> paragraphs = new ArrayList();

        String[] str = entity.getText().split("\\n");

        for (int i = 0; i < str.length; i++) {
            paragraphs.add(new Paragraph(str[i], i));
        }
        return paragraphs;
    }

    public static List<Sentence> getSenList(Entity entity) {
        String text = entity.getText();
        text = text.replaceAll("\\.", DOTC);            //replace all punctuation for saving it after splitting
        text = text.replaceAll("\\!", EXPOINTC);
        text = text.replaceAll("\\?", QUESTMARKC);
        List<Sentence> sentences = new ArrayList();
        String[] str = text.split("[.!?]\\s*");

        for (int i = 0; i < str.length; i++) {
            str[i] = str[i].replace("~dot", ".");
            str[i] = str[i].replace("~expoint", "!");
            str[i] = str[i].replace("~questmark", "?");
            sentences.add(new Sentence(str[i], i));
        }
        return sentences;
    }

    public static List<Word> getWordList(Entity entity) {

        List<Word> words = new ArrayList();
        String[] str = entity.getText().split(" ");
        Pattern p = Pattern.compile("(.+\\.)|(.+,)|(.+\\?)|(.+\\!)");  //if there is punctuation mark in te end, then delete it
        for (int i = 0; i < str.length; i++) {
            Matcher m = p.matcher(str[i]);
            if (m.matches()){
                int strLen = str[i].length();
                String symbolText = str[i].substring(strLen - 1, strLen);
                //deleting
                str[i] = str[i].replaceAll("(\\.)", "");
                str[i] = str[i].replaceAll(",", "");
                str[i] = str[i].replaceAll("\\?", "");
                str[i] = str[i].replaceAll("\\!", "");
                //creating new word obj with punctSymbol
                words.add(new Word(str[i], i, new Symbol(symbolText, i)));
            }
            //without symbol
            else words.add(new Word(str[i], i));
        }
        return words;
    }

    public static List<Symbol> getSymbList(Entity entity){

        List<Symbol> symbols = new ArrayList();
        char[] ch = entity.getText().toCharArray();
        String[] str = new String[ch.length];
        for(int i = 0; i < ch.length; i++){
            str[i] = String.valueOf(ch[i]);
        }
        for(int i = 0; i < str.length; i++){
            symbols.add(new Symbol(str[i], i));
        }
        return symbols;
    }

}
