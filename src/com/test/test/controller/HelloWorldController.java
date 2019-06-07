package com.test.test.controller;


//import com.test.test.entity.FormEntity;
import com.test.test.entity.FormEntity;
import com.test.test.entity.GoodEntity;
import com.test.test.entity.ResultCause;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class HelloWorldController {
    @RequestMapping(value = "/hello" ,method = {RequestMethod.GET, RequestMethod.POST})
    public String sayHello() {
        return "index";
    }

    @RequestMapping(value = "/getGoodList",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody List<GoodEntity> getGoodList(){
        List<GoodEntity> goodEntities = new ArrayList<>();
        goodEntities.add(new GoodEntity(1,"iphone",5000));
        goodEntities.add(new GoodEntity(2,"ipad",4000));
        goodEntities.add(new GoodEntity(3,"macpro",120000));
        return goodEntities;
    }

    @RequestMapping(value = "/checkToken", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause checkToken(String token){
        if (token.equals("1")){
            return new ResultCause(ResultCause.SUCCESS_CODE,"验证成功");
        }else {
            return new ResultCause(ResultCause.FAIL_CODE,"验证失败");
        }
    }

    @RequestMapping(value = "/form",method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody ResultCause testForm(FormEntity form){
        System.out.println(form.getName()+"'s is : " + form.getName());
        return new ResultCause("200",form.getName()+"'s is : " + form.getSignature());
    }

    @RequestMapping(value = "ajax_test", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    ResultCause testAjax(FormEntity form){
        System.out.println(form.getName()+"'s is : "+form.getSignature());
        return new ResultCause("200",form.getName()+"'s is : "+form.getSignature());
    }

    @RequestMapping(value = "get_list", method = {RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    List<ResultCause> getList(){
        List<ResultCause> resultCauses = new ArrayList<>();
        resultCauses.add(new ResultCause("200","ToMax"));
        resultCauses.add(new ResultCause("300","Java"));
        resultCauses.add(new ResultCause("400","Hello World"));
        return resultCauses;
    }
}
