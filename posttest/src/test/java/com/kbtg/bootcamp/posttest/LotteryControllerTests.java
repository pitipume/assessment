package com.kbtg.bootcamp.posttest;


import com.kbtg.bootcamp.posttest.controllers.LotteryController;
import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.services.LotteryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LotteryControllerTests {
    @Mock
    private LotteryService lotteryService;

    @InjectMocks
    private LotteryController lotteryController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowTable1() {
        List<LotteryEntity> expectedLotteries = Arrays.asList(new LotteryEntity(), new LotteryEntity());
        when(lotteryService.showTable1()).thenReturn(expectedLotteries);

        List<LotteryEntity> actualLotteries = lotteryController.showTable1();

        assertEquals(expectedLotteries, actualLotteries);
    }

    @Test
    public void testAddLottery() {
        LotteryEntity lotteryEntity = new LotteryEntity();
        lotteryEntity.setTicket("ABC123");

        ResponseEntity<String> expectedResponse = ResponseEntity.status(HttpStatus.CREATED).body("{\"ticket\": \"ABC123\"}");

        ResponseEntity<String> actualResponse = lotteryController.addLottery(lotteryEntity);

        assertEquals(expectedResponse, actualResponse);
        verify(lotteryService, times(1)).createLottery(lotteryEntity);
    }

}
