<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="cinemaShowsDetail.title"/></title>
    <meta name="heading" content="<fmt:message key='cinemaShowsDetail.heading'/>"/>
</head>

<c:set var="delObject" scope="request"><fmt:message key="cinemaShowsList.cinemaShows"/></c:set>
<script type="text/javascript">var msgDelConfirm =
   "<fmt:message key="delete.confirm"><fmt:param value="${delObject}"/></fmt:message>";
</script>

<div class="col-sm-2">
    <h2><fmt:message key="cinemaShowsDetail.heading"/></h2>
    <fmt:message key="cinemaShowsDetail.message"/>
</div>

<div class="col-sm-7">
<form:errors path="*" cssClass="alert alert-danger alert-dismissable" element="div"/>
<form:form commandName="cinemaShows" method="post" action="cinemaShowsform" cssClass="well"
           id="cinemaShowsForm" onsubmit="return validateCinemaShows(this)">
<form:hidden path="id"/>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="cinemas" items="cinemasList" itemLabel="label" itemValue="value"/>
    <spring:bind path="cinemaShows.created">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="cinemaShows.created" styleClass="control-label"/>
        <form:input cssClass="form-control" path="created" id="created"  maxlength="19"/>
        <form:errors path="created" cssClass="help-block"/>
    </div>
    <spring:bind path="cinemaShows.description">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="cinemaShows.description" styleClass="control-label"/>
        <form:input cssClass="form-control" path="description" id="description"  maxlength="65535"/>
        <form:errors path="description" cssClass="help-block"/>
    </div>
    <!-- todo: change this to read the identifier field from the other pojo -->
    <form:select cssClass="form-control" path="films" items="filmsList" itemLabel="label" itemValue="value"/>
    <spring:bind path="cinemaShows.modified">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="cinemaShows.modified" styleClass="control-label"/>
        <form:input cssClass="form-control" path="modified" id="modified"  maxlength="19"/>
        <form:errors path="modified" cssClass="help-block"/>
    </div>
    <spring:bind path="cinemaShows.showTime">
    <div class="form-group${(not empty status.errorMessage) ? ' has-error' : ''}">
    </spring:bind>
        <appfuse:label key="cinemaShows.showTime" styleClass="control-label"/>
        <form:input cssClass="form-control" path="showTime" id="showTime"  maxlength="8"/>
        <form:errors path="showTime" cssClass="help-block"/>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-primary" name="save" onclick="bCancel=false">
            <i class="icon-ok icon-white"></i> <fmt:message key="button.save"/>
        </button>
        <c:if test="${not empty cinemaShows.id}">
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

<v:javascript formName="cinemaShows" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<c:url value='/scripts/validator.jsp'/>"></script>

<script type="text/javascript">
    $(document).ready(function() {
        $("input[type='text']:visible:enabled:first", document.forms['cinemaShowsForm']).focus();
    });
</script>
