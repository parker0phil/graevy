package admin
import static com.google.appengine.api.datastore.FetchOptions.Builder.*
import com.google.appengine.api.datastore.PreparedQuery
import com.google.appengine.api.datastore.Query

if (!user){
    redirect users.createLoginURL("/admin/list")
}
log.info "$user.graevyName"
namespace.of(user.namespace){
    def query = new Query(entityName)
    PreparedQuery preparedQuery = datastore.prepare(query)
    request['mashups'] = preparedQuery.asList(withLimit(1000))
}
if (params.deletesuccess){
     request['messages'] = [[type:messageType.success,message:"Successfully deleted '$params.deletesuccess'."]]
}
if (params.deletefailurealreadyexists){
    request['messages'] = [[type:messageType.notice,message:"Can't delete app '$params.deletefailurealreadyexists' (it doesn't exist)."]]
}
forward "/list.gtpl"

