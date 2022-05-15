package com.yy.controller;


import com.alibaba.fastjson.JSONObject;
import com.yy.content.Constants;
import com.yy.pojo.Song_list;
import com.yy.service.impl.Song_listServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@RestController
@RequestMapping("/songList")
public class Song_listController {
    @Autowired
    private Song_listServiceImp songListService;
    
    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer{
        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/songListPic/**")
                    .addResourceLocations(Constants.SONGLIST_PIC_PATH);
        }
    }
    //添加歌单
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addSongList(HttpServletRequest request){
        JSONObject object = new JSONObject();
        String title = request.getParameter("title").trim();
        String pic = request.getParameter("pic").trim();
        String introduction = request.getParameter("introduction").trim();
        String style = request.getParameter("style").trim();

        Song_list songLists = new Song_list();
        songLists.setTitle(title);
        songLists.setIntroduction(introduction);
        songLists.setPic(pic);
        songLists.setStyle(style);
        boolean b = songListService.addSongList(songLists);
        if (b) {
            object.put("code",0);
            object.put("msg","添加失败");
            return object;
        }else {
            object.put("code",1);
            object.put("msg","添加成功！");
            return object;
        }
    }
    
    //返回所有歌单
    @RequestMapping(method =RequestMethod.GET)
    public Object allSongList(){
        return songListService.allSongList();
    }
    
    //返回指定标题对应的歌单
    @RequestMapping(value = "/likeTitle/detail",method = RequestMethod.GET)
    public Object songListOfLikeTitle(HttpServletRequest request){
        String title = request.getParameter("title").trim();
        return songListService.songListOfTitle('%'+title+'%');
    }
    
    //返回指定类型的歌单
    @RequestMapping(value = "/style/detail",method = RequestMethod.GET)
    public Object songListOfStyle(HttpServletRequest request){
        String style = request.getParameter("style");
        return songListService.likeStyle( '%'+style+'%');
    }
    
    //删除歌单
    @RequestMapping(value = "/delete/detail",method = RequestMethod.GET)
    public Object deleteSongList(HttpServletRequest request){
        String id = request.getParameter("id");
        return songListService.deleteSongList(Integer.parseInt(id));
    }
    
    //更新歌单
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public Object updateSongListMsg(HttpServletRequest request){
        JSONObject object = new JSONObject();
        Song_list songList = new Song_list();
        String id = request.getParameter("id").trim();
        String title = request.getParameter("title").trim();
        String pic = request.getParameter("pic").trim();
        String introduction = request.getParameter("introduction").trim();
        String style = request.getParameter("style").trim();
        songList.setTitle(title);
        songList.setStyle(style);
        songList.setIntroduction(introduction);
        songList.setPic(pic);
        songList.setId(Integer.parseInt(id));
        boolean listMsg = songListService.updateSongListMsg(songList);
        if (listMsg) {
            object.put("code",0);
            object.put("msg","修改失败");
            return object;
        }else {
            object.put("code",1);
            object.put("msg","修改成功！");
            return object;
        }
    }
    
    //更新歌单图片
    @RequestMapping(value = "/img/update",method = RequestMethod.POST)
    public Object updateSongListPic(@RequestParam("file")MultipartFile avatorFile,@RequestParam("id")int id){
        JSONObject object = new JSONObject();
        if (avatorFile.isEmpty()) {
            object.put("code",0);
            object.put("msg","文件上传失败！");
            return object;
        }
       String fileName= System.currentTimeMillis()+avatorFile.getOriginalFilename();
       String filePath=System.getProperty("user.dir")+System.getProperty("file.separator")+"img"+System.getProperty("file.separator")+"singerPic";
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }

        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storePath="/img/songListPic/"+fileName;
        try {
            avatorFile.transferTo(dest);
            Song_list songList = new Song_list();
            songList.setId(id);
            songList.setPic(storePath);
            boolean b = songListService.updateSongListImg(songList);
            if (b) {
                object.put("code",1);
                object.put("avator",storePath);
                object.put("msg","上传成功");
                return object;
            }else {
                object.put("code",0);
                object.put("msg","上传失败！");
                return object;
            }
        } catch (IOException e) {
            object.put("code",0);
            object.put("msg","上传出现异常！"+e.getMessage());
        } finally {
            return object;
        }
    }
}

