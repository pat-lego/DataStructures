package io.github.patlego.datastructures.trees.impl;

import java.util.Arrays;
import java.util.List;

import io.github.patlego.datastructures.trees.Node;

public abstract class BinaryNode<T> implements Node<T> {

    public Node<T> left;
    public Node<T> right;
    
	@Override
	public Boolean add(Node<T> node) {
		// TODO Auto-generated method stub
		return null;
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
        Integer size = 0;
        if (left != null) {
            size = size + 1;
        }

        if (right != null) {
            size = size + 1;
        }

        return size;
    }
    
	@Override
	public Boolean remove(Node<T> node) {
       // TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean hasNode(Node<T> node) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Boolean hasParent() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Node<T> getParent() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public T getData() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setData(T data) {
		// TODO Auto-generated method stub
		
	}
    
}
