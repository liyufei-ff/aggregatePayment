package org.juhepay.common.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.qiniu.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

/**
 * @ClassName QiniuUtils
 * @Description
 * @Author lily
 * @Date 2021/1/23 4:42 下午
 * @Version 1.0
 */
public class QiniuUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(QiniuUtils.class);

    //工具方法，上传文件
    public static void upload2Qiniu(String accessKey, String secretKey, String bucket, byte[] bytes,String fileName) {
        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huabei()); //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg); //默认不指定key的情况下，以文件内容的hash值作为文件名，这里建议由自己来控制文件名
        String key = fileName;
        //通常这里得到文件的字节数组
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes, key, upToken); //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            LOGGER.error(r.toString());
            try {
                LOGGER.error(r.bodyString());
            } catch (QiniuException e) {
                e.printStackTrace();
            }
            throw new RuntimeException(r.toString());
        }

    }

    private static void getdownloadurl() throws UnsupportedEncodingException {
        String fileName = "7bd2bb97-4281-4ca6-869c-23bd3ed50605.png";
        String domainOfBucket = "http://qncg2fs78.hb-bkt.clouddn.com";
        String encodedFileName = URLEncoder.encode(fileName, "utf-8").replace("+", "%20");
        String publicUrl = String.format("%s/%s", domainOfBucket, encodedFileName);
        String accessKey = "x-C8Q3cJH5THS0f0EZMJYNeqs09MkrrmKoCjt7it";
        String secretKey = "5101-UHScMIo0d4qsP0B4YIEW8KjNjo0A1sMZzhq";
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;//1小时，可以自定义链接过期时间
        String finalUrl = auth.privateDownloadUrl(publicUrl, expireInSeconds);
        System.out.println(finalUrl);

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        //测试上传
        //QiniuUtils.testUpload();
        //测试获取文件url
        QiniuUtils.getdownloadurl();
    }
}
