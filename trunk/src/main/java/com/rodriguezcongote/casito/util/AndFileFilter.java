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
public class AndFileFilter implements FileFilter {
    private FileFilter[] filters;

    public AndFileFilter(FileFilter... filters) {
        if (filters == null || filters.length < 1) {
            throw new IllegalArgumentException(
                "Filter requires one or more subfilters.");
        }
        this.filters = filters;
    }

    public boolean accept(File pathname) {
        boolean result = true;
        for (FileFilter filter : filters) {
            result = result && filter.accept(pathname);
        }

        return result;
    }
}
