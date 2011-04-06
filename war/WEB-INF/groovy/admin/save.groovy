package admin

import com.google.appengine.api.datastore.*


if (!user){
    redirect users.createLoginURL("/admin/list")
}
log.info "$user.graevyName"
namespace.of(user.namespace){
    request['mashup'] = params
    alreadyExists = false;
    isCreate = "null".equals(params.id)

    if ("".equals(params.name.trim())){
        request['errors'] = ['name':"You must specify a name for your app."]
        forward "/edit.gtpl"
    }

    def query = new Query(entityName)
    query.addFilter("name", Query.FilterOperator.EQUAL, params.name)
    PreparedQuery preparedQuery = datastore.prepare(query)
    Entity entityByName =  preparedQuery.asSingleEntity()
    Entity entityById

    if(isCreate){
        if (entityByName){
            alreadyExists = true;
        }
    }else{
        def key = KeyFactory.createKey(entityName, Long.parseLong(params.id))
        entityById = datastore.get(key)
        if (!entityById==entityByName){
            alreadyExists = true;
        }
    }

    if (alreadyExists){request['errors'] = ['name':"An app with the name '$params.name' already exists."]   }

    if (request['errors']){
        request['mashup'] = params
        forward "/edit.gtpl"
    }else if (isCreate && !alreadyExists){
        log.info "Creating new mashup '$params.name'"
        def newEntity = new Entity('Mashup')
        newEntity.name = params.name;
        newEntity.scraper = params.scraper as Text
        newEntity.display = params.display as Text
        newEntity.save()
        redirect "/$user.graevyName/$newEntity.name"
    }else if (!alreadyExists){

        entityById.scraper = params.scraper as Text
        entityById.display = params.display as Text
        log.info "Updating existing mashup '$entityById.name' as '$params.name'"
        entityById.name = params.name
        entityById.save()
        redirect "/$user.graevyName/$entityById.name"
    }
}


