<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Enregistré</title>
  </head>
  <body>
    <h2>Formulaire traité avec succès!</h2>
    <!-- <p>Bienvenue, <c:out value="${sessionScope.prenomUtilisateur}" />!</p> -->
    <p>Bienvenue, <spring:message code="first.name" />!</p>
  </body>
</html>
