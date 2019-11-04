package com.work.board.board.dto;

import com.work.board.board.domain.Board;

public class BoardDTO {
    private int id;
    private String author;
    private String title;
    private String main;

    public Board toEntity()
    {
        Board board = new Board();
        board.setId(id);
        board.setAuthor(author);
        board.setTitle(title);
        board.setMain(main);
        return board;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }
}
