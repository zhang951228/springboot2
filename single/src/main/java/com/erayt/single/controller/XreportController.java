package com.erayt.single.controller;

import com.erayt.single.service.XreportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @Auther: Z151
 * @Date: 2021/3/9 14:55
 */
@RequestMapping(value = "xre")
@Slf4j
@RestController
public class XreportController {

	@Autowired
	XreportService xreportService;

	/**
	 * 解析人行反馈日志。
	 * @param dateStr
	 * @return
	 */
	@RequestMapping("file/{dateStr}")
	public String fileFilter(@PathVariable("dateStr") String dateStr){

		log.info("调用service开始" + dateStr);
		StringBuilder stringBuilder = new StringBuilder("");
		try {
			stringBuilder = xreportService.fileFilter(dateStr);
		} catch (IOException e) {
			log.error("错误",e);
		}
		log.info("调用service完毕");
		return stringBuilder.toString();
	}

	/**
	 * 解析系统日志
	 * @param fileName
	 * @return
	 */
	@RequestMapping("log/{num}")
	public String fileLogs(@PathVariable(value = "num") String fileName){
		StringBuilder stringBuilder = new StringBuilder();
		try {
			String path = "C:\\Users\\admin\\Desktop\\3.8log\\xreport.ap0"+fileName+".log";
			log.info("开始分析xreport日志。"+path);
			stringBuilder = xreportService.fileLogs(path);
		} catch (IOException e) {
			log.error("",e);
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}

	@RequestMapping("logs/{filter}")
	public String fileLog(@PathVariable(value = "filter") String filter){
		StringBuilder stringBuilder = new StringBuilder();
		try {
			log.info("开始分析xreport日志1。"+filter);
			stringBuilder = xreportService.fileLog(filter);
		} catch (IOException e) {
			log.error("",e);
			e.printStackTrace();
		}
		return stringBuilder.toString();
	}
}
