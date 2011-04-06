all "/_ah/**", ignore: true

get "/admin/edit", forward: "/admin/edit.groovy"
get "/admin/edit/@mashupname", forward: "/admin/edit.groovy?mashupname=@mashupname"
get "/admin/delete/@mashupname", forward: "/admin/delete.groovy?mashupname=@mashupname"
post "/admin/edit", forward: "/admin/save.groovy"

get "/admin/list", forward: "/admin/list.groovy"

get "/@graevyName/@mashupname", forward: "/mash.groovy?mashupname=@mashupname&graevyName=@graevyName"
get "/json/@graevyName/@mashupname", forward: "/mash.groovy?mashupname=@mashupname&graevyName=@graevyName"

get "/favicon.ico", redirect: "/images/favicon.png"