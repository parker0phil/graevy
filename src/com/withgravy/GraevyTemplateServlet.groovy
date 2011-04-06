package com.withgravy

import groovy.servlet.ServletBinding
import groovyx.gaelyk.GaelykTemplateServlet

class GraevyTemplateServlet extends GaelykTemplateServlet
{
    @Override
    protected void setVariables(ServletBinding binding) {
        super.setVariables(binding)
        GraevyBindingEnhancer.bind(binding)

    }
}
// binding.setVariable("messageType", [error:"error", notice : "notice", info:"info", success:"success"])
