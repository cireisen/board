package com.work.board.user.controller;

import com.work.board.user.domain.User;
import com.work.board.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Controller(value="/users")
public class UserController {   // 얘는 이제 웹에 보여주는 행동을 해주는 컨트롤러

    @Autowired
    private UserService service;

    @RequestMapping("/jsp")
    public String jsp() throws Exception
    {
        return "main";
    }
    @RequestMapping("/hreftest")
    public ModelAndView href() throws Exception
    {
        ModelAndView mav= new ModelAndView("href");

        List<User> list = service.findAll();
        List<List<String>> sendData = new ArrayList<List<String>>();

        for(int i =0; i<list.size();i++)
        {
            List<String> Datalist = new ArrayList<String>();
            Datalist.add(list.get(i).getId());
            Datalist.add(list.get(i).getName());
            Datalist.add(list.get(i).getPassword());
            sendData.add(Datalist);
        }
        mav.addObject("value",sendData);
        return mav;
    }
    @RequestMapping(value="/register")
    public String register() throws Exception
    {
        //여기서 해주면 역할이 분리되겠지?네 되긴한데 리다이렉드 해야해오 ㅇㅋ
        return "register";
        //데이터 보내는거
    }

}
