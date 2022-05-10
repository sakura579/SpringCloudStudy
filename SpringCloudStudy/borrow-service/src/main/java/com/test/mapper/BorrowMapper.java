package com.test.mapper;

import com.test.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BorrowMapper {

    @Select("select * from db_borrow where uid = #{uid}")
    List<Borrow> selectByUserId(Integer uid);

    @Select("select * from db_borrow where bid = #{bid}")
    List<Borrow> selectByBookId(Integer bid);

    @Select("select * from db_borrow where uid = #{uid} and bid = #{bid}")
    Borrow selectOne(Integer uid, Integer bid);
}
