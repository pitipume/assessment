package com.kbtg.bootcamp.posttest.controllers;


import com.kbtg.bootcamp.posttest.services.UserLotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserLotteryController {
    private final UserLotteryService userLotteryService;
    @Autowired
    public UserLotteryController(UserLotteryService userLotteryService) {
        this.userLotteryService = userLotteryService;
    }
}
