package com.yy.dao;

import com.yy.pojo.Rank_list;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@Repository
public interface Rank_listMapper extends BaseMapper<Rank_list> {
@Override
int insert(Rank_list rankList);
int insertSelective(Rank_list rankList);
    /**
     * 查总分
     * @param songListId
     * @return
     */
    int selectScoreSum(Long songListId);

    /**
     * 查总评分人数
     * @param songListId
     * @return
     */
    int selectRankNum(Long songListId);

}
