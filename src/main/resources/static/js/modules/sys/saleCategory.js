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
        saleCategory:{
            parentName:null,
            parentId:0,
            delFlag:0
        }
    },
    methods: {
        getSaleCategory: function(){
            //加载类别树
            $.get(baseURL + "sys/saleCategory/select", function(r){
                ztree = $.fn.zTree.init($("#saleCategoryTree"), setting, r.saleCategoriesList);
                var node = ztree.getNodeByParam("id", vm.saleCategory.parentId);

                vm.saleCategory.parentName = node.name;
            })
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.saleCategory = {parentName:null,parentId:0,delFlag:0};
            vm.getSaleCategory();
        },
        update: function () {
            var categoryId = getCategoryId();
            if(categoryId == null){
                return ;
            }

            $.get(baseURL + "sys/saleCategory/info/"+categoryId, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.saleCategory = r.saleCategory;

                vm.getSaleCategory();
            });
        },
        del: function () {
            var categoryId = getCategoryId();
            if(categoryId == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/saleCategory/delete",
                    data: "categoryId=" + categoryId,
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
            });
        },
        saveOrUpdate: function (event) {
            var url = vm.saleCategory.id == null ? "sys/saleCategory/save" : "sys/saleCategory/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.saleCategory),
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
                    vm.saleCategory.parentId = node[0].id;
                    vm.saleCategory.parentName = node[0].name;

                    layer.close(index);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            SaleCategory.table.refresh();
        },
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
    }
});

var SaleCategory = {
    id: "saleCategoryTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
SaleCategory.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '类别名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '上级类别', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '是否有效', field: 'delFlag', align: 'center', valign: 'middle', sortable: true, width: '100px',
        	formatter:function(item,row,index){
        		return (item.delFlag == 0 ? "是" : "否");
        	}
        }]
    return columns;
};


function getCategoryId () {
    var selected = $('#saleCategoryTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return;
    } else {
        return selected[0].id;
    }
}


$(function () {
    $.get(baseURL + "sys/saleCategory/info", function(r){
        var colunms = SaleCategory.initColumn();
        var table = new TreeTable(SaleCategory.id, baseURL + "sys/saleCategory/list", colunms);
        table.setRootCodeValue(r.id);
        table.setExpandColumn(2);
        table.setIdField("id");
        table.setCodeField("id");
        table.setParentCodeField("parentId");
        table.setExpandAll(false);
        table.init();
        SaleCategory.table = table;
    });
});
