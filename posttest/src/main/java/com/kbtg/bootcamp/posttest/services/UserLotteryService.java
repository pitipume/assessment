package com.kbtg.bootcamp.posttest.services;

import com.kbtg.bootcamp.posttest.entities.UserLotteryEntity;
import com.kbtg.bootcamp.posttest.repos.UserLotteryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserLotteryService {

    //-----------------------------------------------------Intro--------------------------------------------------------

    private final UserLotteryRepo userLotteryRepo;
    @Autowired
    public UserLotteryService(UserLotteryRepo userLotteryRepo) {
        this.userLotteryRepo = userLotteryRepo;
    }

    //show user_ticket table2
    public List<UserLotteryEntity> showTable2() {
        return userLotteryRepo.findAll();
    }


    //-------------------------------------------Basic CRUD for user---------------------------------------------------



    //------------------------------------------------Story EXP---------------------------------------------------------

    //Story EXP03
    public UserLotteryEntity buyLottery(String userId, String ticketId, int price, int amount) {
        UserLotteryEntity userLotteryEntity = new UserLotteryEntity();
        userLotteryEntity.setUserId(userId);
        userLotteryEntity.setTicketId(ticketId);
        userLotteryEntity.setPrice(price);
        userLotteryEntity.setAmount(amount);
        return userLotteryRepo.save(userLotteryEntity);
    }

    //Story EXP04
    public List<String> userGetAllTickets() {
        return userLotteryRepo.listAllTicket();
    }

    //Story EXP05
    public void sellBackLottery(String userId, String ticketId) {
        userLotteryRepo.deleteByUserIdAndTicketId(userId, ticketId);
    }

    //Story EXP05 - sell by id
    public void sellLottery(Long id) {
        userLotteryRepo.deleteById(id);
    }

}
