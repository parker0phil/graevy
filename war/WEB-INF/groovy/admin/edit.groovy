package admin

import com.google.appengine.api.datastore.PreparedQuery
import com.google.appengine.api.datastore.Query
import com.google.appengine.api.datastore.Text

if (!user){
    redirect users.createLoginURL("/admin/list")
}
log.info "$user.graevyName"
namespace.of(user.namespace){
    mashupname = params.mashupname
    defaultscraper="""
    return [message:"Hello World", date:new Date()]
    """
    defaultdisplay="""
    <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
    <html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>My withGravy app</title>
        <meta http-equiv="content-type"content="text/html;charset=utf-8" />
    </head>
    <body>
        \$data.message</br>
        It's \${data.date}</br>
    </body>
    </html>
    """

    if (mashupname){
        log.info "Editing $mashupname"
        def query = new Query(entityName)
        query.addFilter("name", Query.FilterOperator.EQUAL, mashupname)
        PreparedQuery preparedQuery = datastore.prepare(query)
        request['mashup'] = preparedQuery.asSingleEntity()

    }else{
        request['mashup'] = [name:"", scraper:defaultscraper as Text, display:defaultdisplay as Text]
    }
}
forward "/edit.gtpl"