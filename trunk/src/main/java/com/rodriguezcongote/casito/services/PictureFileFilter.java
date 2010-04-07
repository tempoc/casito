/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.services;

import com.rodriguezcongote.casito.util.OrFileFilter;
import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author Gabriel
 */
public class PictureFileFilter extends OrFileFilter {

    public PictureFileFilter(FileFilter[] filters) {
        super(filters);
    }

}
