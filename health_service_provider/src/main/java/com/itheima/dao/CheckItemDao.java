package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckItem;
import org.apache.ibatis.annotations.Param;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface CheckItemDao {
    void add(CheckItem checkItem);

    Page<CheckItem> findByCondition(@Param("queryString") String queryString);

    long findCountById(Integer id);

    void delById(Integer id);
}
