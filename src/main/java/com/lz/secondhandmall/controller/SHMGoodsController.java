package com.lz.secondhandmall.controller;

import com.definesys.mpaas.log.SWordLogger;
import com.lz.secondhandmall.service.SHMGoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @Author: lz
 * @Since: 2019/12/24 11:43
 * @History 2019/12/24 created by lz
 */
@RequestMapping("/shm/goods")
@RestController
public class SHMGoodsController {

    @Autowired
    SHMGoodService goodService;

    @Autowired
    private SWordLogger logger;

}
