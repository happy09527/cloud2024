package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * @author: ZhangX
 * @createDate: 2024/11/25
 * @description:
 */
public interface PayService {
    public int add(Pay pay);

    public int delete(Integer id);

    public int update(Pay pay);

    public Pay getById(Integer id);

    public List<Pay> getAll();
}
