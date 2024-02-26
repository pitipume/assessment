package com.kbtg.bootcamp.posttest.services;


import com.kbtg.bootcamp.posttest.dto.LotteryResponse;
import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.entities.UserLotteryEntity;
import com.kbtg.bootcamp.posttest.repos.UserLotteryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserLotteryService {
    private final UserLotteryRepo userLotteryRepo;
    @Autowired
    public UserLotteryService(UserLotteryRepo userLotteryRepo) {
        this.userLotteryRepo = userLotteryRepo;
    }

    //show user_ticket table2
    public List<UserLotteryEntity> showTable2() {
        return userLotteryRepo.findAll();
    }

    //Story EXP03
    //buy lottery
    public UserLotteryEntity buyLottery(UserLotteryEntity userLotteryEntity) {
        return userLotteryRepo.save(userLotteryEntity);
    }
    //test buy lottery
//    public LotteryResponse buyLotteryTicket(String userId, String ticketId) {
//        // Implement logic to buy lottery ticket and return response
//        return new LotteryResponse("1");
//    }

    //Story EXP05
    //sell lottery
    public void sellLottery(Long id) {
        userLotteryRepo.deleteById(id);
    }

    //Story EXP04
    //user see admin lottery before buy
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
