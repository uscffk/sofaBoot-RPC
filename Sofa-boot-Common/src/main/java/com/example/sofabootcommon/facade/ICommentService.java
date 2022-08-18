package com.example.sofabootcommon.facade;

import com.example.sofabootcommon.entity.Comment;

import java.util.List;

/**
 * @author 房发科
 * @create 2022/8/17
 */
public interface ICommentService {

    /**
     * 查询所有评论
     * @return
     */
    List<Comment> queryAll();

    /**
     * 分页查询
     * @param pageNo
     * @param offset
     * @return
     */
    List<Comment> queryByPage(int pageNo, int offset);

    /**
     * 按评论id查询
     * @param id
     * @return
     */
    Comment queryById(int id);

    /**
     * 按用户id查询
     * @param userId
     * @return 评论集合
     */
    List<Comment> queryByUserId(int userId);

    /**
     * 增加评论
     * @param comment
     * @return
     */
    int addComment(Comment comment);

    /**
     * 按评论id删除
     * @param id
     * @return
     */
    int deleteByCommentId(int id);

    /**
     * 按用户id删除
     * @param id
     * @return
     */
    int deleteByUserId(int id);

    /**
     * 更新评论内容
     * @param id 评论id
     * @param content 新的评论内容
     * @return
     */
    int updateComment(int id, String content);

}
