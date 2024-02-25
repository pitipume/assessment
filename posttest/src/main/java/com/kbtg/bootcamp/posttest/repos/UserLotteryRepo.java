package com.kbtg.bootcamp.posttest.repos;


import com.kbtg.bootcamp.posttest.entities.UserLotteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserLotteryRepo extends JpaRepository<UserLotteryEntity, Long> {

}