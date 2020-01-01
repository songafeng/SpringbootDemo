package example.controller;

import com.alibaba.fastjson.JSONObject;
import example.pojo.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jdd on 2019/12/5.
 */
@RestController
public class UserController {
    private Person person;

    @RequestMapping("hello")
    public String Hello(){
        person = new Person();
        person.setName("gyl");
        person.setAge("20");

        String jsonStr = JSONObject.toJSONString(person);
        System.out.println("bean to json:" + jsonStr);
        person = JSONObject.toJavaObject(JSONObject.parseObject(jsonStr), Person.class);
        System.out.println("json to bean:" + person.getName());

        return "ok";
    }

}
