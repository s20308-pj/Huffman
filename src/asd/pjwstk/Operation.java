package asd.pjwstk;

import java.util.ArrayList;

public class Operation {
    public ArrayList<Leaf> prepareLeafArray(char[] arrayLetter) {
        ArrayList<Leaf> leafArray = new ArrayList<Leaf>();
        for (char letter : arrayLetter) {
            if (leafArray.size() == 0) {
                leafArray.add(new Leaf(String.valueOf(letter), 1));
            } else {
                boolean addToArray = true;
                for (Leaf leaf : leafArray) {
                    if (String.valueOf(letter).equals(leaf.getVertexChar())) {
                        leaf.setVertexInt(leaf.getVertexInt() + 1);
                        addToArray = false;
                        break;
                    }
                }
                if (addToArray) {
                    leafArray.add(new Leaf(String.valueOf(letter), 1));
                }
            }
        }
        return leafArray;
    }

    public ArrayList<Leaf> heapSort(ArrayList<Leaf> leafArray) {
        for (int i = leafArray.size() / 2 - 1; i >= 0; i--) {
            changeElement(leafArray, leafArray.size(), i);

        }

        return leafArray;
    }

    private void changeElement(ArrayList<Leaf> leafArray, int size, int i) {
        int smallestElement = i;
        int leftElement = 2 * i + 1;
        int rightElement = 2 * i + 2;

        if (leftElement < size &&
                leafArray.get(leftElement).getVertexInt() < leafArray.get(smallestElement).getVertexInt()) {
            smallestElement = leftElement;
        }

        if (rightElement < size &&
                leafArray.get(rightElement).getVertexInt() < leafArray.get(smallestElement).getVertexInt()) {
            smallestElement = rightElement;
        }

        if (smallestElement != i){
            Leaf temp1 = leafArray.get(i);
            Leaf temp2 = leafArray.get(smallestElement);
            leafArray.remove(i);
            leafArray.add(i, temp2);
            leafArray.remove(smallestElement);
            leafArray.add(smallestElement, temp1);

            changeElement(leafArray, size, smallestElement);
        }
    }

    public void repairArray(ArrayList<Leaf> leafArray) {
        int last = leafArray.size()-1;
        Leaf temp1 = leafArray.get(last);
        Leaf temp2 = leafArray.get(0);
        leafArray.remove(last);
        leafArray.add(last, temp2);
        leafArray.remove(0);
        leafArray.add(0, temp1);
    }

    public Leaf createNewLeaf(Leaf first, Leaf second) {
        Leaf leaf = new Leaf(first.getVertexChar()+second.getVertexChar(),
                first.getVertexInt()+second.getVertexInt());
        leaf.setLeftLeaf(first);
        leaf.setLeftLeaf(second);
        return leaf;
    }
}
