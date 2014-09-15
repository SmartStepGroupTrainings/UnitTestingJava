package com.cft.casino.domain;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PlayerTest {
    protected Player player;

    @Before
    public void setUp() {
        player = new Player();
    }

    @Test
    public void test1() {
        assertEquals(1, 1);
    }
}
