package com.kbtg.bootcamp.posttest.controllers;


import com.kbtg.bootcamp.posttest.entities.UserLotteryEntity;
import com.kbtg.bootcamp.posttest.services.UserLotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserLotteryController {
    private final UserLotteryService userLotteryService;
    @Autowired
    public UserLotteryController(UserLotteryService userLotteryService) {
        this.userLotteryService = userLotteryService;
    }

    @GetMapping("/users/{userId}/lotteries")
    public UserLotteryController.UserLotteryResponse userGetLotteryTickets() {
        List<String> ticketIds = userLotteryService.userGetAllTickets();
        return new UserLotteryController.UserLotteryResponse(ticketIds);
    }

    private static class UserLotteryResponse {
        private List<String> ticketId;
        public UserLotteryResponse(List<String> ticketId) {
            this.ticketId = ticketId;
        }
        public List<String> getTicketId() {
            return ticketId;
        }
        public void setTicketId(List<String> ticketId) {
            this.ticketId = ticketId;
        }
    }

//    @GetMapping("/users/{userId}/lotteries")
//    public UserLotteryResponse getAllUserLotteryTickets(@PathVariable("userId") String userId) {
//        List<String> ticketsIds = userLotteryService.getAllUserLotteryTicketIds(userId);
//        int totalPrice = userLotteryService.calculateTotalPrice(userId);
//        int totalCount = userLotteryService.countTotalTickets(userId);
//        return new UserLotteryResponse(ticketsIds, totalPrice, totalCount);
//    }
//
//    private static class UserLotteryResponse {
//        private List<String> tickets;
//        private int totalPrice;
//        private int totalCount;
//
//        public UserLotteryResponse(List<String> tickets, int totalPrice, int totalCount) {
//            this.tickets = tickets;
//            this.totalPrice = totalPrice;
//            this.totalCount = totalCount;
//        }
//
//        // Getters and setters
//        public List<String> getTickets() {
//            return tickets;
//        }
//
//        public void setTickets(List<String> tickets) {
//            this.tickets = tickets;
//        }
//
//        public int getTotalPrice() {
//            return totalPrice;
//        }
//
//        public void setTotalPrice(int totalPrice) {
//            this.totalPrice = totalPrice;
//        }
//
//        public int getTotalCount() {
//            return totalCount;
//        }
//
//        public void setTotalCount(int totalCount) {
//            this.totalCount = totalCount;
//        }
//    }
}
