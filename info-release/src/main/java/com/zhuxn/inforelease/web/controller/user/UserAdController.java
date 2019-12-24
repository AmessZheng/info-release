package com.zhuxn.inforelease.web.controller.user;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.orm.entity.Ad;
import com.zhuxn.inforelease.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 广告后台管理
 * @author zhuxn
 * @date 2019/12/23 17:10
 */
@RestController
@RequestMapping("user/ad")
public class UserAdController {
    @Autowired
    private AdService adService;

    /**
     * 查询广告列表
     * @author zhuxn
     * @date 2019/12/23 17:11
     * @param adType
     * @param pageNo
     * @return
     */
    @RequestMapping("getAdPageList")
    public AjaxResult getAdPageList(@RequestParam(value = "adType") String adType,
                                    @RequestParam(value = "pageNo", defaultValue = "1") int pageNo) {
        return adService.getAdPageList(adType, pageNo);
    }

    /**
     * 添加广告
     * @author zhuxn
     * @date 2019/12/23 17:13
     * @param ad
     * @return
     */
    @RequestMapping("addAd")
    public AjaxResult addAd (Ad ad){
        return adService.addAd(ad);
    }

    /**
     * 编辑广告
     * @author zhuxn
     * @date 2019/12/23 17:13
     * @param ad
     * @return
     */
    @RequestMapping("editAd")
    public AjaxResult editAd (Ad ad){
        return adService.editAd(ad);
    }

    /**
     * 删除广告
     * @author zhuxn
     * @date 2019/12/23 17:14
     * @param id
     * @return
     */
    @RequestMapping("deleteAd")
    public AjaxResult deleteAd (int id){
        return adService.deleteAd(id);
    }

    /**
     * 根据id查询广告详情
     * @author zhuxn
     * @date 2019/12/24 15:47
     * @param id
     * @return
     */
    @RequestMapping("getById")
    public AjaxResult getById (int id){
        return adService.getAdById(id);
    }
}
