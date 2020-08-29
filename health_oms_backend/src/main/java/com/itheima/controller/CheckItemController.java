package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConst;
import com.itheima.entity.PageResult;
import com.itheima.entity.QueryPageBean;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckItem;
import com.itheima.service.CheckItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@RestController
@RequestMapping("/checkitem")
@Slf4j
public class CheckItemController {

    @Reference
    CheckItemService checkItemService;

    @RequestMapping("/add")
    public Result add(@RequestBody CheckItem checkItem){
        log.debug("add: {" +checkItem +"}");
        checkItemService.add(checkItem);
        log.debug(MessageConst.ADD_CHECKITEM_SUCCESS);
        return new Result(true,MessageConst.ADD_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findPage")
    public Result findPage(@RequestBody QueryPageBean queryPageBean){
        log.debug("findPage: " + queryPageBean);
        PageResult pageResult = checkItemService.findPage(queryPageBean);
        log.debug("PageResult:"+pageResult);
        return new Result(true,MessageConst.QUERY_CHECKITEM_SUCCESS, pageResult);
    }

    @RequestMapping("/delById")
    public Result delById(Integer id){
        log.debug("delById: {" + id +"}");
        checkItemService.delById(id);
        log.debug(MessageConst.DELETE_CHECKITEM_SUCCESS);
        return new Result(true,MessageConst.DELETE_CHECKITEM_SUCCESS);
    }

    @RequestMapping("/findById")
    public Result findById(Integer id){
        log.debug("findById: {" + id +"}");
        CheckItem checkItem = checkItemService.findById(id);
        log.debug("findById： " +  checkItem);
        return new Result(true, MessageConst.QUERY_CHECKITEM_SUCCESS, checkItem);
    }

    @RequestMapping("/edit")
    public Result edit(@RequestBody CheckItem checkItem){
        log.debug("edit:" + checkItem);
        checkItemService.edit(checkItem);
        log.debug(MessageConst.EDIT_CHECKITEM_SUCCESS);
        return new Result(true,MessageConst.EDIT_CHECKITEM_SUCCESS);
    }
}
