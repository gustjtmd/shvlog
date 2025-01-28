<script setup lang="ts">
import { reactive } from "vue";
import SignUp from "@/entity/user/SignUp";
import { ElMessage } from "element-plus";
import type HttpError from '@/http/HttpError'
import { container } from "tsyringe";
import UserRepository from "@/repository/UserRepository";


const state = reactive({
  signup: new SignUp(),
});

const USER_REPOSITORY = container.resolve(UserRepository);

function doSignUp() {
  USER_REPOSITORY.signUp(state.signup)
  .then(() => {
    alert(`${state.signup.name}님 회원 가입이 완료되었습니다.`);
    ElMessage({ type: 'success', message: '환영합니다 :)' })
    location.href = '/'
  })
  .catch((e: HttpError) => {
    ElMessage({ type: 'error', message: e.getMessage() })
  })
}
</script>

<template>
  <el-row>
    <el-col :span="10" :offset="7">
      <el-form label-position="top">
        <el-form-item label="이름">
          <el-input v-model="state.signup.name"></el-input>
        </el-form-item>
        <el-form-item label="이메일">
          <el-input v-model="state.signup.email"></el-input>
        </el-form-item>
        <el-form-item label="비밀번호">
          <el-input type="password" v-model="state.signup.password"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" style="width: 100%" @click="doSignUp()">회원가입</el-button>
        </el-form-item>
      </el-form>
    </el-col>
  </el-row>
</template>


