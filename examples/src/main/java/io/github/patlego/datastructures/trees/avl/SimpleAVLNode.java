package io.github.patlego.datastructures.trees.avl;

public class SimpleAVLNode extends AVLNode<Integer> {

    public SimpleAVLNode(Integer data) {
        super(data);
    }

    @Override
    public int compareTo(Integer o) {
        if (o == null) {
            throw new IllegalArgumentException("Cannot supply a null value to compare against");
        }
        
        if (this.getData() < o) {
            return -1;
        }

        if (this.getData() > o) {
            return 1;
        }

        return 0;
    }
    
}
