package com.test.mapper;

import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from db_user where uid = #{uid}")
    public User getUserById(Integer uid);
}
