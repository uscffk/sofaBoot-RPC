package com.example.sofabootcommon.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sofabootcommon.entity.Comment;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 房发科
 * @create 2022/8/17
 */
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
}
