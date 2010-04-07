/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.services;

import com.rodriguezcongote.casito.util.OrFileFilter;
import java.io.FileFilter;

/**
 *
 * @author Grodriguez
 */
public class GalleryItemFileFilter extends OrFileFilter {

    public GalleryItemFileFilter(FileFilter[] filters) {
        super(filters);
    }

}
