package com.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.order.controller.DemoController;
import com.order.mapper.DemoMapper;
import com.order.service.FTPService;
import com.order.util.FTPUtil;

import lombok.extern.slf4j.Slf4j;

/**  
* @classDesc: FTP上传下载功能(FTPService 服务类)
* @author: 过宝麒  
* @createTime: 2017年5月19日 下午2:27:22  
* @version: v1.0  
* @copyright:善林(上海)金融信息服务有限公司 
*/

@Slf4j
@Service
public class FTPServiceImpl implements FTPService {


	@Autowired
	private Environment env;
	
	/*  
	*(non-Javadoc)  
	* @see com.order.service.FTPService#upload(java.lang.String, java.lang.String)  
	*/  
	@Override
	public boolean upload(String pathname, String filename) {
		try {
			
			log.info(env.getProperty("ftp.path")+env.getProperty("ftp.addr")+env.getProperty("ftp.username")+env.getProperty("ftp.password"));
			FTPUtil.connect(env.getProperty("ftp.path"), env.getProperty("ftp.addr"), 21, env.getProperty("ftp.username"), env.getProperty("ftp.password"));
		} catch (Exception e) {
			log.error("ftp connect failed!!");
			System.out.println(e);
			return false;  		    
		}
		
		try {
			FTPUtil.upload(pathname, filename);
		} catch (Exception e) {
			log.error("ftp upload failed!!");
		} 
		return true;   
	}

	/*  
	*(non-Javadoc)  
	* @see com.order.service.FTPService#downLoadDirectory(java.lang.String, java.lang.String)  
	*/  
	@Override
	public boolean downLoadDirectory(String localDirectoryPath, String remoteDirectory) {
		try {
			
			log.info(env.getProperty("ftp.path")+env.getProperty("ftp.addr")+env.getProperty("ftp.username")+env.getProperty("ftp.password"));
			FTPUtil.connect(env.getProperty("ftp.path"), env.getProperty("ftp.addr"), 21, env.getProperty("ftp.username"), env.getProperty("ftp.password"));
		} catch (Exception e) {
			log.error("ftp connect failed!!");
			return false;  		    
		}
		
		try {
			FTPUtil.downLoadDirectory(localDirectoryPath, remoteDirectory);
		} catch (Exception e) {
			log.error("ftp download failed!!");
		} 
		return true; 
	}

}
