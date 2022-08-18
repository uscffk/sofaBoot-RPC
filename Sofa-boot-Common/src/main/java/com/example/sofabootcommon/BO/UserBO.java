package com.example.sofabootcommon.BO;

import com.example.sofabootcommon.dto.UserDto;
import com.example.sofabootcommon.entity.Comment;
import com.example.sofabootcommon.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author 房发科
 * @create 2022/8/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserBO extends UserDto {
    List<Comment> comments;
}
