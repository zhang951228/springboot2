package com.erayt.producer.service;

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
}
