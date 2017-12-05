package com.radiofc;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InputFileReader {

    private static final Logger LOGGER = Logger.getLogger(InputFileReader.class);

    private InputFileReader() {
    }

    public static List<String> readFile(String filePath) {
        List<String> linesOfText = new ArrayList<>();

        PropertyConfigurator.configure(LogMessage.LOG4JCONFPATH);

        try {
            try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                String sCurrentLine;
                while ((sCurrentLine = br.readLine()) != null) {
                    LOGGER.info("Line: "+ sCurrentLine);
                    linesOfText.add(sCurrentLine);
                }
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return linesOfText;
    }


}
