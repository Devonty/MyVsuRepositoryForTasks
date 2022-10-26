package task_8_27;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Utils {

    public static void writeToFile(String fileName, String data) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(data);

            writer.close();
        }
        catch (IOException ie){
            ie.printStackTrace();
        }
    }
}
