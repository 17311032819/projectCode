/**
 * Created by 吴健军 on 2022.12.05
 */

var sum = 0;
$(function () {
//            按照下面这个方式添加新的元素，如果想在开头位置添加，就用first  before
//            $('.table_content:last').after("<tr class='table_content'><td><span>11111</span></td></tr>");
    calSum();
    var which = 0;
    $('.shipping_address').click(function () {
        var id = $(this).attr('id');
        $('.shipping_address').each(function () {
            if ($(this).attr('id')==id) {
                $(this).css({"border-color": "slateblue"});
                which = id;
            }else {
                $(this).css({"border-color": "rgba(0,0,0,0.1)"});
            }
        });
    });
//            -号，不能低于 1
    $('span.minus').click(function () {
        var num = $(this).siblings(".number").html();
        if (num>=2) {
            num--;
        }
        $(this).siblings(".number").html(num);
        var cost = $(this).parent().siblings(".cost").children("span").html();
        $(this).parent().siblings(".per_sum").children("span").html(returnFloat(cost*num));
        calSum();
    });
    $('span.add').click(function () {
        var num = $(this).siblings(".number").html();
        num++;
        $(this).siblings(".number").html(num);
        var cost = $(this).parent().siblings(".cost").children("span").html();
        $(this).parent().siblings(".per_sum").children("span").html(returnFloat(cost*num));
        calSum();
    });
    $('.table_content td.input_checkbox input').change(function () {
        calSum();
    });
    $('#all').change(function () {
        if($(this).is(":checked")) {
            $("input[name='checkbox']").attr("checked","true");
        }else {
            $("input[name='checkbox']").removeAttr("checked");
        }
        calSum();
    });
//            保留两位小数
    function returnFloat(value){
        var value=Math.round(parseFloat(value)*100)/100;
        var xsd=value.toString().split(".");
        if(xsd.length==1){
            value=value.toString()+".00";
            return value;
        }
        if(xsd.length>1){
            if(xsd[1].length<2){
                value=value.toString()+"0";
            }
            return value;
        }
    }
//            计算总金额
    function calSum() {

        $('.cart_content table tr.table_content').each(function () {
            var isCheck = $(this).children("td.input_checkbox").children("input").is(":checked");
            if(isCheck){
                sum  +=  parseFloat($(this).children(".per_sum").children("span").html());
            }
        });
        sum = returnFloat(sum);
        $('.end_pay').children(".all_sum").children("span").html(sum);
    }

    // 结算功能
    $('.pay_button_div').click(function () {

        var r = confirm('确定结算');
        if (r == true) {
            var sidList=[];
            //获得商品idlist
            $('.cart_content table tr.table_content').each(function () {
                var isCheck = $(this).children("td.input_checkbox").children("input").is(":checked");
                if(isCheck){
                    var sid = $(this).children("td.input_checkbox").children("input").attr("value");
                    sidList.push(sid)
                }
            });
            var orderId=Math.floor(Math.random()*1000000+1);
            var amount =sum;
            var product=encodeURI(encodeURI("产品名字"));
            // alert(product);解码，编码
            // alert(decodeURIComponent(decodeURIComponent(product)));
            var body="good";
            //http://localhost:8080/pay/aliPay/678621/4589.50/11/good
            window.location.href="http://localhost:8080/pay/aliPay?orderId="+orderId+"&amount="+amount+"&product="+product+"&body="+body+"&sidList="+sidList+"";
        }
    })

    $('.deleteShopCar').click(function () {
        var r = confirm('确定删除？？？？');
        if (r == true) {
            var id = $(this).attr('value');
            var sid = $(this).parent().siblings(".show_img").children().attr("value");
            // alert(sid);
            $.ajax({
                url:'deleteShopCar.do',
                dataType:'JSON',
                type:'post',
                data:{id:id,sid:sid},
                success:function (data) {
                    var result = data.result;
                    if (result==2){
                        alert('您还没有登录，请先登录');
                    }  else if (result==1) {
                        alert("删除成功");
                        window.location.href='shopping_cart.do?result=删除成功';
                    } else if (result==0){
                        alert('删除失败，请检测网络');
                    } else {
                        alert('删除失败，请检测网络');
                    }
                }
            })
        }
    })
});