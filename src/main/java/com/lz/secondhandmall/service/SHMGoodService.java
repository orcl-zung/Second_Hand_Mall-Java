package com.lz.secondhandmall.service;

import com.definesys.mpaas.log.SWordLogger;
import com.lz.secondhandmall.dao.SHMGoodsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @Author: lz
 * @Since: 2019/12/24 11:43
 * @History 2019/12/24 created by lz
 */
@Service("goodsService")
public class SHMGoodService {

    @Autowired
    private SWordLogger logger;

    @Autowired
    SHMGoodsDao goodsDao;

}
