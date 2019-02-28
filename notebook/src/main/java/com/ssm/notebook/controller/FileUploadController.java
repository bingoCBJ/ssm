package com.ssm.notebook.controller;

import com.ssm.notebook.model.FileInfo;
import com.ssm.notebook.model.User;
import com.ssm.notebook.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.*;


@Controller
@RequestMapping("/file")
public class FileUploadController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private FileService fileService;

    @ResponseBody
    @RequestMapping(value="/md5checkou",method = RequestMethod.POST)
    public Map<String,Object> md5Checkout(@RequestParam("user_id") String user_id,
                              @RequestParam("file_name") String file_name,
                              @RequestParam("md5_code") String md5_code) {
        //文件状态：0为文件不存在；1为文件存在且名相同；2为文件存在但名不同；
        String fileStatus = "0";
        //文件id：-1为文件不存在
        String fileId = "-1";
        Map<String,Object> map = new HashMap<>();
        User user = new User();
        user.setId(Integer.parseInt(user_id));
        List<FileInfo> fileInfoList = fileService.getFileByUser(user);
        Iterator fileIterator = fileInfoList.iterator();
        while (fileIterator.hasNext()){
            FileInfo fileInfo = (FileInfo) fileIterator.next();
            if (md5_code.endsWith(fileInfo.getMd5_code())){
                if (file_name.endsWith(fileInfo.getFile_name())){
                    fileStatus = "1";
                    fileId = ""+fileInfo.getId();
                    break;
                }else {
                    fileInfo.setUser_id(Integer.parseInt(user_id));
                    fileInfo.setFile_name(file_name);
                    fileInfo.setCreate_time(new Date());
                    fileService.addFile(fileInfo);
                    fileStatus = "2";
                    fileId = ""+fileInfo.getId();
                    break;
                }
            }
        }
        map.put("fileStatus",fileStatus);
        map.put("fileId",fileId);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public Map<String,Object> upload(@RequestParam("multiFile")MultipartFile files,
                                     @RequestParam("user_id") String user_id,
                                     @RequestParam("md5Str") String md5Str,
                                     HttpServletResponse response) throws IOException {
        Map<String,Object> map = new HashMap<>();
        FileInfo fileInfo = new FileInfo();
        response.setCharacterEncoding("utf-8");
        String msg ;
        String result = "";
        logger.info("-------------------开始调用上传文件upload接口-------------------");
        try{
            String name = files.getOriginalFilename();
            String path = "/home";
            //int index = path.indexOf("Shopping");
            //path = path.substring(0, index + "Shopping".length()) + "/WebContent/resources/upload/";
            path = path + File.separator + name;
            File uploadFile = new File(path);
            files.transferTo(uploadFile);
            //String md5Str = DigestUtils.md5DigestAsHex(files.getInputStream());
            logger.info(md5Str);
            fileInfo.setUser_id(Integer.parseInt(user_id));
            logger.info(user_id);
            fileInfo.setFile_name(name);
            logger.info(name);
            fileInfo.setPath(path);
            logger.info(path);
            fileInfo.setCreate_time(new Date());
            fileInfo.setMd5_code(md5Str);
            logger.info(fileInfo.toString());
            fileService.addFile(fileInfo);
            result = ""+fileInfo.getId();
            msg="success";
        }catch(Exception e){
            logger.error(e.fillInStackTrace()+"|||||"+e.getLocalizedMessage());
            e.printStackTrace();
            msg="false";
        }
        logger.info("-------------------结束调用上传文件upload接口-------------------");
        map.put("msg", msg);
        map.put("result", result);
        return map;
    }

    /**
     * 文件的下载
     */
    /*@RequestMapping(value = "/download/{id}")
    public void download(@RequestParam("id") String id, HttpServletRequest request, HttpServletResponse response) {

        try (
                //jdk7新特性，可以直接写到try()括号里面，java会自动关闭
                InputStream inputStream = new FileInputStream(new File(folder, id + ".txt"));
                OutputStream outputStream = response.getOutputStream()
        ) {
            //指明为下载
            response.setContentType("application/x-download");
            String fileName = "test.txt";
            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);   // 设置文件名


            //把输入流copy到输出流
            IOUtils.copy(inputStream, outputStream);

            outputStream.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }*/

}
