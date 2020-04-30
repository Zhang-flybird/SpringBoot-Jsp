package com.etoak.mapper;

import com.etoak.bean.HouseVo;

import java.util.List;

public interface HouseMapper {

    List<HouseVo> queryList(HouseVo houseVo);
}
