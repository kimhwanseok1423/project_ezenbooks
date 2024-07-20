
<img src="https://github.com/user-attachments/assets/1c52f779-8135-4184-aa41-ff7faaed6b79" alt="image" width="800"/>

---

## 목차
- [개요](#개요)
- [사용기술](#사용기술)
- [느낀 점](#느낀-점)
- [구현 기능](#구현기능)
- [ERD](#erd)
- [영상](#영상)


## 개요

다양한 책 쇼핑몰을 벤치마킹하여 사용자 접근성을 높였습니다.

기존의 광고와 베스트셀러 추천에 의존하던 구매 패턴에서 벗어나, 딥러닝 기술을 이용해 <br>

고객의 구매 데이터를 분석하고 개인의 취향에 맞는 상품을 추천합니다.

검색 기능, 베스트셀러, 카테고리 등을 직관적으로 표현하여 사용자들이 더욱 쉽게 원하는 책을 찾을 수 있도록 개발했습니다 <br>
## 사용기술
 <br>
<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처11.PNG"><br><br>



## 느낀 점 


이번 프로젝트는 백엔드 팀원 4명 덕분에 여유 있게 진행할 수 있었습니다.<br>

결제 시스템은 다른 조원이 맡았기에, 다음 개인 프로젝트에서 직접 해볼 계획입니다.<br>

쇼핑몰 개발의 복잡함과 팀원과의 협업 어려움을 느꼈습니다. 앞으로는 협업 능력을 강화하고 <br>

더 완성도 높은 프로젝트를 목표로 하겠습니다.

## 구현기능 


<details>
  <summary>회원가입 및 회원기능 </summary>
  
  - **구현 기능** <br>
  사용자 회원가입 및 로그인 기능을 구현했습니다.

- **구현 방법** <br>
  
  - 계정 중복 확인
    -`UserRepository`조회하여 중복 시 예외 던집니다.
  - 로그인 기능
    - 로그인 시 사용자가 입력한 정보가 데이터베이스와 일치하는지 확인합니다. 로그인 성공 시 사용자에게 로그인 상태를 유지하는 기능을 제 
      공하며, 로그인 실패 시 적절한 오류 메시지를 표시합니다.
  - 이메일 중복 확인
     -회원가입 시 입력한 이메일이 이미 존재하는지 확인합니다. 중복된 이메일이 있을 경우 사용자에게 알림을 제공하고, 회원가입을 차단합니다.
  - 마이 페이지
    - 로그인 후 사용자가 자신의 정보를 확인하고 수정할 수 있는 마이페이지를 구현했습니다. 
      
<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처21.PNG"><br>

<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처22.PNG"><br>


</details>

<details>
  <summary>관리자 페이지 </summary>


  - **구현 기능** <br>
    - 관리자 페이지
    - 회원 삭제 ,리뷰 관리
    - 기간별 매출 현황 

  - **구현 방법** <br>
    - 관리자 페이지 구성
      - 관리자가 쉽게 사용할 수 있도록 UI/UX를 설계했습니다.
    - 회원 삭제
      - 회원 목록을 표시하고, 특정 회원을 선택하여 삭제할 수 있도록 했습니다.
      - 삭제 요청 시 확인 절차를 추가하여 실수로 인한 삭제를 방지합니다.
    - 리뷰 관리
      - 모든 리뷰를 리스트업하여 관리할 수 있는 인터페이스를 제공했습니다.
      - 리뷰를 승인하거나 삭제할 수 있는 기능을 구현했습니다.
    - 기간별 매출 현황
      - 기간을 설정하여 해당 기간의 매출 데이터를 조회할 수 있는 기능을 구현했습니다.
      - 매출 데이터를 차트로 시각화하여 분석할 수 있도록 했습니다.
 <img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처23.PNG"><br>

 <img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처24.PNG"><br>

 <img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처25.PNG"><br>
   
</details>

<details>
  <summary>고객들이 원하는 알고리즘 추천  </summary> <br>

- **구현 기능** <br>
    - 로그인한 회원과 비슷한 취향의 고객이 선택한 책들을 추천해주는 기능 <br>

- **구현 방법**<br>
    - 유사도 높은 순으로 정렬
      - 사용자가 평가 혹은 구매하지 않은 아이템을 유사도에 따라 정렬한다.
    - 인기도 높은 순으로 정렬
      - 각 아이템 간 등급(평점)의 평균을 계산하고 이를 통해 인기도를 결정한다. 그 후 인기도 순으로 정렬하고 상위 N개를 출력한다.<br>
        
      <img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처15.PNG"><br><br>
        <img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처16.PNG"><br><br>
          <img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처17.PNG"><br><br>
            <img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처18.PNG"><br><br>
  <img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처19.PNG"><br><br>
   <img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처20.PNG"><br>

</details>

<details>
  <summary>메인 페이지 기능 구현  </summary>

- **구현 기능** <br>
    - 

- **구현 방법**<br>
   - 메인 페이지 구성
     - 데이터베이스에서 책 데이터를 가져와 select 요소에 동적으로 표시했습니다.
   - 카테고리 페이지
     - 데이터베이스 테이블에 카테고리 컬럼을 추가하여 책들이 해당 카테고리에 맞게 분류되도록 설정했습니다.
       사용자가 메인 페이지에서 선택한 카테고리에 따라 해당 카테고리에 속하는 책들을 조회하고 표시했습니다.
   - 상세 페이지
     - 사용자가 특정 책을 선택하면, 선택된 책의 id 값을 기반으로 데이터베이스에서 해당 책의 상세 정보를 가져와 상세 페이지에 표시했습니다.
       상세 페이지에서는 책의 제목, 저자, 가격, 설명 등의 세부 정보를 제공했습니다.
   - 장바구니 기능
     - 사용자가 원하는 책을 장바구니에 추가할 수 있도록 구현했습니다.
       장바구니에 담긴 책들은 사용자 세션에 저장되어 유지되며, 필요 시 데이터베이스에도 저장됩니다.
   - 결제 기능
     - 장바구니에 담긴 책들을 확인하고 결제할 수 있는 기능을 구현했습니다.
     결제 정보 입력, 결제 처리, 그리고 주문 확인 단계를 거쳐 사용자가 책을 구매할 수 있도록 했습니다.

<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처26.PNG"><br><br><br><br>
<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처27.PNG"><br><br><br><br>
<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처28.PNG"><br><br><br><br>
<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처29.PNG"><br><br><br><br>
<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처30.PNG"><br><br><br><br>
<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처31.PNG"><br><br><br><br>
<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처32.PNG"><br><br><br><br>

</details>

 ## ERD
<img src="https://github.com/kimhwanseok1423/project_ezenbooks/blob/master/frontend/public/img/캡처12.PNG">

  ## 영상
   ## [유튜브 링크](https://www.youtube.com/watch?v=ntikFWHEWn4)

   
