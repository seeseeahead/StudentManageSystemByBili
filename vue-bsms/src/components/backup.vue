<!-- <template>
    <div id="app">
      <!-- 居中：占8列，偏移量为2，左右偏移2，共占12。 -->
      <div class="col-8 offset-2"> 
        <!-- 定义table的属性：说明文字caption置顶，table-hover鼠标进入表格阴影效果，table-striped表格斑马线色彩显示（本项目不用） -->
        <table class="table caption-top table-hover">
          <caption class="text-center">
            <h1>学生管理系统</h1>
            <el-button type="primary" @click="getStudents">获取学生信息</el-button>
            <el-button type="warning" @click="dialogVisible = true">点击添加学生信息</el-button>
            <el-dialog
              title="提示"
              :visible.sync="dialogVisible"
              width="30%"
              :before-close="handleClose">
              <div>添加学生信息</div>
              <span slot="footer" class="dialog-footer">
                <el-button @click="dialogVisible = false">取消</el-button>
                <el-button type="primary" @click="addStudent">添加</el-button>
              </span>
              <div>
                <span>学号</span><input v-model="newStudent.number"/>
              </div>
              <div>
                <span>姓名</span><input v-model="newStudent.name"/>
              </div>
              <div>
                <span>年龄</span><input v-model="newStudent.age"/>
              </div>
              <div>
                <span>语文</span><input v-model="newStudent.chi"/>
              </div>
              <div>
                <span>数学</span><input v-model="newStudent.math"/>
              </div>
              <div>
                <span>英语</span><input v-model="newStudent.eng"/>
              </div>
            </el-dialog>
          </caption>
          <thead>
            <tr>
              <th scope="col">学号</th>
              <th scope="col">姓名</th>
              <th scope="col">年龄</th>
              <th scope="col">语文成绩</th>
              <th scope="col">数学成绩</th>
              <th scope="col">英语成绩</th>
              <th scope="col">操作</th>
            </tr>
          </thead>
          <tbody>
            <!-- 遍历数组students并把数据传给Student -->
            <StudentS v-for="stu in students_for_page" :key="stu.id" :student="stu"></StudentS>
          </tbody>
        </table>
        <!-- 使此div里的按钮居中 -->
        <div class="text-center">
          <el-button-group>
            <el-button type="primary" icon="el-icon-arrow-left" @click="last_page">上一页</el-button>
            <el-button type="primary" @click="next_page">下一页<i class="el-icon-arrow-right el-icon--right"></i></el-button>
          </el-button-group>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  import StudentS from './components/StudentS.vue';//引入Students页面
  export default {
    name: 'App',
    components: {//在父组件中，使用'components'属性，将刚才导入的comment组件，注册为自己的子组件。
     StudentS
    },
    data(){
        return{
          page:1,//页码
          students:[],//空列表
          dialogVisible: false,
          newStudent:{
            number:"",
            name:"",
            age:"",
            chi:"",
            math:"",
            eng:"",
          }
        }
      },
    methods:{
      getStudents() {//用axios函数请求调用后端数据
        axios({
          url: "http://localhost:8080/students",
          method: "GET",
        }).then(res => {
          console.log(res.data);
          this.students = res.data;
        })
      },
      handleClose(done) {
        this.$confirm('确认关闭？')
          .then(() => {
            done();
          })
          .catch(() => { });
      },
      addStudent(){
        axios({
          url: "http://localhost:8080/add",
          method: "POST",
          data:this.newStudent
        })
        this.dialogVisible = false,
        location.reload();
      },
      last_page(){
        this.page -= 1
      },
      next_page(){
        this.page += 1
      }
    },
    computed: {
      students_for_page(){
        return this.students.slice(this.page * 5 - 5,this.page * 5);//切片，第一页返回0~5条数据，后续递增
      }
    }
  }
  </script>
  
  <style>
  
  </style>
   -->