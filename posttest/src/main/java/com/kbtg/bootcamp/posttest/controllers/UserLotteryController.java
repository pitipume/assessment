package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.entities.UserLotteryEntity;
import com.kbtg.bootcamp.posttest.services.UserLotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<StoryExp05Response> sellBackLotteryTicket(@PathVariable("userId") String userId, @PathVariable("ticketId") String ticketId) {
        userLotteryService.sellBackLottery(userId, ticketId);
        StoryExp05Response response = new StoryExp05Response(ticketId);
        return ResponseEntity.ok(response);
    }
    public class StoryExp05Response {
        private String ticketId;
        public StoryExp05Response(String ticketId) {
            this.ticketId = ticketId;
        }
        public String getTicket() {
            return ticketId;
        }
        public void setTicketId(String ticketId) {
            this.ticketId = ticketId;
        }
    }
    //Story EXP05 - sell by id
    @DeleteMapping("/users/{id}")
    public void sellLottery(@PathVariable("id") Long id) {
        userLotteryService.sellLottery(id);
    }

}
