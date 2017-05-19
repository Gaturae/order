package com.order.util;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * SpringBoot集成MyBatis入口 1) 创建数据源 2) 创建SqlSessionFactory
 */
@Configuration
@MapperScan(basePackages = "com.order.mapper")
public class MyBatisConfig {

	@Autowired
	private Environment environment;

	/**
	 * 
	 * 创建数据源
	 */
	@Bean
	public DataSource getDataSource() throws Exception {

		Properties properties = new Properties();
		properties.put("driverClassName", environment.getProperty("cg.properties.driverClass"));
		properties.put("url", environment.getProperty("cg.properties.url"));
		properties.put("username", environment.getProperty("cg.properties.username"));
		properties.put("password", environment.getProperty("cg.properties.password"));
		return DruidDataSourceFactory.createDataSource(properties);
	}

	/**
	 * 根据数据源创建SqlSessionFactory
	 */
	@Bean
	public SqlSessionFactory getSqlSessionFactory(DataSource dataSource) throws Exception {

		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource);
		// 下边两句仅仅用于*.xml文件，如果整个持久层操作不需要使用到xml文件的话（只用注解就可以搞定），则不加
		sqlSessionFactoryBean.setTypeAliasesPackage(environment.getProperty("mybatis.typeAliasesPackage"));// 指定基包
		sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver()
				.getResources(environment.getProperty("mybatis.mapperLocations")));// 指定xml文件位置

		return sqlSessionFactoryBean.getObject();
	}
}