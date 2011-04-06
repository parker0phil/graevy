<div class="span-24 header">
    <div class="span-16">
        <a href="/"><img src="/images/graevy-small.png"></a>
    </div>
    <div class="span-8 last login">
        <% if (user) { %>
            Welcome <a href="/admin/list" title="View your apps">$user.graevyName</a>
        <%}else{ %>
            <a href="${users.createLoginURL('/')}" title="Sign In to Google Account">sign in</a>
        <%}%>
    </div>
</div>