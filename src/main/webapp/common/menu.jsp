<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="navbarMenu.vm" permissions="rolesAdapter">
<div class="collapse navbar-collapse" id="navbar">
<ul class="nav navbar-nav">
    <c:if test="${empty pageContext.request.remoteUser}">
        <li class="active">
            <a href="<c:url value="/login"/>"><fmt:message key="login.title"/></a>
        </li>
    </c:if>
    <menu:displayMenu name="Home"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="Logout"/>
    <!--FilmCategories-START-->
    <menu:displayMenu name="FilmCategoriesMenu"/>
    <!--FilmCategories-END-->
    <!--Films-START-->
    <menu:displayMenu name="FilmsMenu"/>
    <!--Films-END-->
    <!--FilmGalleries-START-->
    <menu:displayMenu name="FilmGalleriesMenu"/>
    <!--FilmGalleries-END-->
    <!--Cinemas-START-->
    <menu:displayMenu name="CinemasMenu"/>
    <!--Cinemas-END-->
    
    <!--CinemaShows-START-->
    <menu:displayMenu name="CinemaShowsMenu"/>
    <!--CinemaShows-END-->
</ul>
</div>
</menu:useMenuDisplayer>
