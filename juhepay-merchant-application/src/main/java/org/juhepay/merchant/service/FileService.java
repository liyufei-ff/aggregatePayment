package org.juhepay.merchant.service;

import org.juhepay.common.domain.BusinessException;

/**
 * @ClassName FileService
 * @Description
 * @Author lily
 * @Date 2021/1/24 11:49 上午
 * @Version 1.0
 */
public interface FileService {
    /**
     *  上传文件
     * @param bytes 文件字节数组
     * @param fileName 文件名
     * @return  文件访问路径（绝对的url）
     * @throws BusinessException
     */
    public String upload(byte[] bytes,String fileName) throws BusinessException;
}
