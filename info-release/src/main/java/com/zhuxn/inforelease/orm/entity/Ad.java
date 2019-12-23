package com.zhuxn.inforelease.orm.entity;

import com.beagledata.commons.orm.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 广告
 * @author zhuxn
 * @date 2019/12/23 14:29
 */
public class Ad extends BaseEntity{

    private static final long serialVersionUID = 2113887371094963057L;
    /**
     * 广告类型 text文字广告 img图片广告
     */
    private String adType;
    /**
     * 文字广告内容
     */
    private String content;
    /**
     * 图片广告地址
     */
    private String imgUrl;
    /**
     * 是否删除
     */
    private boolean isDeleted;
    /**
     * 重要级别
     */
    private int adLevel;
    /**
     * 创建时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public String getAdType() {
        return adType;
    }

    public void setAdType(String adType) {
        this.adType = adType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getAdLevel() {
        return adLevel;
    }

    public void setAdLevel(int adLevel) {
        this.adLevel = adLevel;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Ad{");
        sb.append("adType='").append(adType).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", imgUrl='").append(imgUrl).append('\'');
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", adLevel=").append(adLevel);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
