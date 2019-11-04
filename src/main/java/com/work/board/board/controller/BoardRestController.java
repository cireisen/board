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

    @RequestMapping(value="/upload",method= RequestMethod.POST)
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
        mav.addObject("user",dto.getId());
        return mav;
    }
    @GetMapping("/boards/{id}")
    public ModelAndView display(@PathVariable("id")String id) throws Exception
    {
        System.out.println("display 2");
        ModelAndView mav= new ModelAndView("display");
        System.out.println("display 1");
        List<String> list = new ArrayList<String>();
        Board index = service.findById(Integer.parseInt(id));
        System.out.println(id);
        list.add(index.getAuthor());

        list.add(index.getTitle());

        list.add(index.getMain());
        System.out.println(list);
        mav.addObject("value",list);
        return mav;
    }
}
