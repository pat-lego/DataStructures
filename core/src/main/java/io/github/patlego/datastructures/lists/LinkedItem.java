package io.github.patlego.datastructures.lists;

public abstract class LinkedItem<T> implements Item<T>, Cloneable {

    private T data;
    private Item<T> next;
    private Item<T> previous;

    public LinkedItem(T data) {
        if (data == null) {
            throw new IllegalArgumentException("Cannot have a null item inserted in the list");
        }
        this.data = data;
    }

    @Override
    public T getData() {
        return this.data;
    }

    @Override
    public Item next() {
        return this.next;
    }

    @Override
    public Boolean hasNext() {
        if (this.next != null) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Item previous() {
        return this.previous;
    }

    @Override
    public Boolean hasPrevious() {
        if (this.previous != null) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public void setPrevious(Item item) {
        this.previous = item;
    }

    @Override
    public void setNext(Item item) {
        this.next = item;
    }

    public abstract Object clone() throws CloneNotSupportedException;
}
