import axios from "axios";
import { useEffect, useState } from "react";

const Write = () => {

  const [formData, setFormData] = useState({
    title: '',
    content: '',
  });
  const { title,  content } =  formData;

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await axios.post('/api/v1/post', formData).then((res) => {
        alert('등록되었습니다.');
      });
      console.log('글 생성 성공:', response.data);
      // 글 생성 후 다음 단계로 이동하거나 필요한 작업을 수행합니다.
    } catch (error) {
      console.error('글 생성 실패:', error);
    }
  };


  return (

<div>
      <div>
        <span>제목</span>
        <input type="text" name="title" value={title} onChange={handleChange} />
      </div>
      <br />
      
      <br />
      <div>
        <span>내용</span>
        <textarea
          name="content"
          cols="30"
          rows="10"
          value={content}
          onChange={handleChange}
        ></textarea>
      </div>
      <br />
      <div>
        <button onClick={handleSubmit}>저장</button>
      </div>
    </div>
  );
};

export default Write;
