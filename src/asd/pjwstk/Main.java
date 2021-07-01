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

        while (leafArray.size() != 2) {
            leafArray = operation.heapSort(leafArray);
            Leaf first = leafArray.get(0);
            leafArray.remove(0);
            operation.repairArray(leafArray);
            operation.heapSort(leafArray);
            Leaf second = leafArray.get(0);
            leafArray.remove(0);
            operation.repairArray(leafArray);
            leafArray.add(operation.createNewLeaf(first, second));
            printLeafArray(leafArray);
        }
        if (leafArray.size()==2){
            operation.heapSort(leafArray);
            Leaf leaf = operation.createNewLeaf(leafArray.get(0), leafArray.get(1));
            arrayLetter = null;
            System.out.println(leaf.getVertexChar()+", "+leaf.getVertexInt());
        }
    }

    private static void printLeafArray(ArrayList<Leaf> leafArray) {
        for (Leaf leaf : leafArray) {
            System.out.print(leaf.getVertexChar() + "-" + leaf.getVertexInt() + "; ");
        }
        System.out.println("");
    }


}
