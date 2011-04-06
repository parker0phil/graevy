<% include '/WEB-INF/includes/header.gtpl' %>
<h3>What is it?</h3>
<p>
    <span class="withgravy">$appName</span> is a super-lightweight framework for creating online apps (e.g. mashups, prototypes, mobile app endpoints).
    See some <a href="/manual/ideas">ideas</a> of what else you can do with it.
</p>
<p>
    Apps can be created completely online, using the <span class="withgravy">$appName</span> website. Any required setup, configuration and coding
    (of which there is very little) can be done with just a browser.
</p>
<p>
    Each app works on the basis of a <a href="#scripts">Script</a> (which is used primarily to collect data from the internet, or process input passed to them)
    and a <a href="#pages">Page</a> (which is used to interact with users).
</p>
<p>
    <span class="withgravy">$appName</span> makes it easy to re-use other peoples Scripts so the whole community can make use of each others work.
</p>


<h3><a id="scripts"></a>Scripts</h3>
<div class="span-14">
<p>Every app must have a Script. This is a <a href="http://groovy.codehaus.org/">Groovy</a> script which has some
useful helper objects in place to make it easy for you to request, parse and consume loads of different data sources.</p>
<p>Scripts also have access to information passed in on the query string (e.g. encoded on a link), or posted from a form (e.g. on a <span class="withgravy">$appName</span> Page or elsewhere).
<p>
    The last line in a Script returns an object (if you don't do it explicitly then the last evaluated expression will be used).
    If you've created a Page then this object will be passed to it as data, otherwise it will be passed back to the requester as
    <a href="www.json.org/ ">JSON</a> (<strong>todo:</strong>you currently just get a text representation of your object)</p>
</p>
<p>See the <a href="/manual/scripts">Scripts manual</a> for more help.</p>
</div>
<div class="span-5 last fig">
    <img src="images/script.png"/>
</div>
<h3 class="span-20"><a id="pages"></a>Pages</h3>
<div class="span-5 fig">
    <img src="images/page.png"/>
</div>
<div class="span-14 last">
<p>Pages are optional (if you don't have one then, as we've said, you'll just see JSON returned to your browser). </p>
<p>If you do create a Page then it's basically an html page (that was a lie, it's actually a
    <a href="http://groovy.codehaus.org/api/groovy/text/SimpleTemplateEngine.html">Simple Groovy Template</a> but for the time being think of it like an html page on steroids!) </p>
 <p>Pages let you embed data from your Script (from an object called 'data') into your html: <br/> <br/>

    <code> The current exchange rate is &lt;b&gt;\$data.rate["dollar"]&lt;\\b&gt;</b> dollars to the pound.</code>

 </p>

 <p>See the <a href="/manual/pages">Pages manual</a> for more help.</p>
</div>
<div class="span-18">
<h2>Getting started...</h2>
<p>
    You need a Google Account to create apps on <span class="withgravy">$appName</span>
    (so no-one else changes your perfect creation!).
</p>

<p>
<% if (user) {%>
    As you are already signed in (as <strong>$user.email</strong>) you can just <a href="/admin/edit">create an app</a>. Any apps you create will be available on:
</p>
<code>$baseurl/$user.graevyName/{app name}/</code>.

<%}else{%>
<p>
If you already have an account then you can <a href="${users.createLoginURL('/')}">login here</a> or <a href="https://www.google.com/accounts/NewAccount">create a Google Account</a> before coming back here to get started!
</p>
<% }%>
</div>
 <!--
<h3><a id="urls"></a>Urls</h3>

<p>When you create a new <span class="withgravy">$appName</span> app it will available on the url <code>$baseurl/{yourgoogleid}/{app name}/</code>.</p>
<p>As you already know, if you don't create a Page then a JSON interface is presented. This is always available on the url:
    <code>$baseurl/<strong>json</strong>/{yourgoogleid}/{mashupname}/</code></p>

<h4>Using the requested url</h4>
<p>Any query string parameters (e.g. <code>/{mashupname}?foo=best&bar=worst</code>.) will  be available in your Scraper:</p>
<p>
    <code>params.foo == "best"</code><br/>
    <code>params.bar == "worst"</code><br/>
</p>
<p>Anything on the url after the mashup name (e.g. <code>/{mashupname}/foo/bar</code>) will also be available:</p>
<p>
    <code>url[1] == "foo"</code><br/>
    <code>url[2] == "bar"</code><br/>
    <code>url[0]</code> is used for the whole url (including query parameters)
</p>
-->












<% include '/WEB-INF/includes/footer.gtpl' %>

