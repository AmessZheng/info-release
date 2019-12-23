package com.zhuxn.inforelease.service;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.orm.entity.Info;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhuxn
 */
public interface InfoService {

	/**
	 * 发布信息
	 * @author zhuxn
	 * @date 2019/12/23 9:01
	 * @param info
	 * @return
	 */
	AjaxResult addInfo(Info info, HttpServletRequest request);

	/**
	 * 删除信息
	 * @author zhuxn
	 * @date 2019/12/23 9:03
	 * @param infoId
	 * @param deletePassword
	 * @return
	 */
	AjaxResult deleteInfo(int infoId, String deletePassword);

	/**
	 * 管理员删除信息
	 * @author zhuxn
	 * @date 2019/12/23 9:03
	 * @param infoId
	 * @return
	 */
	AjaxResult deleteInfoByUser(int infoId);

	/**
	 * 查询信息列表
	 * @author zhuxn
	 * @date 2019/12/22 15:22
	 * @param category
	 * @param infoType
	 * @param pageNo
	 * @return
	 */
	AjaxResult getInfoPageList(String category, String infoType, int pageNo);

	/**
	 * 查询信息列表
	 * @author zhuxn
	 * @date 2019/12/22 15:22
	 * @param category
	 * @param infoType
	 * @param pageNo
	 * @return
	 */
	AjaxResult getInfoPageListForUser(String category, String infoType, int pageNo);

	/**
	 * 根据id查询信息
	 * @author zhuxn
	 * @date 2019/12/23 9:05
	 * @param infoId
	 * @return
	 */
	AjaxResult getInfoById(int infoId);

	/**
	 * 更新信息置顶状态
	 * @author zhuxn
	 * @date 2019/12/23 9:05
	 * @param infoId
	 * @param status
	 * @return
	 */
	AjaxResult updateTopStatus(int infoId, int status);

	/**
	 * 更新审核状态
	 * @author zhuxn
	 * @date 2019/12/23 9:11
	 * @param infoId
	 * @param status
	 * @return
	 */
	AjaxResult updatePassStatus(int infoId, int status);

	/**
	 * 查询信息分类列表
	 * @author zhuxn
	 * @date 2019/12/23 9:06
	 * @return
	 */
	AjaxResult getInfoCategorys();

	/**
	 * 查询信息类型列表
	 * @author zhuxn
	 * @date 2019/12/23 9:09
	 * @param category
	 * @return
	 */
	AjaxResult getInfoTypes(String category);

}
