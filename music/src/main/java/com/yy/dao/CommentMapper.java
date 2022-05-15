package com.yy.dao;

import com.yy.pojo.Comment;
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
public interface CommentMapper extends BaseMapper<Comment> {
int deleteByPrimaryKey(Integer id);

@Override
int insert(Comment comment);

int insertSelective(Comment comment);

Comment selectByPrimaryKey(Integer id);

int updateCommentMsg(Comment comment);

int updateByPrimaryKey(Comment comment);

int deleteComment(Integer id);

List<Comment> commentOfSongId(Integer songId);


List<Comment> allComment();
List<Comment> commentOfSongListId(Integer songListId);
}
