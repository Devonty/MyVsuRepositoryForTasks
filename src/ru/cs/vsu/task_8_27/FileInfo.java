package ru.cs.vsu.task_8_27;

import java.util.Scanner;

public class FileInfo {
    private String inputPath;
    private String outputPath;

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
            }
        }
    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}