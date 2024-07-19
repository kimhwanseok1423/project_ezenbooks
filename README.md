
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


1. 현재 많은 책 쇼핑몰들을 밴치마킹하여 접근성이 쉽게 표현함.
2. 광고와 베스트셀러 추천에 의존하던 기존 구매패턴에서 벗어나 딥러닝 기술을 이용해 고객이 자주 구매한 상품을 </br> 바탕으로 고객의 취향을 
   분석해 새로운 상품을 개발
3. 검색기능, 베스트셀러 , 카테고리 등을 표현하여 좀더 쉽게 접근가능하도록 개발.



## 사용기술

<img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/123123123111.PNG">



## 느낀 점

이번 프로젝트는 아무것도 모르는 백지 상태에서 구글링을 통해 백엔드 기능을 맡아 구현했다. 첫 팀 프로젝트였기에 배울 것이 너무 많았다. 구글링을 통해 얻은 지식을 가지고 작업하다 보니 안되는 기능이 많았다. 백엔드 작업을 혼자 맡다 보니 기능적, 시간적으로 많이 부족함을 느꼈다.

카카오 API를 활용하려 했으나 시간상의 문제로 간단한 로그인 처리로 대체했고, CRUD 기능만 구현한 점이 아쉬웠다. 더 복잡하고 다양한 기능을 추가하고 싶었지만, 프로젝트의 범위와 시간 제약 때문에 실현하지 못한 것이 아쉬웠다.

이번 경험을 통해 프로젝트의 계획과 시간 관리를 어떻게 해야 하는지, 그리고 팀원과의 협업의 중요성을 배울 수 있었다. 앞으로는 더 나은 계획과 시간 관리를 통해 더욱 완성도 높은 프로젝트를 수행하고 싶다.



## 구현기능

<details>
  <summary>회원가입 및 로그인 기능</summary>
  
  - **구현 기능** <br>
  사용자 회원가입 및 로그인 기능을 구현했습니다.

- **구현 방법** <br>
  
  - 계정 중복 확인 -> `UserRepository`조회하여 중복 시 예외 던짐
  - 로그인 완료시 기능 , 로그인 아닐시 기능 분리 
  - 사이드바를 통해 회원정보수정 , 자유게시판 , 추천리스트 활성화
  - 메인 페이지 우측에 회원 이름 표시
      
 <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/로그인1.PNG">

 <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/로그인2.PNG">

  <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/로그인3.PNG">

   <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/로그인4.PNG">

</details>

<details>
  <summary>회원관리기능 (마이페이지  / 자유게시판 / 댓글 )</summary>


  - **구현 기능** <br>
    회원 정보 관리기능을 구현했습니다.
   
  - **구현 방법** <br>

    - 마이페이지 기능을 추가
    - 게시판 기능 
    - 댓글 삭제 , 수정

 <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처9.PNG">

 <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처9.5.PNG">

  <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처9.6.PNG">

   <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처10.PNG">

<img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처11.PNG">

<img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처12.PNG">
   
</details>

<details>
  <summary>다음지도 API 기능  </summary>

- **구현 기능** <br>
    - API를 활용한 카페 위치 표현 
- **구현 방법**<br>
    - 카카오에서 키값을 받아와 api를 활성화
    - 현위치 표현
    - 카페이름 검색시 좌표 표현
    - 구,동 입력시 데이터에 맞는 카페 호출

   <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처14.PNG"><br>
   

   

     <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처13.PNG">
   

     <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처15.PNG">
   

</details>

<details>
  <summary>메인페이지 </summary>

- **구현 기능** <br>
    - 크롤링을 활용한 데이터분석후 분류한 카테고리에 키워드로 분류함

- **구현 방법**<br>
   
    
   - 크롤링을 활용한 인터넷에 있는 카페 분위기 댓글 키워드를 추출 </br>
  

        <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처19.PNG">


    - AJAX를 활용한 키워드를 클릭시 해당함수를 실행시켜 UI에 표현하기</br>
      

    <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처20.PNG">

- 상세페이지로 이동시 주소,전화번호,별점,영업시간등 정보 표현</br>
  
  
     <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처21.PNG">


 - 로그인 후에 카페 대한 리뷰 댓글 작성</br>
   
   
   <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처22.PNG">
 - 데이터 랭킹 홍페이지를 크롤링을 통해  연령별 커피 수요 장소 데이터를 이용하여 AJAX로 뿌려줌

     <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/캡처23.PNG">

</details>

 ## ERD
 <img src="https://github.com/kimhwanseok1423/cafegaza/blob/master/src/main/webapp/resources/img/erd1.PNG">

  ## 영상
   ## [유튜브 링크](https://www.youtube.com/watch?v=OGwiO6MsiHY)
