package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/22 0022.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Girl girlA = new Girl();
        girlA.setAge(19);
        girlA.setCupSize("A");
        girlRepository.save(girlA);

        Girl girlB = new Girl();
        girlB.setAge(19);
        girlB.setCupSize("BBBB");
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl =  girlRepository.findOne(id);
        Integer age = girl.getAge();
        if(age<10){
            //返回“你还在上小学吧”
            throw  new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if(age >= 10 && age < 16){
            //返回“你可能在上初中”
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    /**
     * 能过ID查询一个女生的信息
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.findOne(id);
    }
}
