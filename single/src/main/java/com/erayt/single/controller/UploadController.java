package com.erayt.single.controller;

import com.erayt.single.utility.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * @Auther: Z151
 * @Date: 2021/3/18 17:56
 *  参考网站：https://baijiahao.baidu.com/s?id=1654419465068708673&wfr=spider&for=pc
 */
@Controller
@Slf4j
public class UploadController {

    @ResponseBody
    @RequestMapping(value = "upload")
    public String upload_new(@RequestPart("headImager") MultipartFile headImager,
                               @RequestPart("photos") MultipartFile[] photos,
                               @RequestParam("userName") String userName ,
                               ModelMap modelMap) throws IOException {
        log.info("userName:{}",userName);
        log.info("headImager:{},photos:{},",headImager.getSize(),photos.length);
        String path = "C:\\ideaworkspace\\springboot2\\file\\";
        if(null != headImager){
            headImager.transferTo(new File(path + headImager.getOriginalFilename()));
        }
        if(null != photos){
            for (MultipartFile photo : photos) {
                photo.transferTo(new File(path + photo.getOriginalFilename()));
            }
        }
        modelMap.put("msg","上传文件成功啦");
        modelMap.put("state","200");
        return "SUCCESS";
    }

    @ResponseBody
    @RequestMapping(value = "download")
    public String download(HttpServletRequest request,
                             HttpServletResponse response,ModelMap modelMap) throws IOException {
        String fileName = "";
        File file = new File("C:\\ideaworkspace\\springboot2\\file\\测试下载excel.xls");
        response.setContentType("application/octet-stream");
        response.addHeader("Content-Disposition","attachment;fileName=" + URLEncoder.encode("测试下载excel.xls", "UTF-8"));
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        fis = new FileInputStream(file);
        bis = new BufferedInputStream(fis);
        OutputStream os = response.getOutputStream();
        int i = 0;
        i = bis.read(buffer);
        while(i != -1){
            os.write(buffer,0,i);
            i = bis.read(buffer);
        }

        modelMap.put("msg","success");
        modelMap.put("state","下载成功");
        bis.close();
        fis.close();

        return "SUCCESS";
    }

    @Deprecated
    @ResponseBody
    @RequestMapping(value = "upload_bak")
    public ModelMap upload_bak(@RequestParam("file") MultipartFile file) throws IOException {
        ModelMap modelMap = new ModelMap();
        if(file.isEmpty()){
            modelMap.put("msg","文件为空或者不存在啊");
            return modelMap;
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
        if(dest.exists()){
            originalFilename += DateUtil.getDateRandom();
            dest = new File(filePath + originalFilename);
        }
        file.transferTo(dest);
        modelMap.put("msg","上传文件成功");
        modelMap.put("state","x200");
        return modelMap;
    }
}
