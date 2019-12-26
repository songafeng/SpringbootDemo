package com.example.controller;

import com.example.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 前台文章Controller
 * @author 小卖铺的老爷爷
 * @date 2018年5月5日
 * @website www.laoyeye.net
 */
@Api(description="文章查询")
@RestController
@RequestMapping("/article")
public class ArticleController {

    @ApiOperation(value="文章查询接口")
    @ApiImplicitParam(name = "id", value = "文章ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public String index(Model model, @PathVariable("id") Long id) {

        return "frontend/article";
    }

    @ApiOperation(value="获取用户")
    @ApiImplicitParam(name = "userID", value = "用户ID", required = false, dataType = "Int")
    @GetMapping("/getUser/{userID}")
    @ResponseBody
    public User getUser(@PathVariable("userID") int userID) {
        User user=new User();
        user.setId(10);
        user.setUserName("afeng");
        user.setPassWord("111111");
        user.setRealName("宋贵生");
        return user;
    }

//    @ApiOperation(value="文章点赞接口")
//    @ApiImplicitParam(name = "articleId", value = "文章ID", required = true, dataType = "Long")
//    @PostMapping("/approve")
//    @ResponseBody
//    public YYBlogResult approve(@RequestParam Long articleId) {
//        return articleService.updateApproveCntById(articleId);
//    }
}