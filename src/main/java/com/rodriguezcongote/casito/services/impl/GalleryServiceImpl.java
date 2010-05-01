/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.services.impl;

import com.rodriguezcongote.casito.gallery.GalleryItem;
import com.rodriguezcongote.casito.gallery.GalleryRoom;
import com.rodriguezcongote.casito.services.DirectoryFileFilter;
import com.rodriguezcongote.casito.services.GalleryItemFileFilter;
import com.rodriguezcongote.casito.services.GalleryService;
import java.io.File;
import java.io.IOException;
import java.util.ListResourceBundle;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class GalleryServiceImpl implements GalleryService {
    private static final String PROPERTIES_FILE = "/../app.properties";
    private static final String CONTENT_ROOT_KEY = "content.root";
    private static final String DEFAULT_CONTENT_FOLDER = "content";

    private DirectoryFileFilter directoryFileFilter;
    private GalleryItemFileFilter galleryItemFileFilter;

    private ResourceBundle resources;
    private GalleryRoom root;

    private String rootPath;
    private String rootUrl;
    
    public GalleryServiceImpl(DirectoryFileFilter directoryFileFilter, GalleryItemFileFilter galleryItemFileFilter) {
        this.directoryFileFilter = directoryFileFilter;
        this.galleryItemFileFilter = galleryItemFileFilter;
        try {
            resources = new PropertyResourceBundle(getClass().getResourceAsStream(PROPERTIES_FILE));
        } catch (IOException ex) {
            Logger.getLogger(GalleryServiceImpl.class.getName()).log(Level.SEVERE, null, ex);

            resources = new ListResourceBundle() {

                @Override
                protected Object[][] getContents() {
                    Object[][] contents = {
                        {CONTENT_ROOT_KEY, DEFAULT_CONTENT_FOLDER}
                    };
                    
                    return contents;
                }
            };
        }


        File file = new File(
            getClass().getClassLoader().getResource("/").getPath());
        rootPath =
               file.getParentFile().getParentFile().getPath() + File.separator +
               resources.getString(CONTENT_ROOT_KEY);
        root = new GalleryRoom(this, galleryItemFileFilter, directoryFileFilter, new File(
            rootPath));
        rootUrl = "/" + resources.getString(CONTENT_ROOT_KEY);
    }

    public String getRootPath() {
        return rootPath;
    }

    public String getRootUrl() {
        return rootUrl;
    }

    public GalleryRoom getRoot() {
        return root;
    }

    public GalleryItem getGalleryItem(String path) {
        File file = new File(rootPath + path);
        GalleryItem result;
        if(file.isDirectory()) {
            result = new GalleryRoom(this, galleryItemFileFilter,
                                     directoryFileFilter, file);
        } else {
            result = new GalleryItem(this, galleryItemFileFilter,
                                     directoryFileFilter, file);
        }
        return result;
    }

}
