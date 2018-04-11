 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
  <head>
    
    <title>日志管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="description" content="This is my page">
	<%-- <%@include file="../common/_common.html" %> --%>
	<link rel="stylesheet" type="text/css" href="/fangfq/layui/css/layui.css">
  </head>
  <body>
  		<div class="layui-btn-group demoTable">
		  <button class="layui-btn" data-type="getCheckData">查看</button>
		  <button class="layui-btn" data-type="getCheckLength">获取选中数目</button>
		  <button class="layui-btn" data-type="isAll">验证是否全选</button>
		</div>
	<table class="layui-table"  id= "logTable"></table>
	<script src="/fangfq/layui/layui.js"></script>
	<script>
	layui.use('table', function(){
	  var table = layui.table;
	  //监听表格复选框选择
	  table.on('checkbox(demo)', function(obj){
	    console.log(obj)
	  }); 
	//执行渲染
	  table.render({
	    elem: '#logTable' //指定原始表格元素选择器（推荐id选择器）
	   // ,height: 500 //容器高度
	    ,url: '/fangfq/admin/system/query.do'
	    ,id: 'logTable'
	    ,page: true
	    ,request: {
	    	  pageName: 'curr' //页码的参数名称，默认：page
	    		  ,limitName: 'nums' //每页数据量的参数名，默认：limit
	    		}
	    ,response: {
	    	  statusName: 'code' //数据状态的字段名称，默认：code
	    		  ,statusCode: 200 //成功的状态码，默认：0
	    		  ,msgName: 'msg' //状态信息的字段名称，默认：msg
	    		  ,countName: 'count' //数据总数的字段名称，默认：count
	    		  ,dataName: 'data' //数据列表的字段名称，默认：data
	    		} 
	    ,cols: [[
	            {type:'checkbox', fixed: true},
	            {type:'numbers', width:60, title:'序号',  fixed: true},
	            {field:'fileName',  title:'文件名称',fixed: true},
	            {field:'fileSize', width:200,  title: '文件大小',fixed: true},
	            {field:'lastModifyTime', width:200,  title: '最后一次修改时间',fixed: true},
	            ]] //设置表头
	   
	  });
	  //监听工具条
	  table.on('tool(demo)', function(obj){
	    var data = obj.data;
	    if(obj.event === 'detail'){
	      layer.msg('ID：'+ data.id + ' 的查看操作');
	    } else if(obj.event === 'del'){
	      layer.confirm('真的删除行么', function(index){
	        obj.del();
	        layer.close(index);
	      });
	    } else if(obj.event === 'edit'){
	      layer.alert('编辑行：<br>'+ JSON.stringify(data))
	    }
	  });
	  var $ = layui.$, active = {
	    getCheckData: function(){ //获取选中数据
	      var checkStatus = table.checkStatus('logTable')
	      ,data = checkStatus.data;
	      if (data.length < 1) {
	    	  layer.msg('请选择一条数据')
	    	  return false;
	      } else if(data.length >1) {
	    	  layer.msg('只能选择一条数据')
	    	  return false;
	      }
	      layer.alert(JSON.stringify(data));
	    }
	    ,getCheckLength: function(){ //获取选中数目
	      var checkStatus = table.checkStatus('idTest')
	      ,data = checkStatus.data;
	      layer.msg('选中了：'+ data.length + ' 个');
	    }
	    ,isAll: function(){ //验证是否全选
	      var checkStatus = table.checkStatus('idTest');
	      layer.msg(checkStatus.isAll ? '全选': '未全选')
	    }
	  };
	  
	  $('.demoTable .layui-btn').on('click', function(){
	    var type = $(this).data('type');
	    active[type] ? active[type].call(this) : '';
	  });
	});
	</script>
</body>
</html>
