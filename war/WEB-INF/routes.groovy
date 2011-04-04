
get "/mash/@mashupname", forward: "/mash.groovy?mashupname=@mashupname"
get "/json/@mashupname", forward: "/mash.groovy?mashupname=@mashupname"

get "/admin/edit", forward: "/admin/edit.groovy"
get "/admin/edit/@mashupname", forward: "/admin/edit.groovy?mashupname=@mashupname"
post "/admin/edit", forward: "/admin/save.groovy"

get "/admin/list", forward: "/admin/list.groovy"


get "/favicon.ico", redirect: "/images/favicon.png"