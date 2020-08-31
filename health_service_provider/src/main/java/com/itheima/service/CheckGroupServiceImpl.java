package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckGroupDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.pojo.CheckGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
@Transactional
public class CheckGroupServiceImpl implements CheckGroupService {

    @Autowired
    CheckGroupDao checkGroupDao;

    /***
     * 1. 新增检查组数据到 数据库(主键回显)
     * 2. 维护检查组和检查项的关闭， 添加数据到中间表
     *
     * @param checkGroup
     * @param checkItemIds
     */
    @Override
    public void add(CheckGroup checkGroup, Integer[] checkItemIds) {
        //主键回显 selectKey
        checkGroupDao.add(checkGroup);
        //维护关系
        if(checkGroup.getId() != null){
            setRelation(checkGroup.getId(), checkItemIds);
        }
    }

    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //开始分页
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        //条件查询
        Page<CheckGroup> page = checkGroupDao.findByCondition(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page);
    }

    /**
     * 维护检查组和检查项的关系
     */
    public void setRelation(Integer checkGroupId, Integer[] checkItemIds){
        if(checkItemIds != null && checkItemIds.length > 0){
            for (Integer checkItemId : checkItemIds) {
                checkGroupDao.setRelation(checkGroupId, checkItemId);
            }
        }
    }
}
