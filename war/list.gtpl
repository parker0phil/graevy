<% include '/WEB-INF/includes/admin-header.gtpl' %>
        <%
          mashups = request['mashups']
        %>
<h1>Mashups</h1>
        <ul>
         <% mashups.each{ mashup -> %>
            <li>$mashup.name   - <a href="/admin/edit/$mashup.name">edit</a></li>
         <% }%>
        </ul>
<% include '/WEB-INF/includes/footer.gtpl' %>

