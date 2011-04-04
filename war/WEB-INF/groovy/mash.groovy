import groovy.text.*
import com.google.appengine.api.datastore.PreparedQuery
import com.google.appengine.api.datastore.Query


mashupname = params.mashupname
log.info "Serving request for $mashupname"

def query = new Query('Mashup')
query.addFilter("name", Query.FilterOperator.EQUAL, mashupname)
PreparedQuery preparedQuery = datastore.prepare(query)
mashup = preparedQuery.asSingleEntity()

log.info ""+mashup
scraper = mashup?.scraper
display = mashup?.display

if (!scraper){
    forward "/404.gtpl"
}
Binding scraperBinding = new Binding()
GroovyShell scraperShell = new GroovyShell(scraperBinding)
model = scraperShell.evaluate(scraper)
if (!display){
    out << model
}
else{
    out << new GStringTemplateEngine().createTemplate(display).make(['mashupname':mashupname , data:model, user:user]).toString()
}
