package ru.cs.vsu.task_7_29;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[]{1,2,2,1,2,3,4,5,1,2,3,4,5,6,7,6,5,4,3,2,1,0}; // ответ 14 8
        int indexAns = -1, lenghtAns = 0;

        // WORK PART
        for (int i = 0; i < array.length; i++) {
            HashSet<Integer> hashSet = new HashSet<>();
            for (int ln_now = 1; ln_now <= array.length; ln_now++) {
                for (int j = i; j < i + ln_now && j < array.length; j++) hashSet.add(array[j]); // закидываю все элементы от i до i + ln_now в множество
                if (ln_now == hashSet.size() && ln_now >= lenghtAns) {
                    indexAns = i;
                    lenghtAns = ln_now;
                }
            }
        }
        // END WORK PART
        System.out.println(indexAns + " " + lenghtAns);
        for (int i = indexAns; i < indexAns + lenghtAns; i++) {
            System.out.print(array[i] + " ");
        }

    }


}
