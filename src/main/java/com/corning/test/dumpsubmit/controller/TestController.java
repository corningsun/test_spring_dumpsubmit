package com.corning.test.dumpsubmit.controller;

import com.corning.test.dumpsubmit.core.DuplicateSubmitToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RequestMapping("/test")
@RestController
public class TestController {

    @DuplicateSubmitToken
    @GetMapping(value = "/requestUrl")
    public Map<String, Object> requestUrl(HttpServletRequest request) throws InterruptedException {

        Thread.sleep(5000);

        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }

    @DuplicateSubmitToken
    @GetMapping(value = "/requestUrl2")
    public Map<String, Object> requestUrl2(HttpServletRequest request) throws Exception {

        Random r = new Random();
        int i = r.nextInt(3);
        if (i == 2) {
            throw new Exception("有异常");
        }

        Thread.sleep(5000);

        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("request Url", request.getRequestURL());
        map.put("request Url", request.getRequestURL());
        return map;
    }
}
