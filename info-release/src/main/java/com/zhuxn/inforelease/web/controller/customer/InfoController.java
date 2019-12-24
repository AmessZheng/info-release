package com.zhuxn.inforelease.web.controller.customer;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.orm.entity.Info;
import com.zhuxn.inforelease.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;

/**
 * 信息服务
 * @author zhuxn
 * @date 2019/12/20 18:22
 */
@RestController
@RequestMapping("info")
public class InfoController {
    @Autowired
    private InfoService infoService;

    /**
     * 发布信息
     * @author zhuxn
     * @date 2019/12/23 9:00
     * @param info
     * @return
     */
    @RequestMapping("addInfo")
    public AjaxResult addInfo(Info info, HttpServletRequest request) {
        return infoService.addInfo(info, request);
    }

    /**
     * 删除信息
     * @author zhuxn
     * @date 2019/12/23 11:41
     * @param infoId
     * @param deletePassword
     * @return
     */
    @RequestMapping("deleteInfo")
    public AjaxResult deleteInfo(int infoId, String deletePassword) {
        return infoService.deleteInfo(infoId, deletePassword);
    }

    /**
     * 分页查询信息列表
     * @author zhuxn
     * @date 2019/12/23 11:43
     * @param category
     * @param pageNo
     * @return
     */
    @RequestMapping("getInfoPageList")
    public AjaxResult getInfoPageList(@RequestParam(value = "category")  String category,
                                      @RequestParam(value = "infoType", defaultValue = "", required = false) String infoType,
                                      @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
        return infoService.getInfoPageList(category, infoType, pageNo);
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
     * @date 2019/12/23 11:44
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
