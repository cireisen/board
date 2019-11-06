package com.work.board.user.controller;

import com.work.board.user.domain.User;
import com.work.board.user.dto.RegisterDTO;
import com.work.board.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.ArrayList;
import java.util.List;

@RestController(value = "/api/users")
@EnableAutoConfiguration
public class UserRestController {   //데이터만 다루는 REST controller

    @Autowired
    private UserService service;

    @RequestMapping(value="/")
    @ResponseBody
    public String findAllUser() throws Exception
    {
        List<User> list = service.findAll();

        for(int i = 0 ; i<list.size();i++)
        {
            System.out.println(list.get(i).getName());
            System.out.println(list.get(i).getId());
        }
        return "Hello Gradle";
    }

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public ModelAndView register(RegisterDTO dto) throws Exception
    {
        ModelAndView mav= new ModelAndView("redirect");
        if(service.createUser(dto)==null)
        {
            mav.addObject("done",false);
        }
        else
        {
            mav.addObject("done",true);
        }
        mav.addObject("data","회원가입");
        mav.addObject("user",dto.getId());
        return mav;
    }
    @RequestMapping(value="/user",method=RequestMethod.POST)
    public ModelAndView login(RegisterDTO dto) throws Exception
    {
        ModelAndView mav = new ModelAndView("redirect");
        if(service.findById(dto.getId()) == null)
        {
            mav.addObject("done",false);
        }
        else
        {
            mav.addObject("done",true);
        }
        mav.addObject("data","로그인");
        mav.addObject("user",dto.getId());
        return mav;
    }

}
