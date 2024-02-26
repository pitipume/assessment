package com.kbtg.bootcamp.posttest;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LotteryEntityTests {
    private LotteryEntity lottery;

    @BeforeEach
    public void setUp() {
        lottery = new LotteryEntity();
        lottery.setId();
        lottery.setTicket("test1");
        lottery.setPrice(80);
        lottery.setAmount(1);
    }

    @Test
    public void testGetters() {
        assertEquals(null, lottery.getId());
        assertEquals("test1", lottery.getTicket());
        assertEquals(80, lottery.getPrice());
        assertEquals(1, lottery.getAmount());
    }

    @Test
    public void testSetters() {
        lottery.setId();
        lottery.setTicket("test2");
        lottery.setPrice(80);
        lottery.setAmount(1);

        assertEquals(null, lottery.getId());
        assertEquals("test2", lottery.getTicket());
        assertEquals(80, lottery.getPrice());
        assertEquals(1, lottery.getAmount());
    }
    
}
