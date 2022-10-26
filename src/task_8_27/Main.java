package task_8_27;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Utils.writeToFile("output.txt", "test message\n samlpe");
    }

    public static void solve0(){
        for(int i = 1; i <= 4; i++){
            int char_id = 'a' + i - 1;
            char char_now = (char)char_id;
            String stringPart = String.valueOf(char_now);
            System.out.print(String.join("", Collections.nCopies(i, stringPart)));
        }
    }
}

