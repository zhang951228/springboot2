package com.erayt.producer.controller;

import com.erayt.producer.service.XreportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.io.IOException;

/**
 * @Auther: Z151
 * @Date: 2021/3/9 14:55
 */
@Slf4j
@RestController
public class XreportController {

	@Autowired
	XreportService xreportService;

	@RequestMapping("xre/file/{dateStr}")
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
}
