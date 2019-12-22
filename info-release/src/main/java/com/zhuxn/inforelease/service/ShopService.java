package com.zhuxn.inforelease.service;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.orm.entity.Shop;

/**
 * @author zhuxn
 */
public interface ShopService {

	/**
	 * 添加店铺信息
	 * @author zhuxn
	 * @date 2019/12/22 15:22
	 * @param shop
	 * @return
	 */
	AjaxResult addShop(Shop shop);

	/**
	 * 编辑店铺信息
	 * @author zhuxn
	 * @date 2019/12/22 15:22
	 * @param shop
	 * @return
	 */
	AjaxResult editShop(Shop shop);

	/**
	 * 删除店铺信息
	 * @author zhuxn
	 * @date 2019/12/22 15:22
	 * @param shopId
	 * @return
	 */
	AjaxResult deleteShop(int shopId);

	/**
	 * 查询店铺信息
	 * @author zhuxn
	 * @date 2019/12/22 15:22
	 * @param category
	 * @param pageNo
	 * @return
	 */
	AjaxResult getShopPageList(String category, int pageNo);

	/**
	 * 根据id查询店铺信息
	 * @author zhuxn
	 * @date 2019/12/22 16:01
	 * @param shopId
	 * @return
	 */
	AjaxResult getShopById(int shopId);

	/**
	 * 更新店铺置顶状态
	 * @author zhuxn
	 * @date 2019/12/22 16:36
	 * @param shopId
	 * @param status
	 * @return
	 */
	AjaxResult updateTopStatus(int shopId, int status);

	/**
	 * 查询店铺分类列表
	 * @author zhuxn
	 * @date 2019/12/22 16:50
	 * @return
	 */
	AjaxResult getShopCategorys();
}
