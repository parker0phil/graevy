package com.withgravy

import groovy.servlet.ServletBinding
import groovyx.gaelyk.GaelykServlet
import javax.servlet.ServletConfig
import com.google.appengine.api.users.User

class GraevyServlet extends GaelykServlet
{
    @Override
    void init(ServletConfig config) {
        super.init(config)
        User.metaClass.getGraevyName = {
            return delegate?.nickname?.contains('@') ? delegate?.nickname : delegate?.nickname?.replaceAll(/\./, '')
        }
        User.metaClass.getNamespace = {
            return "ns-"+delegate?.graevyName.replaceAll(/@/, '__AT__')
        }
    }

    @Override
    protected void setVariables(ServletBinding binding) {
        super.setVariables(binding)
        GraevyBindingEnhancer.bind(binding)
    }
}

