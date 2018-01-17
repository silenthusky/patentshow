package com.patentshow.controller;

import com.alibaba.fastjson.JSON;
import com.patentshow.common.error.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by unclexiao on 2017/12/4.
 */
@RestController
@ControllerAdvice
@RequestMapping(produces = "application/json;charset=UTF-8")
public class AppExceptionHandler {

    @ExceptionHandler(RatioNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String ratioNotFound() {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("status", "404");
        res.put("msg", "ratio not found");
        return JSON.toJSONString(res);
    }


    @ExceptionHandler(GoodsNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String goodsNotFound(GoodsNotFoundException e) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("status", "404");
        res.put("msg", "top " + e.getCount() + " goods not found");
        return JSON.toJSONString(res);
    }

    @ExceptionHandler(InputNumberNotValid.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String inputNumberNotValid(InputNumberNotValid e) {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("status", 400);
        res.put("msg", "input number " + e.getCount() + " in path is not valid");
        return JSON.toJSONString(res);
    }


    @ExceptionHandler(ZeroCannotBeDivided.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String zeroCannotBeDivided() {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("status", "500");
        res.put("msg", "0 cannot be divided");
        return JSON.toJSONString(res);
    }


    @ExceptionHandler(ShouldBeEqualException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map shouldBeEqualException() {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("result", "");
        res.put("code", "500");
        res.put("message", " two value should have be equal");
        return res;
    }

    @ExceptionHandler(ShouldNotBeLessException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map shouldNotBeLessException() {
        Map<String, Object> res = new HashMap<String, Object>();
        res.put("result", "");
        res.put("code", "500");
        res.put("message", " one value should not have be less than another");
        return res;
    }
}
