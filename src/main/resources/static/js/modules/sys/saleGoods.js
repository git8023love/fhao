$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/salegoods/list',
        datatype: "json",
        colModel: [			
			/*{ label: 'id', name: 'id', index: 'id', width: 50, key: true },*/
			{ label: '商品条码', name: 'vgno', index: 'vgno', width: 80 }, 			
			{ label: '商品编号', name: 'goodsNo', index: 'goods_no', width: 80 }, 			
			{ label: '商品中文名称', name: 'goodsName', index: 'goods_name', width: 80 }, 			
			{ label: '商品英文名称', name: 'englishName', index: 'english_name', width: 80 }, 			
			{ label: '售价', name: 'price', index: 'price', width: 80 }, 			
			{ label: '供应商', name: 'supplyName', index: 'supply_id', width: 80 }, 			
			{ label: '商品类型', name: 'categoryName', index: 'category_id', width: 80 }, 			
			{ label: '创建时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '更新时间', name: 'updateTime', index: 'update_time', width: 80 }			
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
var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl"
        }
    }
};

var ztree;

var vm = new Vue({
	el:'#rapp',
	data:{
		showList: true,
		title: null,
		saleGoods: {
			categoryName:null,
			categoryId:0,
            delFlag:0
		},
	
	},
	methods: {
		getSaleCategory: function(){
            //加载类别树
            $.get(baseURL + "sys/saleCategory/select", function(r){
                ztree = $.fn.zTree.init($("#saleCategoryTree"), setting, r.saleCategoriesList);
                var node = ztree.getNodeByParam("id", vm.saleGoods.categoryId);

                vm.saleGoods.categoryName = node.name;
            })
        },
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.saleGoods = {parentName:null,categoryId:0,delFlag:0};
			vm.getSaleCategory();
		},
		update: function () {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.getSaleCategory();
            vm.getInfo(id)
		},
		saveOrUpdate: function () {
			var url = vm.saleGoods.id == null ? "sys/salegoods/save" : "sys/salegoods/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.saleGoods),
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
				    url: baseURL + "sys/salegoods/delete",
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
			$.get(baseURL + "sys/salegoods/info/"+id, function(r){
                vm.saleGoods = r.saleGoods;
            });
		},
		reload: function () {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		},
		saleCategoryTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择类别",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#saleCategoryLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    vm.saleGoods.categoryId = node[0].id;
                    vm.saleGoods.categoryName = node[0].name;

                    layer.close(index);
                }
            });
        },
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
	}
});