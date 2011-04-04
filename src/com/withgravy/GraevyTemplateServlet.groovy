package com.withgravy

import groovy.servlet.ServletBinding
import groovyx.gaelyk.GaelykTemplateServlet

class GraevyTemplateServlet extends GaelykTemplateServlet
{
    @Override
    protected void setVariables(ServletBinding binding) {
        super.setVariables(binding)
        binding.setVariable("appName", "withGravy")
        binding.setVariable("baseurl", "http://withgravy.appspot.com")
    }
}
