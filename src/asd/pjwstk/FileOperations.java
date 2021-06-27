package asd.pjwstk;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class FileOperations {
    private String text = null;
    DataInputStream dataInputStream = null;

    public String downloadText() throws IOException {
        try {
            String patchToFile = "C:\\Users\\czapl\\Desktop\\java_studia\\Huffman\\text.txt";
            Scanner scanner = new Scanner(new FileInputStream(patchToFile));
            text = scanner.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null){
                dataInputStream.close();
            }
        }
        return text;
    }
}
