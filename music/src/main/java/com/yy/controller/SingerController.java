package com.yy.controller;


import com.alibaba.fastjson.JSONObject;
import com.yy.content.Constants;
import com.yy.pojo.Singer;
import com.yy.service.impl.SingerServiceImp;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@RestController
@RequestMapping("/singer")
public class SingerController {
    @Autowired
    private SingerServiceImp singerService;

    @Configuration
    public static class MyPicConfig implements WebMvcConfigurer {

        @Override
        public void addResourceHandlers(ResourceHandlerRegistry registry) {
            registry.addResourceHandler("/img/singerPic/**")
                    .addResourceLocations(Constants.SINGER_PIC_PATH);
        }
    }

    //添加歌手
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Object addSinger(HttpServletRequest request) {
        JSONObject object = new JSONObject();
        String name = request.getParameter("name").trim();
        String sex = request.getParameter("sex").trim();
        String pic = request.getParameter("pic").trim();
        String birth = request.getParameter("birth").trim();
        String location = request.getParameter("location").trim();
        String introduction = request.getParameter("introduction").trim();

        Singer singer = new Singer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = sdf.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setBirth(myBirth);
        singer.setPic(pic);
        singer.setLocation(location);
        singer.setIntroduction(introduction);

        boolean b = singerService.addSinger(singer);
        if (b) {
            object.put("code", 1);
            object.put("msg", "添加成功");
            return object;
        } else {
            object.put("code", 0);
            object.put("msg", "添加失败");
            return object;
        }
    }

    //返回所有歌手
    @RequestMapping(method = RequestMethod.GET)
    public Object allSinger() {
        return singerService.allSinger();
    }

    //会根据歌名查找歌手
    @RequestMapping(value = "/name/detail")
    public Object singerOfName(HttpServletRequest request) {
        String name = request.getParameter("name").trim();
        return singerService.singerOfName(name);
    }

    //根据歌手性别查找歌手
    @RequestMapping(value = "/sex/detail")
    public Object singerOfSex(HttpServletRequest request) {
        String sex = request.getParameter("sex").trim();
        return singerService.singerOfSex(Integer.parseInt(sex));
    }

    //    删除歌手
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Object deleteSinger(HttpServletRequest req) {
        String id = req.getParameter("id");
        return singerService.deleteSinger(Integer.parseInt(id));
    }

    //    更新歌手信息
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Object updateSingerMsg(HttpServletRequest req) {
        JSONObject jsonObject = new JSONObject();
        String id = req.getParameter("id").trim();
        String name = req.getParameter("name").trim();
        String sex = req.getParameter("sex").trim();
        String pic = req.getParameter("pic").trim();
        String birth = req.getParameter("birth").trim();
        String location = req.getParameter("location").trim();
        String introduction = req.getParameter("introduction").trim();

        Singer singer = new Singer();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date myBirth = new Date();
        try {
            myBirth = dateFormat.parse(birth);
        } catch (Exception e) {
            e.printStackTrace();
        }
        singer.setId(Integer.parseInt(id));
        singer.setName(name);
        singer.setSex(new Byte(sex));
        singer.setPic(pic);
        singer.setBirth(myBirth);
        singer.setLocation(location);
        singer.setIntroduction(introduction);

        boolean res = singerService.updateSingerMsg(singer);
        if (res) {
            jsonObject.put("code", 1);
            jsonObject.put("msg", "修改成功");
            return jsonObject;
        } else {
            jsonObject.put("code", 0);
            jsonObject.put("msg", "修改失败");
            return jsonObject;
        }
    }

    //更新歌手头像
    @RequestMapping(value = "/avatar/update", method = RequestMethod.POST)
    public Object updateSingerPic(@RequestParam("file") MultipartFile avatarFile, @RequestParam("id") int id) {
        JSONObject object = new JSONObject();
        if (avatarFile.isEmpty()) {
            object.put("code", 0);
            object.put("msg", "文件上传失败！");
            return object;
        }
        String fileName = System.currentTimeMillis() + avatarFile.getOriginalFilename();
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator") + "img" + System.getProperty("file.separator") + "singerPic";

        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }
        //保存头像到本地资源库
        File dest = new File(filePath + System.getProperty("file.separator") + fileName);
        String storePath = "/img/singerPic/" + fileName;
        try {
            avatarFile.transferTo(dest);
            Singer singer = new Singer();
            singer.setId(id);
            singer.setPic(storePath);
            boolean res = singerService.updateSingerPic(singer);
            if (res) {
                object.put("code", 1);
                object.put("msg", "上传成功");
                return object;
            } else {
                object.put("code", 0);
                object.put("msg", "上传失败！");
                return object;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return object;
        }
    }
//    @RequestMapping("/find")
//    File find(){
//        String path=System.getProperty("user.dir")+singerService.getById(1).getPic();
//        File file = new File(path);
//        return file;
//    }
}


