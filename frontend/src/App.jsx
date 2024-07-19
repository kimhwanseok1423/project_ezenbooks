import './App.css';
import { Route, Routes, useLocation } from 'react-router-dom';
import React from 'react';
import Home from './components/Home/Home';
import Header from './components/Shared/Header';
import MainTemplate from './components/Shared/MainTemplate';
import MultiTemplate from './components/Shared/MultiTemplate';
import BookDetail from './routes/BookDetail';
<<<<<<< HEAD
import CountList from './routes/CountList';
import SalesList from './routes/SalesList';
=======
import CartPage from './components/cart/CartPage';
import SearchList from './routes/SearchList';
import Admin from './routes/Admin';
import Mypage from './components/login/Mypage';
import Login from './components/login/Login';
import Register from './components/login/Register';
import Logout from './components/login/Logout';
import UserPick from './pages/UserPick';
import Bestseller from './routes/Bestseller';
import OrderFail from './components/order/OrderFail';
import OrderSuc from './components/order/OrderSuc';
import PayPage from './components/order/PayPage';
import BookDetailPageupdel from './pages/BookDetailPageupdel';
import BookUpdate from './pages/BookUpdate';
import Modify from './components/login/Modify';
import UserUpdatePage from './components/admin/UserUpdatePage';

// import NotFoundPage from './pages/NotFoundPage';
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42

function App() {
  const location = useLocation();
  console.log(location.pathname);

  return (
    <div className='App'>
      <Header />
      <Routes>
        <Route index element={<Home />} />
        <Route exact path='/' element={<Home />} />
        <Route path='/:menu/:id' element={<MultiTemplate />} />
        <Route path='/:menu' element={<MainTemplate />} />
        <Route path='/book/:id' element={<BookDetail name='category' />} />
        <Route path='/bestseller' element={<Bestseller />} />
        <Route path='/userpick' element={<UserPick />} />
        <Route path='/admin/userlist/update/:id' element={<UserUpdatePage />} />
        <Route path='/admin/booklist/:id' element={<BookDetailPageupdel />} />
        <Route path='/admin/booklist/update/:id' element={<BookUpdate />} />
        <Route path='/admin/:category' element={<Admin />} />
        <Route path='/cart' element={<CartPage />} />
<<<<<<< HEAD
        <Route path='/:admin/countlist' element={<CountList />} />
        <Route path='/admin/saleslist' element={<SalesList />} />
=======
        <Route path='/search' element={<SearchList name='category' />} />
        <Route
          path='/category/search'
          element={<SearchList name='category' />}
        />
        <Route path='/book/search' element={<SearchList name='category' />} />
        <Route path='/login' element={<Login />} />
        <Route path='/register' element={<Register />} />
        <Route path='/logout' element={<Logout />} />
        <Route path='/mypage/:id' element={<Mypage />} />
        <Route path='/modify/:id' element={<Modify />} />
        <Route path='/order' element={<PayPage />} />
        <Route path='/order/delete' element={<OrderFail />} />
        <Route path='/order/confirm' element={<OrderSuc />} />
        {/* <Route path='*' element={<NotFoundPage />} /> */}
>>>>>>> bdb1accde08a7a252b7433c0c4d0f343f4ad4d42
      </Routes>
    </div>
  );
}

export default App;
