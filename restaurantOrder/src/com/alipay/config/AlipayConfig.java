package com.alipay.config;

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
	public static String app_id = "2021000117659797";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIQV5lsTlwSxPxU5wSZwM+XDYZ6vMjimUM4n1fi6+87xt1v/LVPl2uj9/R9Ugkhj36LM57uXNSTdSax2VbvItG07+e2lLKQfg9G0vLqqG7tufhIfg3Qih3X7hQwxfRyqbnCm8hZ2POfivv9fLNTioPMDzTYBKXH/qyN4xkux1+SFmzUQ55Hhul+ksY+k1gf4t1JoAyNoFaf1vQfSkudqcPJ4+swWXUsFJbURMqGVPH7evedUl8yhpQEF1QWSBbwijX0S+IV4fZNuw2/xs9F6IyEW2XSVD1b+bM9mudKgund0nPIRUNLlAAMAIWuWNMZijWzcutZz7M7vmnYeEDr3PZAgMBAAECggEBAId2leb8X2KpAda3jT8ucycYfiEeWURIX1aEBqlrMvjfr6lNgJtJOdJG7/rJpUPKwutqiI6xPVniTzDidH7T4JQ2CRhhblXvaGE4Ng7yQYFiwv4sy54EhD7KR3DjxVap521kDkBjjfLJtd0H5LEAuQgIqTBtH45oGNH+L/IlpZjZ1MxYsJcpiVWz+GzI+649eTmRZTUcAtRB3poLgjf4weOVt5ManD1L/nmUSmpQ4CHmK/1k3X4xvRg5s/hEJh4whOVhKD4Uxhw84dNoplK8fZfPCheb4qx3aZJra6SLZuECqnvCqBFrwU+OVEKbc47YRI55GFDEZrEt2/NJikF+hNECgYEA3RC4KvguS7JCgdJ43dGgnGYbQnqlhFqn/KE/2Q/MIJHzbtPn1BW3lp33TzFeUBniVMHNVXp/jtgdBBpplkkMwZEKa547sxzy9EYXSSIZAR5NEJX27g73fadNk7ZNAHvHXqvL481oVSfE9lSdnm4k1vLA3LN58RQQqFkma8vgO8cCgYEAncmhVxyw4gtViU7MVkYdyONXwIM2DhTt+eDy/YiYyk2FvtaL9zWssxr189Ek9n+0f/K01DwREt75ehzOHhQQx9QyomkjX72W8QpfJX9k2HmzCWKMuzk5KTjweCjH2Ee8AZY6mfMcXFXRjBerD2aX3va2/JxNnTlMZ5You+Gqk18CgYAHuzH1rsBPvWg+ChJYD6DCV3/Uj12Ch3kgiLMm8Dp/WRteYOLWs/u7tMKVbnCR9JXJyQ1ZU/NqF3zMS/AtZVig3GW05c/Ir9Z/XIQr9plRRLIFRnlgUf2t01APPmzq+2k5kmCLEv/3GnD0/HiWtdtr+QltrokxOTZr7NI/Kt4ouQKBgEJLxY5kb62KNZZLlW9qZnlRjD1G5B9mi9bBvVbpXckiaV+VpZlo4/cdDNo0teMcJSrdPz0tP78+EHRORgw9Qg+0CNJUephvgEwmn3OR4z1RZPg8gATqNior0l2qRM2K1mOUS2sDypbBOBo0l5sQ8B6uapQY2EOHH6MmZFcMqi7hAoGAI3JBWyFVHkiWFbdB4FIklyQURqH1gBixJ/SE/Kcd7TYvQE0N3Lla+mY5Q95eMG8whUDXS3UrGuNAw0d2qgjOAc0VjIlb8k2KcgEoSkYik6HoPXB9TvkX1BDv4NoEHn0OGpgkynUxym/gvsT85OY8ROu1iYIiPkZWI4wYzmJsfdA=";

	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqZM+rA/dN6zXvLAMAdx1XGDV7mgN9F+j2hEYkPwnx9SRqekH4Jaj+vmHA8FfatBqI+MqYUELr4r6pSRobnL/2QNqcJOyAmgCH7JTf8EzfuJ1B8SUdlO41LuijIBuH5l7jdzMP2yvHurHz0gv25kYwuPFd6iCvyH85H+KjpxW+BRoDTtrU8cJ33buGzqXyj8u4KPRdFwq3H3RRgujCoTQlQjM3m+38BrfWUBuCn1NkujrFm1A340ZAjoUQafeUfuJud+DFfgtiyNr1QbDwws+DtYqdhIBm9eFNvs/jmbhhhL07JTUNpFt5YuUuj/xFAh2c78loc1yBk5Ypg7qaN2NCQIDAQAB";


	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://niubai.free.idcfengye.com/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://niubai.free.idcfengye.com/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";

	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关https://openapi.alipaydev.com/gateway.do
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

