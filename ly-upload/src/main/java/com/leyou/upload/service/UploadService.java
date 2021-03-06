package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import com.leyou.common.enums.ExceptionEnums;
import com.leyou.common.exception.LyException;
import com.leyou.upload.config.UploadProperties;
import com.leyou.upload.web.UploadController;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author huangyi
 * @date 2019/10/22 0:10
 */
@Service
@EnableConfigurationProperties(UploadProperties.class)
public class UploadService {

    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    @Autowired
    private FastFileStorageClient storageClient;

    @Autowired
    private UploadProperties uploadProperties;

    // 支持的文件类型
    //private static final List<String> suffixes = Arrays.asList("image/png", "image/jpeg");

    public String uploadImage(MultipartFile file) {
        try {
            // 1、图片信息校验
            // 1)校验文件类型
            String type = file.getContentType();
            if (!uploadProperties.getAllowTypes().contains(type)) {
                logger.info("上传失败，文件类型不匹配：{}", type);
                throw new LyException(ExceptionEnums.UPLOAD_FILE_ERROR);
            }
            // 2)校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null) {
                logger.info("上传失败，文件内容不符合要求");
                throw new LyException(ExceptionEnums.UPLOAD_FILE_ERROR);
            }

//            // 2、保存图片
//            // 2.1、生成保存目录
//            File dir = new File("D:\\heima\\upload");
//            if (!dir.exists()) {
//                dir.mkdirs();
//            }
//            // 2.2、保存图片
//            file.transferTo(new File(dir, file.getOriginalFilename()));
//
//            // 2.3、拼接图片地址
//            String url = "http://image.leyou.com/upload/" + file.getOriginalFilename();
//
//            return url;

            String extension = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
            StorePath storePath = storageClient.uploadFile(file.getInputStream(), file.getSize(), extension, null);

            return uploadProperties.getBaseUrl() + storePath.getFullPath();


        } catch (Exception e) {
            throw new LyException(ExceptionEnums.UPLOAD_FILE_ERROR);
        }
    }
}
