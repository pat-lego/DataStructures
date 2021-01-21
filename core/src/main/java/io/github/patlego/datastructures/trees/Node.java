package io.github.patlego.datastructures.trees;

import java.util.List;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public interface Node<T> extends Comparable<T> {

    /**
     * Returns true if this node has children associated to it, False if this node is a leaf node
     * @return If this node has children
     */
    public @Nonnull Boolean hasChildren();

    /**
     * Returns the list of children nodes associated to it.
     * @return
     */
    public @Nonnull List<Node<T>> getChildren();

    /**
     * The size of a node is calculated as the sum of all of its children directly below it and itself, thus the minimum size of any node is 1
     * @return The size of the nodes descendants at depth 1, including itself
     */
    public @Nonnull @Nonnegative Integer size();

    /**
     * Returns the data this node stores
     * @return Node data
     */
    public T getData();
    
}
