package com.yy.dao;

import com.yy.pojo.Singer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author young
 * @since 2022-03-13
 */
@Repository
public interface SingerMapper extends BaseMapper<Singer> {
//int deleteByPrimaryKey(Integer id);
//
//int inert(Singer singer);

int insertSelective(Singer singer);

Singer selectByPrimaryKey(Integer id);

int updateByPrimaryKey(Singer singer);

int updateSingerMsg(Singer singer);

int updateSingerPic(Singer singer);

int deleteSinger(Integer id);

List<Singer> allSinger();

List<Singer> singerOfName(String name);

List<Singer> singerOfSex(Integer sex);
}
