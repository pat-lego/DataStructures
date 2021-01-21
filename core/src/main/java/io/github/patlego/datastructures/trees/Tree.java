package io.github.patlego.datastructures.trees;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;


public interface Tree {
    
    public @Nonnull <T> Boolean isRoot(@Nonnull Node<T> node);

    public @Nonnull <T> Node<T> getRoot();

    public @Nonnull @Nonnegative Integer size();

    public @Nonnull <T> Boolean hasParent(Node<T> node);

    public @Nonnull <T> Node<T> getParent(Node<T> node);
}
