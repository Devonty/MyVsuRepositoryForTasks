import java.util.Arrays;

public class task_7_19 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5, 6}))); // вся
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 3, 3, 4, 5, 6}))); // в конце
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 2, 4, 5, 6}))); // последний
        System.out.println(Arrays.toString(solution(new int[]{2, 1, 2, 2, 2, 5, 6, 2, 3, 4}))); // последний через несколько
        System.out.println(Arrays.toString(solution(new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2, 2}))); // все одинаковые
        System.out.println(Arrays.toString(solution(new int[]{-2, 2, -3, 1, -2, 3, 3, -2, 1, 0}))); // c минусами
        System.out.println(Arrays.toString(solution(new int[]{-2, -2, -1}))); // все минусы
        System.out.println(Arrays.toString(solution(new int[]{-5, -2, 1, 2, 3, 4, 5, 6}))); // вся с минусами
        System.out.println(Arrays.toString(solution(new int[]{1, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0}))); // 0, 1
        System.out.println(Arrays.toString(solution(new int[]{0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1}))); // 0, 1 x 2
    }

    public static int[] solution(int[] nums) {
        // нумерация с нуля
        int max_len = 1, ans_cur = 0, tmp_len = 1, last_cur = 0;
        for (int i = 1; i < nums.length; i++) {
            if (Math.abs(nums[i - 1]) % 2 == Math.abs(nums[i]) % 2) {
                if (tmp_len >= max_len) {
                    max_len = tmp_len;
                    ans_cur = last_cur;
                }
                last_cur = i;
                tmp_len = 1;
            } else {
                tmp_len++;
            }
            if (i == nums.length - 1) {
                if (tmp_len >= max_len) {
                    max_len = tmp_len;
                    ans_cur = last_cur;
                }
            }
        }
        return new int[]{ans_cur, max_len};
    }
}
