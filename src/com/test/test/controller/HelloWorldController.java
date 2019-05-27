package com.test.test.controller;


//import com.test.test.entity.FormEntity;
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
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String sayHello() {
        return "index";
    }

    @RequestMapping(value = "/getGoodList",method = RequestMethod.GET)
    public @ResponseBody List<GoodEntity> getGoodList(){
        List<GoodEntity> goodEntities = new ArrayList<>();
        goodEntities.add(new GoodEntity(1,"iphone",5000));
        goodEntities.add(new GoodEntity(2,"ipad",4000));
        goodEntities.add(new GoodEntity(3,"macpro",120000));
        return goodEntities;
    }

    @RequestMapping(value = "/checkToken", method = RequestMethod.GET)
    public @ResponseBody
    ResultCause checkToken(String token){
        // 这里的1因为是只会用在这一个地方，所以没有专门设置一个状态来描述
        if (token.equals("1")){
            return new ResultCause(ResultCause.SUCCESS_CODE,"验证成功");
        }else {
            return new ResultCause(ResultCause.FAIL_CODE,"验证失败");
        }
    }

    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public @ResponseBody
    ResultCause testForm(String name, String signature){
        System.out.println(name+"'s is : "+signature);
        return new ResultCause("200",name+"'s is : "+signature);
    }
}
