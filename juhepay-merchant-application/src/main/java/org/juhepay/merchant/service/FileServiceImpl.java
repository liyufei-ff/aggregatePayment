package org.juhepay.merchant.service;

import org.juhepay.common.domain.BusinessException;
import org.juhepay.common.domain.CommonErrorCode;
import org.juhepay.common.util.QiniuUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @ClassName FileServiceImpl
 * @Description
 * @Author lily
 * @Date 2021/1/24 11:59 上午
 * @Version 1.0
 */
@Service
public class FileServiceImpl implements FileService {
    @Value("${oss.qiniu.url}")
    private String qiniuUrl;
    @Value("${oss.qiniu.accessKey}")
    private String accessKey;
    @Value("${oss.qiniu.secretKey}")
    private String secretKey;
    @Value("${oss.qiniu.bucket}")
    private String bucket;
    @Override
    public String upload(byte[] bytes, String fileName) throws BusinessException {
        //调用common 下的工具类
        //String accessKey,String secretKey,String bucket, byte[] bytes,String fileName
        try {
            QiniuUtils.upload2Qiniu(accessKey,secretKey,bucket,bytes,fileName);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw new BusinessException(CommonErrorCode.E_100106);
        }
        //上传成功返回文件的访问地址（绝对路径）
        return qiniuUrl+fileName;
    }
}
