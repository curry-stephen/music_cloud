package com.yy.service;

import com.yy.pojo.Song_list;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
public interface Song_listService extends IService<Song_list> {
    boolean addSongList (Song_list songList);

    boolean updateSongListMsg(Song_list songList);

    boolean updateSongListImg(Song_list songList);

    boolean deleteSongList(Integer id);

    List<Song_list> allSongList();

    List<Song_list> likeTitle(String title);

    List<Song_list> likeStyle(String style);

    List<Song_list> songListOfTitle(String title);
}
