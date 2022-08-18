package com.example.sofabootcommon.facade;

import com.example.sofabootcommon.BO.UserBO;
import com.example.sofabootcommon.dto.UserDto;
import com.example.sofabootcommon.entity.User;

import java.util.List;

/**
 * @author 房发科
 * @create 2022/8/17
 */
public interface IUserService {
    /**
     * 注册
     * @param user
     * @return
     */
    int register(User user);

    /**
     * 修改密码
     * @param pwd 新密码
     * @param id  用户编号
     * @return
     */
    int updatePwd(String pwd, int id);

    /**
     * 查询所有用户
     * @return
     */
    List<UserDto> queryAllUsers();

    /**
     * 分页查询
     * @param pageNo
     * @param offset
     * @return
     */
    List<UserDto> queryByPage(int pageNo, int offset);

    /**
     * 按用户id查询
     * @param id
     * @return
     */
    UserDto queryById(int id);

    /**
     * 按用户id删除
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 查询一个用户的所有评论
     * @param id
     * @return
     */
    UserBO queryAllCommentForUser(int id);

}
