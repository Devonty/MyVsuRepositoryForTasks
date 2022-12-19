package ru.cs.vsu.task_12_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Directory {
    private String directoryName;
    List<Directory> includes;

    public Directory(String directoryName, List<Directory> includes) {
        this.directoryName = directoryName;
        this.includes = includes;
    }

    public Directory(String directoryName) {
        this.directoryName = directoryName;
        this.includes = new ArrayList<>();
    }

    public static void main(String[] args) {
        System.out.println("\nFIRST");
        String pattern = "(a, second, (abc, y, (x, 7), uuu, (8, 9, (10, 1))), abcddcdba)";
        Directory directory = Directory.buildDirectoryFromString(pattern);
        directory.printTraceTree();

        System.out.println("\nSECOND");
        pattern = "(a, b, (c), d)";
        directory = Directory.buildDirectoryFromString(pattern);
        directory.printTraceTree();

    }


    public static Directory buildDirectoryFromString(String pattern) {
        String stripedPattern = pattern.substring(1, pattern.length() - 1); // erase "(" and ")"
        String[] splitPattern = Directory.splitPatternOneLayer(stripedPattern);
        System.out.println(Arrays.toString(splitPattern));

        Directory directory = new Directory(splitPattern[0]);

        for (int i = 1; i < splitPattern.length; i++) {
            String part = splitPattern[i];

            Directory toAddDirectory;
            if (part.startsWith("(")) {
                toAddDirectory = Directory.buildDirectoryFromString(part);
            } else {
                toAddDirectory = new Directory(part);
            }
            directory.addToDirectory(toAddDirectory);
        }

        return directory;
    }

    private static String[] splitPatternOneLayer(String pattern) {
        List<String> splitList = new ArrayList<>();
        char[] charPattern = (pattern + ",").toCharArray();
        int layerNum = 0;
        int lastIndex = 0;

        for (int i = 0; i < charPattern.length; i++) {
            if (charPattern[i] == ',' && layerNum == 0) {
                splitList.add(pattern.substring(lastIndex, i).strip());
                lastIndex = i + 1;
            } else if (charPattern[i] == '(') {
                layerNum++;
            } else if (charPattern[i] == ')') {
                layerNum--;
            }
        }
        String[] array = new String[splitList.size()];
        splitList.toArray(array); // fill the array
        return array;
    }

    public void printTraceTree() {
        printTraceTree(0);
    }

    public void printTraceTree(int layerNum) {
        String line = "";
        if (layerNum != 0) {
            line = "|  ".repeat(layerNum - 1);
            line += "+-";
        }
        line += this.directoryName;
        System.out.println(line);

        for (Directory directory : this.includes) {
            directory.printTraceTree(layerNum + 1);
        }
    }

    public void setDirectoryName(String directoryName) {
        this.directoryName = directoryName;
    }

    public void setIncludes(List<Directory> includes) {
        this.includes = includes;
    }

    public String getDirectoryName() {
        return directoryName;
    }

    public List<Directory> getIncludes() {
        return includes;
    }

    public void addToDirectory(Directory toAddDirectory) {
        this.includes.add(toAddDirectory);
    }
}
