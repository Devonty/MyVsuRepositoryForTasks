package ru.cs.vsu.tools;

import java.util.Scanner;

public class FileInfo {
    private String inputPath;
    private String outputPath;
    private int index1;
    private int index2;

    public FileInfo(String inputPath, String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;
    }

    public FileInfo(String[] args) {
        this.parseStringArgs(args);
    }

    public void parseStringArgs(String[] args) {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-i")){
                this.inputPath = args[i++ + 1];
            } else if (args[i].equals("-o")) {
                this.outputPath = args[i++ + 1];
            } else if (args[i].equals("-i1")) {
                this.index1 = Integer.parseInt(args[i++ + 1]);
            } else if (args[i].equals("-i2")) {
                this.index2 = Integer.parseInt(args[i++ + 1]);
            }
        }
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public int getIndex1() {
        return index1;
    }

    public int getIndex2() {
        return index2;
    }

    public void setIndex1(int index1) {
        this.index1 = index1;
    }

    public void setIndex2(int index2) {
        this.index2 = index2;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}