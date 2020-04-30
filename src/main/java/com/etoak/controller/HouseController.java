package com.etoak.controller;

import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;
import com.etoak.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/house")
public class HouseController {

    @Autowired
    HouseService houseService;

    @GetMapping("/list")
    @ResponseBody
    public Page<HouseVo> list(
            @RequestParam(required = false,defaultValue = "1") int pageNum,
            @RequestParam(required = false,defaultValue = "1")int pageSize,
            HouseVo houseVo){
        return houseService.queryList(pageNum,pageSize,houseVo);

    }
}
