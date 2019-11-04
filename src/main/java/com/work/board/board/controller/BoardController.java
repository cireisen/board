package com.work.board.board.controller;

import com.work.board.board.domain.Board;
import com.work.board.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller(value="/boards")
public class BoardController {
    @Autowired
    private BoardService services;

    @RequestMapping("/main")
    public ModelAndView loadboard() throws Exception {
        ModelAndView mav= new ModelAndView("main");

        List<Board> list = services.findAll();
        List<List<String>> sendData = new ArrayList<List<String>>();
        for(int i =0; i<list.size();i++)
        {
            List<String> Datalist = new ArrayList<String>();
            Datalist.add( String.valueOf(list.get(i).getId()));
            Datalist.add(list.get(i).getTitle());
            Datalist.add(list.get(i).getAuthor());
            sendData.add(Datalist);
        }
        mav.addObject("value",sendData);
        return mav;
    }
}
