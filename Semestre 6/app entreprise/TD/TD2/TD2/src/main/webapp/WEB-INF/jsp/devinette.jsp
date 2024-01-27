<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Devinette</title>
</head>
<body>
    <h1>Ceci est une devinette !</h1>
    
    <% 
        Integer nbAlea = (Integer) session.getAttribute("nbAlea");
        
        if (nbAlea != null) {
    %>
        <p>Le nombre aléatoire est : <%= nbAlea %></p>
    <%
        } else {
    %>
        <p>Le nombre aléatoire n'est pas disponible.</p>
    <%
        }
    %>  

</body>
</html>