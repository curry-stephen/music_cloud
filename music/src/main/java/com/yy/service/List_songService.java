package com.yy.service;

import com.yy.pojo.List_song;
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
public interface List_songService extends IService<List_song> {
    boolean addListSong(List_song listSong);

    boolean updateListSongMsg(List_song listSong);

    boolean deleteListSong(Integer songId);

    List<List_song> allListSong();

    List<List_song> listSongOfSongId(Integer songListId);

}
