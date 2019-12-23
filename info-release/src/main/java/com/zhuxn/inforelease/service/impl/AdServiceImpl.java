package com.zhuxn.inforelease.service.impl;

import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.orm.entity.Ad;
import com.zhuxn.inforelease.orm.mapper.AdMapper;
import com.zhuxn.inforelease.service.AdService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuxn
 * @date 2019/12/23 15:04
 */
@Service
public class AdServiceImpl implements AdService{


    private static Logger LOG = LoggerFactory.getLogger(AdServiceImpl.class);

    @Autowired
    private AdMapper adMapper;
    private static final int PAGE_SIZE = 10;

    @Override
    public AjaxResult addAd(Ad ad) {
        try {
            if (StringUtils.isBlank(ad.getAdType())) {
                return AjaxResult.newError().withMsg("请选择一个广告类型");
            }
            if (ad.getAdType().equals("文本广告")) {
                if (StringUtils.isBlank(ad.getContent())) {
                    return AjaxResult.newError().withMsg("文本广告内容不能为空");
                }
            } else if (ad.getAdType().equals("图片广告")) {
                if (StringUtils.isBlank(ad.getImgUrl())) {
                    return AjaxResult.newError().withMsg("图片广告图片链接不能为空");
                }
            }
            int row = adMapper.insertAd(ad);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("AdServiceImpl addAd error. ad = " + ad, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult editAd(Ad ad) {
        try {
            if (ad.getId() <= 0) {
                return AjaxResult.newError().withMsg("广告id不能为空");
            }
            if (StringUtils.isBlank(ad.getAdType())) {
                return AjaxResult.newError().withMsg("请选择一个广告类型");
            }
            if (ad.getAdType().equals("文本广告")) {
                if (StringUtils.isBlank(ad.getContent())) {
                    return AjaxResult.newError().withMsg("文本广告内容不能为空");
                }
            } else if (ad.getAdType().equals("图片广告")) {
                if (StringUtils.isBlank(ad.getImgUrl())) {
                    return AjaxResult.newError().withMsg("图片广告图片链接不能为空");
                }
            }
            int row = adMapper.updateAd(ad);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("AdServiceImpl editAd error. ad = " + ad, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult deleteAd(int id) {
        try {
            int row = adMapper.deleteAd(id);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("AdServiceImpl deleteAd error. id = " + id, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getAdPageList(String adType, int pageNo) {
        try {
            if (pageNo < 1) {
                pageNo = 1;
            }
            int count = adMapper.selectCount(adType);
            List<Ad> ads = adMapper.selectPageList(adType, (pageNo - 1) * PAGE_SIZE, PAGE_SIZE);
            Map<String, Object> data = new HashMap<>();
            data.put("count", count);
            data.put("pageCount", (count - 1)/PAGE_SIZE + 1);
            data.put("ads", ads);
            return AjaxResult.newSuccess().withData(data);
        } catch (Exception e) {
            LOG.error("AdServiceImpl getAdPageList error. adType = " + adType + ",pageNo = " + pageNo, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getAdForView(String adType) {
        try {
            List<Ad> ads = adMapper.selectForView(adType);
            if (null != ads) {
                return AjaxResult.newSuccess().withData(ads);
            }
        } catch (Exception e) {
            LOG.error("AdServiceImpl getAdForView error. adType = " + adType, e);
        }
        return AjaxResult.newError();
    }
}
