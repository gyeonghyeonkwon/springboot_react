
import axios from "axios";
import { useEffect, useState } from "react";
import BasicLayout from "../../layouts/BasicLayout";
import { Link, useParams } from "react-router-dom";

const PostList = () => {
  const [PostList, setList] = useState([]);
  const {id} = useParams;
  useEffect(() => {
    const getPostList = async () => {
      try {
        const response = await axios.get('http://127.0.0.1:8090/api/v1/post/list');
        setList(response.data); // 서버에서 받은 데이터를 상태에 설정
      } catch (error) {
        console.error('글을 불러 올 수 없습니다 :', error);
      }
    };

    getPostList(); // 컴포넌트가 마운트될 때 게시글 목록을 가져오는 함수 호출
  }, [id]); // 빈 배열을 두어 한 번만 호출되도록 설정


  return (
<BasicLayout>
<div className="overflow-x-auto">
      <table className="table">
        {/* 테이블 헤더 */}
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>생성일</th>
          </tr>
        </thead>
        <tbody>
          {PostList.map((postDto) => (
            <tr key={postDto.id}>
              <td>{postDto.id}</td>
              <td> <Link to={`/post/detail/${postDto.id}`}>{postDto.title}</Link></td>            
              <td>{postDto.content}</td>
              <td>{postDto.createDate}</td>
              
            </tr>
          ))}
        </tbody>
      </table>
    </div>
    </BasicLayout>
  );
};


export default PostList; 
