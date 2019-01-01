package com.zcx.controller;

import com.alibaba.fastjson.JSON;
import com.zcx.controller.response.RestResponse;
import com.zcx.request.UserRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * httpClient测试方法
     * @param user
     * @return
     */
    @RequestMapping(value = "/postTest", method = RequestMethod.POST)
    @ResponseBody
    public String postTest(UserRequest user) {
        RestResponse restResponse = new RestResponse();
        restResponse.setSuccess(true);
        System.out.println(user.getName());
        System.out.println(user.getAge());
        System.out.println(user.getSex());
        String result = JSON.toJSONString(restResponse);
        return result;
    }
}
