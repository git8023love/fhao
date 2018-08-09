var vm = new Vue({
    el:'#rapp',
    data:{
        showList: true,
        title: null,
        bookStyle:{
        }
    },
    methods: {
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.bookStyle = {};
        },
        update: function () {
            var id = getBookStyleId();
            if(id == null){
                return ;
            }
            vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
        },
        saveOrUpdate: function () {
            var url = vm.bookStyle.id == null ? "book/bookstyle/save" : "book/bookstyle/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.bookStyle),
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
            var ids = getBookStyleId();
            if(ids == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "book/bookstyle/delete",
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
			$.get(baseURL + "book/bookstyle/info/"+id, function(r){
				vm.bookStyle = r.bookStyle;
			});
		},
        reload: function () {
            vm.showList = true;
            Menu.table.refresh();
        },
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
    }
});

var BookStyle = {
    id: "bookStyleTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
BookStyle.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        /*{title: '菜单id', field: 'id', visible: false, align: 'center', valign: 'middle', width: '80px'},*/
        {title: '分类名称', field: 'name', align: 'center', valign: 'middle', sortable: true, width: '160px'},
        {title: '上级分类', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '160px'},
        {title: '排序', field: 'remd', align: 'center', valign: 'middle', sortable: true, width: '160px'}]
    return columns;
};

function getBookStyleId () {
    var selected = $('#bookStyleTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return;
    } else {
        return selected[0].id;
    }
}

$(function () {
    var colunms = BookStyle.initColumn();
    var table = new TreeTable(BookStyle.id, baseURL + "book/bookstyle/list", colunms);
    table.setExpandColumn(2);
    table.setIdField("id");
    table.setCodeField("id");
    table.setParentCodeField("parentId");
    table.setExpandAll(false);
    table.init();
    BookStyle.table = table;
});
