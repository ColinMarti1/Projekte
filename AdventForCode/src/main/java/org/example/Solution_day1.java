package org.example;

import java.io.*;
import java.util.*;

public class Solution_day1 {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader("src\\main\\resources\\input_day1.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            ArrayList<Integer> elves = new ArrayList<>();
            int totalCalories = 0;
            for (String zeile = bufferedReader.readLine(); zeile != null; zeile = bufferedReader.readLine()) {
                if (zeile.isBlank()){
                    elves.add(totalCalories);
                    totalCalories = 0;
                }else {
                    int calories = Integer.parseInt(zeile);
                    totalCalories+=calories;
                }
            }
            System.out.println("Top 3:" +elves.stream().sorted(Comparator.reverseOrder()).limit(3).mapToInt(Integer::valueOf).sum());
        } catch (FileNotFoundException e) {
            System.out.println("Datei wurde nicht gefunden");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
