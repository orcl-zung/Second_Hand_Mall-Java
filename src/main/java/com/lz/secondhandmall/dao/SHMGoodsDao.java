package com.lz.secondhandmall.dao;

import com.definesys.mpaas.log.SWordLogger;
import com.definesys.mpaas.query.MpaasQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @Author: lz
 * @Since: 2019/12/24 11:43
 * @History 2019/12/24 created by lz
 */
@Repository("goods")
public class SHMGoodsDao {

    @Autowired
    private MpaasQueryFactory sw;

    @Autowired
    private SWordLogger logger;
}
