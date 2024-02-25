package com.kbtg.bootcamp.posttest.services;


import com.kbtg.bootcamp.posttest.repos.UserLotteryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserLotteryService {
    private final UserLotteryRepo userLotteryRepo;
    @Autowired
    public UserLotteryService(UserLotteryRepo userLotteryRepo) {
        this.userLotteryRepo = userLotteryRepo;
    }

}
