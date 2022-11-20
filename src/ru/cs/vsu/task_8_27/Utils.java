package ru.cs.vsu.task_8_27;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {
    public static void writeIntMatrixToFile(String filePath, int[][] matrix) throws IOException {
        File file = new File(filePath);
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        StringBuilder matrixString = new StringBuilder();
        // Write size
        matrixString.append(matrix.length);
        matrixString.append(" ");
        matrixString.append(matrix[0].length);
        matrixString.append("\n");
        // Write matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrixString.append(matrix[i][j]);
                matrixString.append(" ");
            }
            matrixString.append("\n");
        }

        fileOutputStream.write(matrixString.toString().getBytes());
        fileOutputStream.close();

    }

    public static int[][] readIntMatrixFromFile(String filePath) throws IOException {
        System.out.println(filePath);
        File file = new File(filePath);
        file.createNewFile();
        Scanner scanner = new Scanner(file);


        int countRows = scanner.nextInt();
        int countColumns = scanner.nextInt();

        int[][] matrix = new int[countRows][countColumns];
        for (int i = 0; i < countRows; i++) {
            for (int j = 0; j < countColumns; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> getListMatrixFromArrayMatrix(int[][] input) {
        // convert int[][] to List<List<Integer>>

        List<List<Integer>> newList = new ArrayList<List<Integer>>();
        for (int[] ints : input) {
            List<Integer> output = new ArrayList<Integer>();
            for (int value : ints) {
                output.add(value);
            }
            newList.add(output);
        }
        return newList;
    }

    public static int[][] getIntMatrixFromListMatrix(List<List<Integer>> input) {
        // convert List<List<Integer>> to int[][]
        int rows = input.size();
        int cols = input.get(0).size();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input.get(i).get(j);
            }
        }
        return matrix;
    }

    public static int[][] getMatrixFromTable(JTable table) {
        // sizes
        int rows = table.getRowCount();
        int cols = table.getColumnCount();

        int[][] matrix = new int[rows][cols];

        // write from table
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                Object nm = table.getModel().getValueAt(i, j);
                matrix[i][j] = Integer.parseInt(nm.toString());
            }
        }

        return matrix;
    }

    public static void setMatrixToTable(JTable table, int[][] matrix) {
        // sizes
        int rows = matrix.length;
        int cols = matrix[0].length;

        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        dtm.setColumnCount(cols);
        dtm.setRowCount(rows);


        // write from table
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dtm.setValueAt(matrix[i][j], i, j);
            }
        }

        table.setModel(dtm);
    }

    // DEFAULT
    public static void printMatrix(List<List<Integer>> listMatrix) {
        printMatrix(Utils.getIntMatrixFromListMatrix(listMatrix));
    }

    public static void setMatrixToTable(JTable table, List<List<Integer>> listMatrix){
        int[][] matrix = Utils.getIntMatrixFromListMatrix(listMatrix);
        setMatrixToTable(table, matrix);
    }
    public static int[][] readIntMatrixFromFile() throws IOException {
        return readIntMatrixFromFile("src/ru/cs/vsu/task_8_27/input/input.txt");
    }

    public static void writeIntMatrixToFile(int[][] matrix) throws IOException {
        writeIntMatrixToFile("src/ru/cs/vsu/task_8_27/output/output.txt", matrix);
    }
}