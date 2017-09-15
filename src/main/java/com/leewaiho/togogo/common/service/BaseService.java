package com.leewaiho.togogo.common.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

/**
 * @Author leewaiho
 * @Email 791783391@qq.com
 * @Date 2017/9/15
 */
public interface BaseService<T, ID extends Serializable> {
    
    Page<T> findAll(Pageable pageable);
    
    List<T> findAll();
}
