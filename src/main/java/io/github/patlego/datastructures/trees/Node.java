package io.github.patlego.datastructures.trees;

import java.util.List;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

public interface Node<T> extends Comparable {

    public @Nonnull Boolean add(@Nonnull Node<T> node);

    public @Nonnull Boolean hasChildren();

    public @Nonnull List<Node<T>> getChildren();

    public @Nonnull @Nonnegative Integer size();

    public @Nonnull Boolean remove(@Nonnull Node<T> node);

    public @Nonnull Boolean hasNode(@Nonnull Node<T> node);

    public @Nonnull Boolean hasParent();

    public @Nonnull Node<T> getParent();
    
}
