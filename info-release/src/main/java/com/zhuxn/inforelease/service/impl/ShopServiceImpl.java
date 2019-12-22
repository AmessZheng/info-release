package com.zhuxn.inforelease.service.impl;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.orm.entity.Shop;
import com.zhuxn.inforelease.orm.mapper.ShopCategoryMapper;
import com.zhuxn.inforelease.orm.mapper.ShopMapper;
import com.zhuxn.inforelease.service.ShopService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 店铺相关
 * @author zhuxn
 * @date 2019/12/22 15:23
 */
@Service
public class ShopServiceImpl implements ShopService {
    private final Logger LOG = LoggerFactory.getLogger(ShopServiceImpl.class);

    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ShopCategoryMapper shopCategoryMapper;
    private static final int pageSize = 10;

    @Override
    public AjaxResult addShop(Shop shop) {
        try {
            if (StringUtils.isBlank(shop.getName())) {
                return AjaxResult.newError().withMsg("店铺名称不能为空");
            }
            if (StringUtils.isBlank(shop.getTelephone())) {
                return AjaxResult.newError().withMsg("电话不能为空");
            }
            if (StringUtils.isBlank(shop.getAddress())) {
                return AjaxResult.newError().withMsg("地址不能为空");
            }
            if (StringUtils.isBlank(shop.getDesc())) {
                return AjaxResult.newError().withMsg("描述不能为空");
            }
            if (StringUtils.isBlank(shop.getCoverImg())) {
                return AjaxResult.newError().withMsg("封面不能为空");
            }
            if (StringUtils.isBlank(shop.getContent())) {
                return AjaxResult.newError().withMsg("详细内容不能为空");
            }
            if (StringUtils.isBlank(shop.getCategory())) {
                return AjaxResult.newError().withMsg("分类不能为空");
            }
            int row = shopMapper.insertShop(shop);
            if (row > 0) {
                return AjaxResult.newSuccess().withData(shop.getId());
            }
        } catch (Exception e) {
            LOG.error("ShopServiceImpl addShop error. shop = " + shop, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult editShop(Shop shop) {
        try {
            if (shop.getId() <= 0) {
                return AjaxResult.newError().withMsg("店铺id不能为空");
            }
            if (StringUtils.isBlank(shop.getName())) {
                return AjaxResult.newError().withMsg("店铺名称不能为空");
            }
            if (StringUtils.isBlank(shop.getTelephone())) {
                return AjaxResult.newError().withMsg("电话不能为空");
            }
            if (StringUtils.isBlank(shop.getAddress())) {
                return AjaxResult.newError().withMsg("地址不能为空");
            }
            if (StringUtils.isBlank(shop.getDesc())) {
                return AjaxResult.newError().withMsg("描述不能为空");
            }
            if (StringUtils.isBlank(shop.getCoverImg())) {
                return AjaxResult.newError().withMsg("封面不能为空");
            }
            if (StringUtils.isBlank(shop.getContent())) {
                return AjaxResult.newError().withMsg("详细内容不能为空");
            }
            if (StringUtils.isBlank(shop.getCategory())) {
                return AjaxResult.newError().withMsg("分类不能为空");
            }
            int row = shopMapper.updateShop(shop);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("ShopServiceImpl editShop error. shop = " + shop, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult deleteShop(int shopId) {
        try {
            int row = shopMapper.deleteShop(shopId);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("ShopServiceImpl deleteShop error. shopId = " + shopId, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getShopPageList(String category, int pageNo) {
        try {
            if (pageNo < 1) {
                pageNo = 1;
            }
            int count = shopMapper.selectCount(category);
            List<Shop> shops = shopMapper.selectPageList(category, (pageNo - 1) * pageSize, pageSize);
            Map<String,Object> data = new HashMap<>();
            data.put("count", count);
            data.put("pageCount", (count - 1) / pageSize + 1);
            data.put("shops", shops);
            return AjaxResult.newSuccess().withData(data);
        } catch (Exception e) {
            LOG.error("ShopServiceImpl getShopPageList error. category = " + category + ",pageNo = " + pageNo, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getShopById(int shopId) {
        try {
            Shop shop = shopMapper.selectById(shopId);
            return AjaxResult.newSuccess().withData(shop);
        } catch (Exception e) {
            LOG.error("ShopServiceImpl getShopById error. shopId = " + shopId, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult updateTopStatus(int shopId, int status) {
        try {
            int row = shopMapper.updateTopStatus(shopId, status);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("ShopServiceImpl updateTopStatus error. shopId = " + shopId + ",status = " + status, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getShopCategorys() {
        try {
            List<Map<String,String>> categorys = shopCategoryMapper.selectCategorys();
            return AjaxResult.newSuccess().withData(categorys);
        } catch (Exception e) {
            LOG.error("ShopServiceImpl getShopCategorys error.", e);
        }
        return AjaxResult.newError();
    }
}
