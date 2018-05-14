package ssh.dao;

import org.jboss.logging.Param;
import ssh.entity.User;

import java.util.List;

/**
 * create by tan om 2018-05-09
 * 用户操作接口
 * */
public interface UserDAO {
    public User getUser(int id); // 根据id查询用户信息
    public User getUserByName(String name); // 根据名称查询用户信息
    public List<User> getAllUser(); // 查询所有用户信息
    public void addUser(User user); // 添加用户信息
    public boolean delUser(int id); // 删除用户信息
    public boolean updateUser(User user); // 更细用户信息
}
