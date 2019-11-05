package com.work.board.board.controller;

import com.work.board.board.domain.Board;
import com.work.board.board.dto.BoardDTO;
import com.work.board.board.service.BoardService;
import com.work.board.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;

@RestController(value = "/api/boards")
@EnableAutoConfiguration
public class BoardRestController {
    @Autowired
    private BoardService service;

    @RequestMapping(value="/update",method= RequestMethod.POST)
    public ModelAndView upload(BoardDTO dto) throws Exception
    {
        ModelAndView mav= new ModelAndView("redirect");

        if(service.uploadBoard(dto)==null)
        {
            mav.addObject("done",false);
        }
        else
        {
            mav.addObject("done",true);
        }
        mav.addObject("data","업로드");
        mav.addObject("user",String.valueOf(dto.getId()));
        return mav;
    }
    @GetMapping(value="/boards/{id}")
    public ModelAndView display(@PathVariable("id")String id) throws Exception
    {
        ModelAndView mav= new ModelAndView("display");
        System.out.println(Integer.parseInt(id));
        Board index = service.findById(Integer.parseInt(id));
        index.setAuthor(index.getAuthor());

        index.setTitle(index.getTitle());

        index.setMain(index.getMain());
        System.out.println("이씨발"+index.getMain());
        mav.addObject("board",index);
        return mav;
    }
    @GetMapping(value="/delete/{id}")
    public ModelAndView delete(@PathVariable("id")String id) throws Exception
    {
        ModelAndView mav = new ModelAndView("redirect");
        System.out.println(id);
        String[] getdata = id.split("&");
        String name = getdata[0];
        int num = Integer.parseInt(getdata[1]);
        if(name.equals(service.findById(num).getAuthor()))
        {
            System.out.println("if문 들어옴");
            if (service.deleteById(Integer.parseInt(getdata[1])))
            {
                mav.addObject("done", true);
            } else {
                mav.addObject("done", false);
            }
        }
        else
        {
            mav.addObject("done",false);
        }
        mav.addObject("data","게시판 삭제");
        mav.addObject("user",null);


        return mav;
    }
}
