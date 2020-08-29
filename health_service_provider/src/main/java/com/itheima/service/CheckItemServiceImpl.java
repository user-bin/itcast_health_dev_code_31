package com.itheima.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.dao.CheckItemDao;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.exception.BusinessRuntimeException;
import com.itheima.pojo.CheckItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Service
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    CheckItemDao checkItemDao;

    @Override
    public void add(CheckItem checkItem) {
        checkItemDao.add(checkItem);
    }

    /**
     * 分页查询
     * @param queryPageBean
     * @return
     */
    @Override
    public PageResult findPage(QueryPageBean queryPageBean) {
        //开始分页
        PageHelper.startPage(queryPageBean.getCurrentPage(), queryPageBean.getPageSize());
        //条件查询
        Page<CheckItem> page =  checkItemDao.findByCondition(queryPageBean.getQueryString());
        return new PageResult(page.getTotal(), page);
    }

    /**
     *
     * 判断该检查项是否被检查组关联， 如果被关联，提示不能删除 ，没有被关联，直接删除检查项
     * @param id
     */
    @Override
    public void delById(Integer id) {
        long count = checkItemDao.findCountById(id);
        if(count > 0){
            throw new BusinessRuntimeException("检查项被检查组关联，不能删除!!");
        }
        checkItemDao.delById(id);
    }

    @Override
    public CheckItem findById(Integer id) {
        return checkItemDao.findById(id);
    }

    @Override
    public void edit(CheckItem checkItem) {
        checkItemDao.edit(checkItem);
    }
}
