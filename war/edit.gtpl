<% include '/WEB-INF/includes/admin-header.gtpl' %>
<%
    mashup = request.mashup
    errors = request.errors
%>
<script src="/js/codemirror.js"></script>
<link rel="stylesheet" href="/js/codemirror.css">
<script src="/js/mode/javascript/javascript.js"></script>
<link rel="stylesheet" href="/js/mode/javascript/javascript.css">
<script src="/js/mode/css/css.js"></script>
<link rel="stylesheet" href="/js/mode/css/css.css">
<script src="/js/mode/xml/xml.js"></script>
<link rel="stylesheet" href="/js/mode/xml/xml.css">

<script src="/js/mode/htmlmixed/htmlmixed.js"></script>

    <script type="text/javascript">
       jq(document).ready(function() {
            jq("#tabs").tabs();
            var scraperEditor = CodeMirror.fromTextArea(document.getElementById('scraperTextArea'),
            {
                lineNumbers:true,
                enterMode:"keep"
            });
            var displayEditor = CodeMirror.fromTextArea(document.getElementById('displayTextArea'),
            {
                mode:"htmlmixed",
                lineNumbers:true,
                enterMode:"keep"
            });
            //var myCodeMirror = CodeMirror(document.body);
        });
    </script>
    <form action="/admin/edit" method="post">
        <div id="tabs">
            <% if (errors?.name) {%><div class="error">$errors.name</div>  <%}%>
             <ul>
                <li>
                    <label>${baseurl}/${user.graevyName}/</label><% if (errors?.scraper) {%><div class="error">$errors.scraper</div>  <%}%>
                    <input type="text" name="name" value="${mashup.name}">

                </li>
                <li><a href="#tabs-scraper"><span>Script source</span></a></li>
                <li><a href="#tabs-display"><span>Page source</span></a></li>
                <li>
                    <input type="submit" value="Save & View">
                    <input type="hidden" name="id" value="${mashup.key?.id}">
                </li>
            </ul>
            <div id="tabs-scraper">

                <textarea id="scraperTextArea" rows="20"  cols ="10" name="scraper" >$mashup.scraper.value</textarea>  <br/>
            </div>
            <div id="tabs-display">
                <% if (errors?.display) {%><div class="error">$errors.display</div>  <%}%>
                <textarea id="displayTextArea" rows="20" cols ="10"  name="display" >$mashup.display.value</textarea>
            </div>
        </div>
    </form>


<% include '/WEB-INF/includes/admin-footer.gtpl' %>

