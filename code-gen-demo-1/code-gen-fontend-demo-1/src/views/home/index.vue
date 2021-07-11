<template>
  <div>
    <ul>
      <li class="ico1">用户昵称：{{ personalData.username }}</li>
      <li class="ico2">真实姓名：{{ personalData.userRealname }}</li>
      <!-- <li class="ico3">用户类型：{{personalData.userType==0?"开发员":personalData.userType==1?"系统管理员":"其他管理员"}}</li> -->
      <li class="ico4">角色：{{ roleName }}</li>
      <li class="ico5">邮箱：{{ personalData.email }}</li>
      <li class="ico6">电话号码：{{ personalData.mobile }}</li>
      <li class="ico7">上次登录时间：</li>
      <li class="lastli"><a @click="showForm">修改密码</a></li>
    </ul>
    <el-dialog
      title="修改密码"
       :visible.sync="formShow"
    >
      <el-form
        ref="formData"
        :model="formData"
        label-width="80px"
      >
        <el-form-item
          label="原密码"
          prop="password"
        >
          <el-input
            v-model="formData.password"
            placeholder="请输入原密码..."
          />
        </el-form-item>
        <el-form-item
          label="新密码"
          prop="newPassword"
        >
          <el-input
            v-model="formData.newPassword"
            placeholder="请输入新密码..."
          />
        </el-form-item>
      </el-form>
      <div
        slot="footer"
        class="dialog-footer"
      >
        <el-button
          size="mini"
          class="cancelbtn"
          @click="formShow = false"
        >
          取 消
        </el-button>
        <el-button
          type="primary"
          size="mini"
          class="submitbtn"
          @click="submitHandle"
        >
          确 定
        </el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { getUserInfo, updateUserPassword } from '@/api/sys.js'
import { formatDateFromTimestamp, cloneDeep } from '@/utils'
import md5 from 'js-md5'
export default {
  data() {
    return {
      personalData: {},
      roleName: '',
      formShow: false,
      formData: {
        password: '',
        newPassword: ''
      }
    }
  },
  created() {
    this.getPersonalInfo()
  },
  methods: {
    formatDateFromTimestamp(val) {
      return formatDateFromTimestamp(val)
    },
    getPersonalInfo() {
      getUserInfo().then((res) => {
        console.log('kkkkkkk', res)
        this.personalData = res.user
        //this.roleName = res.user.roleList.map(function(item) { return item.roleName }).join(',')
      })
    },
    showForm() {
      this.formShow = true
      this.formData.password = ''
      this.formData.newPassword = ''
    },
    submitHandle() {
      if (this.formData.password && this.formData.newPassword) {
        var parm = { password: '', newPassword: '' }
        parm.password = md5(this.formData.password)
        parm.newPassword = md5(this.formData.newPassword)
        updateUserPassword(parm).then((res) => {
          if (res.code === 0) {
            this.$message({
              message: '密码修改成功',
              type: 'success'
            })
            this.formShow = false
          }
        })
      }
    }
  }
}
</script>
<style scoped>
.contentBody .contentinner {
  padding: 0 !important;
}
.contentinner ul {
  width: 100%;
  overflow: hidden;
  padding: 20px 35px;
  box-sizing: border-box;
}
.contentinner ul li {
  float: left;
  width: 25%;
  overflow: hidden;
  height: 60px;
  /* line-height:59px; */
  font-size: 13px;
  color: #8e99af;
  box-sizing: border-box;
  padding-left: 65px;
  margin-bottom: 40px;
  padding-top: 18px;
}
.contentinner ul li.ico1 {
  background: url("../../assets/images/perico1.png") no-repeat left center;
  background-size: 50px 50px;
}
.contentinner ul li.ico2 {
  background: url("../../assets/images/perico4.png") no-repeat left center;
  background-size: 50px 50px;
}
.contentinner ul li.ico3 {
  background: url("../../assets/images/perico5.png") no-repeat left center;
  background-size: 50px 50px;
}
.contentinner ul li.ico4 {
  background: url("../../assets/images/perico7.png") no-repeat left center;
  background-size: 50px 50px;
}
.contentinner ul li.ico5 {
  background: url("../../assets/images/perico3.png") no-repeat left center;
  background-size: 50px 50px;
}
.contentinner ul li.ico6 {
  background: url("../../assets/images/perico2.png") no-repeat left center;
  background-size: 50px 50px;
}
.contentinner ul li.ico7 {
  background: url("../../assets/images/perico6.png") no-repeat left center;
  background-size: 50px 50px;
}
.contentinner ul li.lastli a {
  display: block;
  width: 100px;
  height: 34px;
  background: #266fff;
  border-radius: 23px;
  font-size: 13px;
  color: #fff;
  text-align: center;
  line-height: 34px;
  border: 1px solid #266fff;
}
.contentinner ul li.lastli {
  padding-left: 5px;
  padding-top: 0;
}
.contentinner ul li.lastli a:hover {
  border: 1px solid currentColor;
  color: #266fff;
  background: #fff;
}
.el-dialog {
  width: 400px;
}
</style>
