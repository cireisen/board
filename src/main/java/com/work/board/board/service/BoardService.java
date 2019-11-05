package com.work.board.board.service;

import com.work.board.board.domain.Board;
import com.work.board.board.dto.BoardDTO;
import com.work.board.board.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BoardService {
    @Autowired  // 그럼 여기서 스프링이 알아서 맵퍼 보고 자동으로 매칭시켜줌. 여기도 마찬가지 ㅇㅋ?쩌네요
    //https://khj93.tistory.com/entry/MyBatis-MyBatis%EB%9E%80-%EA%B0%9C%EB%85%90-%EB%B0%8F-%ED%95%B5%EC%8B%AC-%EC%A0%95%EB%A6%AC
    // 시간날 때 함 봐 이거 보니깐 조금 어려운거 같은데, MyBatis 구조 검색해보면 더 쉬운게 나올 수 도
    // 수고혀 감사합니다.
    private BoardMapper boardmapper;

    public List<Board> findAll() throws Exception
    {
        return boardmapper.findAll();
    }
    public Board uploadBoard(BoardDTO dto) throws Exception
    {
        Board board = findById(dto.getId());
        System.out.println(dto.getAuthor());

        if(board!=null)
        {
            return null;
        }

        board = dto.toEntity();
        boardmapper.save(board);
        return board;
    }
    public Board findById(int id) throws Exception
    {
        return boardmapper.findById(id);
    }
    public boolean deleteById(int id) throws Exception
    {
        boardmapper.deleteById(id);
        return true;
    }
}
