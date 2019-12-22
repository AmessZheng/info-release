package com.zhuxn.inforelease.web.controller.user;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.orm.entity.Shop;
import com.zhuxn.inforelease.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 店铺后台管理
 * @author zhuxn
 * @date 2019/12/20 18:24
 */
@RestController
@RequestMapping("user/shop")
public class UserShopController {
    @Autowired
    private ShopService shopService;

    /**
     * 新增店铺信息
     * @author zhuxn
     * @date 2019/12/22 15:03
     * @param shop
     * @return
     */
    @RequestMapping("addShop")
    public AjaxResult addShop(Shop shop) {
        return shopService.addShop(shop);
    }

    /**
     * 编辑店铺信息
     * @author zhuxn
     * @date 2019/12/22 15:03
     * @param shop
     * @return
     */
    @RequestMapping("editShop")
    public AjaxResult editShop(Shop shop) {
        return shopService.editShop(shop);
    }

    /**
     * 删除店铺
     * @author zhuxn
     * @date 2019/12/22 15:03
     * @param shopId
     * @return
     */
    @RequestMapping("deleteShop")
    public AjaxResult deleteShop(int shopId) {
        return shopService.deleteShop(shopId);
    }

    /**
     * 分页查询店铺信息
     * @author zhuxn
     * @date 2019/12/22 15:03
     * @param category
     * @param pageNo
     * @return
     */
    @RequestMapping("getShopPageList")
    public AjaxResult getShopPageList(String category, int pageNo) {
        return shopService.getShopPageList(category, pageNo);
    }

    /**
     * 根据shopId查询店铺信息
     * @author zhuxn
     * @date 2019/12/22 16:30
     * @param shopId
     * @return
     */
    @RequestMapping("getById")
    public AjaxResult getById(int shopId) {
        return shopService.getShopById(shopId);
    }

    /**
     * 更新店铺置顶状态
     * @author zhuxn
     * @date 2019/12/22 16:36
     * @param shopId
     * @param status
     * @return
     */
    @RequestMapping("updateTopStatus")
    public AjaxResult updateTopStatus(int shopId, int status) {
        return shopService.updateTopStatus(shopId, status);
    }

    /**
     * 查询店铺分类列表
     * @author zhuxn
     * @date 2019/12/22 16:59
     */
    @RequestMapping("getShopCategorys")
    public AjaxResult getShopCategorys() {
        return shopService.getShopCategorys();
    }
}
