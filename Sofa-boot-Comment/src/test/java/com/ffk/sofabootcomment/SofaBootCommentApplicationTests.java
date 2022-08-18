package com.ffk.sofabootcomment;

import com.example.sofabootcommon.entity.Comment;
import com.ffk.sofabootcomment.service.CommentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class SofaBootCommentApplicationTests {

    @Resource
    CommentServiceImpl commentService;

    @Test
    void addComment(){
        Comment comment = new Comment();
        comment.setContent("heng");
        comment.setUserId(1);
        commentService.addComment(comment);
    }

    @Test
    void queryAll(){
        List<Comment> comments = commentService.queryAll();
        System.out.println(comments);
    }

    @Test
    void queryById(){
        System.out.println(commentService.queryById(1));
    }

    @Test
    void queryByUserId(){
        System.out.println(commentService.queryByUserId(1));
    }

    @Test
    void deleteByCommentId(){
        System.out.println(commentService.deleteByCommentId(10));
    }

    @Test
    void updateComment(){
        System.out.println(commentService.updateComment(4, "qqq"));
    }

    @Test
    void queryByPage(){
        System.out.println(commentService.queryByPage(0, 1));
    }

}
