<% include '/WEB-INF/includes/declarations.gtpl' %>
        <link href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/themes/base/jquery-ui.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="https://www.google.com/jsapi?key=ABQIAAAATeX24mCwdGj6nn1HC0CtOhQKZ6yzjW36Ccy0z1j2168lM1PiwxQlNs8dDO9OV_7U-jsuCy2g3AlApA" type="text/javascript"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.11/jquery-ui.min.js"></script>
        <script language="Javascript" type="text/javascript">
        //<![CDATA[
        var jq = jQuery.noConflict();
        //]]>
        </script>
        <title>${appName} - admin</title>
    </head>
    <body>
        <div class="container">  <%//showgrid %>
            <% include '/WEB-INF/includes/topbar.gtpl' %>
            <div class="span-24 nav">
                   <hr/><a href="/admin/list">list all</a> | <a href="/admin/edit">create new</a> <hr/>
            </div>
            <div class="span-24 content">
            <% request['messages'].each{ message -> %>
                <div class="$message.type">$message.message</div>
            <% }%>
