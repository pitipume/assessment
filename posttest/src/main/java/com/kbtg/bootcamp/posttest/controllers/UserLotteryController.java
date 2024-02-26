package com.kbtg.bootcamp.posttest.controllers;


import com.kbtg.bootcamp.posttest.dto.LotteryResponse;
import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.entities.UserLotteryEntity;
import com.kbtg.bootcamp.posttest.services.UserLotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
public class UserLotteryController {

    //-----------------------------------------------Intro-------------------------------------------------------------
    private final UserLotteryService userLotteryService;
    @Autowired
    public UserLotteryController(UserLotteryService userLotteryService) {
        this.userLotteryService = userLotteryService;
    }

    //show user_ticket table2
    @RequestMapping("/user_ticket")
    public List<UserLotteryEntity> showTable2() {
        return userLotteryService.showTable2();
    }

    //-------------------------------------------Basic CRUD for user---------------------------------------------------



    //------------------------------------------------Story EXP---------------------------------------------------------
    //Story EXP03
    //user buy lottery
//    @PostMapping("/users/{userId}/lotteries/{ticketId}")
//    public UserLotteryEntity buyLottery(@RequestBody UserLotteryEntity userLotteryEntity) {
//        return userLotteryService.buyLottery(userLotteryEntity);
//    }
    //Story EXP03
    @PostMapping("/users/{userId}/lotteries/{ticketId}")
    public ResponseEntity<StoryExp03Response> buyLotteryTicket(@PathVariable("userId") String userId, @PathVariable("ticketId") String ticketId) {
        int price = 80;
        int amount = 1;
        UserLotteryEntity boughtTicket = userLotteryService.buyLottery(userId, ticketId, price, amount);
        StoryExp03Response response = new StoryExp03Response(boughtTicket.getId());
        //        return new ResponseEntity<>(boughtTicket.getId(), HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    public class StoryExp03Response {
        private Long id;
        public StoryExp03Response(Long id) {
            this.id = id;
        }
        public Long getId() {
            return id;
        }
        public void setId(Long id) {
            this.id = id;
        }
    }

    //Story EXP04
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

    //Story EXP05
    //user sell lottery
    @DeleteMapping("/users/{userId}/lotteries/{ticketId}")
    public void sellLottery(@PathVariable("id") Long id) {
        userLotteryService.sellLottery(id);
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
