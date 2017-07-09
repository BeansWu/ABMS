/**
 * Created by LongFurCat on 2017/5/24.
 */
$(function(){
    /**表单验证**/
    $('#login').bootstrapValidator({
        message:'This is not valid',
        feedbackIcons:{
            valid:'glyphicon glyphicon-ok',
            invalid:'glyphicon glyphicon-remove',
            validating:'glyphicon glyphicon-refresh'
        },
        fields:{
            username:{
                validators:{
                    notEmpty:{
                        message:'用户名或邮箱不能为空'
                    },
                    stringLength:{
                        max:20,
                        message:'用户名长度不得超过20'
                    },
                }
            },//检验登录名
            password:{
                validators:{
                    notEmpty:{
                        message:'密码不能为空'
                    },
                }
            }//检验密码  
        }
    })
})