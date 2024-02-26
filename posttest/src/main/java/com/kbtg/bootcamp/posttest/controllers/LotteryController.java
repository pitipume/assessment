package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.services.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LotteryController {

    //---------------------------------------------------Intro----------------------------------------------------------

    private final LotteryService lotteryService;
    @Autowired
    public LotteryController(LotteryService lotteryService) {
        this.lotteryService = lotteryService;
    }

    //show lottery table1
    @RequestMapping("/lottery")
    public List<LotteryEntity> showTable1() {
        return lotteryService.showTable1();
    }


    //-------------------------------------------basic CRUD for admin---------------------------------------------------

    //create
    @PostMapping("/admin/post")
    public LotteryEntity createLottery(@RequestBody LotteryEntity lotteryEntity) {
        return lotteryService.createLottery(lotteryEntity);
    }
    //read
    @GetMapping("/admin/get")
    public List<LotteryEntity> getAllLotteries() {
        return lotteryService.showTable1();
    }
    @GetMapping("/admin/get/{id}")
    public LotteryEntity getLotteryById(@PathVariable("id") Long id) {
        return lotteryService.getLotteryById(id);
    }
    //update
    @PutMapping("/admin/put/{id}")
    public LotteryEntity updateLottery(@PathVariable("id") Long id, @RequestBody LotteryEntity updatedLottery) {
        return lotteryService.updateLottery(id, updatedLottery);
    }
    //delete
    @DeleteMapping("/admin/delete/{id}")
    public void deleteLottery(@PathVariable("id") Long id) {
        lotteryService.deleteLottery(id);
    }


    // -------------------------------------------------Story EXP------------------------------------------------------

    //Story EXP01
    @PostMapping("/admin/lotteries")
    public ResponseEntity<String> addLottery(@RequestBody LotteryEntity lotteryEntity) {
        lotteryService.createLottery(lotteryEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body("{\"ticket\": \"" + lotteryEntity.getTicket() + "\"}");
    }

    //Story EXP02
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

}