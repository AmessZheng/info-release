package com.zhuxn.inforelease.orm.mapper;

import com.zhuxn.inforelease.orm.entity.Ad;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author zhuxn
 * @date 2019/12/23 10:37
 */
public interface AdMapper {

    /**
     * 新增广告
     * @author zhuxn
     * @date 2019/12/23 14:42
     * @param ad
     * @return
     */
    int insertAd(Ad ad);

    /**
     * 编辑广告
     * @author zhuxn
     * @date 2019/12/23 16:43
     * @param ad
     * @return
     */
    int updateAd(Ad ad);

    /**
     * 删除广告
     * @author zhuxn
     * @date 2019/12/23 9:24
     * @param id
     * @return
     */
    int deleteAd(@Param(value = "id") int id);



    /**
     * 分页查询广告列表
     * @author zhuxn
     * @date 2019/12/23 14:40
     * @param adType
     * @param start
     * @param pageSize
     * @return
     */
    List<Ad> selectPageList(@Param(value = "adType") String adType,
                            @Param(value = "start") int start,
                            @Param(value = "pageSize") int pageSize);

    /**
     * 查询广告总数
     * @author zhuxn
     * @date 2019/12/23 14:39
     * @param adType
     * @return
     */
    int selectCount(@Param(value = "adType") String adType);

    /**
     * 根据id查询广告详情
     * @author zhuxn
     * @date 2019/12/24 15:43
     * @param id
     * @return
     */
    Ad selectById(@Param(value = "id") int id);

    /**
     * 分类查询广告信息
     * @author zhuxn
     * @date 2019/12/23 16:56
     * @param adType
     * @return
     */
    List<Ad> selectForView(@Param(value = "adType") String adType);
}
