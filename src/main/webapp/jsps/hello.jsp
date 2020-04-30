<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <!-- element-ui的css样式 -->
    <link href="${pageContext.request.contextPath}/static/js/element-ui/index.css" rel="stylesheet">
    <title>Hello</title>
</head>
<body>
    <div id="app">
        <!-- 房源列表展示 -->
        <el-table :data="houseList" stripe style="width: 100%">
            <el-table-column prop="id" label="id" ></el-table-column>
            <el-table-column prop="areaName" label="所在区"></el-table-column>
            <el-table-column prop="rentModeName" label="方式"></el-table-column>
            <el-table-column prop="houseTypeName" label="户型"></el-table-column>
            <el-table-column prop="orientationName" label="朝向"></el-table-column>
            <el-table-column prop="rental" label="租金"></el-table-column>
            <el-table-column prop="address" label="地址"></el-table-column>
            <el-table-column label="图片">
                <tempalte slot-scope="scope">
                    <el-image :src="path + scope.row.pic" style="width:50px; height: 50px"></el-image>
                </tempalte>
            </el-table-column>
            <el-table-column prop="publishTime" label="发布时间"></el-table-column>
        </el-table>

        <div style="margin-top:20px">
            <el-pagination background
                           layout="prev, pager, next, sizes, total, jumper"
                           :total="total"
                           :page-sizes="[2, 4, 6,8]"
                           prev-text="<<"
                           next-text=">>"
                           @current-change="currentChange"
                           @size-change="sizeChange"
            >
            </el-pagination>
        </div>

    </div>
<script src="${pageContext.request.contextPath}/static/js/jquery/jquery.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/vue/vue.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/axios/axios.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/static/js/element-ui/index.js"></script>
<script>
    const path = "${pageContext.request.contextPath}";
    let vm = new Vue({
        el: '#app',
        data: {
            path: path,
            pageNum: 1,
            pageSize: 2,
            total: 0,
            houseList: [],
        },
        methods: {
            queryList() {
                axios.get(this.path + '/house/list', {
                    params: {
                        pageNum: this.pageNum,
                        pageSize: this.pageSize
                    }})
                .then(res => {
                    this.pageNum = res.data.pageNum;
                    this.pageSize = res.data.pageSize;
                    this.total = res.data.total;
                    this.houseList = res.data.rows;
                }).catch(error => {
                    console.log(error);
                });
            },
            // 当前页改变的时候，也就是点击具体的页码是触发
            currentChange(currentPage) {
                console.log('当前页：' + currentPage)
                this.pageNum = currentPage
                this.queryList()
            },
            //当每页条数改变时触发
            sizeChange(pageSize){
                console.log('pageSize' + pageSize)
                this.pageSize = pageSize
                this.queryList()
            }
        },
        created() {
            this.queryList();
        }
    });
</script>
</body>
</html>
