package ssh.validator;


import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ssh.entity.User;

/**
 * create by tan on 2018-05-10
 * 用户输入校验器
 * */
public class UserValidator implements Validator {
    // 判断是否是需要校验的类
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User)obj;
        if(user.getUserName().trim() == null || "".equals(user.getUserName())) {
            errors.rejectValue("userName",null,null,"用户名不能为空");
        } else if(!(user.getUserName().trim().matches("^[\u4e00-\u9fa5]*$"))) {
            errors.rejectValue("userName",null,null,"用户名只能输入汉字");
        } else if(user.getUserName().trim().length() > 6) {
            errors.rejectValue("userName",null,null,"用户名长度不能大于6");
        } else if(user.getAge().trim() == null || "".equals(user.getAge())) {
            errors.rejectValue("age",null,null,"请输入年龄");
        } else if(!(user.getAge().trim().matches("^\\+?[1-9][0-9]*$"))) {
            errors.rejectValue("age",null,null,"请输入正确年龄");
        } else if(Integer.parseInt(user.getAge().trim()) > 60 || Integer.parseInt(user.getAge().trim()) < 20) {
            errors.rejectValue("age",null,null,"年龄区间是20-60");
        }
    }
}
