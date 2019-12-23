package com.zhuxn.inforelease.orm.mapper;

import java.util.List;

/**
 * @author zhuxn
 * @date 2019/12/23 10:37
 */
public interface InfoCategoryMapper {

    /**
     * 查询信息分类列表
     * @author zhuxn
     * @date 2019/12/23 11:19
     * @return
     */
    List<String> selectInfoCategroys();
}
