package com.kbtg.bootcamp.posttest.controllers;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import com.kbtg.bootcamp.posttest.services.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LotteryController {
    @Autowired
    private LotteryService lotteryService;
    @RequestMapping("/api/lotteries")
    public List<LotteryEntity> getLottery() {
        return lotteryService.getAllLotteries();
    }
    @RequestMapping("/api/lotteries/{id}")
    public LotteryEntity getLottery(@PathVariable long id) {
        return lotteryService.getOneLottery(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/api/lotteries")
    public String addLottery(@RequestBody LotteryEntity lottery) {
        return lotteryService.addOneLottery(lottery);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/api/lotteries/{id}")
    public void updateLottery(@PathVariable long id, @RequestBody LotteryEntity lottery) {
        lotteryService.updateOneLottery(id, lottery);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "api/lotteries/{id}")
    public void deleteLottery(@PathVariable Long id) {
        lotteryService.deleteOneLottery(id);
    }
}
