import '../../css/mypage.css';
import React from 'react';
import axios from 'axios';
import { useCallback, useEffect, useState } from 'react';
import { baseUrl } from '../commonApi/mainApi';
import Swal from 'sweetalert2';

const Mypage = () => {
  const [user, setUser] = useState('');
  const username = localStorage.getItem('username');

  useEffect(() => {
    getUser();
  }, []);

  const getUser = useCallback(async () => {
    try {
      const response = await axios.get(baseUrl + '/user/' + username);
      setUser(response.data);
    } catch (error) {
      console.log(error);
    }
  }, []);

  function userWithdraw() {
    Swal.fire({
      text: '탈퇴하시겠습니까?',
      showDenyButton: true,
      showCancelButton: true,
      showConfirmButton: false,
      cancelButtonText: '아니오',
      denyButtonText: '탈퇴',
      width: 400,
    });
  }

  //nickname 변경
  function nickChange() {
    Swal.fire({
      title: '변경할 이름을 입력하세요',
      input: 'text',
      inputAttributes: {
        autocapitalize: 'off',
      },
      showCancelButton: true,
      confirmButtonText: '수정',
      cancelButtonText: '취소',
      showLoaderOnConfirm: true,
      preConfirm: (login) => {
        return fetch(`//api.github.com/users/${login}`)
          .then((response) => {
            if (!response.ok) {
              throw new Error(response.statusText);
            }
            return response.json();
          })
          .catch((error) => {
            Swal.showValidationMessage(`다시 입력해주세요: ${error}`);
          });
      },
      allowOutsideClick: () => !Swal.isLoading(),
    }).then((result) => {
      if (result.isConfirmed) {
        Swal.fire({
          title: `${result.value.login}'s avatar`,
          imageUrl: result.value.avatar_url,
        });
      }
    });
  }

  return (
    <div className='mypage-wrapper container columns-low col-8'>
      <div className='mypage-title'>Mypage</div>
      <div className='mypage-username'>ID : {user.user_name}</div>
      <div className='mypage-user-email'>Email : {user.user_email}</div>
      <div className='mypage-user-nickname'>
        Nickname : {user.user_nickname}
        <button className='btn btn-search nickname-edit' onClick={nickChange}>
          수정하기
        </button>
      </div>
      <div className='mypage-create-date'>
        가입일 : {user.create_date}
        <button className='btn btn-search user-withdraw' onClick={userWithdraw}>
          탈퇴하기
        </button>
      </div>
    </div>
  );
};

export default Mypage;
