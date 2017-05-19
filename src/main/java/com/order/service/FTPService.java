package com.order.service;

/**  
* @classDesc: FTP上传下载功能
* @author: 过宝麒  
* @createTime: 2017年5月19日 下午2:22:07  
* @version: v1.0  
* @copyright:善林(上海)金融信息服务有限公司 
*/

public interface FTPService {
	
	/**
	   * 上传文件
	   * @param pathname  本地服务器文件目录
	   * @param filename  文件名称
	   */
	public boolean upload(String pathname, String filename);
	
	
	/**
	   * 下载文件
	   * @param remoteDirectory  FTP服务器文件目录
	   * @param localDirectoryPath 下载后的文件路径
	   */
	public boolean downLoadDirectory(String localDirectoryPath,String remoteDirectory);
	

}
