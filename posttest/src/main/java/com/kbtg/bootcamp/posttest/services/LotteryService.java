package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.repos.LotteryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LotteryService {

    private final LotteryRepo lotteryRepo;

    @Autowired
    public LotteryService(LotteryRepo lotteryRepo) {
        this.lotteryRepo = lotteryRepo;
    }
    public LotteryEntity addLotteryEntity(LotteryEntity ticket) {
        return lotteryRepo.save(ticket);
    }
    public List<LotteryEntity> getAllLotteries() {
        return lotteryRepo.findAll();
    }
    public List<String> getAllTickets() {
        return lotteryRepo.findAllTicket();
    }

//    public List<String> getAllTickets() {
//        List<LotteryEntity> lotteryEntities = lotteryRepo.findAll();
//        return lotteryEntities.stream()
//                .map(LotteryEntity::getTicket)
//                .collect(Collectors.toList());
//    }

//    public LotteryEntity getOneLottery(long id) {
////        return lotteryRepo.getReferenceById(id).get();
//        return lotteryRepo.findById(id)
//                .orElseThrow(() -> new RuntimeException("Lottery not found"));
//    }
//    public String addOneLottery(LotteryEntity lottery) {
//        lotteryRepo.save(lottery);
//        return "Success";
//    }
//    public void updateOneLottery(long id, LotteryEntity lottery) {
//        lotteryRepo.save(lottery);
//    }
//    public void deleteOneLottery(Long id) {
//        lotteryRepo.deleteById(id);
//    }
}
