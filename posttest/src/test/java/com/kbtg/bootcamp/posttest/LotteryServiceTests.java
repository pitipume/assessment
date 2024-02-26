package com.kbtg.bootcamp.posttest;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.repos.LotteryRepo;
import com.kbtg.bootcamp.posttest.services.LotteryService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LotteryServiceTests {

    @Mock
    private LotteryRepo lotteryRepo;

    @InjectMocks
    private LotteryService lotteryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testShowTable1() {
        List<LotteryEntity> expectedLotteries = new ArrayList<>();
        when(lotteryRepo.findAll()).thenReturn(expectedLotteries);

        List<LotteryEntity> actualLotteries = lotteryService.showTable1();

        assertEquals(expectedLotteries, actualLotteries);
    }

    @Test
    public void testCreateLottery() {
        LotteryEntity lotteryEntity = new LotteryEntity();
        when(lotteryRepo.save(lotteryEntity)).thenReturn(lotteryEntity);

        LotteryEntity createdLottery = lotteryService.createLottery(lotteryEntity);

        assertEquals(lotteryEntity, createdLottery);
    }

    @Test
    public void testGetLotteryById() {
        Long id = 1L;
        LotteryEntity expectedLottery = new LotteryEntity();
        when(lotteryRepo.findById(id)).thenReturn(Optional.of(expectedLottery));

        LotteryEntity actualLottery = lotteryService.getLotteryById(id);

        assertEquals(expectedLottery, actualLottery);
    }

    @Test
    public void testUpdateLottery_Exists() {
        Long id = null;
        LotteryEntity updatedLottery = new LotteryEntity();
        updatedLottery.setId();
        when(lotteryRepo.existsById(id)).thenReturn(true);
        when(lotteryRepo.save(updatedLottery)).thenReturn(updatedLottery);

        LotteryEntity result = lotteryService.updateLottery(id, updatedLottery);

        assertEquals(updatedLottery, result);
    }

    @Test
    public void testUpdateLottery_NotExists() {
        Long id = null;
        LotteryEntity updatedLottery = new LotteryEntity();
        when(lotteryRepo.existsById(id)).thenReturn(false);

        LotteryEntity result = lotteryService.updateLottery(id, updatedLottery);

        assertEquals(null, result);
    }

    @Test
    public void testDeleteLottery() {
        Long id = null;
        lotteryService.deleteLottery(id);

        verify(lotteryRepo, times(1)).deleteById(id);
    }

    @Test
    public void testGetAllTickets() {
        List<String> expectedTickets = new ArrayList<>();
        when(lotteryRepo.findAllTicket()).thenReturn(expectedTickets);

        List<String> actualTickets = lotteryService.getAllTickets();

        assertEquals(expectedTickets, actualTickets);
    }
}
