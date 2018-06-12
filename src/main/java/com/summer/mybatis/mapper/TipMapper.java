package com.summer.mybatis.mapper;

import com.summer.mybatis.entity.Tip;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

public interface TipMapper {
    @Delete({
        "delete from tip",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into tip (recordid, tipid, ",
        "ctime)",
        "values (#{recordid,jdbcType=INTEGER}, #{tipid,jdbcType=INTEGER}, ",
        "#{ctime,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Tip record);

    @Select({
        "select",
        "id, recordid, tipid, ctime",
        "from tip",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="recordid", property="recordid", jdbcType=JdbcType.INTEGER),
        @Result(column="tipid", property="tipid", jdbcType=JdbcType.INTEGER),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP)
    })
    Tip selectByPrimaryKey(Integer id);

    @Select({
        "select",
        "id, recordid, tipid, ctime",
        "from tip"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="recordid", property="recordid", jdbcType=JdbcType.INTEGER),
        @Result(column="tipid", property="tipid", jdbcType=JdbcType.INTEGER),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Tip> selectAll();

    @Update({
        "update tip",
        "set recordid = #{recordid,jdbcType=INTEGER},",
          "tipid = #{tipid,jdbcType=INTEGER},",
          "ctime = #{ctime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Tip record);
}