package ru.cs.vsu.task_8_27;

import ru.cs.vsu.tools.FileInfo;
import ru.cs.vsu.tools.Utils;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        int[][] matrix = {
                new int[]{1, 3, 4, 10, 11},
                new int[]{2, 5, 9, 12, 17},
                new int[]{6, 8, 13, 16, 18},
                new int[]{7, 14, 15, 19, 20},
        };
        System.out.print(isMatrixCorrect(matrix));

        System.out.println();

        FileInfo fileInfo = new FileInfo(args);
        matrix = Utils.readIntMatrixFromFile(fileInfo.getInputPath());
        System.out.print(isMatrixCorrect(matrix));
    }

    public static boolean isMatrixCorrect(int[][] matrix) {
        int i, j;
        int rows = matrix.length;
        int cols = matrix[0].length;

        int lastChecked = matrix[0][0] - 1;
        int diagonalCount = rows + cols - 1;
        for (int k = 0; k < diagonalCount; k++) {
            // right up
            if (k % 2 == 1) {
                j = 0;
                i = k;

                // not inside
                if (i >= rows) {
                    int dif = Math.abs(rows - i) + 1;
                    i -= dif;
                    j += dif;
                }

                while (i >= 0) {
                    if (j >= cols) break;

                    if (matrix[i][j] > lastChecked) {
                        System.out.println(matrix[i][j]);
                        lastChecked = matrix[i][j];
                    } else {
                        return false;
                    }

                    i--;
                    j++;

                }
            } else {
                // left down
                j = k;
                i = 0;

                // not inside
                if (j >= rows) {
                    int dif = Math.abs(cols - j) + 1;
                    i += dif;
                    j -= dif;
                }

                while (j >= 0) {
                    if (i >= rows) break;

                    if (matrix[i][j] > lastChecked) {
                        System.out.println(matrix[i][j]);
                        lastChecked = matrix[i][j];
                    } else {
                        return false;
                    }

                    i++;
                    j--;

                }
            }
        }
        return true;
    }
}