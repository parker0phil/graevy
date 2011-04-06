package admin

import com.google.appengine.api.datastore.PreparedQuery
import com.google.appengine.api.datastore.Query

mashupname = params.mashupname
if (!user){
    redirect users.createLoginURL("/admin/list")
}
log.info "$user.graevyName"
namespace.of(user.namespace){
    if (mashupname){
        log.info "Deleting $mashupname"
        def query = new Query('Mashup')

        query.addFilter("name", Query.FilterOperator.EQUAL, mashupname)
        PreparedQuery preparedQuery = datastore.prepare(query)
        def mashup = preparedQuery.asSingleEntity()
        mashup.delete()
        redirect "/admin/list?deletesuccess=$mashupname"
    }else{
        redirect "/admin/list?deletefailurealreadyexists=$mashupname"
    }
}