package com.example.sofabootcommon.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 房发科
 * @create 2022/8/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
    String username;
    String pwd;
}
