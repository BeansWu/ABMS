/**
 * Created by Administrator on 2017/5/22.
 */
$(function () {
    /** 先请求获取联系人姓名、项目预算号、二级单位姓名，生成填表日期 **/
    $("#budget_item_number").val("101");
    $("#contact_user_number").val("吴忠恩");
    $("#college_name").val("数学与计算机科学学院");
    $('#fill_in_date').val(new Date().toLocaleDateString());

    /**
     * 添加采购项目明细,在 session 中创建一个 purchaseDetails 集合，
     * 添加采购项目明细时先放到集合中，等点击提交申请的时候再全部保存到数据库中
     */
    $("#save_purchase_detail").click(function () {
        var budgetApplicationNumber = $("#budget_item_number").val();
        var purchaseJouralCode = $("#purchase_item_code").val();
        var quantity = $("#quantity").val();
        var unit = $("#unit").val();
        var price = $("#price").val();
        var ifBelongsToScopeOfGovtProcBud = $("input:radio[name ='if_belongs_to_scope_of_govt_proc_bud']:checked").val();
        var ifPartOfGovetProcServBud = $("input:radio[name ='if_part_of_govet_proc_serv_bud']:checked").val();
        var ifPartOfAssetPurBud = $("input:radio[name ='if_part_of_asset_pur_bud']:checked").val();
        var ifSpecForSmallMedEnt = $("input:radio[name ='if_spec_for_small_med_ent']:checked").val();
        var purchase_detail = {
            budgetApplicationNumber : budgetApplicationNumber,
            purchaseJouralCode : purchaseJouralCode,
            quantity : quantity,
            unit : unit,
            price : price,
            ifBelongsToScopeOfGovtProcBud : ifBelongsToScopeOfGovtProcBud,
            ifPartOfGovetProcServBud : ifPartOfGovetProcServBud,
            ifPartOfAssetPurBud : ifPartOfAssetPurBud,
            ifSpecForSmallMedEnt : ifSpecForSmallMedEnt
        }


    })



    /** 提交预算申请 **/
    $("#submit_application").click(function () {
        var budget_item_name = $("#budget_item_name").val();
        var required_time = $("#required_time").val();
        var reason = $("#reason").val();

    })



    /**表单验证**/
    $('#application_form').bootstrapValidator({
        message:'This is not valid',
        feedbackIcons:{
            valid:'glyphicon glyphicon-ok',
            invalid:'glyphicon glyphicon-remove',
            validating:'glyphicon glyphicon-refresh'
        },
        fields:{
            budget_item_name:{
                validators:{
                    notEmpty:{
                        message:'项目名称不能为空'
                    },
                    regexp:{
                        regexp:/^[a-zA-Z0-9\u4e00-\u9fa5_]+$/,
                        message:'项目名称不能存在空格'
                        //只能由汉字、字母、数字、下划线组成
                    }
                }
            },//检验预算项目名称
            required_time:{
                validators:{
                    notEmpty:{
                        message:'需求时间不能为空'
                    },
                    regexp:{
                        // regexp:/^[a-zA-Z0-9_]+$/,
                        regexp:/\d{4}-\d{2}-\d{2}/,
                        message:'日期格式应为YYYY-mm-DD'
                    },
                    callback:{
                        callback:function(value,validator){//只比较年 暂时这样做 以后可以用控件
                            var doday=$('#fill_in_date').val();
                            var this_year=doday.substr(0,4);
                            var required_year=value.substr(0,4);
                            return parseInt(required_year)>=parseInt(this_year);
                        },
                        message:'需求时间必须是本年或以后'
                    }
                }
            },//检验需求时间
            reason:{
                validators:{
                    notEmpty:{
                        message:'购置理由不能为空',
                    },
                    stringLength:{
                        max:50,
                        message:'字数不得超过50'
                    },
                    regexp:{//不太好 暂时先这样实现
                        regexp:/^[a-zA-Z0-9\u4e00-\u9fa5_，。]+$/,
                        message:'不能有空格'
                    }
                }
            },//检验购置理由  
        }
    });//第一个表单验证

    $('#add_item').bootstrapValidator({
        message:'This is not valid',
        feedbackIcons:{
            valid:'glyphicon glyphicon-ok',
            invalid:'glyphicon glyphicon-remove',
            validating:'glyphicon glyphicon-refresh'
        },
        fields:{
            purchase_item_code:{
                validators:{
                    notEmpty:{
                        message:'采购品目编码不能为空'
                    }
                }
            },//验证品目编码
            quantity:{
                validators:{
                    notEmpty:{
                        message:'数量不能为空'
                    },
                    regexp:{
                        regexp:/^[0-9]+$/,
                        message:'数量只能为整数'
                    }
                }
            },//验证数量
            unit:{
                validators:{
                    notEmpty:{
                        message:'计量单位不能为空'
                    }
                }
            },//验证计量单位
            price:{
                validators:{
                    notEmpty:{
                        message:'单价不能为空'
                    },
                    regexp:{
                        regexp:/^[0-9]+$/,
                        message:'单价只能为整数'
                    }
                }
            },//验证单价
            if_belongs_to_scope_of_govt_proc_bud:{
                validators:{
                    notEmpty:{
                        message:'必选'
                    }
                }
            },//验证 是否属于政府采购预算编制范围：
            if_part_of_govet_proc_serv_bud:{
                validators:{
                    notEmpty:{
                        message:'必选'
                    }
                }
            },//验证 是否属于政府购买服务预算编制范围：
            if_part_of_asset_pur_bud:{
                validators:{
                    notEmpty:{
                        message:'必选'
                    }
                }
            },//验证 是否属于资产购置预算编制范围：
            if_spec_for_small_med_ent:{
                validators:{
                    notEmpty:{
                        message:'必选'
                    }
                }
            },//验证 是否专门面向中小企业（含监狱企业)：

        }
    })

    //模态框居中
    function centerModals(){
        $('#edit').each(function(i){
            var $clone=$(this).clone().css('display','block').appendTo('body');
            var top=Math.round(($clone.height()-$clone.find('.modal-content').height())/2);
            top=top>0?top:0;
            $clone.remove();
            $(this).find('.modal-content').css("margin-top",top);
        });
    };

    //当模态框弹出时 调用让其居中的方法
    $('#edit').on('show.bs.modal',centerModals);


})