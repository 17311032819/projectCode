
/**
 * Created by 吴健军 on 2022.12.05
 */
$( function() {
    $('.update_button').click(function () {
        var token = $('.token').val();
        var password = $(this).siblings(".first_info").children(".password").val();
        var password1 = $(this).siblings(".first_info").children(".password1").val();
        var password2 = $(this).siblings(".first_info").children(".password2").val();
        alert(password,password1,password2);
        if (password2!=password1) {
            alert("两次新密码不一致")
        }else {
            $.ajax({
                url:'/certificationPassword.do',
                type:'post',
                dataType:'JSON',
                data: {password:password,password1:password1},
                success:function (data) {
                    var result = data.result;
                    if (result === 0){
                        alert('修改失败，密码太简单');
                    } else if (result === 1){
                        // $(this).text(value);
                        alert('修改失败，原密码错误');
                    }else if (result === 2){
                        // $(this).text(value);
                        alert('修改成功');
                    }
                }
            });
        }
    });
//            实时监听输入框的输入变化，当有输入值的时候，隐藏必须填写字段
    $('.first_info input').bind("input propertychange change",function () {
        var val = $(this).val();
        if (val!=undefined&&val!='') {
            $(this).siblings(".reqiure_enter").hide(0);
        }
    });
} );
$(function () {
    if ($('.show_tip').is(':hidden')){
        var show_tip = $('.show_tip').val();
        alert('请先认证真实信息！！！！！');
    }
});