package com.kbtg.bootcamp.posttest.services;


import com.kbtg.bootcamp.posttest.entities.UserLotteryEntity;
import com.kbtg.bootcamp.posttest.repos.UserLotteryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserLotteryService {
    private final UserLotteryRepo userLotteryRepo;
    @Autowired
    public UserLotteryService(UserLotteryRepo userLotteryRepo) {
        this.userLotteryRepo = userLotteryRepo;
    }

    //Story EXP04
    public List<String> userGetAllTickets() {
        return userLotteryRepo.listAllTicket();
    }

//    public List<String> getAllUserLotteryTicketIds(String userId) {
//        return userLotteryRepo.findTicketIdsByUserId(userId);
//    }
//
//    public int calculateTotalPrice(String userId) {
//        List<String> ticketIds = getAllUserLotteryTicketIds(userId);
//        int totalPrice = 0;
//        for (String ticketId : ticketIds) {
//            int ticketPrice = getPriceByTicketId(ticketId);
//            totalPrice += ticketPrice;
//        }
//        return totalPrice;
//    }
//    private int getPriceByTicketId(String ticketId) {
//        List<UserLotteryEntity> tickets = userLotteryRepo.findByTicketId(ticketId);
//        if (tickets.isEmpty()) {
//            return 0;
//        } else {
//            UserLotteryEntity ticket = tickets.get(0);
//            return ticket.getPrice();
//        }
//    }
//
//    public int countTotalTickets(String userId) {
//        List<String> ticketIds = getAllUserLotteryTicketIds(userId);
//        return ticketIds.size();
//    }

}
