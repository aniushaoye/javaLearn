package cn.aniu.service.impl;

import cn.aniu.dao.UserMapper;
import cn.aniu.domain.User;
import cn.aniu.domain.UserExample;
import cn.aniu.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper mapper ;
    @Override
    public List<User> selectByExample(int p, int size, UserExample example) {
        example.setLimitEnd((p-1) * size);
        example.setLimitEnd(size);
        return mapper.selectByExample(example);
    }

    @Override
    public List<User> selectByExample(UserExample example) {
        return null;
    }

    @Override
    public int countByExample(UserExample example) {
        return 0;
    }

    @Override
    public User findByUsername(String username) {
        return mapper.findByUsername(username);
    }
}
