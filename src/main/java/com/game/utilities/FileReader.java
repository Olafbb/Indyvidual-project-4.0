package com.game.utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {

    private StringBuilder stringBuilder;

    private static int countLines(String str) {
        String[] lines = str.split("\n");
        return lines.length;
    }

    public String getFileContent(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(fileName).getFile());
        Path path = Paths.get(file.getPath());

        try {
            String fileLines = Files.readAllLines(path).toString();
            fileLines = fileLines.replace("[", "");
            fileLines = fileLines.replace("]", "");
            StringBuilder stringBuilder = new StringBuilder(fileLines);
            for (int i = 0; i < stringBuilder.length(); i += 40)
                stringBuilder.insert(i, '\n');


            return stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();

            return file.getPath();
        }
    }
}
