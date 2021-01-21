package io.github.patlego.datastructures.lists;

import java.util.HashSet;
import java.util.Set;

public abstract class CircularList implements List {

    private Item head;
    private Item tail;

    public CircularList(Item node) throws CloneNotSupportedException {
        if (node == null) {
            throw new IllegalArgumentException("Cannot have a null node in the list");
        }

        head = (Item) node.clone();
        tail = (Item) node.clone();

        head.setNext(tail);
        head.setPrevious(tail);

        tail.setNext(head);
        tail.setPrevious(head);
    }

    @Override
    public Boolean isEmpty() {
        if (tail == null && tail == null) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    @Override
    public Boolean add(Item item) {
        if (item == null) {
            return Boolean.FALSE;
        }

        if (tail == null || head == null) {
            return Boolean.FALSE;
        }

        if (exists(item)) {
            return Boolean.FALSE;
        }

        tail.setNext(item);
        item.setNext(head);
        item.setPrevious(tail);
        head.setPrevious(item);
        tail = item;
        return Boolean.TRUE;
    }

    @Override
    public Boolean remove(Item item) {
        if (item == null) {
            return Boolean.FALSE;
        }

        if (tail == null || head == null) {
            return Boolean.FALSE;
        }

        Item previous = item.previous();
        previous.setNext(item.next());

        Item next = item.next();
        next.setPrevious(item.previous());

        item = null;

        return Boolean.TRUE;
    }

    @Override
    public Item getHead() {
        return this.head;
    }

    @Override
    public Item getTail() {
        return this.tail;
    }

    @Override
    public Integer size() {
        Integer size = 0;
        Set set = new HashSet();

        Item iterator = head;
        while (iterator.hasNext()) {
            if (doesItemExist(iterator, set)) {
                break;
            }
            set.add(iterator);
            size = size + 1;
            iterator = iterator.next();
        }

        return size;
    }

    @Override
    public Boolean exists(Item item) {
        Set set = new HashSet();

        Item iterator = head;
        while (iterator.hasNext()) {
            if (item.compareTo(iterator.getData()) == 0) {
                return Boolean.TRUE;
            }

            // Eventually this will overflow and then we will break
            if (doesItemExist(iterator, set)) {
                break;
            }

            set.add(iterator);
            iterator = iterator.next();
        }

        return Boolean.FALSE;

    }

    private Boolean doesItemExist(Item item, Set set) {
        return set.contains(item);
    }

}
