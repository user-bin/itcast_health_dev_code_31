package com.itheima.dao;

import com.github.pagehelper.Page;
import com.itheima.pojo.CheckGroup; /**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    void setRelation(Integer checkGroupId, Integer checkItemId);

    Page<CheckGroup> findByCondition(String queryString);

    long findCountById(Integer id);

    void delRelation(Integer id);

    void delById(Integer id);
}
