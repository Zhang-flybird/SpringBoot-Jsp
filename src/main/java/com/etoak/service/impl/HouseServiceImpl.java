package com.etoak.service.impl;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;
import com.etoak.mapper.HouseMapper;
import com.etoak.service.HouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    HouseMapper houseMapper;

    @Override
    public Page<HouseVo> queryList(int pageNum, int pageSize, HouseVo houseVo) {
        PageHelper.startPage(pageNum, pageSize);
        List<HouseVo> houseVoList = houseMapper.queryList(houseVo);
        PageInfo<HouseVo> pageInfo = new PageInfo<>(houseVoList);
        return new Page<HouseVo>(pageInfo.getPageNum(),
                pageInfo.getPageSize(),
                houseVoList,
                pageInfo.getTotal(),
                pageInfo.getPages());
    }
}
