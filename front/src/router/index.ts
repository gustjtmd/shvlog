import { createRouter, createWebHistory } from "vue-router";
import HomeView from "@/views/HomeView.vue";
import WriteView from "@/views/WriteView.vue";
import ReadView from "@/views/ReadView.vue";
import LoginView from "@/views/LoginView.vue";
import SignUpView from "@/views/SignUpView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "home",
      component: HomeView,
    },
    {
      path: "/write",
      name: "write",
      component: WriteView,
    },
    {
      path: "/signup",
      name: "signup",
      component: SignUpView,

    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
    },
    {
      path: "/post/:postId",
      name: "post",
      component: ReadView,
      props: true,
    },
  ],
});

export default router;
