import { Suspense, lazy } from "react";
const { createBrowserRouter } = require("react-router-dom");

const Loading = <span className="loading loading-spinner loading-lg"></span>//로딩

const Main = lazy(() => import("../pages/MainPage")) //보여질 메인페이지 
const Login = lazy(() => import("../pages/member/LoginPage")) //보여질 로그인 페이지 
const List = lazy(() => import("../post/list/PostList")) //보여질 리스트 페이지 
const Write = lazy(() => import("../post/create/Write")) //보여질 글작성 페이지 

const root = createBrowserRouter ([
  
  {
    path: "",
    element: <Suspense fallback={Loading}><Main/></Suspense>
  },
  {
    path: "member/login", //이동할 경로 
    element: <Suspense fallback={Loading}><Login/></Suspense>
  },
  {
    path: "post/list", //이동할 경로 
    element: <Suspense fallback={Loading}><List/></Suspense>
  },
  {
    path: "post/write", //이동할 경로 
    element: <Suspense fallback={Loading}><Write/></Suspense>
  },
  {
    path: "post/modify", //이동할 경로 
    element: <Suspense fallback={Loading}><Write/></Suspense>
  }
])

export default root;
