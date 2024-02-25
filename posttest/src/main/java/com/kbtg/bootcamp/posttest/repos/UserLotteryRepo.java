package com.kbtg.bootcamp.posttest.repos;


import com.kbtg.bootcamp.posttest.entities.UserLotteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserLotteryRepo extends JpaRepository<UserLotteryEntity, Long> {
    @Query("SELECT u.ticketId FROM UserLotteryEntity u")
    List<String> listAllTicket();
//    List<UserLotteryEntity> findByTicketId(String ticketId);
//    @Query("SELECT u.ticketId FROM UserLotteryEntity u WHERE u.userId = :userId")
//    List<String> findTicketIdsByUserId(@Param("userId") String userId);

}