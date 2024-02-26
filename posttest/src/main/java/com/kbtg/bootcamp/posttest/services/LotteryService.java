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

    //show lottery table1
    public List<LotteryEntity> showTable1() {
        return lotteryRepo.findAll();
    }


    //for user who wants to list all lottery ticket to choose and buy
    public List<String> getAllTickets() {
        return lotteryRepo.findAllTicket();
    }

    //basic CRUD for admin
    //create
    public LotteryEntity createLottery(LotteryEntity lotteryEntity) {
        return lotteryRepo.save(lotteryEntity);
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
