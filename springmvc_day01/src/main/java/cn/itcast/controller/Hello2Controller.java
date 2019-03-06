package cn.itcast.controller;

import cn.itcast.domain.User;
import cn.itcast.domain.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
/*@RequestMapping("hello")*/
public class Hello2Controller {

    @RequestMapping("show1")
    public ModelAndView test1(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","这是我第一个基于注解springmvc程序");
        mv.setViewName("hello");
        return mv;
    }

    @RequestMapping("sss?/show2")
    public ModelAndView test2(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","ant风格映射：？");
        mv.setViewName("hello2");
        return mv;
    }

    @RequestMapping("aa*/show3")
    public ModelAndView test3(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","ant风格映射：*");
        mv.setViewName("hello2");
        return mv;
    }

    @RequestMapping("**/show4")
    public ModelAndView test4(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","ant风格映射：**");
        mv.setViewName("hello2");
        return mv;
    }

    @RequestMapping("show5/{id}/{name}")
    public ModelAndView test5(@PathVariable("id") Long id ,@PathVariable("name") String name){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","占位符：id："+id+";name:"+name);
        mv.setViewName("hello2");
        return mv;
    }

    @RequestMapping(value = "show6",method = RequestMethod.GET)
    public ModelAndView test6(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","限定请求方法映射");
        mv.setViewName("hello2");
        return mv;
    }

    @RequestMapping(value = "show7",params = "id")
    public ModelAndView test7(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","限定请求方法映射:必须有id");
        mv.setViewName("hello2");
        return mv;
    }

    @RequestMapping(value = "show8",params = "!id")
    public ModelAndView test8(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","限定请求方法映射:不能有id");
        mv.setViewName("hello2");
        return mv;
    }


    @RequestMapping(value = "show9",params = "id=1")
    public ModelAndView test9(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","限定请求方法映射:id=1");
        mv.setViewName("hello2");
        return mv;
    }



    @RequestMapping(value = "show10",params = "id!=1")
    public ModelAndView test10(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","限定请求方法映射:id!=1");
        mv.setViewName("hello2");
        return mv;
    }



    @RequestMapping(value = "show11",params = {"id","name"})
    public ModelAndView test11(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","限定请求方法映射:请求参数中必须含有id name");
        mv.setViewName("hello2");
        return mv;
    }


     @GetMapping(value = "show12")
    public ModelAndView test12(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","组合注解@GetMapping");
      mv.setViewName("hello2");
        return mv;
    }

    @PostMapping(value = "show13")
    public ModelAndView test13(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","组合注解@PostMapping");
      mv.setViewName("hello2");
        return mv;
    } @PutMapping(value = "show14")
    public ModelAndView test14(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","组合注解@PutMapping");
      mv.setViewName("hello2");
        return mv;
    }

    @DeleteMapping(value = "show15")
    public ModelAndView test15(){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","组合注解@DeleteMapping");
      mv.setViewName("hello2");
        return mv;
    }

    @RequestMapping("show16")

    public ModelAndView test16(@RequestParam("name") String name){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","接受普通的请求参数："+name);
        mv.setViewName("hello2");
        return mv;
    }


    @RequestMapping("show17")

    public ModelAndView test17(@RequestParam(value = "name",required = false) String name){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","接受普通的请求参数："+name);
        mv.setViewName("hello2");
        return mv;
    }


    @RequestMapping("show18")

    public ModelAndView test18(@RequestParam(value = "name",required =true,defaultValue = "hello") String name){

        ModelAndView mv = new ModelAndView();
        //添加一个数据，页面上可以取出这个数据
        mv.addObject("msg","接受普通的请求参数："+name);
        mv.setViewName("hello2");
        return mv;
    }



    @RequestMapping("show19")
    public ModelAndView test19(@RequestParam("username")String username,@RequestParam("age")Integer age,@RequestParam("marry")Boolean idMarry,@RequestParam("income")Double income,@RequestParam(value="hobby",required=false)String[] hobby){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        StringBuffer sb = new StringBuffer();
        sb.append(username + "," + age + "," + idMarry + "," + income);
        if(hobby != null){
            for (String string : hobby) {
                sb.append("," + string);
            }
        }

        mv.addObject("msg", "基本数据类型的接收：" + sb.toString());
        return mv;
    }

    @RequestMapping("show20")
  public ModelAndView test20(User user){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","对象数据的接受"+user);

        return mv;
    }

    @RequestMapping("show21")
  public ModelAndView test20(UserVO userVO){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        mv.addObject("msg","集合类型的接收"+userVO);

        return mv;
    }


    @RequestMapping("show22")
    public ModelAndView test22(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello2");
        StringBuffer sb = new StringBuffer();
        sb.append(request.toString()+"<br>");
        sb.append(response.toString()+"<br>");
        sb.append(session.toString()+"<br>");
        mv.addObject("msg","访问ServletAPI:<br>"+sb.toString());
        return mv;
    }

    @RequestMapping("show23")
    public String test23(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        StringBuffer sb = new StringBuffer();
        sb.append(request.toString()+"<br>");
        sb.append(response.toString()+"<br>");
        sb.append(session.toString()+"<br>");
        model.addAttribute("msg", "访问ServletAPI::<br>" + sb.toString());
        //返回视图名称
        return "hello2";
    }


    @RequestMapping("show24")
    public String test24(ModelMap map, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        StringBuffer sb = new StringBuffer();
        sb.append(request.toString()+"<br>");
        sb.append(response.toString()+"<br>");
        sb.append(session.toString()+"<br>");
        map.addAttribute("msg", "访问ServletAPI:<br>?" + sb.toString());
        //返回视图名称
        return "hello2";
    }


    @RequestMapping("show25")
    public String test25(Model model,@CookieValue("JSESSIONID--") String jsessionid){

        model.addAttribute("msg", "获取cookie,jsessionid:" + jsessionid);
        return "hello2";
    }

    @RequestMapping("show26")
    public String test26(){
        return "forward:show27.do?type=forward";
    }

    @RequestMapping("show27")
public String test27(Model model , @RequestParam("type") String type){
        model.addAttribute("msg","转发或重定向:type="+type);
        return "hello2";
    }

    @RequestMapping("show28")
    public String test28(){
        return "redirect:show27.do?type=redirect";
    }


    @RequestMapping("show29")
    @ResponseBody
    public List<User> test29() {
        List<User> users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUsername("小红" + (i + 1));
            user.setAge(20 + i);
            user.setMarry(false);
            user.setIncome(10000.0);
            user.setHobby(new String[]{"篮球", "足球", "排球"});
            users.add(user);

        }
        return users;

    }


    @RequestMapping("show30")
    public String test30(Model model,@RequestBody User user){
        model.addAttribute("msg",user);
        return "hello2";
    }
}
