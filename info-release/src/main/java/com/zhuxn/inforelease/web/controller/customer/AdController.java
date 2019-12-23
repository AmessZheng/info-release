package com.zhuxn.inforelease.web.controller.customer;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.service.AdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhuxn
 * @date 2019/12/23 17:19
 */
@RequestMapping("ad")
@RestController
public class AdController {
    @Autowired
    private AdService adService;

    /**
     * 查询广告列表
     * @author zhuxn
     * @date 2019/12/23 17:16
     * @param adType
     * @return
     */
    @RequestMapping("getAdForView")
    public AjaxResult getAdForView(String adType) {
        return adService.getAdForView(adType);
    }
}
