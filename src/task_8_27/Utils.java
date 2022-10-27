package task_8_27;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils {
    public static void writeToFile(String fileName, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(data);

            writer.close();
        }
        catch (IOException ie){
            ie.printStackTrace();
        }
    }

    public static final String NOT_FOUND_MSG = "//_File_not_found_//";

    public static String readFile(String fileName) {
        StringBuilder fileDataBuilder = new StringBuilder();
        InputStream in = Main.class.getResourceAsStream("data/input/" + fileName);
        try {
            if (in != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String line = null;
                while ((line = reader.readLine()) != null) {
                    fileDataBuilder.append(line).append('\n');
                }
            } else {
                fileDataBuilder.append("//_File_not_found_//");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return fileDataBuilder.toString();
    }

    public static boolean writeFile(String fileName) {
        return true;
    }

    public static List<List<Integer>> getIntData(String fileData) {
        List<List<Integer>> listOfLists = new ArrayList<>();
        String[] lines = fileData.split("\n");

        for (String line : lines) {
            List<Integer> listInteger = new ArrayList<>();
            String[] lineSplited = line.split(" ");

            for (String strNum : lineSplited) {
                try {
                    Integer num = Integer.parseInt(strNum);
                    listInteger.add(num);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            listOfLists.add(listInteger);
        }

        return listOfLists;
    }

    // DEFAULT
    public static boolean writeFile() {
        return writeFile("output.txt");
    } // Значение по умолчанию

    public static String readFile() {
        return readFile("input.txt");
    } // Значение по умолчанию


}


