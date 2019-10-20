package io.riguron.stream.iterator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class TakeWhileIteratorTest {

    @Test
    public void takeWhile() {
        TakeWhileIterator<Integer> takeWhileIterator =
                new TakeWhileIterator<>(
                        Arrays.asList(5, 6, 2, 3, 8, 9, 11, 4, 1).iterator(),
                        x -> x <= 8
                );

        assertTrue(takeWhileIterator.hasNext());
        assertEquals(5, takeWhileIterator.next());

        assertTrue(takeWhileIterator.hasNext());
        assertEquals(6, takeWhileIterator.next());

        assertTrue(takeWhileIterator.hasNext());
        assertEquals(2, takeWhileIterator.next());

        assertTrue(takeWhileIterator.hasNext());
        assertEquals(3, takeWhileIterator.next());

        assertTrue(takeWhileIterator.hasNext());
        assertEquals(8, takeWhileIterator.next());

        assertFalse(takeWhileIterator.hasNext());
    }

    @Test
    public void whenEmpty() {
        TakeWhileIterator<Integer> takeWhileIterator =
                new TakeWhileIterator<>(
                        Collections.<Integer>emptyList().iterator(),
                        x -> x <= 8
                );

        assertFalse(takeWhileIterator.hasNext());
    }

    @Test
    public void whenNoSuitableElements() {
        TakeWhileIterator<Integer> takeWhileIterator =
                new TakeWhileIterator<>(
                        Arrays.asList(11, 13, 51, 8, 22, 31).iterator(),
                        x -> x <= 8
                );

        assertFalse(takeWhileIterator.hasNext());

    }

}