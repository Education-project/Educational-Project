<%@ taglib prefix="s" uri="/struts-tags"%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 02.09.2020
  Time: 8:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>
    <script src="crud.js" type="text/javascript"></script>
  </head>
  <body>
    <button onclick="getMenu()">menu</button>
    <button onclick="getTest(1)">test</button>
    <button onclick="getText('Section_1')">text</button>
    <s:iterator value="tests">
      <s:property value="id"/>
      <s:iterator value="sections">
        <s:property value="textPath"/>
        <s:iterator value="questions">
          <s:property value="seqNumber"/>
          <s:property value="text"/>
        </s:iterator>
      </s:iterator>
      <p></p>
    </s:iterator>
  </body>
</html>
