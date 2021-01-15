package com.imooc.controller;

import com.imooc.domain.Girl;
import com.imooc.repository.GirlRepository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Administrator on 2017/10/15 0015.
 */
@RestController
public class GirlController {
    private final static Logger loger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        System.out.println("提交第二个commit");
        loger.info("girlList");
        return girlRepository.findAll();
    }

    /**
     * 添加一个女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls")
    public Object addGirl(@Valid Girl girl, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        return  ResultUtil.success(girlRepository.save(girl));
    }

    /**
     * 根据id查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl getGirl(@PathVariable("id")Integer id){
        return girlRepository.findOne(id);
    }

    @PutMapping(value = "/girls/{id}")
    public Girl updateGirl(@PathVariable("id")Integer id,
                           @RequestParam("cupSize")String cupSize,
                           @RequestParam("age")Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        return girlRepository.save(girl);
    }

    @DeleteMapping(value = "/girls/{id}")
    public void deleteGirl(@PathVariable("id")Integer id){
        girlRepository.delete(id);
    }

    //通过年龄来查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age")Integer age){
        return girlRepository.findByAge(age);
    }

    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }

    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        girlService.getAge(id);
    }
}
