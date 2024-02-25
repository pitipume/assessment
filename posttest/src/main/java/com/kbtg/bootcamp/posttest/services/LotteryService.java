package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.repos.LotteryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public List<String> getAllTickets() {
        return lotteryRepo.findAllTicket();
    }

    //create
    public LotteryEntity createLottery(LotteryEntity lotteryEntity) {
        return lotteryRepo.save(lotteryEntity);
    }
    //read
    public List<LotteryEntity> getAllLotteries() {
        return lotteryRepo.findAll();
    }
    public LotteryEntity getLotteryById(Long id) {
        Optional<LotteryEntity> lotteryOptional = lotteryRepo.findById(id);
        return lotteryOptional.orElse(null);
    }
    //update
    public LotteryEntity updateLottery(Long id, LotteryEntity updatedLottery) {
        if (lotteryRepo.existsById(id)) {
            updatedLottery.setId();
            return  lotteryRepo.save(updatedLottery);
        } else {
            return null;
        }
    }
    //delete
    public void deleteLottery(Long id) {
        lotteryRepo.deleteById(id);
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
