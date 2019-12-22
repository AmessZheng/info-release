package com.zhuxn.inforelease.orm.entity;

import com.beagledata.commons.orm.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;

/**
 * 信息
 * @author zhuxn
 * @date 2019/12/22 15:19
 */
public class Info extends BaseEntity{

    private static final long serialVersionUID = 2829420257234039268L;
    /**
     * 信息分类
     */
    private String category;
    /**
     * 信息类型
     */
    private String infoType;
    /**
     * 信息内容
     */
    private String content;
    /**
     * 发布ip
     */
    private String ipAddress;
    /**
     * 删除密码
     */
    private String deletePassword;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getDeletePassword() {
        return deletePassword;
    }

    public void setDeletePassword(String deletePassword) {
        this.deletePassword = deletePassword;
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
        final StringBuffer sb = new StringBuffer("Info{");
        sb.append("category='").append(category).append('\'');
        sb.append(", infoType='").append(infoType).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", ipAddress='").append(ipAddress).append('\'');
        sb.append(", deletePassword='").append(deletePassword).append('\'');
        sb.append(", isTop=").append(isTop);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createTime=").append(createTime);
        sb.append('}');
        return sb.toString();
    }
}
