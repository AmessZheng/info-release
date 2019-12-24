package com.zhuxn.inforelease.orm.mapper;

import com.zhuxn.inforelease.orm.entity.Shop;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ShopMapper {

    /**
     * 新增店铺
     * @author zhuxn
     * @date 2019/12/22 15:32
     * @param shop
     * @return
     */
    int insertShop(Shop shop);

    /**
     * 编辑店铺
     * @author zhuxn
     * @date 2019/12/22 15:55
     * @param shop
     * @return
     */
    int updateShop(Shop shop);
    /**
     * 删除店铺
     * @author zhuxn
     * @date 2019/12/22 15:55
     * @param shopId
     * @return
     */
    int deleteShop(@Param(value = "shopId") int shopId);
    /**
     * 分页查询店铺列表
     * @author zhuxn
     * @date 2019/12/22 15:55
     * @param category
     * @param start
     * @param pageSize
     * @return
     */
    List<Shop> selectPageList(@Param(value = "category") String category,
                              @Param(value = "start") int start,
                              @Param(value = "pageSize") int pageSize);
    /**
     * 查询店铺总数
     * @author zhuxn
     * @date 2019/12/22 15:56
     * @param category
     * @return
     */
    int selectCount(@Param(value = "category") String category);

    /**
     * 根据shopId查询店铺详细信息
     * @author zhuxn
     * @date 2019/12/22 16:02
     * @param shopId
     * @return
     */
    Shop selectById(@Param(value = "shopId") int shopId);

    /**
     * 更新店铺置顶状态
     * @author zhuxn
     * @date 2019/12/22 16:37
     * @param shopId
     * @param status
     * @return
     */
    int updateTopStatus(@Param(value = "shopId")int shopId,
                        @Param(value = "status")int status);
}
