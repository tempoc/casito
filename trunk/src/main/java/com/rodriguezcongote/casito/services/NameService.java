/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.services;

import org.apache.tapestry5.ioc.Messages;

/**
 *
 * @author Grodriguez
 */
public class NameService {

    public String localize(Object obj, Messages messages) {
        String name = obj.toString();
        return messages.contains(name) ? messages.get(name) : name;
    }

}
