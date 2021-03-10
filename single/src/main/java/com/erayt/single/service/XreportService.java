package com.erayt.single.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;

/**
 * @Auther: Z151
 * @Date: 2021/3/9 14:55
 */
@Slf4j
@Service
public class XreportService {

	/**
	 * 解析人行反馈文件。
	 * @param dateStr
	 * @return
	 * @throws IOException
	 */
	public StringBuilder fileFilter(String dateStr) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		String filePath = "C:\\Users\\admin\\Desktop\\xre02\\"+dateStr;
		File file = new File(filePath);
		for (File listFile : file.listFiles()) {
			for (File file1 : listFile.listFiles()) {
				//log.info(file1.getName()+"    "+file1.getAbsolutePath());
				if("FVR1.dat".equals(file1.getName())){
					BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
					String tempStr;

					while ((tempStr = bufferedReader.readLine()) != null) {
						if(tempStr.contains("831.zip")){
							stringBuilder.append("\n__________________________________");
							stringBuilder.append("\n__________________________________");
							stringBuilder.append("\n__________________________________");
							stringBuilder.append("\n__________________________________");
							stringBuilder.append(listFile.getName()).append("\n ：");
							log.info(listFile.getName() + " __ " + tempStr);
							stringBuilder.append("__" + tempStr).append("\n");
						}
						if(true) {
							stringBuilder.append(listFile.getName()).append("\n ：");
							log.info(listFile.getName() + " __ " + tempStr);
							stringBuilder.append("__" + tempStr).append("\n");
						}
					}
					bufferedReader.close();
				}
			}
		}
		return stringBuilder;
	}

	/**
	 * 解析xreport日志。
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public StringBuilder fileLogs(String fileName) throws IOException {
		StringBuilder stringBuilder = new StringBuilder();
		File file = new File(fileName);
		BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
		String tempStr;
		while ((tempStr = bufferedReader.readLine()) != null) {
			//if(tempStr.contains("将PBI文件备份到指定目录失败，具体请查看日志！"))
			if(tempStr.contains("将PBI文件备份到指定目录成功！"))
			stringBuilder.append(tempStr).append(System.getProperty("line.separator"));
		}
		return stringBuilder;
	}
}
