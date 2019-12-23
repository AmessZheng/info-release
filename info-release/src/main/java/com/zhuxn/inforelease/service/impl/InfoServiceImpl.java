package com.zhuxn.inforelease.service.impl;

import com.alibaba.fastjson.JSON;
import com.beagledata.commons.AjaxResult;
import com.zhuxn.inforelease.orm.entity.Info;
import com.zhuxn.inforelease.orm.mapper.InfoCategoryMapper;
import com.zhuxn.inforelease.orm.mapper.InfoMapper;
import com.zhuxn.inforelease.orm.mapper.InfoTypeMapper;
import com.zhuxn.inforelease.service.InfoService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhuxn
 * @date 2019/12/23 9:13
 */
@Service
public class InfoServiceImpl implements InfoService{

    private final Logger LOG = LoggerFactory.getLogger(InfoServiceImpl.class);

    @Autowired
    private InfoMapper infoMapper;
    @Autowired
    private InfoCategoryMapper infoCategoryMapper;
    @Autowired
    private InfoTypeMapper infoTypeMapper;
    private static final int PAGE_SIZE = 20;

    @Override
    public AjaxResult addInfo(Info info, HttpServletRequest request) {
        try {
            if (StringUtils.isBlank(info.getCategory())) {
                return AjaxResult.newError().withMsg("请选择一个合适的信息分类");
            }
            if (StringUtils.isBlank(info.getInfoType())) {
                return AjaxResult.newError().withMsg("请选择一个合适的信息发布类型");
            }
            if (StringUtils.isBlank(info.getContent())) {
                return AjaxResult.newError().withMsg("信息内容不能为空");
            }
            if (info.getContent().length() > 200) {
                return AjaxResult.newError().withMsg("信息内容不能超过200字符");
            }
            if (StringUtils.isBlank(info.getDeletePassword())) {
                return AjaxResult.newError().withMsg("删除密码不能为空");
            }
            info.setIpAddress(getIpAddressFromRequest(request));
            info.setDeletePassword(DigestUtils.md5DigestAsHex(info.getDeletePassword().getBytes()));
            int row = infoMapper.insertInfo(info);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("InfoServiceImpl addInfo error. info = " + info, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult deleteInfo(int infoId, String deletePassword) {
        try {
            if (StringUtils.isBlank(deletePassword)) {
                return AjaxResult.newError().withMsg("请输入删除密码");
            }
            int row = infoMapper.deleteInfo(infoId, DigestUtils.md5DigestAsHex(deletePassword.getBytes()));
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("InfoServiceImpl deleteInfo error. infoId = " + infoId + ",deletePassword = " + deletePassword, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult deleteInfoByUser(int infoId) {
        try {
            int row = infoMapper.deleteInfoByUser(infoId);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("InfoServiceImpl deleteInfoByUser error. infoId = " + infoId, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getInfoPageList(String category, String infoType, int pageNo) {
        try {
            if (pageNo < 1) {
                pageNo = 1;
            }
            int count = infoMapper.selectCount(category, infoType);
            List<Info> infos = infoMapper.selectPageList(category, infoType, (pageNo - 1) * PAGE_SIZE, PAGE_SIZE);
            Map<String,Object> data = new HashMap<>();
            data.put("count", count);
            data.put("pageCount", (count - 1)/PAGE_SIZE + 1);
            data.put("infos", infos);
            return AjaxResult.newSuccess().withData(data);
        } catch (Exception e) {
            LOG.error("InfoServiceImpl getInfoPageList error. category = " + category + ",pageNo = " + pageNo, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getInfoPageListForUser(String category, String infoType, int pageNo) {
        try {
            if (pageNo < 1) {
                pageNo = 1;
            }
            int count = infoMapper.selectCountForUser(category, infoType);
            List<Info> infos = infoMapper.selectPageListForUser(category, infoType, (pageNo - 1) * PAGE_SIZE, PAGE_SIZE);
            Map<String,Object> data = new HashMap<>();
            data.put("count", count);
            data.put("pageCount", (count - 1)/PAGE_SIZE + 1);
            data.put("infos", infos);
            return AjaxResult.newSuccess().withData(data);
        } catch (Exception e) {
            LOG.error("InfoServiceImpl getInfoPageListForUser error. category = " + category + ",pageNo = " + pageNo, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getInfoById(int infoId) {
        try {
            Info info = infoMapper.selectById(infoId);
            if (null != info) {
                return AjaxResult.newSuccess().withData(info);
            }
        } catch (Exception e) {
            LOG.error("InfoServiceImpl getInfoById error. infoId = " + infoId, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult updateTopStatus(int infoId, int status) {
        try {
            int row = infoMapper.updateTopStatus(infoId, status);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("InfoServiceImpl updateTopStatus error. infoId = " + infoId + ",status = " + status, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult updatePassStatus(int infoId, int status) {
        try {
            int row = infoMapper.updatePassStatus(infoId, status);
            if (row > 0) {
                return AjaxResult.newSuccess();
            }
        } catch (Exception e) {
            LOG.error("InfoServiceImpl updatePassStatus error. infoId = " + infoId + ",status = " + status, e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getInfoCategorys() {
        try {
            List<String> categroys = infoCategoryMapper.selectInfoCategroys();
            if (null != categroys) {
                return AjaxResult.newSuccess().withData(categroys);
            }
        } catch (Exception e) {
            LOG.error("InfoServiceImpl getInfoCategorys error.", e);
        }
        return AjaxResult.newError();
    }

    @Override
    public AjaxResult getInfoTypes(String category) {
        try {
            List<String> types = infoTypeMapper.selectInfoTypes(category);
            if (null != types) {
                return AjaxResult.newSuccess().withData(types);
            }
        } catch (Exception e) {
            LOG.error("InfoServiceImpl getInfoTypes error. category = " + category, e);
        }
        return AjaxResult.newError();
    }

    private String getIpAddressFromRequest(HttpServletRequest request) {
        try {
            String ipAddress = request.getHeader("x-forwarded-for");
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("Proxy-Client-IP");
            }
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getHeader("WL-Proxy-Client-IP");
            }
            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
                ipAddress = request.getRemoteAddr();
                if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
                    //根据网卡取本机配置的IP
                    InetAddress inet = null;
                    try {
                        inet = InetAddress.getLocalHost();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    ipAddress= inet.getHostAddress();
                }
            }
            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
            //"***.***.***.***".length() = 15
            if(ipAddress!=null && ipAddress.length()>15){
                if(ipAddress.indexOf(",")>0){
                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
                }
            }
            return ipAddress;
        } catch (Exception e) {
            LOG.error("InfoServiceImpl getIpAddressFromRequest error. request = " + JSON.toJSONString(request), e);
        }
        return StringUtils.EMPTY;
    }
}
