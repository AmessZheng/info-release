package com.zhuxn.inforelease.web.controller.user;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 信息后台管理
 * @author zhuxn
 * @date 2019/12/20 18:24
 */
@RestController
@RequestMapping("user/info")
public class UserInfoController {
    @Autowired
    private InfoService infoService;

    /**
     * 查询信息列表
     * @author zhuxn
     * @date 2019/12/23 11:47
     * @param category
     * @param infoType
     * @param pageNo
     * @return
     */
    @RequestMapping("getInfoPageList")
    public AjaxResult getInfoPageList(@RequestParam(value = "category") String category,
                                      @RequestParam(value = "infoType", defaultValue = "", required = false) String infoType,
                                      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
        return infoService.getInfoPageListForUser(category, infoType, pageNo);
    }

    /**
     * 更新置顶状态
     * @author zhuxn
     * @date 2019/12/23 11:47
     * @param infoId
     * @param status
     * @return
     */
    @RequestMapping("updateTopStatus")
    public AjaxResult updateTopStatus(int infoId, int status) {
        return infoService.updateTopStatus(infoId, status);
    }

    /**
     * 更新审核状态
     * @author zhuxn
     * @date 2019/12/23 11:47
     * @param infoId
     * @param status
     * @return
     */
    @RequestMapping("updatePassStatus")
    public AjaxResult updatePassStatus(int infoId, int status) {
        return infoService.updatePassStatus(infoId, status);
    }

    /**
     * 删除信息
     * @author zhuxn
     * @date 2019/12/23 13:32
     * @param infoId
     * @return
     */
    @RequestMapping("deleteInfo")
    public AjaxResult updatePassStatus(int infoId) {
        return infoService.deleteInfoByUser(infoId);
    }

    /**
     * 根据id查询信息详情
     * @author zhuxn
     * @date 2019/12/24 14:32
     * @param infoId
     * @return
     */
    @RequestMapping("getInfoById")
    public AjaxResult getInfoById(int infoId) {
        return infoService.getInfoById(infoId);
    }

    /**
     * 查询信息分类列表
     * @author zhuxn
     * @date 2019/12/23 11:47
     * @return
     */
    @RequestMapping("getInfoCategorys")
    public AjaxResult getInfoCategorys() {
        return infoService.getInfoCategorys();
    }

    /**
     * 查询信息类型列表
     * @author zhuxn
     * @date 2019/12/23 11:45
     * @param category
     * @return
     */
    @RequestMapping("getInfoTypes")
    public AjaxResult getInfoTypes(String category) {
        return infoService.getInfoTypes(category);
    }
}
