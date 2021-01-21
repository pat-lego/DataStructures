package io.github.patlego.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.withSettings;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestCircularList {

    @Test
    public void testGetHead_GetTail() throws CloneNotSupportedException {
        LinkedItem item_1 = Mockito.mock(LinkedItem.class, withSettings().useConstructor(1));

        doCallRealMethod().when(item_1).getData();
        doCallRealMethod().when(item_1).next();
        doCallRealMethod().when(item_1).previous();
        doCallRealMethod().when(item_1).setNext(Mockito.any());
        doCallRealMethod().when(item_1).setPrevious(Mockito.any());

        CircularList list = Mockito.mock(CircularList.class, withSettings().useConstructor(item_1));

        Mockito.when(list.getHead()).thenCallRealMethod();
        Mockito.when(list.getTail()).thenCallRealMethod();

        assertEquals(1, list.getHead().getData());
        assertEquals(1, list.getTail().getData());
        assertEquals(1, list.getHead().next().getData());
        assertEquals(1, list.getTail().previous().getData());
    }

    @Test
    public void testAdd() throws CloneNotSupportedException {
        TestLinkedItem_1 item_1 = new TestLinkedItem_1(1);
        TestLinkedItem_2 item_2 = new TestLinkedItem_2(2);
        TestLinkedItem_2 item_3 = new TestLinkedItem_2(3);

        SimpleCircularList list = new SimpleCircularList(item_1);

        list.add(item_1);
        assertEquals(1, list.size());

        list.add(item_2);

        assertEquals(2, list.size());
        assertEquals(2, list.getHead().next().getData());

        list.add(item_3);
        assertEquals(3, list.size());
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getHead().next().getData());
        assertEquals(3, list.getHead().next().next().getData());
        assertEquals(1, list.getHead().next().next().next().getData());
    }

    @Test
    public void testRemove_Head() throws CloneNotSupportedException {
        TestLinkedItem_1 item_1 = new TestLinkedItem_1(1);
        TestLinkedItem_2 item_2 = new TestLinkedItem_2(2);
        TestLinkedItem_2 item_3 = new TestLinkedItem_2(3);

        SimpleCircularList list = new SimpleCircularList(item_1);

        list.add(item_1);
        assertEquals(1, list.size());

        list.add(item_2);

        assertEquals(2, list.size());
        assertEquals(2, list.getHead().next().getData());

        list.add(item_3);
        assertEquals(3, list.size());
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getHead().next().getData());
        assertEquals(3, list.getHead().next().next().getData());
        assertEquals(1, list.getHead().next().next().next().getData());

        list.remove(item_1);
        assertEquals(2, list.getHead().getData());
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_Tail() throws CloneNotSupportedException {
        TestLinkedItem_1 item_1 = new TestLinkedItem_1(1);
        TestLinkedItem_2 item_2 = new TestLinkedItem_2(2);
        TestLinkedItem_2 item_3 = new TestLinkedItem_2(3);

        SimpleCircularList list = new SimpleCircularList(item_1);

        list.add(item_1);
        assertEquals(1, list.size());

        list.add(item_2);

        assertEquals(2, list.size());
        assertEquals(2, list.getHead().next().getData());

        list.add(item_3);
        assertEquals(3, list.size());
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getHead().next().getData());
        assertEquals(3, list.getHead().next().next().getData());
        assertEquals(1, list.getHead().next().next().next().getData());

        list.remove(item_3);
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getTail().getData());
        assertEquals(2, list.size());
    }

    @Test
    public void testRemove_Middle() throws CloneNotSupportedException {
        TestLinkedItem_1 item_1 = new TestLinkedItem_1(1);
        TestLinkedItem_2 item_2 = new TestLinkedItem_2(2);
        TestLinkedItem_2 item_3 = new TestLinkedItem_2(3);

        SimpleCircularList list = new SimpleCircularList(item_1);

        list.add(item_1);
        assertEquals(1, list.size());

        list.add(item_2);

        assertEquals(2, list.size());
        assertEquals(2, list.getHead().next().getData());

        list.add(item_3);
        assertEquals(3, list.size());
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.getHead().next().getData());
        assertEquals(3, list.getHead().next().next().getData());
        assertEquals(1, list.getHead().next().next().next().getData());

        list.remove(item_2);
        assertEquals(1, list.getHead().getData());
        assertEquals(2, list.size());
    }

    private class TestLinkedItem_1 extends LinkedItem<Integer> {

        public TestLinkedItem_1(Integer data) {
            super(data);
            // TODO Auto-generated constructor stub
        }

        @Override
        public int compareTo(Integer o) {
            if (this.getData() < o) {
                return -1;
            }

            if (this.getData() > o) {
                return 1;
            }

            return 0;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            TestLinkedItem_1 clone = new TestLinkedItem_1(this.getData());
            clone.setPrevious(this.previous());
            clone.setNext(this.next());

            return clone;
        }

    }

    private class TestLinkedItem_2 extends LinkedItem<Integer> {

        public TestLinkedItem_2(Integer data) {
            super(data);
            // TODO Auto-generated constructor stub
        }

        @Override
        public int compareTo(Integer o) {
            if (this.getData() < o) {
                return -1;
            }

            if (this.getData() > o) {
                return 1;
            }

            return 0;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            TestLinkedItem_2 clone = new TestLinkedItem_2(this.getData());
            clone.setPrevious(this.previous());
            clone.setNext(this.next());

            return clone;
        }

    }

    private class SimpleCircularList extends CircularList {

        public SimpleCircularList(Item node) throws CloneNotSupportedException {
            super(node);
        }

    }

}
