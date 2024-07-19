import AdminMenu from '../pages/AdminMenu';
import BookListPage from '../pages/BookListPage';
import SalesListPage from '../pages/SalesListPage';

const SalesList = () => {
  return (
    <div className='container-fluid d-flex'>
      <div className='col-1'>
        <AdminMenu />
      </div>
      <div className='col-11 p-0'>
        <SalesListPage />
      </div>
    </div>
  );
};

export default SalesList;
