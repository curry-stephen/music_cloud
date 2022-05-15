package com.yy.service.impl;

import com.yy.pojo.List_song;
import com.yy.dao.List_songMapper;
import com.yy.service.List_songService;
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
public class List_songServiceImp extends ServiceImpl<List_songMapper, List_song> implements List_songService {
@Autowired
private List_songMapper listSongMapper;
    @Override
    public boolean addListSong(List_song listSong) {
        return listSongMapper.insertSelective(listSong)>0?true:false;
    }

    @Override
    public boolean updateListSongMsg(List_song listSong) {
        return listSongMapper.updateListSongMsg(listSong)>0?true:false;
    }

    @Override
    public boolean deleteListSong(Integer songId) {
        return listSongMapper.deleteListSong(songId)>0?true:false;
    }

    @Override
    public List<List_song> allListSong() {
        return listSongMapper.allListSong();
    }

    @Override
    public List<List_song> listSongOfSongId(Integer songListId) {
        return listSongMapper.listSongOfSongId(songListId);
    }
}
