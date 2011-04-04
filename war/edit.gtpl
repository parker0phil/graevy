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
             <ul>
                <li>
                    <label>${baseurl}/mash/</label>
                    <input type="text" name="name" value="${mashup.name}">

                </li>
                <li><a href="#tabs-scraper"><span>Scraper</span></a></li>
                <li><a href="#tabs-display"><span>Display</span></a></li>
                <li>
                    <input type="submit" value="Save & View">
                    <input type="hidden" name="create" value="${request.create}">
                </li>
            </ul>
            <div id="tabs-scraper">
                <% if (errors?.scraper) {%><span class="error">$errors.scraper</span><br/>  <%}%>
                <textarea id="scraperTextArea" rows="20"  cols ="10" name="scraper" >$mashup.scraper</textarea>  <br/>
            </div>
            <div id="tabs-display">
                <% if (errors?.display) {%><span class="error">$errors.display</span><br/>  <%}%>
                <textarea id="displayTextArea" rows="20" cols ="10"  name="display" >$mashup.display</textarea>
            </div>
        </div>
    </form>


<% include '/WEB-INF/includes/footer.gtpl' %>

