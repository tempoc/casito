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
public class OrFileFilter implements FileFilter {
    private FileFilter[] filters;

    public OrFileFilter(FileFilter... filters) {
        if (filters == null || filters.length < 1) {
            throw new IllegalArgumentException(
                "Filter requires one or more subfilters.");
        }
        this.filters = filters;
    }

    public boolean accept(File pathname) {
        boolean result = false;
        for(FileFilter filter : filters) {
            result = result || filter.accept(pathname);
        }

        return result;
    }

}
