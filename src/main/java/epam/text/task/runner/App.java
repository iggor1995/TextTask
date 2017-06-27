package epam.text.task.runner;

import epam.text.task.builder.FileBuilder;
import epam.text.task.filler.Filler;
import java.io.*;


public class App 
{
    public static void main( String[] args ) throws IOException {

        Filler filler = new Filler();
        filler.fill();

        FileBuilder.buildFile();


    }
}
