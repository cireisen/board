package com.work.board.user.service;

import com.work.board.user.domain.User;
import com.work.board.user.dto.RegisterDTO;
import com.work.board.user.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserService {

    @Autowired  // 그럼 여기서 스프링이 알아서 맵퍼 보고 자동으로 매칭시켜줌.
    UserMapper mapper;

    public List<User> findAll() throws Exception {
        return mapper.findAll();
        /* 그리고 맵퍼 메소드 이름은 보통 이렇게 지음
           findAll
           findBy**
           save
           delete
           deleteBy**

           필요하면 수정은 modify
        */

    }
    public User createUser(RegisterDTO dto) throws Exception
    {
        User user = findById(dto.getId());
        if(user != null)
        {
            return null;
        }
        User create = dto.toEntity();
        mapper.save(create);
        return create;
    }
    public User findById(String id) throws Exception
    {
        return mapper.findById(id);
    }
}
