import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom'; 


const PostModify = () => {
  const {id} = useParams(); //url id 매핑
  const [formData, setFormData] = useState({
    title: '',
    content: '',
  });

  useEffect(() => {
    if (id) {
      getBoard();
    }
  }, [id]);

  const getBoard = async () => {
    try {
      const response = await axios.get(`http://127.0.0.1:8090/api/v1/post/modify/${id}`);
      setFormData(response.data);
    } catch (error) {
      console.error('Error fetching post:', error);
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevFormData) => ({
      ...prevFormData,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!formData.title.trim()) {
      alert('제목을 입력해주세요.');
      return;
    }

    if (!formData.content.trim()) {
      alert('내용을 입력해주세요.');
      return;
    }

    try {
      const response = await axios.put(`http://127.0.0.1:8090/api/v1/post/modify/${id}`, formData);
      alert('수정되었습니다.');
      console.log('글 수정 성공:', response.data);
      // 글 수정 후 다음 단계로 이동하거나 필요한 작업을 수행합니다.
      window.location.href = '/'; //글 수정 후 리스트로 이동
    } catch (error) {
    }
  };

  return (
    <div>
      <h2>게시물 수정</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>제목:</label>
          <input type="text" name="title" value={formData.title} onChange={handleChange} />
        </div>
        <div>
          <label>내용:</label>
          <textarea name="content" cols="30" rows="10" value={formData.content} onChange={handleChange}></textarea>
        </div>
        <button type="submit">수정 완료</button>
      </form>
    </div>
  );
};

export default PostModify;