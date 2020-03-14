package com.lz.secondhandmall.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;

/**
 * @Copyright: Shanghai Definesys Company.All rights reserved.
 * @Description:
 * @Author: lz
 * @Since: 2019/12/20 16:57
 * @History 2019/12/20 created by lz
 */
public class SmsUtils {

    public static void sendMessage(String phone, String key) {

        // 第二个参数为自己独有的accessKeyid，第三个参数为自己独有的accessKeySecret
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", "LTAI4Fd21Djh6uXGS9kxPeJq", "eiOUwJTzI2JTyJ1PJdcHeE2uJjxGii");
        IAcsClient client = new DefaultAcsClient(profile);

        // 组装对象
        CommonRequest request = new CommonRequest();

        // 设置post提交
        request.setMethod(MethodType.POST);

        // 短信API产品域名（接口地址固定，无需修改）
        request.setDomain("dysmsapi.aliyuncs.com");
        request.setVersion("2017-05-25");
        request.setAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);

        // 短信签名
        request.putQueryParameter("SignName", "lz校园二手商品交易");
        request.putQueryParameter("TemplateCode", "SMS_180945548");
        request.putQueryParameter("TemplateParam", "{code:"+key+"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }

    }

}
