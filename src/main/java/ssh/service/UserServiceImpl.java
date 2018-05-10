package ssh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ssh.dao.UserDAO;
import ssh.entity.User;

import javax.transaction.Transactional;
import java.util.List;

/**
 * create by tan on 2018-05-10
 * 用户操作业务逻辑层实现
 * */
@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    @Override
    public User getUser(int id) {
        return userDAO.getUser(id);
    }

    @Override
    public User getUserByName(String name) {
        return userDAO.getUserByName(name);
    }

    @Override
    public List<User> getAllUser() {
        return userDAO.getAllUser();
    }

    @Override
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    public boolean delUser(int id) {
        return userDAO.delUser(id);
    }

    @Override
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }
}
