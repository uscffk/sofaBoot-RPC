package com.ffk.sofabootcomment.service;

import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.sofabootcommon.entity.Comment;
import com.example.sofabootcommon.facade.ICommentService;
import com.example.sofabootcommon.mapper.CommentMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 房发科
 * @create 2022/8/17
 */
@Service
@SofaService(
        interfaceType = ICommentService.class,
        bindings = {
                @SofaServiceBinding(
                        bindingType = "bolt"
                )
        })
@DS("comment")
public class CommentServiceImpl implements ICommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> queryAll() {
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        return commentMapper.selectList(commentQueryWrapper);
    }

    @Override
    public List<Comment> queryByPage(int pageNo, int offset) {
        PageHelper.startPage(pageNo, offset);
        return commentMapper.selectList(new QueryWrapper<>());
    }

    @Override
    public Comment queryById(int id) {
        return commentMapper.selectById(id);
    }

    @Override
    public List<Comment> queryByUserId(int userId) {
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.eq("user_id",userId);
        return commentMapper.selectList(commentQueryWrapper);
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.insert(comment);
    }

    @Override
    public int deleteByCommentId(int id) {
        return commentMapper.deleteById(id);
    }

    @Override
    public int deleteByUserId(int id) {
        QueryWrapper<Comment> commentQueryWrapper = new QueryWrapper<>();
        commentQueryWrapper.eq("user_id",id);
        return commentMapper.delete(commentQueryWrapper);
    }

    @Override
    public int updateComment(int id, String content) {
        UpdateWrapper<Comment> commentUpdateWrapper = new UpdateWrapper<>();
        commentUpdateWrapper.eq("id",id);
        Comment comment = new Comment();
        comment.setContent(content);
        return commentMapper.update(comment,commentUpdateWrapper);
    }
}
