package com.yy.dao;

import com.yy.pojo.Collect;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@Repository
public interface CollectMapper extends BaseMapper<Collect> {
    
    int deleteByPrimaryKey(Integer id);

    @Override
    int insert(Collect collect);

    int insertSelective(Collect collect);

    Collect selectByPrimaryKey(Integer id);

    

    int updateByPrimaryKey(Collect collect);

    int existSongId(@Param("userId") Integer userId, @Param("songId") Integer songId);

    int updateCollectMsg(Collect collect);

    int deleteCollect(@Param("userId") Integer userId, @Param("songId") Integer songId);

    List<Collect> allCollect();

    List<Collect> collectionOfUser(Integer userId);
}
