import '../../css/style.css';
import '../../css/userlist.css';
import React from 'react';

const AdminMenu = () => {
  return (
    <div className='adminpage-wrap container-fluid d-flex mt-3'>
      <div className='adminpage-menu column-row'>
        <ul>
          <a href='/admin/user'>
            <li>회원 관리</li>
          </a>
          <a href='/admin/book'>
            <li>상품 관리</li>
          </a>
<<<<<<< HEAD:frontend/src/pages/AdminMenu.js
          <li>리뷰 관리</li>
          <a>
            <a href='/admin/SalesList'>
              <li>회계 분석 </li>
            </a>
=======
          <a href='/admin/review'>
            <li>리뷰 관리</li>
          </a>
          <a href='/admin/sales'>
            <li>매출 관리</li>
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42:frontend/src/components/admin/AdminMenu.js
          </a>
        </ul>
      </div>
    </div>
  );
};

export default AdminMenu;
