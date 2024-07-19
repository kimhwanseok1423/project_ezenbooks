import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { baseUrl } from '../components/commonApi/mainApi';
import Pagination from '../components/Shared/Pagination';
import Table from 'react-bootstrap/Table';
import '../css/bootstrap.min.css';
import '../css/saleslistpage.css';

const SalesListPage = () => {
  const [book, setbook] = useState([]);
  const [limit, setLimit] = useState(5);
  const [page, setPage] = useState(1);
  const currentDate = new Date();
  const currentYearMonth = currentDate.toISOString().slice(0, 7); // YYYY-MM 형식으로 반환
  const [startDate, setStartDate] = useState(currentYearMonth);
  const [endDate, setEndDate] = useState(currentYearMonth);
  const offset = (page - 1) * limit;

  console.log(startDate);

  useEffect(() => {
    getbook(startDate, endDate);
  }, [startDate, endDate]);

  async function getbook(startDate, endDate) {
    const response = await axios.get(baseUrl + '/Saleslist');
    setbook(
      response.data.filter((book) => {
        const bookYearMonth = book.month.slice(0, 7);
        return bookYearMonth >= startDate && bookYearMonth <= endDate;
      })
    );
  }

  function handleStartDateChange(e) {
    setStartDate(e.target.value);
  }

  function handleEndDateChange(e) {
    setEndDate(e.target.value);
  }
  return (
    <div className='bookPage-Wrap container-fluid col-xl-12 col-lg-12'>
      <div className='booklist-topmenu d-flex justify-content-between'>
        <div className='set_pages'>
          <label>
            페이지 당 표시할 게시물 수&nbsp;&nbsp;:&nbsp;&nbsp;
            <select
              type='number'
              value={limit}
              onChange={({ target: { value } }) => setLimit(Number(value))}
            >
              <option value='5'>5</option>
              <option value='10'>10</option>
              <option value='25'>25</option>
              <option value='50'>50</option>
            </select>
          </label>
          <div className='row date-range'>
            <label>
              시작 날짜:&nbsp;&nbsp;
              <input
                type='month'
                value={startDate}
                onChange={handleStartDateChange}
              />
            </label>
            <label>
              종료 날짜:&nbsp;&nbsp;
              <input
                type='month'
                value={endDate}
                onChange={handleEndDateChange}
              />
            </label>
          </div>
        </div>
        <div className='booklist-topmenu-modify'></div>
      </div>
      <div className='row'>
        <div className='card'>
          <table className='table mb-0' id='booklist-title'>
            <thead>
              <tr>
                <th scope='col' className='book_num1'>
                  날짜
                </th>
                <th scope='col' className='book_category1'>
                  카테고리
                </th>

                <th scope='col' className='book_price1'>
                  가격
                </th>
              </tr>
            </thead>
          </table>
          {book.slice(offset, offset + limit).map((book, index) => {
            return (
              <React.Fragment key={index}>
                <Table className='book_data'>
                  <tbody>
                    <tr>
                      <th scope='row' className='book_num'>
                        {book.month}
                      </th>
                      <td className='book_category'>
                        {book.category_code !== 0
                          ? book.category_code
                          : '총합계'}
                      </td>
                      <td className='book_price'>{book.total}</td>
                    </tr>
                  </tbody>
                </Table>
              </React.Fragment>
            );
          })}

          <footer>
            <Pagination
              total={book.length}
              limit={limit}
              page={page}
              setPage={setPage}
            />
          </footer>
        </div>
      </div>
    </div>
  );
};
export default SalesListPage;