 //한줄 주석입니다.
   
   /*
     여러줄 주석 또는 부분주석입니다.
     여기 부터는 자바스크립트 문법으로 코딩
      1) 대소문자를 구분한다. 
      2) 한문장을 ; 끝낸다.  또는 엔터를 하면 ; 역할 
   */
   
   //브라우져에 출력
   document.write("<h2 style='color:blue'>난 어디에 출력되니??</h2>");
   
   
   document.write("<h4>나도 출력되니?<h4>");
  
  //마우스를 오버했을때 기능
  function mouseOver( th ){ //th는 this
	  //콘솔에 출력
	  console.log("오버했다... th= " + th);
	  th.style.backgroundColor='red';
	  th.style.color="white";
  }
  
  //마우스를 아웃했을 때 기능 
  function mouseOut(th){
	  console.log("아웃했다... th = " + th);
	  th.style.backgroundColor='white';
	  th.style.color="black";
  }
  