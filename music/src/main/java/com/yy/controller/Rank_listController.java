package com.yy.controller;


import com.alibaba.fastjson.JSONObject;
import com.yy.pojo.Rank_list;
import com.yy.service.impl.Rank_listServiceImp;
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
@RequestMapping("/rankList")
public class Rank_listController {
@Autowired
    private Rank_listServiceImp rankListService;

@RequestMapping(value = "/add",method = RequestMethod.POST)
    public Object addRank(HttpServletRequest request){
    JSONObject object = new JSONObject();
    String songListId = request.getParameter("songListId");
    String consumerId = request.getParameter("consumerId");
    String score = request.getParameter("score").trim();
    Rank_list rankList = new Rank_list();
    rankList.setSongListId(Long.parseLong(songListId));
    rankList.setConsumerId(Long.parseLong(consumerId));
    rankList.setScore(Integer.parseInt(score));

    boolean rank = rankListService.addRank(rankList);
    if (rank){
        object.put("code",1);
        object.put("msg","评价成功");
        return object;
    }else {
        object.put("code",0);
        object.put("msg","评价失败");
        return object;
    }
}
//获取指定歌单评分
@RequestMapping(method = RequestMethod.GET)
    public Object rankOfSongListId(HttpServletRequest request){
    String songListId = request.getParameter("songListId");
    return rankListService.rankOfSongListId(Long.parseLong(songListId));
}
}

