package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.services.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class LotteryController {

    private final LotteryService lotteryService;
    @Autowired
    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    @PostMapping("/admin/lotteries")
    public LotteryEntity addLotteryEntity(@RequestBody LotteryEntity ticket) {
        return lotteryService.addLotteryEntity(ticket);
    }
    @RequestMapping("/api/lotteries")
    public List<LotteryEntity> getLottery() {
        return lotteryService.getAllLotteries();
    }
    @GetMapping("/lotteries")
    public LotteryResponse getLotteryTickets() {
        List<String> tickets = lotteryService.getAllTickets();
        return new LotteryResponse(tickets);
    }

    private static class LotteryResponse {
        private List<String> tickets;
        public LotteryResponse(List<String> tickets) {
            this.tickets = tickets;
        }
        public List<String> getTickets() {
            return tickets;
        }
        public void setTickets(List<String> tickets) {
            this.tickets = tickets;
        }
    }

    //create
    @PostMapping("")
    public LotteryEntity createLottery(@RequestBody LotteryEntity lotteryEntity) {
        return lotteryService.createLottery(lotteryEntity);
    }
    //read
    @GetMapping("")
    public List<LotteryEntity> getAllLotteries() {
        return lotteryService.getAllLotteries();
    }
    @GetMapping("/{id}")
    public LotteryEntity getLotteryById(@PathVariable("id") Long id) {
        return lotteryService.getLotteryById(id);
    }
    //update
    @PutMapping("/{id}")
    public LotteryEntity updateLottery(@PathVariable("id") Long id, @RequestBody LotteryEntity updatedLottery) {
        return lotteryService.updateLottery(id, updatedLottery);
    }
    //delete
    @DeleteMapping("/{id}")
    public void deleteLottery(@PathVariable("id") Long id) {
        lotteryService.deleteLottery(id);
    }

//    @RequestMapping("/admin/lotteries/{id}")
//    public LotteryEntity getLottery(@PathVariable long id) {
//        return lotteryService.getOneLottery(id);
//    }
//
//    @RequestMapping(method = RequestMethod.POST, value = "/admin/lotteries")
//    public String addLottery(@RequestBody LotteryEntity lottery) {
//        return lotteryService.addOneLottery(lottery);
//    }
//
//    @RequestMapping(method = RequestMethod.PUT, value = "/admin/lotteries/{id}")
//    public void updateLottery(@PathVariable long id, @RequestBody LotteryEntity lottery) {
//        lotteryService.updateOneLottery(id, lottery);
//    }
//    @RequestMapping(method = RequestMethod.DELETE, value = "/admin/lotteries/{id}")
//    public void deleteLottery(@PathVariable Long id) {
//        lotteryService.deleteOneLottery(id);
//    }

}