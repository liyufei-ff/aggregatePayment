package org.juhepay.merchant.controller;


import io.swagger.annotations.*;
import org.apache.dubbo.config.annotation.Reference;
import org.juhepay.merchant.api.AppService;
import org.juhepay.merchant.api.MerchantService;
import org.juhepay.merchant.api.dto.AppDTO;
import org.juhepay.merchant.api.dto.MerchantDTO;
import org.juhepay.merchant.convert.MerchantDetailConvert;
import org.juhepay.merchant.convert.MerchantRegisterConvert;
import org.juhepay.merchant.service.FileService;
import org.juhepay.merchant.service.SmsService;
import org.juhepay.merchant.util.SecurityUtil;
import org.juhepay.merchant.vo.MerchantDetailVO;
import org.juhepay.merchant.vo.MerchantRegisterVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * @ClassName MerchantController
 * @Description
 * @Author lily
 * @Date 2021/1/21 3:04 下午
 * @Version 1.0
 */
@Api(value = "商户平台‐商户相关", tags = "商户平台‐商户相关")
@RestController
public class MerchantController {

    @Reference //调用微服务项目中的service，远程注入
    private MerchantService merchantService;

    @Reference
    private AppService appService;

    //本地注入
    @Autowired
    private SmsService smsService;

    @Autowired
    private FileService fileService;




    @GetMapping("/merchants/{id}")
    public MerchantDTO queryMerchantById(@PathVariable("id") Long id){
        return merchantService.queryMerchantById(id);
    }

    @ApiOperation("获取手机验证码")
    @ApiImplicitParam(value = "手机号",name = "phone",required = true,dataType = "string",paramType = "query")
    @GetMapping("/sms")
    public String getSMSCode(@RequestParam("phone") String phone){
        //向验证服务器请求发送验证码
        return smsService.sendMsg(phone);
    }

    @ApiOperation("注册商户")
    @ApiImplicitParam(name = "merchantRegisterVO",value = "注册信息",required = true,dataType = "MerchantRegisterVO",paramType = "body")
    @PostMapping("/merchants/register")
    public MerchantRegisterVO registerMerchant(@RequestBody MerchantRegisterVO merchantRegisterVO){
        //int i=1/0;//故意制造异常 ....
        //校验验证码
        smsService.checkVerifiyCode(merchantRegisterVO.getVerifiykey(),merchantRegisterVO.getVerifiyCode());
        //注册商户
        MerchantDTO merchantDTO = MerchantRegisterConvert.INSTANCE.vo2dto(merchantRegisterVO);
        merchantService.createMerchant(merchantDTO);
        //返回注册后的商户对象
        return merchantRegisterVO;
    }

    @ApiOperation("证件上传")
    @PostMapping("/upload")
    public String upload(@ApiParam(value = "上传的文件", required = true) @RequestParam("file") MultipartFile file) {
        //原始文件名称
        String originalFilename = file.getOriginalFilename();
        //文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".")-1);
        //文件名称
        String fileName = UUID.randomUUID().toString()+suffix;
        //上传文件，返回文件下载url
        String fileurl = null;
        try {
            fileurl = fileService.upload(file.getBytes(), fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileurl;
    }

    @ApiOperation("商户资质申请")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "merchantInfo", value = "商户认证资料", required = true, dataType = "MerchantDetailVO", paramType = "body")
    })
    @PostMapping("/my/merchants/save")
    public void saveMerchant(@RequestBody MerchantDetailVO merchantInfo) {
        //获取id
        Long merchantId = SecurityUtil.getMerchantId();
        MerchantDTO merchantDTO = MerchantDetailConvert.INSTANCE.vo2dto(merchantInfo);
        merchantService.applyMerchant(merchantId,merchantDTO);
    }

    @ApiOperation("查询商户下的应用列表")
    @GetMapping(value = "/my/apps")
    public List<AppDTO> queryMyApps() {
        Long merchantId = SecurityUtil.getMerchantId();
        return appService.queryAppByMerchant(merchantId);
    }



    @ApiOperation("测试1")
    @GetMapping(path = "/hello")
    public String hello(){
        return "hello";
    }

    @ApiOperation("测试2")
    @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "string")
    @PostMapping(value = "/hi")
    public String hi(String name) {
        return "hi,"+name;
    }

}
