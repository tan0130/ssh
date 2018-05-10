package ssh.dao;

import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ssh.entity.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * create by tan on 2018-05-09
 * 用户操作接口实现类
 * */
public class UserDAOImpl implements UserDAO{
    //注入已在applicationcontext.xml中配制好的sessionFactory
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

   /* public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

    @Override
    public User getUser(int id) {
        String hql = "from User u where u.id=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, String.valueOf(id));
        return (User) query.uniqueResult();
    }

    @Override
    public User getUserByName(String name) {
        String hql = "from User u where u.userName=?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, name);
        return (User) query.uniqueResult();
    }

    @Override
    public List<User> getAllUser() {
        String hql = "from User";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        return query.list();
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        Transaction tran = session.beginTransaction();
        session.save(user);
        session.flush();
        tran.commit();
    }

    @Override
    public boolean delUser(int id) {
        String hql = "delete User u where u.id = ?";
        Session session = sessionFactory.getCurrentSession();
        Transaction tran = session.beginTransaction();
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, String.valueOf(id));
        query.executeUpdate();
        tran.commit();
        return (query.executeUpdate() > 0);
    }

    @Override
    public boolean updateUser(User user) {
        String hql = "update User u set u.userName = ?,u.age=? where u.id = ?";
        Query query = sessionFactory.getCurrentSession().createQuery(hql);
        query.setString(0, user.getUserName());
        query.setString(1, user.getAge());
        query.setString(2, String.valueOf(user.getId()));
        return (query.executeUpdate() > 0);
    }
}
