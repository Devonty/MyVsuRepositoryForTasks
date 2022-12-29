package ru.cs.vsu.task_9_17;

import ru.cs.vsu.tools.Utils;
import ru.cs.vsu.tools.FileInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileInfo fileInfo = new FileInfo(args);

        List<List<Integer>> listMatrix = new ArrayList<>();
        try {
            listMatrix = Utils.getListMatrixFromArrayMatrix(Utils.readIntMatrixFromFile(fileInfo.getInputPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (List<Integer> lst : listMatrix) {
            Main.sort(lst, fileInfo.getIndex1(), fileInfo.getIndex2());
        }
        Utils.printMatrix(listMatrix);

    }

    public static void sort(List<Integer> list, int index1, int index2) {
        index1 = Math.max(0, index1);
        index2 = Math.min(list.size() - 1, index2);

        for (int i = index1; i <= index2; i++) {
            for (int j = index1; j < index2; j++) {

                int leftNum = list.get(j);
                int rightNum = list.get(j + 1);

                if (leftNum > rightNum) {
                    list.set(j, rightNum);
                    list.set(j + 1, leftNum);
                }
            }
        }
    }
}
