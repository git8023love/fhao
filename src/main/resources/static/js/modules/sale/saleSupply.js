$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sale/salesupply/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '供应商名称', name: 'name', index: 'name', width: 80 }, 			
			/*{ label: '供应商缩写', name: 'shortname', index: 'shortName', width: 80 }, 	
			{ label: '付款单位', name: 'unitname', index: 'unitName', width: 80 }, */				
			{ label: '地址', name: 'address', index: 'address', width: 80 }, 			
			{ label: '网址', name: 'www', index: 'www', width: 80 }, 			
			{ label: '邮箱', name: 'email', index: 'email', width: 80 }, 			
			{ label: '公司电话', name: 'telno', index: 'telNo', width: 80 }, 			
			{ label: '公司传真', name: 'faxno', index: 'faxNo', width: 80 }, 			
			{ label: '联系人', name: 'cman', index: 'cman', width: 80 }, 			
			{ label: '传呼/手机', name: 'bpno', index: 'bPNo', width: 80 }, 			
			/*{ label: '邮政编码', name: 'zipno', index: 'zipNo', width: 80 }, 			
			{ label: '开户银行', name: 'khbank', index: 'kHBank', width: 80 }, 			
			{ label: '银行帐号', name: 'accno', index: 'accNo', width: 80 }, 			
			{ label: '经营范围', name: 'bscope', index: 'bScope', width: 80 }, 			
			{ label: '纳税号', name: 'taxno', index: 'taxNo', width: 80 }, 			
			{ label: '法人代表', name: 'juridicalperson', index: 'juridicalPerson', width: 80 }, 			
			{ label: '条码', name: 'barcodefee', index: 'barCodeFee', width: 80 }, 			
			{ label: '谈判级别', name: 'negotiationlevel', index: 'negotiationLevel', width: 80 }, 			
			{ label: '代理级别', name: 'agencylevel', index: 'agencyLevel', width: 80 }, 			
			{ label: '省份', name: 'povince', index: 'povince', width: 80 }, 			
			{ label: '城市', name: 'city', index: 'city', width: 80 }, 			
			{ label: '县/区', name: 'district', index: 'district', width: 80 }, 			
			{ label: '区域标志', name: 'areaflag', index: 'areaFlag', width: 80 }, 			
			{ label: '供应商类型', name: 'supplytype', index: 'supplyType', width: 80 },*/ 			
			{ label: '经营类型 ', name: 'supregionflag', index: 'supRegionFlag', width: 80 }			
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
		saleSupply: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.saleSupply = {};
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
			var url = vm.saleSupply.id == null ? "sale/salesupply/save" : "sale/salesupply/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.saleSupply),
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
				    url: baseURL + "sale/salesupply/delete",
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
			$.get(baseURL + "sale/salesupply/info/"+id, function(r){
                vm.saleSupply = r.saleSupply;
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