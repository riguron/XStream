package io.riguron.stream;

import io.riguron.stream.operation.ElementCount;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class ElementCountTest {

    @Test
    public void whenListContainsElements() {

        ElementCount elementCount = new ElementCount(
                Arrays.asList(1, 2, 3, 4).iterator()
        );

        assertEquals(4, elementCount.evaluate());
    }

    @Test
    public void whenEmpty() {
        ElementCount elementCount = new ElementCount(
                Collections.<Integer>emptyList().iterator()
        );

        assertEquals(0, elementCount.evaluate());
    }
}