<% include '/WEB-INF/includes/admin-header.gtpl' %>
<%
  mashups = request['mashups']
%>
    <h2>Your Apps</h2>
    <ul>
     <% mashups.each{ mashup -> %>
        <li>$mashup.name   - <a href="/admin/edit/$mashup.name">edit</a> - <a href="/admin/delete/$mashup.name">delete</a></li>
     <% }%>
    </ul>
<% include '/WEB-INF/includes/admin-footer.gtpl' %>

