<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="资讯id" prop="infoId">
        <el-input
          v-model="queryParams.infoId"
          placeholder="请输入资讯id"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资讯标题" prop="infoTitle">
        <el-input
          v-model="queryParams.infoTitle"
          placeholder="请输入资讯标题"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="资讯状态" prop="infoStates">
        <el-select v-model="queryParams.infoStates" placeholder="请输入资讯状态" clearable size="small" @keyup.enter.native="handleQuery">
          <el-option value="已停用" label="已停用"></el-option>
          <el-option value="正常" label="正常"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="资讯类型" prop="infoType">
        <el-select v-model="queryParams.infoType" placeholder="请选择资讯类型" clearable size="small" @keyup.enter.native="handleQuery" >
          <el-option value="科技资讯" label="科技资讯"></el-option>
          <el-option value="应用资讯" label="应用资讯"></el-option>
          <el-option value="娱乐资讯" label="娱乐资讯"></el-option>
          <el-option value="教育资讯" label="教育资讯"></el-option>
          <el-option value="行业资讯" label="行业资讯"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="排序" prop="infoSort">
        <el-input
          v-model="queryParams.infoSort"
          placeholder="请输入排序"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="是否首页" prop="isFpage">
        <el-input
          v-model="queryParams.isFpage"
          placeholder="请输入是否首页"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['system:information:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['system:information:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['system:information:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
		  :loading="exportLoading"
          @click="handleExport"
          v-hasPermi="['system:information:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="informationList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="资讯id" align="center" prop="infoId" />
      <el-table-column label="资讯标题" align="center" prop="infoTitle" />
      
      <!--<el-table-column label="资讯内容" align="center" prop="infoContent">
        <template slot-scope="scope" ><div v-html="scope.row.infoContent">
        </div></template>
      </el-table-column> -->
      
      <el-table-column label="资讯状态" align="center" prop="infoStates" />
      <el-table-column label="资讯类型" align="center" prop="infoType" />
      <el-table-column label="删除标志" align="center" prop="deleteFlag" />
      <el-table-column label="排序" align="center" prop="infoSort" />
      <el-table-column label="备注" align="center" prop="infoRemarks" />
      <el-table-column label="是否首页" align="center" prop="isFpage" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:information:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:information:remove']"
          >删除</el-button>
          
          <el-button
            size="mini"
            type="text"
            icon="el-icon-view"
            @click="handleView(scope.row)"
            v-hasPermi="['system:information:query']"
          >查看</el-button>
          </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改资讯对话框 -->
    <el-dialog :title="title1" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="资讯标题" prop="infoTitle">
          <el-input v-model="form.infoTitle" placeholder="请输入资讯标题" />
        </el-form-item>
        <el-form-item label="资讯内容">
          <editor v-model="form.infoContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="资讯状态" prop="infoStates">
          <el-select v-model="form.infoStates" placeholder="请输入资讯状态">
            <el-option value="已停用" label="已停用"></el-option>
            <el-option value="正常" label="正常"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="资讯类型" prop="infoType">
          <el-select v-model="form.infoType" placeholder="请选择资讯类型">
            <el-option value="科技资讯" label="科技资讯"></el-option>
            <el-option value="应用资讯" label="应用资讯"></el-option>
            <el-option value="娱乐资讯" label="娱乐资讯"></el-option>
            <el-option value="教育资讯" label="教育资讯"></el-option>
            <el-option value="行业资讯" label="行业资讯"></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="删除标志" prop="deleteFlag">
          <el-input v-model="form.deleteFlag" placeholder="请输入删除标志" />
        </el-form-item>
        <el-form-item label="排序" prop="infoSort">
          <el-input v-model="form.infoSort" placeholder="请输入排序" />
        </el-form-item>
        <el-form-item label="备注" prop="infoRemarks">
          <el-input v-model="form.infoRemarks" placeholder="请输入备注" />
        </el-form-item>
        <el-form-item label="是否首页" prop="isFpage">
          <el-select v-model="form.isFpage" placeholder="请输入是否首页">
            <el-option value="是" label="是"></el-option>
            <el-option value="否" label="否"></el-option>
          </el-select>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>


    <!-- 详情页面对话框 -->
    <el-dialog :title="title2" :visible.sync="detail_open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="资讯标题" prop="infoTitle">
          <el-input v-model="form.infoTitle" value="" />
        </el-form-item>
        <el-form-item label="资讯内容">
          <editor v-model="form.infoContent" :min-height="192"/>
        </el-form-item>
        <el-form-item label="资讯状态" prop="infoStates">
          <el-input v-model="form.infoStates" value="" />
        </el-form-item>
        <el-form-item label="资讯类型" prop="infoType">
          <el-input v-model="form.infoType" value="" />
            
        </el-form-item>
        <el-form-item label="删除标志" prop="deleteFlag">
          <el-input v-model="form.deleteFlag" value="" />
        </el-form-item>
        <el-form-item label="排序" prop="infoSort">
          <el-input v-model="form.infoSort" value="" />
        </el-form-item>
        <el-form-item label="备注" prop="infoRemarks">
          <el-input v-model="form.infoRemarks" value="" />
        </el-form-item>
        <el-form-item label="是否首页" prop="isFpage">
          <el-input v-model="form.isFpage" value="" />
        </el-form-item>

      </el-form> 
    </el-dialog>
  </div>
</template>

<script>
import { listInformation, getInformation, delInformation, addInformation, updateInformation, exportInformation } from "@/api/system/information";

export default {
  name: "Information",
  data() {
    return {
      //点击事件提示框
      title1: "",
      title2: "",
      // 遮罩层
      loading: true,
      // 导出遮罩层
      exportLoading: false,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 资讯表格数据
      informationList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 详情显示弹出层
      detail_open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        infoId: null,
        infoTitle: null,
        infoStates: null,
        infoType: null,
        infoSort: null,
        isFpage: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询资讯列表 */
    getList() {
      this.loading = true;
      listInformation(this.queryParams).then(response => {
        this.informationList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        infoId: null,
        infoTitle: null,
        infoContent: null,
        infoStates: null,
        infoType: null,
        deleteFlag: null,
        infoSort: null,
        infoRemarks: null,
        isFpage: null,
        infoViews: null,
        infoMassage: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null,
        isHotinfo: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.infoId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title1 = "添加资讯";
    },

    /** 详细按钮操作 */
    handleView(row) {
      this.detail_open = true;
      this.form = row;
      this.title2 = "资讯详情";
    },

    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const infoId = row.infoId || this.ids
      getInformation(infoId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title1 = "修改资讯";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.infoId != null) {
            updateInformation(this.form).then(response => {
              this.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addInformation(this.form).then(response => {
              this.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const infoIds = row.infoId || this.ids;
      this.$confirm('是否确认删除资讯编号为"' + infoIds + '"的数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(function() {
          return delInformation(infoIds);
        }).then(() => {
          this.getList();
          this.msgSuccess("删除成功");
        }).catch(() => {});
    },

    
    
   
handleExport() {
      const queryParams = this.queryParams;
      this.$confirm('是否确认导出所有资讯数据项?', "警告", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          this.exportLoading = true;
          return exportInformation(queryParams);
        }).then(response => {
          this.download(response.msg);
          this.exportLoading = false;
        }).catch(() => {});
    }
  }
};
</script>