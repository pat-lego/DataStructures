package io.github.patlego.datastructures.trees.impl;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import io.github.patlego.datastructures.trees.BinaryTree;
import io.github.patlego.datastructures.trees.Node;

public class SimpleBinaryTree extends BinaryTree {

    public <T> SimpleBinaryTree(Node<T> node) {
        super(node);
    }

    @Override
    public <T> Boolean add(Node<T> node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> Boolean remove(Node<T> node) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> List<Node<T>> getAllNodes(Node<T> start) {
        List<Node<T>> nodes = new LinkedList<Node<T>>();
        if (start.hasChildren()) {
            start.getChildren().stream().forEach(node -> {
                nodes.addAll(getAllNodes(node));
            });
        } else {
            return Arrays.asList(start);
        }
        nodes.add(start);
        return nodes;
    }

}
