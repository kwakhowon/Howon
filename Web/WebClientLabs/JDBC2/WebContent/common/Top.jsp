<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav
        class="navbar navbar-expand-lg navbar-light bg-light border-bottom"
>
  <button class="btn btn-primary" id="menu-toggle">Toggle Menu</button>

  <button
          class="navbar-toggler"
          type="button"
          data-toggle="collapse"
          data-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
  >
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto mt-2 mt-lg-0">
      <li class="nav-item active">
        <a class="nav-link" href="Ex02_JDBC_Main.jsp"
        >Main <span class="sr-only">(current)</span></a
        >
      </li>
      <li class="nav-item">
        <a class="nav-link" href="Ex02_JDBC_Login.jsp">Login</a>
      </li>
      <li class="nav-item dropdown">
        <a
                class="nav-link dropdown-toggle"
                href="#"
                id="navbarDropdown"
                role="button"
                data-toggle="dropdown"
                aria-haspopup="true"
                aria-expanded="false"
        >
          더 보기
        </a>
        <div
                class="dropdown-menu dropdown-menu-right"
                aria-labelledby="navbarDropdown"
        >
          <a class="dropdown-item" href="Ex02_JDBC_JoinForm.jsp">Register</a>
          <a class="dropdown-item" href="#">Intro</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="#">Intro</a>
        </div>
      </li>
    </ul>
  </div>
</nav>
