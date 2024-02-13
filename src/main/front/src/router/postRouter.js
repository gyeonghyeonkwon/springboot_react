// import React, { Suspense, lazy } from 'react';
// const Loading = <span className="loading loading-spinner loading-lg"></span>//로딩
// const PostList = lazy(() => import("../post/list/PostList")) //보여질 리스트 페이지 
// const Write = lazy(() => import("../post/create/Write")) //보여질 글작성 페이지 

// const postRouter = () => {
//   return (
//     [
        
//           {
//             path: "post/list", //글 리스트 이동 
//             element: <Suspense fallback={Loading}><PostList/></Suspense>
//           },
//           {
//             path: "post/write", //글 작성 이동
//             element: <Suspense fallback={Loading}><Write/></Suspense>
//           },
          
//     ]
//   );
// }

// export default postRouter;