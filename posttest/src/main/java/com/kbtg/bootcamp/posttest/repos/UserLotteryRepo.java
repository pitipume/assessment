package com.kbtg.bootcamp.posttest.repos;

import com.kbtg.bootcamp.posttest.entities.UserLotteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserLotteryRepo extends JpaRepository<UserLotteryEntity, Long> {

    //Story EXP04
    @Query("SELECT u.ticketId FROM UserLotteryEntity u")
    List<String> listAllTicket();

    //Story EXP05
    void deleteByUserIdAndTicketId(String userId, String ticketId);
//    @Query("SELECT u.id FROM UserLotteryEntity u WHERE u.userId = :userId AND u.ticketId = :ticketId")
//    Long findIdByUserIdAndTicketId(String userId, String ticketId);

}