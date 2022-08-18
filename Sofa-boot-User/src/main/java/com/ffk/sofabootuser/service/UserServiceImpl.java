package com.ffk.sofabootuser.service;

import cn.hutool.core.bean.BeanUtil;
import com.alipay.sofa.runtime.api.annotation.SofaReference;
import com.alipay.sofa.runtime.api.annotation.SofaReferenceBinding;
import com.alipay.sofa.runtime.api.annotation.SofaService;
import com.alipay.sofa.runtime.api.annotation.SofaServiceBinding;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.sofabootcommon.BO.UserBO;
import com.example.sofabootcommon.dto.UserDto;
import com.example.sofabootcommon.entity.Comment;
import com.example.sofabootcommon.entity.User;
import com.example.sofabootcommon.facade.ICommentService;
import com.example.sofabootcommon.facade.IUserService;
import com.example.sofabootcommon.mapper.UserMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 房发科
 * @create 2022/8/17
 */
@Service
@SofaService(
        interfaceType = IUserService.class,
        bindings = {
                @SofaServiceBinding(
                        bindingType = "bolt"
                )
        })
@DS("user")
public class UserServiceImpl implements IUserService {

    @Resource
    private UserMapper userMapper;

    @SofaReference(interfaceType = ICommentService.class,binding = @SofaReferenceBinding(bindingType = "bolt"))
    private ICommentService commentService;

    @Override
    public int register(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int updatePwd(String pwd, int id) {
        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.eq("id",id);
        User user = new User();
        user.setPwd(pwd);
        return userMapper.update(user, userUpdateWrapper);
    }

    @Override
    public List<UserDto> queryAllUsers() {
        ArrayList<UserDto> userDtos = new ArrayList<>();
        for (User user : userMapper.selectList(new QueryWrapper<>())) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public List<UserDto> queryByPage(int pageNo, int offset) {
//        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
//        Page<User> userPage = new Page<>(pageNo , offset , false);
//        IPage<User> userIPage = userMapper.selectPage(userPage, userLambdaQueryWrapper);
//        List<User> records = userIPage.getRecords();

        //失效
        PageHelper.startPage(pageNo, offset);
        ArrayList<UserDto> userDtos = new ArrayList<>();
        for (User user : userMapper.selectList(new QueryWrapper<>())) {
            UserDto userDto = new UserDto();
            userDto.setUsername(user.getUsername());
            userDto.setId(userDto.getId());
            userDtos.add(userDto);
        }
        return userDtos;
    }

    @Override
    public UserDto queryById(int id) {
        User user = userMapper.selectById(id);
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUsername(user.getUsername());
        return userDto;
    }

    @GlobalTransactional
    @Override
    public int deleteById(int id) {
        int urs = userMapper.deleteById(id);
        //远程调用
        int crs = commentService.deleteByUserId(id);
        if(urs == 1 && crs == 1){
            return 1;
        }
        return 0;
    }

    @Override
    public UserBO queryAllCommentForUser(int id) {
        User user = userMapper.selectById(id);
        UserBO userBO = new UserBO();
        //远程调用
        List<Comment> comments = commentService.queryByUserId(id);
        BeanUtil.copyProperties(user, userBO);
        userBO.setComments(comments);
        return userBO;
    }
}
