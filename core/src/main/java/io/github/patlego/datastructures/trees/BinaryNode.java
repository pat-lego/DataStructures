package io.github.patlego.datastructures.trees;

import java.util.Arrays;
import java.util.List;

public abstract class BinaryNode<T> implements Node<T> {

    private BinaryNode<T> left;
	private BinaryNode<T> right;
	
	private T data;

	public BinaryNode(T data) {
		if (data == null) {
			throw new IllegalArgumentException("Cannot have a null data parameter provided to the Binary Node");
		}

		this.data = data;
	}
    
	@Override
	public Boolean hasChildren() {
		if (left != null) {
            return Boolean.TRUE;
        }

        if (right != null) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
    
	@Override
	public List<Node<T>> getChildren() {
        return Arrays.asList(left, right);
    }
    
	@Override
	public Integer size() {
        Integer size = 1;
        if (left != null) {
            size = size + 1;
        }

        if (right != null) {
            size = size + 1;
        }

        return size;
    }

	@Override
	public T getData() {
		return this.data;
    }
    
    public BinaryNode<T> getLeft() {
        return this.left;
    }

    public BinaryNode<T> getRight() {
        return this.right;
    }

    public void setLeft(BinaryNode<T> left) {
        this.left = left;
    }

    public void setRight(BinaryNode<T> right) {
        this.right = right;
    }
    
}
