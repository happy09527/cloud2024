package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author: ZhangX
 * @createDate: 2024/11/25
 * @description:
 */
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
    @Resource
    PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "新增", description = "新增支付")
    public String addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return "成功插入记录，返回值：" + i;
    }

    @DeleteMapping("/pay/del/{id}")
    public Integer deletePay(@PathVariable("id") Integer id) {
        return payService.delete(id);
    }

    @PutMapping("/pay/update")
    public String updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return "成功修改记录，返回值：" + i;
    }

    @GetMapping("/pay/get/{id}")
    public Pay getById(@PathVariable("id") Integer id) {
        return payService.getById(id);
    }

    @GetMapping("/pay/getAll")
    public List<Pay> getAll() {
        return payService.getAll();
    }
}
