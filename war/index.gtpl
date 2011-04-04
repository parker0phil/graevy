<% include '/WEB-INF/includes/header.gtpl' %>
<h1>Welcome</h1>

<p>
    ${appName} is a super-lightweight framework for creating mashups, proof-of-concepts or mobile app endpoints.
    See some <a href="ideas.gtpl">ideas of what you can do</a> with ${appName}.
</p>
<p>
    ${appName} mashups can be created completely online. Any required setup, configuration and coding
    (of which there is very little) can be done with just a browser.
</p>

<h2>Getting started...</h2>
<p>
    You need a <a href="https://www.google.com/accounts/NewAccount">Google Account</a> to create mash-ups on ${appName}
    (so no-one else changes your perfect creation!).
</p>
<p>
    ${appName} works on the basis of <a href="#scrapers">Scrapers</a> (which are used primarily to scrape data from the internet)
    and <a href="#displays">Displays</a> (which are used to interact with users).
</p>
<p>
    ${appName} makes it easy to re-use other peoples Scrapers so the whole community can make use of each others work.
</p>


<h3><a id="scrapers">Scrapers</a></h3>
<p>Every mashup must have a scraper. This is a <a href="http://groovy.codehaus.org/">Groovy</a> script which has some
useful helper objects in place to make it easy for you to request, parse and consume loads of different data sources.</p>
<p>Scrapers also have access to information passed on in the query string, or posted from a form
    (e.g. on a ${appName} Display or elsewhere) - see <a href="#urls">Urls section</a> below.</p>
<p>
    The last line in a scraper will return an object (if you don't do it explicitly then the last evaluated expression will be used).
    If you've created a Display then this object will be passed to it as data, otherwise it will be passed back to the requester as
    <a href="www.json.org/ ">JSON</a></p>
</p>
<p>See the <a href="scrapers.gtpl">Scrapers manual page</a> for more help.</p>


<h3><a id="displays">Displays</a></h3>
<p>Displays are optional (if you don't have one then you'll just see JSON returned to your browser). </p>
<p>If you do create a Display then it's basically an html page (that was a lie, it's actually a
    <a href="http://groovy.codehaus.org/api/groovy/text/SimpleTemplateEngine.html">Simple Groovy Template</a> but for the time being think of it like an html page on steroids!) </p>
 <p>Displays let you embed data from your Scraper into your html: <br/> <br/>

    <code> The current exchange rate is &lt;b&gt;\$data.rate["dollar"]&lt;\\b&gt;</b> dollars to the pound.</code>

 </p>

 <p>See the <a href="displays.gtpl">Displays manual page</a> for more help.</p>



<h3><a id="urls">Urls</a></h3>

<p>When you create a new ${appName} mashup it will available on the url <code>$baseurl/{yourgoogleid}/{mashupname}/</code>.</p>
<p>As you already know, if you don't create a Display then a JSON interface is presented. This is always available on the url:
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












<% include '/WEB-INF/includes/footer.gtpl' %>

