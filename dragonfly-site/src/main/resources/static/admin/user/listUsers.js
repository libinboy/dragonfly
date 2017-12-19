layui.config({
	base : "js/"
}).use(['table'],function(){

	var table = layui.table;

    //方法级渲染
    table.render({
        elem: '#lay_table_user',
        url: '/user/list/page',
        method : 'post',
        loading: true,
        page: true,
        sort :true,
        limits: [10,20,30,50],
        limit: 10,
        cols: [[
            {checkbox: true, fixed: true}
            ,{field:'userId', title: 'ID', width:80, sort: true, fixed: true}
            ,{field:'account', title: '账号', width:80 }
            ,{field:'userName', title: '姓名', width:80 }
        ]],
        request: {
            pageName: 'pageNo', //页码的参数名称，默认：page
            limitName: 'pageSize' //每页数据量的参数名，默认：limit
        },
        response: {
            statusName: 'code', //数据状态的字段名称，默认：code
            statusCode: 0, //成功的状态码，默认：0
            msgName: 'msg', //状态信息的字段名称，默认：msg
            countName: 'total', //数据总数的字段名称，默认：count
            dataName: 'rows', //数据列表的字段名称，默认：data
        },
        done: function (response, curr, count) {
            console.log(response);
            //得到当前页码
            console.log(curr);
            //得到数据总量
            console.log(count);
        },
        id: 'testReload'

    });

    var $ = layui.$, active = {
        reload: function(){
            var account = $('#account');
            table.reload('testReload', {
                where: {
                    account: account.val()
                }
            });
        }
    };

    $('#layui-btn-submit').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    })
        
})