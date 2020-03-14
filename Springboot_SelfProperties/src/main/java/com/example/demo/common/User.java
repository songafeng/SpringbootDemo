package com.example.demo.common;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/7/11 0011.
 * 用户···实体
 *
 * @ConfigurationProperties 表示 告诉SpringBoot将本类中的所有属性和配置文件中相关的配置进行绑定；
 * @ConfigurationProperties (prefix = "user") 默认从全局配置文件中获取值然后进行注入
 * prefix = "user" 表示 将配置文件中key为user的下面所有的属性与本类属性进行一一映射注入值，如果配置文件中
 * 不存在"user"的key，则不会为POJO注入值，属性值仍然为默认值
 * <p/>
 * @Component 将本来标识为一个Spring 组件，因为只有是容器中的组件，容器才会为@ConfigurationProperties提供此注入功能
 * @PropertySource (value = {"classpath:user.properties"}) 指明加载类路径下的哪个配置文件来注入值
 */
@PropertySource(value = {"classpath:user.properties"})
@Component
@ConfigurationProperties(prefix = "user")
public class User {
    private Integer id;
    private String lastName;
    private Integer age;
    private Date birthday;
    private List<String> colorList;
    private Map<String, String> cityMap;
    private Dog dog;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map<String, String> getCityMap() {
        return cityMap;
    }

    public void setCityMap(Map<String, String> cityMap) {
        this.cityMap = cityMap;
    }

    public List<String> getColorList() {
        return colorList;
    }

    public void setColorList(List<String> colorList) {
        this.colorList = colorList;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String name) {
        this.lastName = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", id=" + id +
                ", lastName='" + lastName + '\'' +
                ", birthday=" + birthday +
                ", colorList=" + colorList +
                ", cityMap=" + cityMap +
                ", dog=" + dog +
                '}';
    }
}