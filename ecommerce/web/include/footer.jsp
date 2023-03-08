<%--
  Created by IntelliJ IDEA.
  User: 吴健军
  Date: 2022/6/2
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <title>footer</title>

    <style type="text/css">
        /*页脚*/
        /* 3大优势描述位置和背景设置 */

        #footCon>ul{
            width:1200px;
            height:168px;
            background:#eee;
            margin:auto;
            overflow:hidden;
            margin-top:80px;
        }
        #footCon>ul>li{
            width:330px;
            float:left;
            margin-top:45px;
            margin-left:70px;
            overflow:hidden;
        }
        #footCon>ul>li>.cold{
            width:65px;
            height:65px;
            background:url(images/sprite.png) no-repeat -351px 0px;
            float:left;
            margin-top:10px;
        }
        #footCon>ul>li>.wuxiu{
            width:69px;
            height:69px;
            background:url(images/sprite.png) no-repeat -418px 0px;
            float:left;
            margin-top:10px;
        }
        #footCon>ul>li>.baoyou{
            width:58px;
            height:72px;
            background:url(images/sprite.png) no-repeat -488px 0px;
            float:left;
            margin-top:10px;
        }
        /* 文字描述左边一竖线 */
        #footCon>ul>li>span{
            float:left;
            width:1px;
            height:80px;
            background:#fb0000;
            margin:0 30px 0 30px;
        }
        #footCon>ul>li>ol>h2{
            font-size:30px;
            color:#fb0000;

        }
        #footCon>ul>li>ol>p{
            font-size:24px;
            color:#4c4c4c;
            margin-top:10px;
        }
        #footCon>ol{
            width:1200px;
            margin:auto;
            margin-top:50px;
            overflow:hidden;
        }
        /* 页脚网址设置 */
        #footCon>ol>li{
            float:left;
            margin-left:120px;
            margin-right:85px;
        }
        /* 网址左图 */
        #footCon>ol>li>i{/* block：此元素将显示为块级元素，此元素前后会带有换行符。 */
            display:block; /* block块页面布局中,主要是用来将内容从上到下排列的 */
            width:92px;
            height:62px;
            background:url(images/sprite.png) no-repeat -23px 0px;
            margin-left:20px;
        }
        /* 设置微博/微信图标 */
        #footCon>ol>li>a{
            display:block;
            font-size:14px;
            color:#4c4c4c;
            margin-top:20px;
        }
        #footCon>ol>li>div{
            overflow:hidden;
            margin-top:24px;
            margin-left:10px;
        }
        #footCon>ol>li>div>.weibo{
            float:left;
            width:33px;
            height:27px;
            background:url(images/sprite.png) no-repeat -546px 0px;
        }
        #footCon>ol>li>div>.weixin{
            float:left;
            width:36px;
            height:30px;
            background:url(images/sprite.png) no-repeat -582px 0px;
            margin-left:40px;
        }
        /* 页脚文字 */
        #footCon>ol>ul{
            float:left;
            width:540px;
            border-left:1px solid #b5b5b5;
            border-right:1px solid #b5b5b5;

        }
        #footCon>ol>ul>li{
            float:left;
            margin-right:50px;
        }
        #footCon>ol>ul>.text01{
            margin-left:80px;
        }
        #footCon>ol>ul>li>p{
            font-size:14px;
            color:#4c4c4c;
        }
        /* 下划灰线 */
        #footCon>ol>ul>li>span{
            display:block;
            width:50px;
            height:1px;
            background:#b5b5b5;
            margin-left:5px;
            margin-top:10px;
        }
        #footCon>ol>ul>li>a{
            display:block;
            font-size:14px;
            color:#808080;
            margin-top:20px;
        }
        /* “联系我们”描述div */
        #footCon>ol>div{
            text-align:center;
            float:left;
            margin-left:50px;
        }
        #footCon>ol>div>p{
            font-size:14px;
            color:#4d4d4d;
        }
        #footCon>ol>div>h2{
            font-size:18px;
            color:#4c4c4c;
            margin-top:20px;
        }
        #footCon>ol>div>span{
            display:block;/* block：此元素将显示为块级元素，此元素前后会带有换行符。将内容从上到下排列. */
            font-size:14px;
            color:#4d4d4d;
            margin-top:20px;
        }
        /* 在线客服的圆弧背景 */
        #footCon>ol>div>a{
            display:block;
            border-radius:8px;
            width:75px;
            height:25px;
            background:#b5b5b5;
            color:#fff;
            margin-top:20px;
            margin-left:26px;
            font-size:14px;
            line-height: 25px;
        }
        /* 页脚分割 */
        #footCon>div{
            margin:auto;
            width:1200px;
            height:1px;
            background:#b5b5b5;
            margin-top:30px;
        }
        /* 版权 */
        #footCon>li{
            width:1200px;
            margin:auto;
            text-align:center;
            font-size:14px;
            margin-top:40px;
            color:#808080;
        }
        #footCon>li>span{
            display:block;
            margin-top:20px;
        }
    </style>

    </style>
</head>
<body>
<!--页脚-->
<div id="footCon">
    <ul>
        <li>
            <div class="cold"></div>
            <span></span>
            <ol>
                <h2>18小时低温</h2>
                <p>全程冷链配送</p>
            </ol>
        </li>
        <li>
            <div class="wuxiu"></div>
            <span></span>
            <ol>
                <h2>7*24小时营业</h2>
                <p>全年无休</p>
            </ol>
        </li>
        <li>
            <div class="baoyou"></div>
            <span></span>
            <ol>
                <h2>满88包邮</h2>
                <p>次日送达</p>
            </ol>
        </li>
    </ul>
    <ol>
        <li>
            <i></i>
            <a href="index.jsp">www.sweetlove.com</a>
            <div>
                <a href="http://www.weibo.com" class="weibo"></a>
                <a href="http://wx.qq.com" class="weixin"></a>
            </div>
        </li>
        <ul>
            <li class="text01">
                <p>关于甜爱</p>
                <span></span>
                <a href="#">媒体报道</a>
                <a href="#">知识产权</a>
                <a href="#">加入我们</a>
            </li>
            <li>
                <p>帮助中心</p>
                <span></span>
                <a href="#">购物指南</a>
                <a href="#">订单管理</a>
                <a href="#">常见问题</a>
            </li>
            <li>
                <p>服务支持</p>
                <span></span>
                <a href="#">服务保障</a>
                <a href="#">用户协议</a>
                <a href="#">售后服务</a>
            </li>
            <li>
                <p>商业合作</p>
                <span></span>
                <a href="#">集合采购</a>
                <a href="#">品牌合作</a>
                <a href="#">媒体合作</a>
            </li>
        </ul>
        <div>
            <p>联系我们</p>
            <h2>400-8888-000</h2>
            <span>24小时服务热线</span>
            <a href="#">在线客服</a>
        </div>
    </ol>
    <div></div>
    <li>
        <p>Copyright © 2021 sweetlove.com Inc.All Rights Reserved. 成都甜心食品有限公司</p>
        <span>版权所有 蜀ICP备14049996号-1 增值电信业务经营许可证：川ICP证160061号</span>
    </li>
</div>

</body>
</html>
