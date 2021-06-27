package asd.pjwstk;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOperations downloadFromFile = new FileOperations();
        Operation operation = new Operation();
        String text = downloadFromFile.downloadText();
        char[] arrayLetter = text.toCharArray();
        ArrayList<Leaf> leafArray = operation.prepareLeafArray(arrayLetter);
        printLeafArray(leafArray);
        leafArray = operation.heapSort(leafArray);
        printLeafArray(leafArray);
        leafArray = operation.heapSort(leafArray);
        printLeafArray(leafArray);
    }

    private static void printLeafArray(ArrayList<Leaf> leafArray) {
        for (Leaf leaf : leafArray) {
            System.out.print(leaf.getVertexChar() + "," + leaf.getVertexInt()+"; ");
        }
        System.out.println("");
    }


}
