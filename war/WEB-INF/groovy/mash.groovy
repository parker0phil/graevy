
import com.google.appengine.api.datastore.PreparedQuery
import com.google.appengine.api.datastore.Query
import groovy.text.GStringTemplateEngine
import groovy.json.JsonBuilder

mashupname = params.mashupname
log.info "Serving request for $mashupname"
adminLink = ""
if (user.graevyName == params.graevyName){
    adminLink = """
    <a id="floating_admin" href="/admin/edit/$mashupname" title="Edit this app">edit</a>
    <style>
    #floating_admin {
         position: fixed;
         right: 0;
         top: 40px;
         display: block;
         width: 40px;
         height: 40px;
         text-indent: -10000px;
         background-image: url(/images/favicon.png);
         background-repeat: no-repeat;
         background-position:center;
         overflow: hidden;
         border: 1px solid #5b2c00;
         border-right: 0;
    }
    </style>
    """

}
log.info params.graevyName
def graevyNS = "ns-"+params.graevyName.replaceAll(/@/, "__AT__")
log.info graevyNS
namespace.of(graevyNS){
    def query = new Query('Mashup')
    query.addFilter("name", Query.FilterOperator.EQUAL, mashupname)
    PreparedQuery preparedQuery = datastore.prepare(query)
    mashup = preparedQuery.asSingleEntity()
}
log.info ""+mashup
scraper = mashup?.scraper.value
display = mashup?.display.value

if (!scraper){
    forward "/404.gtpl"
}
groovy.lang.Binding scraperBinding = new Binding()
groovy.lang.GroovyShell scraperShell = new GroovyShell(scraperBinding)
model = scraperShell.evaluate(scraper)
out << adminLink
if (!display){
    out << new JsonBuilder(model)
}
else{
    out << new GStringTemplateEngine().createTemplate(display).make(['mashupname':mashupname , data:model, user:user]).toString()
}
