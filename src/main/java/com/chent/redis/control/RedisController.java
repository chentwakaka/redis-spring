package com.chent.redis.control;

import com.chent.redis.model.SubjectInfo;
import com.chent.redis.service.SubjectInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.PathVariable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chentong on 2016/9/6.
 */
@Controller
@RequestMapping("/")
public class RedisController {

    @Autowired
    private SubjectInfoService subjectInfoService;

    @RequestMapping(method = RequestMethod.GET,value = "/hello")
    public String test(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception{
        modelMap.addAttribute("hello","welcome redis QwQ hello");
        return "hello";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/save")
    public String save(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception{
        boolean result = subjectInfoService.save(new SubjectInfo(3,"english"));
        modelMap.addAttribute("result",result);
        return "save";
    }

    @RequestMapping(method = RequestMethod.GET,value = "/get/{subjectId}")
    public String get(@PathVariable Integer subjectId,ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) throws Exception{
        SubjectInfo subjectInfo = subjectInfoService.get(subjectId);
        modelMap.addAttribute("subjectInfo",subjectInfo);
        return "get";
    }
}
