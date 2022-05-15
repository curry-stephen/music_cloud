package com.yy.service.impl;

import com.yy.pojo.Comment;
import com.yy.dao.CommentMapper;
import com.yy.service.CommentService;
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
public class CommentServiceImp extends ServiceImpl<CommentMapper, Comment> implements CommentService {
@Autowired
private CommentMapper commentMapper;
    @Override
    public boolean addComment(Comment comment) {
        return commentMapper.insertSelective(comment)>0?true:false;
    }

    @Override
    public boolean updateCommentMsg(Comment comment) {
        return commentMapper.updateCommentMsg(comment)>0?true:false;
    }

    @Override
    public boolean deleteComment(Integer id) {
        return commentMapper.deleteComment(id)>0?true:false;
    }

    @Override
    public List<Comment> allComment() {
        return commentMapper.allComment();
    }

    @Override
    public List<Comment> commentOfSongId(Integer songId) {
        return commentMapper.commentOfSongId(songId);
    }

    @Override
    public List<Comment> commentOfSongListId(Integer songListId) {
        return commentMapper.commentOfSongListId(songListId);
    }
}
