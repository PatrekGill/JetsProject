package com.skilldistillery.jets.entities.parser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public abstract class FileParser {
    private final String fileToParse;

    protected FileParser(String fileToParse) {
        this.fileToParse = fileToParse;
    }

    public void parseFile() {
        try ( BufferedReader bufIn = new BufferedReader(new FileReader(fileToParse)) ) {
            String line;
            while ((line = bufIn.readLine()) != null) {
                onLineRead(line);
            }
        }
        catch (IOException e) {
            System.err.println(e);

        }
    }

    protected abstract void onLineRead(String line);

    public String getFileToParse() {
        return fileToParse;
    }
}
