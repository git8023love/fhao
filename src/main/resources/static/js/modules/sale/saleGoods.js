$(function () {
    $('#jqGrid').jqGrid({
        url: baseURL + 'sale/salegoods/list',
        datatype: 'json',
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
        height: '100%',
        rowNum: 50,
        rowList : [50,100,200],
        rownumbers: true,
        rownumWidth: 25,
        autowidth:true,
        multiselect: true,
        pager: '#jqGridPager',
        jsonReader : {
            root: 'page.list',
            page: 'page.currPage',
            total: 'page.totalPage',
            records: 'page.totalCount'
        },
        prmNames : {
            page:'page',
            rows:'limit',
            order: 'order'
        },
        gridComplete:function(){
            //隐藏grid底部滚动条
            $('#jqGrid').closest('.ui-jqgrid-bdiv').css({ 'overflow-x' : 'hidden' });
        }
    });
});

var saleGoodsTree;

var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: 'id',
            pIdKey: 'parentId',
            rootPid: 0
        },
        key: {
            url: 'nourl'
        }
    }
}

var vm = new Vue({
    el:'#rapp',
    data:{
        q:{
            keyword: null
        },
        showList: true,
        title: null,
        saleGoods: {
            categoryName:null,
            categoryId:null,
            delFlag:0
        },

    },
    methods: {
        //查詢
        query: function () {
            vm.reload();
        },

        //新增
        add: function () {
            vm.showList = false;
            vm.title = '新增';
            vm.saleGoods = {categoryName: null, categoryId: null, delFlag: 0};
            vm.getSaleCategory();
        },

        //加载分类树
        getSaleCategory: function () {
            $.get(baseURL + 'sale/saleCategory/list', function (r) {
                saleGoodsTree = $.fn.zTree.init($('#saleCategoryTree'), setting, r);
                var node = saleGoodsTree.getNodeByParam('id', vm.saleGoods.categoryId);
                if (node != null) {
                    saleGoodsTree.selectNode(node);
                    vm.saleGoods.categoryName = node.categoryName;
                }
            })
        },

        //选择分类树
        saleCategoryTree: function () {
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: '选择类别',
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery('#saleCategoryLayer'),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = saleGoodsTree.getSelectedNodes();
                    //选择上级类别
                    vm.saleGoods.categoryId = node[0].id;
                    vm.saleGoods.categoryName = node[0].name;

                    layer.close(index);
                }
            })
        },

        //修改
        update: function () {
            var id = getSelectedRow();
            if (id == null) {
                return ;
            }
            vm.showList = false;
            vm.title = '修改';
            vm.getSaleCategory();//加载分类树
            vm.getInfo(id); //加载修改信息
        },

        //根据id查找商品信息
        getInfo: function (id) {
            $.get(baseURL + 'sale/salegoods/info/'+id, function (r) {
                vm.saleGoods = r.saleGoods;
            })
        },

        //删除
        del: function () {
            var ids = getSelectedRow();
            if (ids == null) {
                return ;
            }
            confirm('确定要删除选中的记录？', function (r) {
                $.ajax({
                    type: 'POST',
                    url: baseURL + 'sale/salegoods/delete',
                    contentType: 'application/json',
                    data: JSON.stringify(ids),
                    success: function (r) {
                        if (r.code === 0) {
                            alert('操作成功', function () {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },

        //保存
        saveOrUpdate: function () {
            var url = vm.saleGoods.id == null ? 'sale/salegoods/save' : 'sale/salegoods/update';
            $.ajax({
                type: 'POST',
                url: baseURL + url,
                contentType: 'application/json',
                data: JSON.stringify(vm.saleGoods),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function () {
                            vm.reload();
                        })
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },

        //加载jqGrid
        reload: function () {
            vm.showList = true;
            var page = $('#jqGrid').jqGrid('getGridParam','page');
            $('#jqGrid').jqGrid('setGridParam',{
                postData:{'keyword': vm.q.keyword},
                page: page
            }).trigger('reloadGrid');
        },

        //刷新
        refresh: function () {
            vm.showList = true;
            window.location.reload();
        }
    }
});