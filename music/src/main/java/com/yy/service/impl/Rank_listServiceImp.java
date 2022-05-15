package com.yy.service.impl;

import com.yy.pojo.Rank_list;
import com.yy.dao.Rank_listMapper;
import com.yy.service.Rank_listService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@Service
public class Rank_listServiceImp extends ServiceImpl<Rank_listMapper, Rank_list> implements Rank_listService {
@Autowired
private Rank_listMapper rankListMapper;
    @Override
    public int rankOfSongListId(Long songListId) {
        //评分总人数如果为0，则返回0
        int i = rankListMapper.selectRankNum(songListId);
        return (i<=0)?0:rankListMapper.selectRankNum(songListId);
    }

    @Override
    public boolean addRank(Rank_list rankList) {
        return rankListMapper.insertSelective(rankList)>0?true:false;
    }
}
