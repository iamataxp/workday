package com.syzxyy.workday.service;

import com.syzxyy.workday.entity.SignWorkDayEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface WorkDayRepository extends CrudRepository<SignWorkDayEntity, Long> {
    SignWorkDayEntity findByWorkDate(Date workDate);
}

