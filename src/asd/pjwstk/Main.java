package asd.pjwstk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOperations fileOperations = new FileOperations();
        Operation operation = new Operation();
        String text = fileOperations.downloadText();
        char[] arrayLetter = text.toCharArray();
        ArrayList<Leaf> leafArray = operation.prepareLeafArray(arrayLetter);
        Operation.printLeafArray(leafArray);
        Leaf huffmanTree = new Leaf();
        HashMap<String, String> codeLetter = new HashMap<>();

        while (leafArray.size() != 2) {
            Leaf first = Operation.sortGetRemoveAddLeaf(leafArray);
            Leaf second = Operation.sortGetRemoveAddLeaf(leafArray);

            leafArray.add(operation.createNewLeaf(first, second));
            Operation.printLeafArray(leafArray);
        }
        Operation.heapSort(leafArray);
        huffmanTree = operation.createNewLeaf(leafArray.get(0), leafArray.get(1));
        arrayLetter = null;
        System.out.println(huffmanTree.getVertexChar() + ", " + huffmanTree.getVertexInt());

        Operation.addCodeToLetter(huffmanTree, "", codeLetter);
        BitSet byteArray = Operation.codeText(codeLetter, text);
        fileOperations.saveAsBinaryFile(byteArray);
//        for (byte b:byteArray) {
//            System.out.print(b);
//        }
    }

}
