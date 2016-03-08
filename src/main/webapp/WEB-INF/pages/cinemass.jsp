<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="cinemasList.title"/></title>
    <meta name="menu" content="CinemasMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="cinemasList.heading"/></h2>

    <form method="get" action="${ctx}/cinemass" id="searchForm" class="form-inline">
    <div id="search" class="text-right">
        <span class="col-sm-9">
            <input type="text" size="20" name="q" id="query" value="${param.q}"
                   placeholder="<fmt:message key="search.enterTerms"/>" class="form-control input-sm"/>
        </span>
        <button id="button.search" class="btn btn-default" type="submit">
            <i class="icon-search"></i> <fmt:message key="button.search"/>
        </button>
    </div>
    </form>

    <fmt:message key="cinemasList.message"/>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/cinemasform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
    </div>

<display:table name="cinemasList" class="table table-condensed table-striped table-hover" requestURI="" id="cinemasList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="cinemasform" media="html"
        paramId="id" paramProperty="id" titleKey="cinemas.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="cinemas.id"/>
    <display:column property="address" sortable="true" titleKey="cinemas.address"/>
    <display:column property="contactNumber" sortable="true" titleKey="cinemas.contactNumber"/>
    <display:column property="created" sortable="true" titleKey="cinemas.created"/>
    <display:column property="description" sortable="true" titleKey="cinemas.description"/>
    <display:column sortProperty="displayInHome" sortable="true" titleKey="cinemas.displayInHome">
        <input type="checkbox" disabled="disabled" <c:if test="${cinemasList.displayInHome}">checked="checked"</c:if>/>
    </display:column>
    <display:column property="fileName" sortable="true" titleKey="cinemas.fileName"/>
    <display:column property="imageUrl" sortable="true" titleKey="cinemas.imageUrl"/>
    <display:column property="modified" sortable="true" titleKey="cinemas.modified"/>
    <display:column property="name" sortable="true" titleKey="cinemas.name"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="cinemasList.cinemas"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="cinemasList.cinemass"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="cinemasList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="cinemasList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="cinemasList.title"/>.pdf</display:setProperty>
</display:table>
