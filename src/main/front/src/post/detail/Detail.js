import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';

const Detail = () => {
  const {id} = useParams(); //url id 매핑
  const [title , setTitle] = useState({});
  const [content , setContent] = useState({});

  useEffect(() => {
    axios.get(`http://127.0.0.1:8090/api/v1/post/detail/${id}`).then((response)=> {
      setTitle(response.data.title);
      setContent(response.data.content);
    })

  }, []);
  return (
    <div>
        <span>제목</span>
        <input type="text" name="title" value={title}  />
      

<div>
<span>내용</span>
<input type="text" name="content" value={content}  />
</div>
</div>

  );
}

export default Detail;