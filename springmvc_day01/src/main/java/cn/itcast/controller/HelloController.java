package cn.itcast.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController implements Controller {


    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {

        System.out.println("hello请求进来了......");

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","这是我第一个springmvc程序");
        mv.setViewName("hello");
        return mv;
    }
}
