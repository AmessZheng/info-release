package com.zhuxn.inforelease.orm.mapper;

import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author zhuxn
 * @date 2019/12/23 10:37
 */
public interface InfoTypeMapper {

    /**
     * 查询信息类型列表
     * @author zhuxn
     * @date 2019/12/23 11:19
     * @param category
     * @return
     */
    List<String> selectInfoTypes(@Param(value = "category") String category);
}
