package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.repos.LotteryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotteryService {
    @Autowired
    LotteryRepo lotteryRepo;
    public List<LotteryEntity> getAllLotteries() {
        return lotteryRepo.findAll();
    }
    public LotteryEntity getOneLottery(long id) {
//        return lotteryRepo.getReferenceById(id).get();
        return lotteryRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Lottery not found"));
    }
    public String addOneLottery(LotteryEntity lottery) {
        lotteryRepo.save(lottery);
        return "Success";
    }
    public void updateOneLottery(long id, LotteryEntity lottery) {
        lotteryRepo.save(lottery);
    }
    public void deleteOneLottery(Long id) {
        lotteryRepo.deleteById(id);
    }
}
