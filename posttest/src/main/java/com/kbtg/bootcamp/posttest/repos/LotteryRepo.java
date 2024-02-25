package com.kbtg.bootcamp.posttest.repos;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LotteryRepo extends JpaRepository<LotteryEntity, Long> {

    @Query("SELECT l.ticket FROM LotteryEntity l")
    List<String> findAllTicket();
    //test commit

}
