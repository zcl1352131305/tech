/**
 * Created by Administrator on 2017/09/20.
 */

$(document).ready(function () {
    //页面初始加载方法
    //显示页面消息
    if($("#audit_hidden_message").val()&&$("#audit_hidden_message").val()!=""){
        toastr["success"]($("#audit_hidden_message").val());

    }
})


function deleteInfo(url) {
    swal({
        title: '提示',
        text: '确认删除该信息？',
        type: 'warning',
        showCancelButton: true,
        confirmButtonText: '删除',
        showLoaderOnConfirm: true,
        preConfirm: function () {
            return new Promise(function (resolve, reject) {
                $.ajax({
                    url: url,
                    type: 'DELETE',
                    success: function (data) {
                        resolve(data);
                    },
                    error: function (err) {
                        reject("出现问题，请稍后重试 !");
                    }
                });
            })
        },
        allowOutsideClick: false
    }).then(function (data) {
        swal({
            type: 'success',
            title: '成功',
            text: '删除成功',
            confirmButtonText: "确认"
        }).then(
            function(result) {
                // handle Confirm button click
                // result is an optional parameter, needed for modals with input
                location.reload();
            }, function(dismiss) {
                // dismiss can be 'cancel', 'overlay', 'esc' or 'timer'
            });

    }, function (err) {
    })
}

//summernote文件上传
function sendFile(file, el) {
    var data = new FormData();
    data.append("file", file); // 表单名称

    $.ajax({
        type: "POST",
        url: "/common/file/upload/image?keyword=doc",
        data: data,
        cache: false,
        contentType: false,
        processData: false,
        dataType: 'json',
        success: function(response) {

            $(el).summernote('editor.insertImage', response.data.webPath, response.data.id);
        },
        error : function(error) {
            alert('图片上传失败');
        },
        complete : function(response) {
        }
    });
}
