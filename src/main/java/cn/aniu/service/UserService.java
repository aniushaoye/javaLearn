package cn.aniu.service;

import cn.aniu.domain.User;
import cn.aniu.domain.UserExample;

import java.util.List;

public interface UserService {
    List<User> selectByExample(int p, int size, UserExample example);
    List<User> selectByExample(UserExample example);
    int countByExample(UserExample example);
    User findByUsername(String username) ;
}
