/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.util;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Grodriguez
 */
public class ExtensionFileFilter implements FileFilter {
    private String extension;

    public ExtensionFileFilter(String extension) {
        this.extension = extension;
    }

    public boolean accept(File pathname) {
        return pathname.getName().matches("^.+\\." + extension + "$");
    }

}
