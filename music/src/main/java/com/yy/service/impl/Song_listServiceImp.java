package com.yy.service.impl;

import com.yy.pojo.Song_list;
import com.yy.dao.Song_listMapper;
import com.yy.service.Song_listService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@Service
public class Song_listServiceImp extends ServiceImpl<Song_listMapper, Song_list> implements Song_listService {
@Autowired
private Song_listMapper songListMapper;
    @Override
    public boolean addSongList(Song_list songList) {
        return songListMapper.insertSelective(songList)>0?true:false;
    }

    @Override
    public boolean updateSongListMsg(Song_list songList) {
        return songListMapper.updateSongListMsg(songList)>0?true:false;
    }

    @Override
    public boolean updateSongListImg(Song_list songList) {
        return songListMapper.updateSongListImg(songList)>0?true:false;
    }

    @Override
    public boolean deleteSongList(Integer id) {
        return songListMapper.deleteSongList(id)>0?true:false;
    }

    @Override
    public List<Song_list> allSongList() {
        return songListMapper.allSongList();
    }

    @Override
    public List<Song_list> likeTitle(String title) {
        return songListMapper.likeTitle(title);
    }

    @Override
    public List<Song_list> likeStyle(String style) {
        return songListMapper.likeStyle(style);
    }

    @Override
    public List<Song_list> songListOfTitle(String title) {
        return songListMapper.songListOfTitle(title);
    }
}
