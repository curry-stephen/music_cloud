package com.yy.controller;


import com.alibaba.fastjson.JSONObject;
import com.yy.pojo.Collect;
import com.yy.service.impl.CollectServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@RestController
public class CollectController {
@Autowired
    private CollectServiceImp collectService;
//添加收藏歌曲

    @RequestMapping(value = "/collection/add",method = RequestMethod.POST)
public Object addCollection(HttpServletRequest request){
    JSONObject object = new JSONObject();
    String user_id = request.getParameter("userId");
    String type = request.getParameter("type");
    String song_id = request.getParameter("songId");
    String song_list_id = request.getParameter("songListId");
    if (song_id==""){
        object.put("code",0);
        object.put("msg","搜藏歌曲为空");
        return object;
    }else if (collectService.existSongId(Integer.parseInt(user_id),Integer.parseInt(song_id))){
        object.put("code",1);
        object.put("msg","已收藏");
        return object;
    }

    Collect collect = new Collect();
    collect.setUserId(Integer.parseInt(user_id));
    collect.setType(new Byte(type));
    if (new Byte(type)==0){
        collect.setSongId(Integer.parseInt(song_id));
    }else if (new Byte(type)==1){
       collect.setSongListId(Integer.parseInt(song_list_id));
    }
        collect.setCreateTime(new Date());
    boolean b = collectService.addCollection(collect);
    if (b){
        object.put("code",1);
        object.put("msg","收藏成功！");
        return object;
    }else {
        object.put("code",0);
        object.put("msg","收藏失败！");
        return object;
    }
}

//返回所有用户收藏列表
    @RequestMapping(value = "/collection",method = RequestMethod.GET)
    public Object allCollection(HttpServletRequest request)
    {
        return collectService.allCollect();
    }
    
    //返回指定用户ID收藏列表
    @RequestMapping(value = "/collection/detail",method = RequestMethod.GET)
    public Object collectionOfUser(HttpServletRequest request){
        String userId = request.getParameter("userId");
        return collectService.collectionOfUser(Integer.parseInt(userId));
    }
    
    //删除收藏歌曲
    @RequestMapping(value = "/collection/delete",method = RequestMethod.GET)
    public Object deleteCollection(HttpServletRequest request){
        String user_id = request.getParameter("userId").trim();
        String song_id = request.getParameter("songId").trim();
        return collectService.deleteCollect(Integer.parseInt(user_id),Integer.parseInt(song_id));
    }
    
    //更新收藏
    @RequestMapping(value = "/collection/update",method = RequestMethod.POST)
    public Object updateCollectMsg(HttpServletRequest request){
        JSONObject object = new JSONObject();
        String id = request.getParameter("id").trim();
        String user_id = request.getParameter("userId").trim();
        String type = request.getParameter("type").trim();
        String song_id = request.getParameter("songId").trim();
        Collect collect = new Collect();
        collect.setId(Integer.parseInt(id));
        collect.setSongId(Integer.parseInt(song_id));
        collect.setType(new Byte(type));
        collect.setUserId(Integer.parseInt(user_id));

        boolean b = collectService.updateCollectMsg(collect);
        if (b){
            object.put("code",1);
            object.put("msg","修改成功！");
            return object;
        }else {
            object.put("code",0);
            object.put("msg","修改失败");
            return object;
        }
    }
}


