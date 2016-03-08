<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="cinemasDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='cinemasDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="cinemasList.cinemas"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="cinemasDetail.heading"/></h2>
    <fmt:message key="cinemasDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="cinemas" method="post" action="cinemasform" cssClass="well"
           id="cinemasForm" onsubmit="return validateCinemas(this)">
<form:hidden path="id"/>
    <spring:bind path="cinemas.address">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="cinemas.address" styleClass="control-label"/>
        <form:input cssClass="form-control" path="address" id="address"  maxlength="255"/>
        <form:errors path="address" cssClass="help-block"/>
    
    <spring:bind path="cinemas.contactNumber">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="cinemas.contactNumber" styleClass="control-label"/>
        <form:input cssClass="form-control" path="contactNumber" id="contactNumber"  maxlength="255"/>
        <form:errors path="contactNumber" cssClass="help-block"/>
    
    <spring:bind path="cinemas.created">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="cinemas.created" styleClass="control-label"/>
        <form:input cssClass="form-control" path="created" id="created"  maxlength="19"/>
        <form:errors path="created" cssClass="help-block"/>
 
    <spring:bind path="cinemas.description">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="cinemas.description" styleClass="control-label"/>
        <form:input cssClass="form-control" path="description" id="description"  maxlength="65535"/>
        <form:errors path="description" cssClass="help-block"/>
   
    <spring:bind path="cinemas.displayInHome">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="cinemas.displayInHome" styleClass="control-label"/>
        <form:checkbox path="displayInHome" id="displayInHome" cssClass="checkbox"/>
        <form:errors path="displayInHome" cssClass="help-block"/>
    
    <spring:bind path="cinemas.fileName">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="cinemas.fileName" styleClass="control-label"/>
        <form:input cssClass="form-control" path="fileName" id="fileName"  maxlength="255"/>
        <form:errors path="fileName" cssClass="help-block"/>
   
    <spring:bind path="cinemas.imageUrl">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="cinemas.imageUrl" styleClass="control-label"/>
        <form:input cssClass="form-control" path="imageUrl" id="imageUrl"  maxlength="255"/>
        <form:errors path="imageUrl" cssClass="help-block"/>
 
    <spring:bind path="cinemas.modified">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="cinemas.modified" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modified" id="modified"  maxlength="19"/>
        <form:errors path="modified" cssClass="help-block"/>
    
    <spring:bind path="cinemas.name">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}"></div>
    </spring:bind>
        <appfuse:label key="cinemas.name" styleClass="control-label"/>
        <form:input cssClass="form-control" path="name" id="name"  maxlength="255"/>
        <form:errors path="name" cssClass="help-block"/>
    

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty cinemas.id}">
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

<v:javascript formName="cinemas" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['cinemasForm']).focus();
    });
</script>
