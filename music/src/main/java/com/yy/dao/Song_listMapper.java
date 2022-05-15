package com.yy.dao;

import com.yy.pojo.Song_list;
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
public interface Song_listMapper extends BaseMapper<Song_list> {
int deleteByPrimaryKey(Integer id);

@Override
int insert(Song_list songList);

int insertSelective(Song_list songList);

Song_list selectByPrimaryKey(Song_list songList);

int updateByPrimaryKeyWithBLOBs(Song_list songList);

int updateByPrimaryKey(Song_list songList);

int updateSongListMsg(Song_list songList);

int updateSongListImg(Song_list songList);

int deleteSongList(Integer id);

List<Song_list> allSongList();

List<Song_list> likeTitle(String title);

List<Song_list> likeStyle(String style);

List<Song_list> songListOfTitle(String title);
}
