package com.reddy.my_show.server.service;

import com.reddy.my_show.common.MyShowException;
import com.reddy.my_show.server.dao.VideosDAO;
import com.reddy.my_show.server.model.UserDetails;
import com.reddy.my_show.server.model.Video;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

/**
 * Created by varshini on 2/10/15.
 */
@Service
public class AdminService {
    Logger logger= LoggerFactory.getLogger(AdminService.class);

    @Autowired
    private VideosDAO videosDAO;

    public void setVideosDAO(VideosDAO videosDAO){
        this.videosDAO = videosDAO;
    }

    public void uploadVideo(MultipartFile multipartFile,UserDetails userDetails) throws IOException, MyShowException {

        File newFile = new File("/home/varshini/srinu/"+ multipartFile.getOriginalFilename());
        if (!newFile.exists()) {
            newFile.createNewFile();
        }

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(multipartFile.getBytes());
        FileOutputStream  fileOutputStream = new FileOutputStream(newFile);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            int read = 0;
            byte[] bytes =new byte[1024];

               // outputStream.write(bytes, 0, read);
               byteArrayOutputStream.write(byteArrayInputStream.read());
              //  byteArrayOutputStream.write(bytes);
                byteArrayOutputStream.writeTo(fileOutputStream);


            byteArrayInputStream.close();
            byteArrayOutputStream.close();
            fileOutputStream.close();

            Video video = new Video();
            video.setUserDetails(userDetails);
            video.setPath(newFile.getAbsolutePath());
            video.setTitle(multipartFile.getName());
            video.setDescription(multipartFile.getOriginalFilename());
            video.setUrl(multipartFile.getName());
            videosDAO.uploadVideo(video);

        } catch (Exception e) {
            e.printStackTrace();
            logger.info("error"+e.getMessage()  + e.getStackTrace() + e.getCause());
            throw new MyShowException("", "file error");
        }


    }

}

