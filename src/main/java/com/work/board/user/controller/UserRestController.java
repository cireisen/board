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
    @RequestMapping(value="/", method = RequestMethod.POST) // 얘는 데이터를 등록하는 역할이므로, POST 메서드 사용하기테스트용으로만들었어요ㅇㅋ 얘는 필요없겠누 가입이필요하니깐
    @ResponseBody
    public String insert() throws Exception
    {
        User usr = new User();
        usr.setName("이야아앗호");
        usr.setPassword("doge");
        usr.setEmail("남");
        return "wow";
    }
    //굿

    @RequestMapping(value="/create",method=RequestMethod.POST)
    public ModelAndView register(RegisterDTO dto) throws Exception
    {
        ModelAndView mav= new ModelAndView("redirect");
        // 여기서 한 번 받아와 출력해보자.호옹이
        //와!
        //이제 여기서 가입 하면되겠넹
        // 여기는 대신에 유저가 입력한 값을 받아와서 처리해주는 부분이고
        // 화면에 뭘 보여줄지 결정하는거는
        // 여기서 완료여부를(돼면)확인하고 그걸로 리다이렉트 위치 지정해서 넘겨주면 되지않을까요
        // ㅇㅇ 될지도 리다이렉트 페이지 하나 두고 거기에 결과 전송해서 ㄱㅊ으면 메인 아니면 뒤로 가도록 자바스크립트 만들면 어떨까. 아니면 제슾에서 처리해도 되고
        //근데 완료여부는 어떻게확인하죠 jsp에서 확인하고 완료여부를 spring에서 어떻게 확인하면될까요
        //여기가 널이면 실패 아니면 성공 아닐까 ㅇㅎ
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
        //요래하면 될거같아요

        System.out.println(dto.getName());
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
