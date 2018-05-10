package ssh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ssh.entity.User;
import ssh.service.UserService;
import ssh.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

/**
 * create by tan on 2018-05-09
 * 用户操作控制层实现
 * */
@Controller
@Transactional
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 我们知道在Controller类中通过@InitBinder标记的方法只有在请求当前Controller的时候才会被执行
    // 所以在这里注册校验器
    @InitBinder
    public void initBainder(DataBinder binder){
        binder.replaceValidators(new UserValidator());
    }

    // 获取所有用户信息
    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public String getAllUser(HttpServletRequest request) {
        request.setAttribute("userList", userService.getAllUser());
        return "pages/allUser";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    @ResponseBody
    public String toIndex() {
        return "index";
    }

    // 删除用户信息
    @RequestMapping(value = "/delUser", method = RequestMethod.DELETE)
    @ResponseBody
    public String delUser(int id) {
        try {
            if(userService.getUser(id) == null) {
                return "fail";
            } else {
                userService.delUser(id);
                return "success";
            }
        } catch(Exception e) {
            return "error";
        }
    }

    // 获取用户信息
    @RequestMapping(value = "/getUser", method = RequestMethod.GET)
    @ResponseBody
    public String getUser(int id, HttpServletRequest request) {
        request.setAttribute("user", userService.getUser(id));
        return "pages/editUser";
    }

    // 更新用户信息
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    @ResponseBody
    public String updateUser(User user, HttpServletRequest request) {
        try {
            if(userService.updateUser(user)) {
                user = userService.getUser(user.getId());
                request.setAttribute("user", user);
                return "redirect:/user/getAllUser";
            } else {
                return "error";
            }
        } catch(Exception e) {
            e.printStackTrace();
            return "error";
        }
    }

    // 跳转添加用户信息页面
    @RequestMapping(value = "/toAddUser")
    @ResponseBody
    public String toAdd() {
        return "pages/addUser";
    }

    // 添加用户信息
    @RequestMapping(value = "/addUser")
    @ResponseBody
    public String addUser(Model model, @Validated @ModelAttribute("user") User user, BindingResult result, Errors errors, HttpServletRequest request) {
        String userName = request.getParameter("userName");
        // 对输入进行验证，当用户名存在时进行提示，不提交页面
        if(userService.getUserByName(userName) != null) {
            errors.rejectValue("userName",null,null,"*用户名已存在");
        }
        if(result.hasErrors()) {
           model.addAttribute("user", user);
           return "pages/addUser";
        } else {
            return "redirect:/user/getAllUser";
        }
    }
}
