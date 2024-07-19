import React from 'react';
import BookSearch from '../pages/BookSearch';
import Categories from '../pages/Categories';

const SearchList = () => {
  const menu = 'category';

  return (
    <div className='container-fluid d-flex'>
      <div className='col-xl-2 col-lg-2 mt-2'>
        <Categories name={menu} />
      </div>
      <div className='col-xl-10 col-lg-10 container-fluid mt-3'>
        <BookSearch />
      </div>
    </div>
  );
};
export default SearchList;
