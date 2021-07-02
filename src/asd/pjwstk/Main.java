package asd.pjwstk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws IOException {
        FileOperations downloadFromFile = new FileOperations();
        Operation operation = new Operation();
        String text = downloadFromFile.downloadText();
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
        if (leafArray.size() == 2) {
            operation.heapSort(leafArray);
            huffmanTree = operation.createNewLeaf(leafArray.get(0), leafArray.get(1));
            arrayLetter = null;
            System.out.println(huffmanTree.getVertexChar() + ", " + huffmanTree.getVertexInt());
        }

        addCodeToLetter(huffmanTree, "", codeLetter);
        String codeText = codeText(codeLetter, text);

    }

    private static String codeText(HashMap<String, String> codeLetter, String text) {
        String codeText = "";
        for (int i = 0; i < text.length(); i++) {
            for (String keyLetter : codeLetter.keySet()) {
                if (text.charAt(i) == keyLetter.charAt(0)) {
                    codeText = codeText + codeLetter.get(keyLetter);
                }
            }
        }
        System.out.println(codeText);
        return codeText;
    }

    private static void addCodeToLetter(Leaf huffmanTree, String code, HashMap<String, String> codeLetter) {
        if (huffmanTree.getLeftLeaf() == null && huffmanTree.getRightLeaf() == null) {
            System.out.println(huffmanTree.getVertexChar() + ":" + huffmanTree.getVertexInt() + " - " + code);
            codeLetter.put(huffmanTree.getVertexChar(), code);
            return;
        }
        if (huffmanTree.getLeftLeaf() != null) {
            addCodeToLetter(huffmanTree.getLeftLeaf(), code + "0", codeLetter);
        }
        if (huffmanTree.getRightLeaf() != null) {
            addCodeToLetter(huffmanTree.getRightLeaf(), code + "1", codeLetter);
        }
    }


}
