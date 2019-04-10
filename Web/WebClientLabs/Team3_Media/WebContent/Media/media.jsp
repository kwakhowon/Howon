<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>동물 소리 공부하기</title>
  <link rel="stylesheet" href="media.css" />
  	<link rel="stylesheet" href="index.css">
</head>
<body>
<jsp:include page="/commonmodule/Top.jsp"></jsp:include>
  <div id="container">
    <aside>
      <ul class="animalList">
       <li>
          <img class="animal" id="conan" src="../images/conon.png" alt="코난 그림" width="48px" height="48px"
            draggable="true" />
        </li>
        
        <li>
          <img class="animal" id="pig" src="https://img.icons8.com/color/48/000000/pig.png" alt="돼지 그림"
            draggable="true" />
        </li>
        <li>
          <img class="animal" id="bird" src="https://img.icons8.com/color/48/000000/bird.png" alt="새 그림"
            draggable="true" />
        </li>
        <li>
          <img class="animal" id="sheep" src="https://img.icons8.com/color/48/000000/sheep.png" alt="양 그림"
            draggable="true" />
        </li>
        <li>
          <img class="animal" id="cat" src="https://img.icons8.com/color/48/000000/cat.png" alt="고양이 그림"
            draggable="true" />
        </li>
      </ul>
    </aside>
    <article>
      <div id="animalBox"></div>
      <h2 id="animalNameBox"></h2>
      <input id="replay" type="button" value="다시 듣기" />
    </article>
  </div>
  <footer>
    <p>2019 비트캠프 3조 제작</p>
  </footer>
  <script src="replay.js"></script>
  <script src="media.js"></script>
</body>
</html>