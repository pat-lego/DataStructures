package io.github.patlego.datastructures.lists;

import javax.annotation.Nonnull;

public interface Item<T> extends Comparable<T>, Cloneable {

    public @Nonnull T getData();

    public @Nonnull Item<T> next();

    public @Nonnull Boolean hasNext();

    public @Nonnull Item<T> previous();

    public @Nonnull Boolean hasPrevious();

    public void setPrevious(@Nonnull Item item);

    public void setNext(@Nonnull Item item);

    public Object clone() throws CloneNotSupportedException;
}
