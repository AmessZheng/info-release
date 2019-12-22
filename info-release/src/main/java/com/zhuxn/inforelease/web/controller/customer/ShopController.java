package com.zhuxn.inforelease.web.controller.customer;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 便民服务
 * @author zhuxn
 * @date 2019/12/20 18:22
 */
@RestController
@RequestMapping("shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    /**
     * 分页查询店铺列表
     * @author zhuxn
     * @date 2019/12/22 17:03
     * @param category
     * @param pageNo
     * @return
     */
    @RequestMapping("getShopPageList")
    public AjaxResult getShopPageList(String category, int pageNo) {
        return shopService.getShopPageList(category, pageNo);
    }

    /**
     * 查询店铺分类列表
     * @author zhuxn
     * @date 2019/12/22 17:05
     * @return
     */
    @RequestMapping("getShopCategorys")
    public AjaxResult getShopCategorys() {
        return shopService.getShopCategorys();
    }
}
