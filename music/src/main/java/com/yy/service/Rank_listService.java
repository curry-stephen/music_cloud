package com.yy.service;

import com.yy.pojo.Rank_list;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
public interface Rank_listService extends IService<Rank_list> {
    int rankOfSongListId(Long songListId);

    boolean addRank(Rank_list rankList);
}
