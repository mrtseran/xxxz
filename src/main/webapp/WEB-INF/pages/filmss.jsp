<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="filmsList.title"/></title>
    <meta name="menu" content="FilmsMenu"/>
</head>

<c:if test="{'$'}{not empty searchError}">
    <div class="alert alert-danger alert-dismissable">
        <a href="#" data-dismiss="alert" class="close">&times;</a>
        <c:out value="{'$'}{searchError}"/>
    </div>
</c:if>

<div class="col-sm-10">
    <h2><fmt:message key="filmsList.heading"/></h2>

    <form method="get" action="${ctx}/filmss" id="searchForm" class="form-inline">
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

    <fmt:message key="filmsList.message"/>

    <div id="actions" class="btn-group">
        <a href='<c:url value="/filmsform"/>' class="btn btn-primary">
            <i class="icon-plus icon-white"></i> <fmt:message key="button.add"/></a>
        <a href='<c:url value="/home"/>' class="btn btn-default"><i class="icon-ok"></i> <fmt:message key="button.done"/></a>
    </div>
    </div>

<display:table name="filmsList" class="table table-condensed table-striped table-hover" requestURI="" id="filmsList" export="true" pagesize="25">
    <display:column property="id" sortable="true" href="filmsform" media="html"
        paramId="id" paramProperty="id" titleKey="films.id"/>
    <display:column property="id" media="csv excel xml pdf" titleKey="films.id"/>
    <display:column property="created" sortable="true" titleKey="films.created"/>
    <display:column property="description" sortable="true" titleKey="films.description"/>
    <display:column property="directedBy" sortable="true" titleKey="films.directedBy"/>
    <display:column property="imageUrl" sortable="true" titleKey="films.imageUrl"/>
    <display:column property="modified" sortable="true" titleKey="films.modified"/>
    <display:column property="musicBy" sortable="true" titleKey="films.musicBy"/>
    <display:column property="name" sortable="true" titleKey="films.name"/>
    <display:column property="starring" sortable="true" titleKey="films.starring"/>

    <display:setProperty name="paging.banner.item_name"><fmt:message key="filmsList.films"/></display:setProperty>
    <display:setProperty name="paging.banner.items_name"><fmt:message key="filmsList.filmss"/></display:setProperty>

    <display:setProperty name="export.excel.filename"><fmt:message key="filmsList.title"/>.xls</display:setProperty>
    <display:setProperty name="export.csv.filename"><fmt:message key="filmsList.title"/>.csv</display:setProperty>
    <display:setProperty name="export.pdf.filename"><fmt:message key="filmsList.title"/>.pdf</display:setProperty>
</display:table>
