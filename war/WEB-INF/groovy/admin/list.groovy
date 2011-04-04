package admin
import static com.google.appengine.api.datastore.FetchOptions.Builder.*
import com.google.appengine.api.datastore.PreparedQuery
import com.google.appengine.api.datastore.Query

def query = new Query('Mashup')
PreparedQuery preparedQuery = datastore.prepare(query)
request['mashups'] = preparedQuery.asList(withLimit(1000))

forward "/list.gtpl"

