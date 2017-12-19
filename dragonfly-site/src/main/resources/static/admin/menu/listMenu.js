layui.config({
	base : "js/"
}).use(['table'],function(){

	var table = layui.table;

    //方法级渲染
    table.render({
        elem: '#lay_table_menu',
        url: '/menu/list/page',
        method : 'post',
        loading: true,
        page: true,
        sort :true,
        limits: [10,20,30,50],
        limit: 10,
        cols: [[
            {checkbox: true, fixed: true}
            ,{field:'menuId', title: '菜单ID', width:80, sort: true, fixed: true}
            ,{field:'name', title: '菜单名称'}
            ,{field:'parentId', title: '上级菜单'}
            ,{field:'icon', title: '菜单图标', render:'Render.customIcon'}
            ,{field:'url', title: '菜单URL'}
            ,{field:'perms', title: '授权标识'}
            ,{field:'type', title: '类型', render:'Render.customState'}
            ,{title: '操作', fixed:'right', width:180, align:'center', toolbar: '#menuBar'}
        ]],
        request: {
            pageName: 'pageNo', //页码的参数名称l，默认：page
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
            var name = $('#name');
            table.reload('testReload', {
                where: {
                    name: name.val()
                }
            });
        }
    };

    $('#layui-btn-submit').on('click', function(){
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    })

    //监听工具条
    table.on('tool(menu)', function(obj){ //注：tool是工具条事件名，test是table原始容器的属性 lay-filter="对应的值"
        var data = obj.data //获得当前行数据
            ,layEvent = obj.event; //获得 lay-event 对应的值
        if(layEvent === 'detail'){
            layer.msg('查看操作');
        } else if(layEvent === 'del'){
            layer.confirm('真的删除行么', function(index){
                obj.del(); //删除对应行（tr）的DOM结构
                layer.close(index);
                //向服务端发送删除指令
            });
        } else if(layEvent === 'edit'){
            layer.msg('编辑操作');
        }
    });

    //数据渲染对象
    var Render = {
        /**
         *  Created by 陈熠 on 2017/6/22
         *  email  ：228112142@qq.com
         *  rowdata：当前行数据
         *  index  ：当前第几行
         *  value  ：当前渲染列的值
         */
        //渲染状态列
        customState: function (rowdata,renderData, index, value) {
            if (value === 0) {
                return '<span class="layui-btn layui-btn-mini layui-btn-warm">目录</span>';
            }
            if (value === 1) {
                return '<span class="layui-btn layui-btn-mini layui-btn-sys">菜单</span>';
            }
            if (value === 2) {
                return '<span class="layui-btn layui-btn-mini layui-btn-green">按钮</span>';
            }
            if (value == "" || value == null) {
                return "";
            }
            return value;
        },
        //渲染操作方法列
        customIcon: function (rowdata,renderData, index, value) {
            if (value == "" || value == null) {
                return "";
            }
            var result = '<i class="' + value + ' fa-lg"></i>';
            return result;
        }

    };
        
})