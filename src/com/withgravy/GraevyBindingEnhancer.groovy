package com.withgravy;

import groovy.lang.Binding;
import groovy.servlet.ServletBinding
import com.google.appengine.api.users.UserService;

class GraevyBindingEnhancer {




    /**
     * Bind the various Google App Engine services and variables
     *
     * @param binding Binding in which to bind the GAE services and variables
     */
    static void bind(Binding binding) {


        String baseUrl = "http://withgravy.appspot.com"

        binding.setVariable("appName", "withGravy")
        binding.setVariable("baseurl", baseUrl)
        binding.setVariable("messageType", [error:"error", notice : "notice", info:"info", success:"success"])
        binding.setVariable("entityName", "Mashup")

    }


}
