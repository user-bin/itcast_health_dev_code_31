package com.itheima.service;

import com.itheima.pojo.CheckGroup; /**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
public interface CheckGroupService {

    void add(CheckGroup checkGroup, Integer[] checkItemIds);
}
