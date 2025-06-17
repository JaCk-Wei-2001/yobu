package com.example.yobu.dao;

import com.example.yobu.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

    // 新增
    @Modifying
    @Transactional
    @Query(value = "insert into user (email, password, name) "
            + " values(:email, :password, :name)", nativeQuery = true)
    public void insert(//
                       @Param("email") String email, //
                       @Param("password") String password, //
                       @Param("name") String name); //

    // 查找
    @Query(value = "select * from user where email = ?1",
            nativeQuery = true)
    public User getQuizByEmail(String email);
}
