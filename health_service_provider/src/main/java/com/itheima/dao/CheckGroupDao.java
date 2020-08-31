package com.itheima.dao;

import com.itheima.pojo.CheckGroup; /**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface CheckGroupDao {
    void add(CheckGroup checkGroup);

    void setRelation(Integer checkGroupId, Integer checkItemId);
}
