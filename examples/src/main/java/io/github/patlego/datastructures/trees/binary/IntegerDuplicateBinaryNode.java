package io.github.patlego.datastructures.trees.binary;

public class IntegerDuplicateBinaryNode extends DuplicateBinaryNode<Integer> {

    public IntegerDuplicateBinaryNode(Integer data) {
        super(data);
    }

    @Override
    public int compareTo(Integer o) {
        if (this.getData() < o) {
            return -1;
        }

        if (this.getData() > o) {
            return 1;
        }

        return 0;
    }
    
}
