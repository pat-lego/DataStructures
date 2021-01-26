package io.github.patlego.datastructures.trees.binary;

public abstract class DuplicateBinaryNode<T> extends BinaryNode<T> {

    private Integer count = 1;

    public DuplicateBinaryNode(T data) {
        super(data);
    }

    public void removeInstance() {
        if (count < 1) {
            return;
        }

        count = count - 1;
    }

    public void addInstance() {
        count = count + 1;
    }

    public Integer getCount() {
        return this.count;
    }
    
    
}
