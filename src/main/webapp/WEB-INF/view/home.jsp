<%--
  Created by IntelliJ IDEA.
  User: hoccu
  Date: 10/26/2024
  Time: 1:22 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Nhà thuốc CodeGym</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">

</head>
<body>
<%--<jsp:include page="menu.jsp"></jsp:include>--%>
<header class="header">
  <div class="container header-content">
    <%--        <div class="logo"><x></x>--%>
    <%--            <h1>Nhà thuốc CodeGym</h1>--%>
    <%--        </div>--%>
    <div class="logo">
      <h1><a href="${pageContext.request.contextPath}/home">Nhà thuốc CodeGym</a></h1>
    </div>

    <div class="nav-buttons">
      <!-- Hiển thị username nếu đã đăng nhập -->
      <c:if test="${not empty username}">
        <span>Xin chào, ${username}</span>
        <a href="${pageContext.request.contextPath}/logout" class="btn btn-primary">Logout</a>
      </c:if>
      <!-- Hiển thị nút đăng nhập nếu chưa đăng nhập -->
      <c:if test="${empty username}">
        <a href="${pageContext.request.contextPath}/login" class="btn btn-primary">Login</a>
      </c:if>
    </div>

    <div class="nav-buttons">
      <c:if test="${isAdmin == 1}">
        <a href="${pageContext.request.contextPath}/managerAccount" class="btn btn-primary">Manager Account</a>
      </c:if>
      <c:if test="${isSell == 1}">
        <a href="${pageContext.request.contextPath}/managerProduct" class="btn btn-primary">Manager Product</a>
      </c:if>

    </div>

    <%--        <div class="nav-buttons">--%>
    <%--            <a href="#" class="btn btn-primary">Manager Account</a>--%>
    <%--            <a href="${pageContext.request.contextPath}/login" class="nav-link">Login</a>--%>
    <%--            <a href="${pageContext.request.contextPath}/login" class="btn btn-primary">Logout</a>--%>
    <%--        </div>--%>

    <form action="search" method="get" class="search-form">
      <input type="text" name="txt" placeholder="Tìm kiếm thuốc...">
      <button type="submit"><i class="fas fa-search"></i></button>
    </form>
  </div>
</header>


<main class="container main-content">
  <aside class="sidebar">
    <div class="category-card">
      <div class="category-header">
        <h2><i class="fas fa-list"></i> Danh mục</h2>
      </div>
      <ul class="category-list">
        <c:forEach var="o" items="${listCC}">
          <li><a href="category?cid=${o.cid}">${o.cname}</a></li>
        </c:forEach>
      </ul>
    </div>
  </aside>

  <section class="product-table">
    <table>
      <thead>
      <tr>
        <th>STT</th>
        <th>Tên thuốc</th>
        <th>Ảnh</th>
        <th>Giá</th>
        <th>Loại thuốc</th>
        <th>Mô tả</th>
        <th>Chi tiết hơn</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="o" items="${listP}">
        <tr>
          <td>${o.id}</td>
          <td><h4 class="card-title show_txt"><a href="detail?pid=${o.id}" title="View Product">${o.name}</a></h4></td>
          <td><img src="${o.image}" alt="Card image cap"></td>

          <td class="price">${o.price}VNĐ</td>
          <td>${o.title}</td>
          <td>${o.description}</td>
          <td><button class="btn-more" onclick="showDetails(${o.id})">Chi tiết</button></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </section>
</main>

<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"></script>
</body>
</html>
