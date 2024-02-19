package com.kbtg.bootcamp.posttest.repos;

import com.kbtg.bootcamp.posttest.entities.LotteryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotteryRepo extends JpaRepository<LotteryEntity, Long> {
}
