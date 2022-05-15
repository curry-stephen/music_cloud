package com.yy.controller;


import com.alibaba.fastjson.JSONObject;
import com.yy.pojo.List_song;
import com.yy.service.impl.List_songServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@RestController
@RequestMapping("/listSong")
public class List_songController {
@Autowired
    private List_songServiceImp listSongService;
//给歌单添加歌曲
@RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addListSong(HttpServletRequest request){
    JSONObject object = new JSONObject();
    String songId = request.getParameter("songId").trim();
    String songListId = request.getParameter("songListId").trim();
    List_song song = new List_song();
    song.setSongId(Integer.parseInt(songId));
    song.setSongListId(Integer.parseInt(songListId));
    boolean b = listSongService.addListSong(song);
    if (b){
        object.put("code",1);
        object.put("msg","添加成功");
        return object;
    }else {
        object.put("code",0);
        object.put("msg","添加失败");
        return object;
    }
}
    //返回歌单中的所有歌曲
    @RequestMapping(method = RequestMethod.GET)
    public Object allListSong(){
        return listSongService.allListSong();
    }

    //返回歌单里的指定歌单ID的歌曲
    @RequestMapping(value = "/detail",method = RequestMethod.GET)
    public Object listSongOfSongId(HttpServletRequest request){
        String songListId = request.getParameter("songListId");
        return listSongService.listSongOfSongId(Integer.parseInt(songListId));
    }
    
    //删除歌单里的歌曲
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public Object deleteListSong(HttpServletRequest request){
        String songId = request.getParameter("songId");
        return listSongService.deleteListSong(Integer.parseInt(songId));
    }
    //更新个单里面的歌曲信息
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateListSongMsg(HttpServletRequest request){
        JSONObject object = new JSONObject();
        String id = request.getParameter("id");
        String songId = request.getParameter("songId");
        String songListId = request.getParameter("songListId");
        List_song list_song = new List_song();
        list_song.setId(Integer.parseInt(id));
        list_song.setSongId(Integer.parseInt(songId));
        list_song.setSongListId(Integer.parseInt(songListId));
        boolean b = listSongService.updateListSongMsg(list_song);
        if (b){
            object.put("code",1);
            object.put("msg","更新成功！");
            return object;
        }else {
            object.put("code",0);
            object.put("msg","更新失败");
            return object;
        }
    }
}

