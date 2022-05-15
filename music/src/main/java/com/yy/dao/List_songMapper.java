package com.yy.dao;

import com.yy.pojo.List_song;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface List_songMapper extends BaseMapper<List_song> {
 int deleteByPrimaryKey(Integer id);
 
 int insertSelective(List_song listSong);
 
 List_song selectByPrimaryKey(List_song listSong);
 
 int updateByPrimaryKey(List_song listSong);
 
 int updateListSongMsg(List_song listSong);
 
 int deleteListSong(Integer songId);
 
 List<List_song> allListSong();
 
 List<List_song> listSongOfSongId(Integer songListId);
 
}
