package ssh.entity;

/**
 * create bu tan on 2018-05-09
 * 用户实体类
 * */

public class User {
    private int id; // 用户id
    private String userName; // 用户姓名
    private String age; // 用户性别

    public User(int id, String userName, String age) {
        this.id = id;
        this.userName = userName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
