package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

/**
 * @author: ZhangX
 * @createDate: 2024/11/25
 * @description:
 */
@RestController
@Tag(name = "支付微服务模块", description = "支付CRUD")
public class PayController {
    @Resource
    PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary = "新增", description = "新增支付")
    public ResultData addPay(@RequestBody Pay pay) {
        System.out.println(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值：" + i);
    }

    @DeleteMapping("/pay/del/{id}")
    public ResultData deletePay(@PathVariable("id") Integer id) {
        return ResultData.success(payService.delete(id));
    }

    @PutMapping("/pay/update")
    public ResultData updatePay(@RequestBody PayDTO payDTO) {
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO, pay);

        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值：" + i);
    }

    @GetMapping("/pay/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id) {
        try {
            TimeUnit.SECONDS.sleep(62);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return ResultData.success(payService.getById(id));
    }

    @GetMapping("/pay/getAll")
    public ResultData getAll() {
        return ResultData.success(payService.getAll());
    }


    @RequestMapping(value = "/pay/error", method = RequestMethod.GET)
    public ResultData<Integer> getPayError() {
        Integer i = Integer.valueOf(200);
        try {
            System.out.println("--------come here");
            int data = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResultData.success(i);
    }

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/pay/get/info", method = RequestMethod.GET)
    public ResultData get(@Value("${atguigu.info}") String info) {
        return ResultData.success("info:" + info + port);
    }

    //=========Resilience4j CircuitBreaker 的例子
    @GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id) {
        if (id == -4) throw new RuntimeException("----circuit id 不能负数");
        if (id == 9999) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Hello, circuit! inputId:  " + id + " \t " + IdUtil.simpleUUID();
    }
}
