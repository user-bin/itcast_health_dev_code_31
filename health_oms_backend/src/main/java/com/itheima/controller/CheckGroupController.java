package com.itheima.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.constant.MessageConst;
import com.itheima.entity.Result;
import com.itheima.pojo.CheckGroup;
import com.itheima.service.CheckGroupService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.misc.resources.Messages_es;

import java.util.Arrays;

/**
 * @author 黑马程序员
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@RestController
@RequestMapping("/checkgroup")
@Slf4j
public class CheckGroupController {

    @Reference
    CheckGroupService checkGroupService;

    @RequestMapping("/add")
    public Result add(@RequestBody CheckGroup checkGroup, Integer[] checkItemIds){
        log.debug("CheckGroup:" + checkGroup);
        log.debug("checkItemIds:" + Arrays.toString(checkItemIds));
        checkGroupService.add(checkGroup, checkItemIds);
        log.debug(MessageConst.ADD_CHECKGROUP_SUCCESS);
        return new Result(true,MessageConst.ADD_CHECKGROUP_SUCCESS);
    }

//    @RequestMapping("/add")
//    public Result add(@RequestBody Map<String,Object> map){
//        log.debug(map.toString());
//        //获取检查项的id集合，转换 jsonArray
//        JSONArray jsonArray = (JSONArray) map.get("checkItemIds");
//        //把json数组转换为 数组对象
//        Integer[] checkItemIds = jsonArray.toArray(new Integer[]{});
//
//        log.debug("checkItemIds:" + Arrays.toString(checkItemIds));
//
//        //获取检查组数据， 转换为jsonObject对象
//        JSONObject jsonObject = (JSONObject) map.get("checkGroup");
//        //把 json对象转换为 pojo
//        CheckGroup checkGroup = jsonObject.toJavaObject(CheckGroup.class);
//        log.debug("checkGroup:" +checkGroup);
//        return null;
//    }
}
