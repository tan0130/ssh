package ssh.service;

import ssh.entity.User;

import java.util.List;

/**
 * create by tan on 2018-05-10
 * 用户操作业务逻辑层接口
 * */
public interface UserService {
    public User getUser(int id); // 根据id查询用户信息
    public User getUserByName(String name); // 根据名称查询用户信息
    public List<User> getAllUser(); // 查询所有用户信息
    public void addUser(User user); // 添加用户信息
    public boolean delUser(int id); // 删除用户信息
    public boolean updateUser(User user); // 更细用户信息
}
