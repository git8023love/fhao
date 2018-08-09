$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'book/bookchapter/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '小说Id', name: 'noveid', index: 'noveId', width: 80 }, 			
			{ label: '章节名', name: 'name', index: 'name', width: 80 }, 			
			{ label: '第几章', name: 'chaptersort', index: 'chapterSort', width: 80 }, 			
			{ label: '章节内容', name: 'chaptercontext', index: 'chapterContext', width: 80 }			
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
		showList: true,
		title: null,
		bookChapter: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.bookChapter = {};
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
			var url = vm.bookChapter.id == null ? "book/bookchapter/save" : "book/bookchapter/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.bookChapter),
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
				    url: baseURL + "book/bookchapter/delete",
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
			$.get(baseURL + "book/bookchapter/info/"+id, function(r){
                vm.bookChapter = r.bookChapter;
            });
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
	}
});