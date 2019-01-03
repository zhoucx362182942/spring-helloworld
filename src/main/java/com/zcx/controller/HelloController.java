package com.zcx.controller;

import com.alibaba.fastjson.JSON;
import com.zcx.controller.response.RestResponse;
import com.zcx.domain.User;
import com.zcx.request.UserRequest;
import com.zcx.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

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

    /**
     * MD5签名、验签测试方法
     * @param
     * @return
     */
    @RequestMapping(value = "/md5VerifyTest", method = RequestMethod.POST)
    @ResponseBody
    public String md5VerifyTest(HttpServletRequest request) {

        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String sex = request.getParameter("sex");
        String sign_ = request.getParameter("sign_");

        Map<String, String> map = new HashMap<String, String>();
        map.put("name", name);
        map.put("age", age);
        map.put("sex", sex);
        try {
            String thisSgn = MD5Util.sign(map, "8EAF2806D7AC4FB2BBE0988E3E31FE35");
            if (StringUtils.equals(thisSgn, sign_)) {
                System.out.println("验签成功");
            } else {
                System.out.println("验签失败");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    @RequestMapping(value = "/fastJsonTest", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String fastJsonTest(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            for (FieldError fieldError : result.getFieldErrors()) {
                System.out.println(fieldError.getDefaultMessage());
            }
        }

        System.out.println(user.toString());
        return user.toString();
    }
}
