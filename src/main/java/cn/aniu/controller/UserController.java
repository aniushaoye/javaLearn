package cn.aniu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import cn.aniu.dao.UserMapper;
import cn.aniu.domain.User;
import cn.aniu.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * �û�������
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Resource
    private UserService service;

    @RequestMapping("/view")
    public String view() {
        return "main/login";
    }

    @RequestMapping("/indexview")
    public String index() {
        return "main/index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(User model, HttpSession session) {
    	System.out.println("in login method...");
        User user = service.findByUsername(model.getUsername());

        if (user == null || !user.getPassword().equals(model.getPassword())) {
            return new ModelAndView("redirect:/login.jsp");
        } else {
            session.setAttribute("user", user);
            ModelAndView mav = new ModelAndView();
            mav.setViewName("index");
            return mav;
        }
    }

    @RequestMapping(value = "/logout")
    public ModelAndView logout(HttpSession session) {
    	System.out.println("in logout method...");
    	session.setAttribute("user", null);
        return new ModelAndView("redirect:/login.jsp");
    }
}