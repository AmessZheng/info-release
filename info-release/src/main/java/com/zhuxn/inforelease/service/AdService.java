package com.zhuxn.inforelease.service;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.orm.entity.Ad;

/**
 * @author zhuxn
 */
public interface AdService {

	/**
	 * 添加广告信息
	 * @author zhuxn
	 * @date 2019/12/23 14:53
	 * @param ad
	 * @return
	 */
	AjaxResult addAd(Ad ad);

	/**
	 * 编辑广告
	 * @author zhuxn
	 * @date 2019/12/23 16:46
	 * @param ad
	 * @return
	 */
	AjaxResult editAd(Ad ad);

	/**
	 * 删除广告信息
	 * @author zhuxn
	 * @date 2019/12/23 14:53
	 * @param id
	 * @return
	 */
	AjaxResult deleteAd(int id);

	/**
	 * 查询广告列表
	 * @author zhuxn
	 * @date 2019/12/23 14:54
	 * @param adType
	 * @param pageNo
	 * @return
	 */
	AjaxResult getAdPageList(String adType, int pageNo);

	/**
	 * 分类查询广告信息
	 * @author zhuxn
	 * @date 2019/12/23 17:04
	 * @param adType
	 * @return
	 */
	AjaxResult getAdForView(String adType);
}
