package com.erayt.single.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @Auther: Z151
 * @Date: 2021/3/18 17:56
 *  参考网站：https://baijiahao.baidu.com/s?id=1654419465068708673&wfr=spider&for=pc
 */
@RestController
@Slf4j
public class UploadController {

    @RequestMapping(value = "upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        if(file.isEmpty()){
            return "errorFile";
        }
        String originalFilename = file.getOriginalFilename();
        log.info("上传文件为：" + originalFilename);
        assert originalFilename != null;
        String suffixName = originalFilename.substring(originalFilename.indexOf("."));
        log.info("上传的文件名为："+originalFilename+" 后缀名称为："+suffixName);
        //设置上传文件路径
        String filePath = "C:\\ideaworkspace\\springboot2\\file\\";
        String path = filePath + originalFilename;
        File dest = new File(path);
        if(dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);

        return "uploadSuccess";
    }
}
