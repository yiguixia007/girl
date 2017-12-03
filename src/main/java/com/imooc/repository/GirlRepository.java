package com.imooc.repository;

import com.imooc.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Administrator on 2017/10/15 0015.
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    /**
     * 通过攫查询女生列表
     * @param age
     * @return
     */
    public List<Girl> findByAge(Integer age);
}
