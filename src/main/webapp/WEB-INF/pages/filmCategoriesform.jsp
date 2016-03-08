<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="filmCategoriesDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='filmCategoriesDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="filmCategoriesList.filmCategories"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="filmCategoriesDetail.heading"/></h2>
    <fmt:message key="filmCategoriesDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="filmCategories" method="post" action="filmCategoriesform" cssClass="well"
           id="filmCategoriesForm" onsubmit="return validateFilmCategories(this)">
<form:hidden path="id"/>
    <spring:bind path="filmCategories.created">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="filmCategories.created" styleClass="control-label"/>
        <form:input cssClass="form-control" path="created" id="created"  maxlength="19"/>
        <form:errors path="created" cssClass="help-block"/>
    
    <spring:bind path="filmCategories.modified">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="filmCategories.modified" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modified" id="modified"  maxlength="19"/>
        <form:errors path="modified" cssClass="help-block"/>
 
    <spring:bind path="filmCategories.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="filmCategories.name" styleClass="control-label"/>
        <form:input cssClass="form-control" path="name" id="name"  maxlength="255"/>
        <form:errors path="name" cssClass="help-block"/>


    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty filmCategories.id}">
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

<v:javascript formName="filmCategories" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['filmCategoriesForm']).focus();
    });
</script>
