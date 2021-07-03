package asd.pjwstk;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.BitSet;
import java.util.Scanner;

public class FileOperations {
    StringBuilder text = new StringBuilder();
    DataInputStream dataInputStream = null;
    ObjectOutputStream objectOutputStream = null;

    public String downloadText() throws IOException {
        try {
            String patchToFile = "C:\\Users\\czapl\\Desktop\\java_studia\\Huffman\\text.txt";
            Scanner scanner = new Scanner(new FileInputStream(patchToFile));
            while (scanner.hasNextLine()) {
                text.append(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
        }
        return text.toString();
    }

    public void saveAsBinaryFile(BitSet codeText) {

        String patchToFile = "C:\\Users\\czapl\\Desktop\\java_studia\\Huffman\\binaryFile";
        try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(patchToFile));
                objectOutputStream.writeObject(codeText);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
