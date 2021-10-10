package com.nchu.order.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id ="2021000117693038";


	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCKyANIO3uDrdRfVQPxYjE3LN7sXjJMwPj63JndKQ/ZVKh0TJBPy7kmVoszULd7TlFDw+f6K8nutboiaXGfK0KBu7+UyuH1SdYtEqydJQYCHEicw/pD2BEm1I6iuFOxm6Q8DPpJbA7+Kb7SrQ/JoSomMu7ySqtJuu/h8EFQ+v7T7nAVk8zSWU6g3UwZu9kiWIjDP51/863HXxN7/MM+B4kEPD9aKLTXstFmcjEJz/D31ba2ccCj18Tu5poV2E0Zo0N2PaMU/KZvCsUQrJLFBCCUnY9k/5P9KJeUEKsf5oXBxKmmTWVWsd3+Pe7+6eo62S9s+N9HKhHxESYSGN3rXLvRAgMBAAECggEAO2NeLDHwKChiAi2yU0BuySq1drbUlY3avhda7I5ezuTwdVwyQUNvxt0wElSPQAACvJoAEklcz38K2SEAU1nCyxuZ30V2rm3bbkxYe6LVUF/kHtmqpg+3P0OkijOQ9Scif+QZ0wOf4tngY+1VHTaPf+s534teg12wu6IBgXL3S59SxCDDzQm+rguoI/GofaxFBPctRymY3HLRSNgPhcmlIMQR6hcK4vqdxEgklcyJW7Ofokh/N1EatasF5M9UgpuVrQQF/bogfh3M4FMLbJ4fMP/4eRx2MelDzsfaIffQSUMQ01zjrd4ZghuOrP9lWe9sMeylaIZdKyMoNvcIyrCuFQKBgQDJJgn5752gDvIciRKVnw4x2hZCVRIg9AIqYSucg+4DzXjYDeCctScIqXlF5ztjWBzJDfp8roskHAq16qm3NiSMOKKINDUUJ4DF74CUhhkHznc7sKDc0xGIAeU+7J5KIcKFV3zJ0qYrA8dSK3fp3Zy10fBBbwyfze5H4v25RM0S1wKBgQCwoC6kmTNa4nsit1t/KZuu/uKE6FjKmH0zC9D0zBJRqc3UsE8F1S4YQTaUowydZS74k4P3o54NKLibEAOyx6mK6vZG+oUdvy31CFy2a03BhpRc6gar3D2e8Be3N6exc3NSSFrOzy6MECIPaDKVsG6+JV9uhamFSvD1/TyJSpl5lwKBgEBobr9aK5XJ01qxxYKlWI078O6ygMiOeXcKgEVwtTEAhRZhcy+ajfInGg75GLoZx7XVRQTRevpIBGH1zvw8WP2RUPHeDbTzZTd8Fib4vWETinhReWDcMPvk53v7lj/UiY3a0rlpOw4A+rzj8FSxQnGx1IWPQnKVJRxdobLGRggnAoGAQAxF/bAEPF/GUSd2SV14M/P/hjyO/iBfviP5yNs7hVty5T5t2WqdhXQYa7vYdjbb2o37m9A8Hv92OdyLyse2Rka/uatcnBXYf3Nh01CD6Lp5kFvYwXdi7QCZSPoomCOKXPsZ2sasVWQARd/9/+PztIXu3jAf8dLkH/+NdSeVEc8CgYANBrXdjfduuIxt+sSdg8AqVaDyo2wb3EwzvVDyP/AqwwSXdeL4RNmNhGjSOL51YQHo44N3u7EZblf/vdzOPsezqWr1kW+XNI+wbLPEBFvFZbaL7WtXGBUcpXYxMjxrMh8ieTo7zW1J1BADeC0IuujvOff3cWWEByAhUjmnTKPLtQ==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAgaFdB8x3ocFczmMsWfB7FJB0FobgDxY2C6zev66UhIwceN4Nyh6aaii5Ap0uI4GvuwA3hXiVrYgaXOYZuUUr4DbZ0hGaGQbJ2YNXSEjhNXYK+ASM7lJn1sJqPqXrrDs5I4Cynk8OGON3JIv8OSjzCCqhzv2AeBL2xvtmJBqRDS2Mc5m/xJMPabbUHE/uksHIV4UtBewr2bUPYuHwrDd7uStE1zasGCBdhwhmWixfoyzrakaFXDJChJYJcH4ybt7EvKJGXCkN7FI7bHYshS/a1etL89dbucPEZ91hVSygL4gGAqH5lg5wdSna4VRd8LR8SWHh8qX15QkGDnCoa5XPlQIDAQAB";

//	 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://150.158.191.108:8080/OrderSystem/cartInfo/success";
                                        /*z注意路径要切换*/
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://150.158.191.108:8080/OrderSystem/indexInfo/findIndexAll";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

