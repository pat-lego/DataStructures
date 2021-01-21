package io.github.patlego.datastructures.lists;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.withSettings;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class TestCircularList {

    @Test
    public void testGetHead_GetTail() {
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
    public void testAdd() {
        LinkedItem item_1 = Mockito.mock(LinkedItem.class, withSettings().useConstructor(1));
        LinkedItem item_2 = Mockito.mock(LinkedItem.class, withSettings().useConstructor(2));

        Mockito.when(item_1.compareTo(2)).thenReturn(-1);
        Mockito.when(item_1.compareTo(1)).thenReturn(0);

        Mockito.when(item_2.compareTo(1)).thenReturn(1);
        Mockito.when(item_2.compareTo(2)).thenReturn(0);

        doCallRealMethod().when(item_1).hasNext();
        doCallRealMethod().when(item_2).hasNext();

        doCallRealMethod().when(item_1).getData();
        doCallRealMethod().when(item_2).getData();

        doCallRealMethod().when(item_1).next();
        doCallRealMethod().when(item_2).next();

        doCallRealMethod().when(item_1).previous();
        doCallRealMethod().when(item_2).previous();

        doCallRealMethod().when(item_1).setNext(Mockito.any());
        doCallRealMethod().when(item_2).setNext(Mockito.any());

        doCallRealMethod().when(item_1).setPrevious(Mockito.any());
        doCallRealMethod().when(item_2).setPrevious(Mockito.any());

        CircularList list = Mockito.mock(CircularList.class, withSettings().useConstructor(item_1));

        Mockito.when(list.add(Mockito.any())).thenCallRealMethod();
        Mockito.when(list.exists(Mockito.any())).thenCallRealMethod();
        Mockito.when(list.size()).thenCallRealMethod();

        list.add(item_1);
        assertEquals(1, list.size());

        list.add(item_2);

        assertEquals(2, list.size());
        //assertEquals(2, list.getHead().next().getData());
    }
    
}
