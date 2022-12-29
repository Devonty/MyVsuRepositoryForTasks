package ru.cs.vsu.task_10_18;

import ru.cs.vsu.tools.Utils;
import ru.cs.vsu.tools.FileInfo;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        FileInfo fileInfo = new FileInfo(args);
        int[][] matrix;

        try {
            matrix = Utils.readIntMatrixFromFile(fileInfo.getInputPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < matrix.length; i++) {
            Point a, b, c;
            System.out.println(Arrays.toString(matrix[i]));
            a = new Point(matrix[i][0], matrix[i][1]);
            b = new Point(matrix[i][2], matrix[i][3]);
            c = new Point(matrix[i][4], matrix[i][5]);

            Triangle triangle = new Triangle(a,b,c);
            boolean status = TriangleThings.checkTriangle(triangle);
            System.out.println(status);
        }

    }
}
