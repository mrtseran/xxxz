<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="filmGalleriesDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='filmGalleriesDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="filmGalleriesList.filmGalleries"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="filmGalleriesDetail.heading"/></h2>
    <fmt:message key="filmGalleriesDetail.message"/>
</div>

<div class="col-sm-7">
<%-- <form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="filmGalleries" method="post" action="todaycinema.film_galleries" cssClass="well"
           id="filmGalleriesForm" onsubmit="return validateFilmGalleries(this)">
<form:hidden path="id"/> --%>

<form:form method="post" action="/filmGalleriesform">
    
   <%--  <table>    
    <tr>
    <td><form:input path="name" type="text" /></td>
    </tr>
    </table> --%>
    
    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty filmGalleries.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
</form:form>
</div>

<v:javascript formName="filmGalleries" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['filmGalleriesForm']).focus();
    });
</script>
