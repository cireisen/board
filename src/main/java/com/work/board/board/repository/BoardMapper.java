package com.work.board.board.repository;

import com.work.board.board.domain.Board;

import java.util.List;

public interface BoardMapper {

    public List<Board> findAll() throws Exception;
    public void save(Board board) throws Exception;
    public Board findById(int id) throws Exception;
}
