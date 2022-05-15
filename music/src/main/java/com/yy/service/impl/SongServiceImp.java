package com.yy.service.impl;

import com.yy.pojo.Song;
import com.yy.dao.SongMapper;
import com.yy.service.SongService;
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
public class SongServiceImp extends ServiceImpl<SongMapper, Song> implements SongService {
@Autowired
private SongMapper songMapper;
    @Override
    public boolean addSong(Song song) {
        return songMapper.insertSelective(song)>0?true:false;
    }

    @Override
    public boolean updateSongMsg(Song song) {
        return songMapper.updateSongMsg(song)>0?true:false;
    }

    @Override
    public boolean updateSongUrl(Song song) {
        return songMapper.updateSongUrl(song)>0?true:false;
    }

    @Override
    public boolean updateSongPic(Song song) {
        return songMapper.updateSongPic(song)>0?true:false;
    }

    @Override
    public boolean deleteSong(Integer id) {
        return songMapper.deleteSong(id)>0?true:false;
    }

    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    @Override
    public List<Song> songOfSingerId(Integer singerId) {
        return songMapper.songOfSingerId(singerId);
    }

    @Override
    public List<Song> songOfId(Integer id) {
        return songMapper.songOfId(id);
    }

    @Override
    public List<Song> songOfSingerName(String name) {
        return songMapper.songOfSingerName(name);
    }

    @Override
    public List<Song> songOfName(String name) {
        return songMapper.songOfName(name);
    }
}
