package com.zhuxn.inforelease.orm.entity;

import com.beagledata.commons.orm.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 店铺
 * @author zhuxn
 * @date 2019/12/22 15:19
 */
public class Shop extends BaseEntity{

    private static final long serialVersionUID = 6425116120631576415L;
    /**
     * 店铺名称
     */
    private String name;
    /**
     * 联系电话
     */
    private String telephone;
    /**
     * 地址
     */
    private String address;
    /**
     * 描述
     */
    private String desc;
    /**
     * 封面
     */
    private String coverImg;
    /**
     * 详细信息
     */
    private String content;
    /**
     * 所属分类
     */
    private String category;
    /**
     * 是否置顶
     */
    private boolean isTop;
    /**
     * 是否删除
     */
    private boolean isDeleted;
    /**
     * 发布时间
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isTop() {
        return isTop;
    }

    public void setTop(boolean top) {
        isTop = top;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
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
        final StringBuffer sb = new StringBuffer("Shop{");
        sb.append("name='").append(name).append('\'');
        sb.append(", telephone='").append(telephone).append('\'');
        sb.append(", address='").append(address).append('\'');
        sb.append(", desc='").append(desc).append('\'');
        sb.append(", coverImg='").append(coverImg).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", category='").append(category).append('\'');
        sb.append(", isTop=").append(isTop);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
