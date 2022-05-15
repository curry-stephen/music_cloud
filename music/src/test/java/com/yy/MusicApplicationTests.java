package com.yy;

import com.yy.service.impl.ConsumerServiceImp;
import com.yy.service.impl.SingerServiceImp;
import com.yy.service.impl.SongServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MusicApplicationTests {
    @Resource
    private SongServiceImp songServiceImp;
@Autowired
private ConsumerServiceImp consumerService;
@Autowired
private SingerServiceImp singerService;

    @Test
    void contextLoads() {
       // Singer singer = new Singer();
      //  System.out.println(singerService.singerOfName("张杰"));
      //  System.out.println(consumerService.userOfId(12));
     //   System.out.println(System.getProperty("user.dir")+singerService.getById(1).getPic());
        songServiceImp.songOfSingerId(9).forEach(System.out::println);
    }
   
   
}
