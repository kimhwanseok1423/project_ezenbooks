import AdminMenu from '../pages/AdminMenu';

import CountListPage from '../pages/CountLIstPage';

const CountList = () => {
  return (
    <div className='container-fluid d-flex'>
      <div className='col-1'>
        <AdminMenu />
      </div>
      <div className='col-11 p-0'>
        <CountListPage />
      </div>
    </div>
  );
};

export default CountList;
