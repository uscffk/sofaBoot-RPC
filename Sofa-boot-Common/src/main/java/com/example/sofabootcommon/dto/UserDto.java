package com.example.sofabootcommon.dto;

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
public class UserDto {
    int id;
    String username;
}
