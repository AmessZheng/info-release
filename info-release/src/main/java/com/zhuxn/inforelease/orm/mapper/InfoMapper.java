package com.zhuxn.inforelease.orm.mapper;

import com.zhuxn.inforelease.orm.entity.Info;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @author zhuxn
 * @date 2019/12/23 10:37
 */
public interface InfoMapper {

    /**
     * 新增信息
     * @author zhuxn
     * @date 2019/12/23 9:22
     * @param info
     * @return
     */
    int insertInfo(Info info);

    /**
     * 删除信息
     * @author zhuxn
     * @date 2019/12/23 9:24
     * @param infoId
     * @param deletePassword
     * @return
     */
    int deleteInfo(@Param(value = "infoId") int infoId,
                   @Param(value = "deletePassword") String deletePassword);

    /**
     * 删除信息
     * @author zhuxn
     * @date 2019/12/23 9:24
     * @param infoId
     * @return
     */
    int deleteInfoByUser(@Param(value = "infoId") int infoId);

    /**
     * 分页查询信息列表
     * @author zhuxn
     * @date 2019/12/23 9:29
     * @param category
     * @param infoType
     * @param start
     * @param pageSize
     * @return
     */
    List<Info> selectPageList(@Param(value = "category") String category,
                              @Param(value = "infoType") String infoType,
                              @Param(value = "start") int start,
                              @Param(value = "pageSize") int pageSize);

    /**
     * 查询店铺总数
     * @author zhuxn
     * @date 2019/12/23 9:29
     * @param category
     * @param infoType
     * @return
     */
    int selectCount(@Param(value = "category") String category,
                    @Param(value = "infoType") String infoType);

    /**
     * 分页查询信息列表
     * @author zhuxn
     * @date 2019/12/23 9:26
     * @param category
     * @param infoType
     * @param start
     * @param pageSize
     * @return
     */
    List<Info> selectPageListForUser(@Param(value = "category") String category,
                                     @Param(value = "infoType") String infoType,
                                     @Param(value = "start") int start,
                                     @Param(value = "pageSize") int pageSize);

    /**
     * 查询店铺总数
     * @author zhuxn
     * @date 2019/12/23 9:29
     * @param category
     * @param infoType
     * @return
     */
    int selectCountForUser(@Param(value = "category") String category,
                           @Param(value = "infoType") String infoType);

    /**
     * 根据infoId查询详细信息
     * @author zhuxn
     * @date 2019/12/23 9:29
     * @param infoId
     * @return
     */
    Info selectById(@Param(value = "infoId") int infoId);

    /**
     * 更新信息置顶状态
     * @author zhuxn
     * @date 2019/12/23 9:28
     * @param infoId
     * @param status
     * @return
     */
    int updateTopStatus(@Param(value = "infoId") int infoId,
                        @Param(value = "status") int status);

    /**
     * 更新信息通过状态
     * @author zhuxn
     * @date 2019/12/23 11:13
     * @param infoId
     * @param status
     * @return
     */
    int updatePassStatus(@Param(value = "infoId") int infoId,
                         @Param(value = "status") int status);
}
