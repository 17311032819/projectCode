package com.wsk.controller;

public class AliPayConfig {
    // [沙箱环境]应用ID,您的APPID，收款账号既是你的APPID对应支付宝账号
    public static String app_id = "2021000117659797";
    // [沙箱环境]商户私钥，你的PKCS8格式RSA2私钥
    public static String merchant_private_key ="MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCIQV5lsTlwSxPxU5wSZwM+XDYZ6vMjimUM4n1fi6+87xt1v/LVPl2uj9/R9Ugkhj36LM57uXNSTdSax2VbvItG07+e2lLKQfg9G0vLqqG7tufhIfg3Qih3X7hQwxfRyqbnCm8hZ2POfivv9fLNTioPMDzTYBKXH/qyN4xkux1+SFmzUQ55Hhul+ksY+k1gf4t1JoAyNoFaf1vQfSkudqcPJ4+swWXUsFJbURMqGVPH7evedUl8yhpQEF1QWSBbwijX0S+IV4fZNuw2/xs9F6IyEW2XSVD1b+bM9mudKgund0nPIRUNLlAAMAIWuWNMZijWzcutZz7M7vmnYeEDr3PZAgMBAAECggEBAId2leb8X2KpAda3jT8ucycYfiEeWURIX1aEBqlrMvjfr6lNgJtJOdJG7/rJpUPKwutqiI6xPVniTzDidH7T4JQ2CRhhblXvaGE4Ng7yQYFiwv4sy54EhD7KR3DjxVap521kDkBjjfLJtd0H5LEAuQgIqTBtH45oGNH+L/IlpZjZ1MxYsJcpiVWz+GzI+649eTmRZTUcAtRB3poLgjf4weOVt5ManD1L/nmUSmpQ4CHmK/1k3X4xvRg5s/hEJh4whOVhKD4Uxhw84dNoplK8fZfPCheb4qx3aZJra6SLZuECqnvCqBFrwU+OVEKbc47YRI55GFDEZrEt2/NJikF+hNECgYEA3RC4KvguS7JCgdJ43dGgnGYbQnqlhFqn/KE/2Q/MIJHzbtPn1BW3lp33TzFeUBniVMHNVXp/jtgdBBpplkkMwZEKa547sxzy9EYXSSIZAR5NEJX27g73fadNk7ZNAHvHXqvL481oVSfE9lSdnm4k1vLA3LN58RQQqFkma8vgO8cCgYEAncmhVxyw4gtViU7MVkYdyONXwIM2DhTt+eDy/YiYyk2FvtaL9zWssxr189Ek9n+0f/K01DwREt75ehzOHhQQx9QyomkjX72W8QpfJX9k2HmzCWKMuzk5KTjweCjH2Ee8AZY6mfMcXFXRjBerD2aX3va2/JxNnTlMZ5You+Gqk18CgYAHuzH1rsBPvWg+ChJYD6DCV3/Uj12Ch3kgiLMm8Dp/WRteYOLWs/u7tMKVbnCR9JXJyQ1ZU/NqF3zMS/AtZVig3GW05c/Ir9Z/XIQr9plRRLIFRnlgUf2t01APPmzq+2k5kmCLEv/3GnD0/HiWtdtr+QltrokxOTZr7NI/Kt4ouQKBgEJLxY5kb62KNZZLlW9qZnlRjD1G5B9mi9bBvVbpXckiaV+VpZlo4/cdDNo0teMcJSrdPz0tP78+EHRORgw9Qg+0CNJUephvgEwmn3OR4z1RZPg8gATqNior0l2qRM2K1mOUS2sDypbBOBo0l5sQ8B6uapQY2EOHH6MmZFcMqi7hAoGAI3JBWyFVHkiWFbdB4FIklyQURqH1gBixJ/SE/Kcd7TYvQE0N3Lla+mY5Q95eMG8whUDXS3UrGuNAw0d2qgjOAc0VjIlb8k2KcgEoSkYik6HoPXB9TvkX1BDv4NoEHn0OGpgkynUxym/gvsT85OY8ROu1iYIiPkZWI4wYzmJsfdA=";

    // [沙箱环境]支付宝公钥
    public static String alipay_public_key ="MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqZM+rA/dN6zXvLAMAdx1XGDV7mgN9F+j2hEYkPwnx9SRqekH4Jaj+vmHA8FfatBqI+MqYUELr4r6pSRobnL/2QNqcJOyAmgCH7JTf8EzfuJ1B8SUdlO41LuijIBuH5l7jdzMP2yvHurHz0gv25kYwuPFd6iCvyH85H+KjpxW+BRoDTtrU8cJ33buGzqXyj8u4KPRdFwq3H3RRgujCoTQlQjM3m+38BrfWUBuCn1NkujrFm1A340ZAjoUQafeUfuJud+DFfgtiyNr1QbDwws+DtYqdhIBm9eFNvs/jmbhhhL07JTUNpFt5YuUuj/xFAh2c78loc1yBk5Ypg7qaN2NCQIDAQAB";

    // [沙箱环境]服务器异步通知页面路径
    public static String notify_url="http://localhost:8080/pay/notify_url";
    // [沙箱环境]页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url ="http://localhost:8080/pay/notify_url";
    // [沙箱环境]
    public static String gatewayUrl ="https://openapi.alipaydev.com/gateway.do";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";
}
