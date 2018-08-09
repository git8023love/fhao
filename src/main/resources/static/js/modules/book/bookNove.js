$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'book/booknove/list',
        datatype: "json",
        colModel: [			
			/*{ label: 'id', name: 'id', index: 'id', width: 50, key: true },*/
			{ label: '小说名', name: 'name', index: 'name', width: 40 },
			{ label: '分类', name: 'styleName', index: 'styleName', width: 40 },
			{ label: '图片路径', name: 'noveimgurl', index: 'noveImgUrl', width: 80 }, 			
			{ label: '该文章原本的地址(便于后期更新)', name: 'noveurl', index: 'noveUrl', width: 50 },
			{ label: '小说简介', name: 'synopsis', index: 'synopsis', width: 180 }
        ],
		viewrecords: true,
        height: "100%",
        rowNum: 50,
		rowList : [50,100,200],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rapp',
	data:{
        q:{
            keyword: null
        },
		showList: true,
		title: null,
		bookNove: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.bookNove = {};
		},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function () {
			var url = vm.bookNove.id == null ? "book/booknove/save" : "book/booknove/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.bookNove),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function () {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "book/booknove/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(){
                                vm.reload();
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "book/booknove/info/"+id, function(r){
                vm.bookNove = r.bookNove;
            });
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page,
				postData:{'keyword': vm.q.keyword},
            }).trigger("reloadGrid");
		},
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
	}
});