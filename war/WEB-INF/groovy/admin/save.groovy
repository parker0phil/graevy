package admin


import com.google.appengine.api.datastore.*

log.info "Trying to save '$params.name' (create=${params['create']})"

def query = new Query('Mashup')
query.addFilter("name", Query.FilterOperator.EQUAL, params.name)
PreparedQuery preparedQuery = datastore.prepare(query)
alreadyExists =  preparedQuery.asSingleEntity()

if (alreadyExists?.name && !params['create']){
    log.info "Cannot save '$params.name' (already exists)"
    request['errors'] = ['name':"Already exists."]
    request['mashup'] = params
    forward "/edit.gtpl"
}else if ("true".equals(params['create'])){
    log.info "Creating new mashup '$params.name'"
    def newMashup = new Entity('Mashup')
    newMashup << params.subMap(['name', 'scraper', 'display'])
    newMashup.save()
    redirect "/mash/$params.name"
}else{
    alreadyExists.scraper = params.scraper
    alreadyExists.display = params.display
    log.info "Updating existing mashup '$alreadyExists.name'"
    alreadyExists.save()
    redirect "/mash/$alreadyExists.name"
}


