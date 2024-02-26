package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.repos.LotteryRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LotteryService {

    //--------------------------------------------------Intro-----------------------------------------------------------
    private final LotteryRepo lotteryRepo;
    @Autowired
    public LotteryService(LotteryRepo lotteryRepo) {
        this.lotteryRepo = lotteryRepo;
    }

    //show lottery table1
    public List<LotteryEntity> showTable1() {
        return lotteryRepo.findAll();
    }




    //--------------------------------------------basic CRUD for admin--------------------------------------------------

    //create
    public LotteryEntity createLottery(LotteryEntity lotteryEntity) {
        return lotteryRepo.save(lotteryEntity);
    }
    //read
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



    //------------------------------------------------------Story EXP---------------------------------------------------
    //Story EXP02
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
