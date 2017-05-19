package com.order.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPClientConfig;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

import lombok.Data;

/**
 * @classDesc: 功能描述:()
 * @author: 过宝麒
 * @createTime: 2017年5月17日 下午6:30:34
 * @version: v1.0
 * @copyright:善林(上海)金融信息服务有限公司
 */

@Data
// FTP工具类提供链接和上传功能
public class FTPUtil {

	private static FTPClient ftp;

	private FTPUtil() {

	}

	/**
	 * 链接ftp
	 * 
	 * @param path
	 *            FTP目录
	 * @param hostname
	 *            FTP服务器地址
	 * @param port
	 *            FTP服务器端口号
	 * @param username
	 *            FTP登录帐号
	 * @param password
	 *            FTP登录密码
	 * @return
	 */
	public static boolean connect(String path, String addr, int port, String username, String password)
			throws Exception {
		boolean result = false;
		ftp = new FTPClient();
		int reply;
		ftp.connect(addr, port);
		
		ftp.setControlEncoding("GBK");
        FTPClientConfig conf = new FTPClientConfig(FTPClientConfig.SYST_UNIX);
        conf.setServerLanguageCode("zh");
		
		ftp.login(username, password);
		//ftp.setControlEncoding("UTF-8");
		ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

		reply = ftp.getReplyCode();
		if (!FTPReply.isPositiveCompletion(reply)) {
			ftp.disconnect();
			return result;
		}
		ftp.changeWorkingDirectory(path);
		result = true;
		return result;
	}

	/**
	 * 上传文件
	 * 
	 * @param pathname
	 *            本地服务器文件目录
	 * @param filename
	 *            文件名称
	 * @return t.connect("\\test\\22", "10.5.202.100", 21, "admin", "111111");
	 *         t.upload("c:\\","test");
	 *         因为远程链接的根目录为文件夹22，所以运行结果为上传本地服务器根目录下的test文件夹到远端ftp的文件夹22目录下
	 */
	public static boolean upload(String pathname, String filename) throws Exception {

		boolean result = false;
		File file = new File(pathname + "\\" + filename);
		// System.out.println("upload is starting...");

		if (file.isDirectory()) {
			ftp.makeDirectory(file.getName());
			ftp.changeWorkingDirectory(file.getName());
			String[] files = file.list();

			for (int i = 0; i < files.length; i++) {

				// System.out.println(file.getPath()+"\\"+files[i]);
				File file1 = new File(file.getPath() + "\\" + files[i]);
				if (file1.isDirectory()) {
					upload(file.getPath(), files[i]);
					ftp.changeToParentDirectory();
				} else {

					System.out.println(file.getPath() + "\\" + files[i]);
					File file2 = new File(file.getPath() + "\\" + files[i]);
					FileInputStream input = new FileInputStream(file2);
					ftp.storeFile(file2.getName(), input);
					input.close();
				}
			}

		} else {

			File file2 = new File(file.getPath());
			FileInputStream input = new FileInputStream(file2);
			ftp.storeFile(file2.getName(), input);
			input.close();
		}

		result = true;
		return result;
	}

	/**
	 * 下载单个文件
	 * 
	 * @param pathname
	 *            FTP服务器文件目录
	 * @param filename
	 *            文件名称
	 * @param localpath
	 *            下载后的文件路径
	 * @return
	 */
	public static boolean downloadFile(String pathname, String filename, String localpath) {
		boolean flag = false;
		try {
			// 切换FTP目录
			ftp.changeWorkingDirectory(pathname);
			FTPFile[] ftpFiles = ftp.listFiles();

			for (FTPFile file : ftpFiles) {

				System.out.println(file.getName());
				if (filename.equalsIgnoreCase(file.getName())) {
					System.out.println(localpath + "\\" + file.getName());
					File localFile = new File(localpath + "\\" + file.getName());
					OutputStream os = new FileOutputStream(localFile);
					ftp.retrieveFile(file.getName(), os);
					os.close();
				}
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	/**
	 * 下载整个文件夹
	 * 
	 * @param remoteDirectory
	 *            FTP服务器文件目录
	 * @param localDirectoryPath
	 *            下载后的文件路径 t.connect("", "10.5.202.100", 21, "admin", "111111");
	 *            链接到ftp的根目录，如果根目录变化，那么下载文件的remote目录也要做相应的变化
	 *            t.downLoadDirectory("c:\\gbq\\","\\test\\11");
	 *            运行结果为下载远程ftp的\\test\\11下的所有文件到本地目录c:\\gbq\\下面
	 */
	public static boolean downLoadDirectory(String localDirectoryPath, String remoteDirectory) {
		try {
			String fileName = new File(remoteDirectory).getName();

			System.out.println(fileName);

			localDirectoryPath = localDirectoryPath + fileName + "//";

			System.out.println(localDirectoryPath);
			new File(localDirectoryPath).mkdirs();
			FTPFile[] allFile = ftp.listFiles(remoteDirectory);
			for (int currentFile = 0; currentFile < allFile.length; currentFile++) {
				if (!allFile[currentFile].isDirectory()) {
					downloadFile(remoteDirectory, allFile[currentFile].getName(), localDirectoryPath);
				}
			}
			for (int currentFile = 0; currentFile < allFile.length; currentFile++) {
				if (allFile[currentFile].isDirectory()) {
					String strremoteDirectoryPath = remoteDirectory + "/" + allFile[currentFile].getName();
					downLoadDirectory(localDirectoryPath, strremoteDirectoryPath);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("下载文件夹失败");
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		// 上传功能
		FTPUtil t = new FTPUtil();
		// t.connect("\\test\\22", "10.5.202.100", 21, "admin", "111111");
		// t.upload("c:\\","test");
		t.connect("", "192.168.2.250", 21, "admin", "111111");
		t.downLoadDirectory("c:\\gbq\\", "\\");

	}

}
