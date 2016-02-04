<%@ page language="java" %>
<%@ page import="java.util.Map, java.util.Date, org.springframework.security.core.context.SecurityContextHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<c:set var="now" value="<%= new java.util.Date() %>" />
<c:set var="roletype" value="<%= session.getAttribute(\"ROLE_TYPE\") %>" />
<c:set var="accountID" value="<%= session.getAttribute(\"ACCOUNT_ID\") %>" />
            <div class="flt" style="padding-top: 10px;"><img src="<c:url value="/static/image/logo.png" />" width="160" height="40" alt=""></div>
            <div class="frt">
                <div style="width: 100%; text-align: right; float: right;">
                    <div class="headersec">
                        <div class="tr pt3">Hello <%= session.getAttribute("USER_NAME") %> (<%= session.getAttribute("ACCOUNT_NAME") %>, Account Number=<%= session.getAttribute("ACCOUNT_ID") %>) <c:if test="${(roletype == 'SU') || (roletype == 'EU')}">&nbsp;&nbsp; <a href="<c:url value="/security/switchuser.html" />"> Switch User </a></c:if>&nbsp;&nbsp; <a href="<c:url value="/security/changepassword.html" />">Change Password</a> &nbsp;&nbsp; <a href="<c:url value="/security/logout.html" />">Logout</a></div>
                        <div class="tr pt7"><fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /></div>
                    </div>
                    <div id="navbar" style="height: 24px;">
                        <ul class="frt">
                            <li><a href="<c:url value="<%= session.getAttribute(\"HOME_URL\").toString() %>" />"><span>DASHBOARD</span></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="clr"></div>