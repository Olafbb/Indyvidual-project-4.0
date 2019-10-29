package com.game.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ScoreWriter {
    private static int countLines(String str) {
        String[] lines = str.split("\n");
        return lines.length;
    }
    public void write(int score, int seconds) {
        File file = new File("C:\\Users\\olafb\\IdeaProjects\\projects\\indyvidual-project-4.0\\src\\main\\resources\\scores.txt");
        try(
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file,true))
        ) {

            String line = "Liczba punktów: "+ score +", liczba sekund: "+ seconds + '\n';
            fileWriter.write(line);
            fileWriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
