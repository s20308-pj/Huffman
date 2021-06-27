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
        for (int i = 0; i < leafArray.size()/2; i++){
            if (leafArray.get(i).getVertexInt()<leafArray.get(2*i).getVertexInt()){
                changeLeaf(leafArray,i,2*i);
            } else if (leafArray.get(i).getVertexInt()<leafArray.get(2*i+1).getVertexInt()){
                changeLeaf(leafArray,i,2*i+1);
            }
        }

        return leafArray;
    }

    private void changeLeaf(ArrayList<Leaf> leafArray, int i1, int i2) {
        Leaf temp1 = leafArray.get(i1);
        Leaf temp2 = leafArray.get(i2);
        leafArray.remove(i1);
        leafArray.add(i1,temp1);
        leafArray.remove(i2);
        leafArray.add(i2,temp2);
    }
}
