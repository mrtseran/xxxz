<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="filmsDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='filmsDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="filmsList.films"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="filmsDetail.heading"/></h2>
    <fmt:message key="filmsDetail.message"/>
</div>

<%-- <div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="films" method="post" action="filmsform" cssClass="well"
           id="filmsForm" onsubmit="return validateFilms(this)">
<form:hidden path="id"/>
    <spring:bind path="films.created">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="films.created" styleClass="control-label"/>
        <form:input cssClass="form-control" path="created" id="created"  maxlength="19"/>
        <form:errors path="created" cssClass="help-block"/>
    
    <spring:bind path="films.description">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="films.description" styleClass="control-label"/>
        <form:input cssClass="form-control" path="description" id="description"  maxlength="65535"/>
        <form:errors path="description" cssClass="help-block"/>
    
    <spring:bind path="films.directedBy">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="films.directedBy" styleClass="control-label"/>
        <form:input cssClass="form-control" path="directedBy" id="directedBy"  maxlength="255"/>
        <form:errors path="directedBy" cssClass="help-block"/>
    
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="filmCategories" items="filmCategoriesList" itemLabel="label" itemValue="value"/>
    <spring:bind path="films.imageUrl">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="films.imageUrl" styleClass="control-label"/>
        <form:input cssClass="form-control" path="imageUrl" id="imageUrl"  maxlength="255"/>
        <form:errors path="imageUrl" cssClass="help-block"/>

    <spring:bind path="films.modified">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="films.modified" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modified" id="modified"  maxlength="19"/>
        <form:errors path="modified" cssClass="help-block"/>

    <spring:bind path="films.musicBy">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="films.musicBy" styleClass="control-label"/>
        <form:input cssClass="form-control" path="musicBy" id="musicBy"  maxlength="255"/>
        <form:errors path="musicBy" cssClass="help-block"/>
  
    <spring:bind path="films.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="films.name" styleClass="control-label"/>
        <form:input cssClass="form-control" path="name" id="name"  maxlength="255"/>
        <form:errors path="name" cssClass="help-block"/>
 
    <spring:bind path="films.starring">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="films.starring" styleClass="control-label"/>
        <form:input cssClass="form-control" path="starring" id="starring"  maxlength="255"/>
        <form:errors path="starring" cssClass="help-block"/> --%>
    

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty films.id}">
            <button type="submit" class="btn btn-warning" name="delete" onclick="bCancel=true;return confirmMessage(msgDelConfirm)">
                <i class="icon-trash icon-white"></i> <fmt:message key="button.delete"/>
            </button>
        </c:if>

        <button type="submit" class="btn btn-default" name="cancel" onclick="bCancel=true">
            <i class="icon-remove"></i> <fmt:message key="button.cancel"/>
        </button>
    </div>
<%-- </form:form>
</div> --%>

<v:javascript formName="films" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['filmsForm']).focus();
    });
</script>
