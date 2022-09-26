package com.roncoo.education.common.upload;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 上传功能
 */
public interface UploadFace {

    /**
     * 图片上传
     *
     * @return 图片url
     */
    String uploadPic(MultipartFile file, Upload upload) throws IOException;
}
