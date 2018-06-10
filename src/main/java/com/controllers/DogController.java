package com.controllers;

import com.models.Dog;
import com.services.IDogService;
import com.utils.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api/dog")
public class DogController {

    @Autowired
    private IDogService dogService;

    @Transactional
    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public
    @ResponseBody
    Object create(@RequestBody Dog dog) throws Exception {
        // 可使用PostMan等前端测试工具传入json数据给这个接口进行测试，使用方法自行百度。
        // 示例json：{"name":"root"}
        dog = dogService.create(dog);
        return Answer.Done(dog);
    }

    @Transactional
    @RequestMapping(value = "/find", method = {RequestMethod.POST})
    public
    @ResponseBody
    Object find(@RequestBody Dog dog) throws Exception {
        // 示例json：{"id":1}
        dog = dogService.findById(dog.getId());
        return Answer.Done(dog);
    }

    @Transactional
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public
    @ResponseBody
    Object update(@RequestBody Dog dog) throws Exception {
        // 示例json：{"id":1,"name":"root1"}
        dog = dogService.update(dog);
        return Answer.Done(dog);
    }

    @Transactional
    @RequestMapping(value = "/del", method = {RequestMethod.POST})
    public
    @ResponseBody
    Object del(@RequestBody Dog dog) throws Exception {
        // 示例json：{"id":1}
        dogService.delById(dog.getId());
        return Answer.Done(null);
    }
}
