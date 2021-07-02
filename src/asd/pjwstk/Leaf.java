package asd.pjwstk;

public class Leaf {
    private String vertexChar;
    private int vertexInt;
    private Leaf leftLeaf = null;
    private Leaf rightLeaf = null;

    public Leaf() {
    }

    public Leaf(String vertexChar, int instanceOfItem) {
        this.vertexChar = vertexChar;
        this.vertexInt = instanceOfItem;
    }

    public String getVertexChar() {
        return vertexChar;
    }

    public void setVertexChar(String vertexChar) {
        this.vertexChar = vertexChar;
    }

    public int getVertexInt() {
        return vertexInt;
    }

    public void setVertexInt(int vertexInt) {
        this.vertexInt = vertexInt;
    }

    public Leaf getLeftLeaf() {
        return leftLeaf;
    }

    public void setLeftLeaf(Leaf leftLeaf) {
        this.leftLeaf = leftLeaf;
    }

    public Leaf getRightLeaf() {
        return rightLeaf;
    }

    public void setRightLeaf(Leaf rightLeaf) {
        this.rightLeaf = rightLeaf;
    }
}
