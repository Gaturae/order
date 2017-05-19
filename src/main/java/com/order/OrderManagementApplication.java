package com.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 
 * @classDesc: 功能描述:(Spring boot Main 启动类)
 * @author: 王浩
 * @createTime: 2017年5月11日 上午9:11:52
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */
@SpringBootApplication
@ComponentScan("com.order")
@MapperScan("com.order.mapper")
public class OrderManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderManagementApplication.class, args);
	}

}
