package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.repos.LotteryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

}
