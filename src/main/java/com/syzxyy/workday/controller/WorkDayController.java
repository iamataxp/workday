package com.syzxyy.workday.controller;

import com.syzxyy.workday.entity.SignWorkDayEntity;
import com.syzxyy.workday.service.WorkDayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class WorkDayController {
    @Autowired
    private WorkDayRepository workDayRepository;

    @RequestMapping(value = "/getWorkDay.json")
    @ResponseBody
    public String getWorkDay(@RequestParam(value = "day") String day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = sdf.parse(day);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SignWorkDayEntity entity = workDayRepository.findByWorkDate(date);

        if (entity != null) {
            return entity.getWorkCode();
        }
        return "-1";
    }
}

