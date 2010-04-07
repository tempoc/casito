/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.services.impl;

import com.rodriguezcongote.casito.services.DirectoryFileFilter;
import java.io.File;

/**
 *
 * @author Gabriel
 */
public class DirectoryFileFilterImpl implements DirectoryFileFilter {

    public boolean accept(File pathname) {
        return !pathname.isHidden() && pathname.isDirectory();
    }

}
