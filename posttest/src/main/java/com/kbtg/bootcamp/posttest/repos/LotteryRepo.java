package com.kbtg.bootcamp.posttest.repos;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LotteryRepo extends JpaRepository<LotteryEntity, Long> {

    //Story EXP01
//    @Query("SELECT l.ticket FROM LotteryEntity l ORDER BY l.id DESC")
//    List<String> findLatestTicket();

    //Story EXP02
    @Query("SELECT l.ticket FROM LotteryEntity l")
    List<String> findAllTicket();

}
