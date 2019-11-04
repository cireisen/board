package com.work.board;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

@SpringBootApplication
@MapperScan(basePackages={"com.work.board.user.repository"})
@MapperScan(basePackages={"com.work.board.board.repository"})
public class BoardApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoardApplication.class, args);
    }

    // SqlSessionFactory Bean 의 기본 이름인 sqlSessionFactory(Bean 어노테이션에 아무 이름을 안지정하면 기본적으로 메서드이름)
    // 을 지정해줌.ㅇㅎㅎㅇㅎ
    @Bean
    public SqlSessionFactory sqlSessionFactory( DataSource dataSource) throws Exception
    {
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);

        // 여기 보면, locationPattern이 "classpath:mappers/*UserMapper.xml"이자너
        // 이 * 이 의미하는게 뭔지 알어?ㄴㄴ
        // 궁금해해! 이거 *이라는게 와일드 카드라고 '모든'을 의미하는거임
        // 아래는 classpath:mappers/(여기에는 아무거나 들어가도됨)UserMapper.xml 을 의미해
        // 그래서 AsdfUserMapper.xml, UserMapper.xml, TestUserMapper.xml 모두 여기에 포함된단거지ㅇㅎ
        // 근데 여기서는 *UserMapper.xml 만 가져오니깐 BoardMapper.xml 은 안가져오고, UserMapper.xml 은 가져오겠지?
        // 네
        // sqlSessionFactory는 sqlSession을 만들어주는 용도의 객체인데, 이건 팩토리 디자인 패턴을 따른거야 이건 나중에 찾아보고
        // 이 sqlSession 이 하는 역할은 jdbc를 이용해 db에 접근하도록 도와줘, 그냥 db 접근가능하게 만드는 아이야
        // 이거랑 너가 만드는 UserMapper, BoardMapper 클래스가 협력해서 간단히 사용할 수 있게 만드는데, 아래의 맵퍼등록하는거에
        // 모든 맵퍼가 안들어갔으니 이건 하나의 맵퍼에게 적용되지 않음.dgㅇㅎ
        // 그래서 *Mapper.xml로 바꾸고
        Resource[] res = new PathMatchingResourcePatternResolver().getResources("classpath:mappers/*Mapper.xml");
        sessionFactory.setMapperLocations(res);

        return sessionFactory.getObject();
    }
    // 그리고 얘는 제거
}
