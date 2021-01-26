package io.github.patlego.datastructures.trees.avl;

public class IntegerDuplicateAVLNode extends DuplicateAVLNode<Integer> {

    public IntegerDuplicateAVLNode(Integer data) {
        super(data);
    }

    @Override
    public int compareTo(Integer o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot compare a value to null in the compareTo function");
        }

        if (getData() < o) {
            return -1;
        }

        if (getData() > o) {
            return 1;
        }

        return 0;
    }

    
}
