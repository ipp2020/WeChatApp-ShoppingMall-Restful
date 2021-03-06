package com.leewaiho.togogo.module.oss.controller;

import com.leewaiho.togogo.common.pojo.Result;
import com.leewaiho.togogo.module.oss.pojo.CallbackBody;
import com.leewaiho.togogo.module.oss.service.OssService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Author leewaiho
 * Email 791783391@qq.com
 * Date 2017/10/4
 * Project togogo-shixun
 */
@RestController
@RequestMapping("/api/oss")
public class OssController {
    
    private static final Logger log = LoggerFactory.getLogger(OssController.class);
    @Autowired
    private OssService ossService;
    
    
    @RequestMapping(value = "/imageToken", method = RequestMethod.GET)
    public Result createToken(@RequestParam(value = "isCreate", required = false, defaultValue = "false") String isCreate) {
        if (isCreate.equalsIgnoreCase("true")){
            isCreate = "true";
        } else {
            isCreate = "false";
        }
        Map result = new HashMap<>();
        result.put("token", ossService.getToken(isCreate));
//        result.put("resourceUrl", resourceUrl);
        return Result.success(result);
    }
    
    @RequestMapping(value = "/upload/callback", method = RequestMethod.POST)
    public Result callback(@RequestBody CallbackBody callbackBody, @RequestParam(value = "isCreate", required = false, defaultValue = "false") String isCreate) {
        return Result.success(ossService.callback(callbackBody, isCreate));
    }
}
