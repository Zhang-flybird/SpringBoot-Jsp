package com.etoak.service;

import com.etoak.bean.House;
import com.etoak.bean.HouseVo;
import com.etoak.bean.Page;

public interface HouseService {

    Page<HouseVo> queryList(int pageNum, int pageSize, HouseVo houseVo);
}
