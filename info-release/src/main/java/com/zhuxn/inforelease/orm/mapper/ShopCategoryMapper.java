package com.zhuxn.inforelease.orm.mapper;

import java.util.List;
import java.util.Map;

public interface ShopCategoryMapper {

    /**
     * 查询店铺分类列表
     * @author zhuxn
     * @date 2019/12/22 16:53
     */
    List<Map<String,String>> selectCategorys();
}
