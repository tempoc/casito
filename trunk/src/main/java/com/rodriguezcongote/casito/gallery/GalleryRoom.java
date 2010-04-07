/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.gallery;

import com.rodriguezcongote.casito.services.DirectoryFileFilter;
import com.rodriguezcongote.casito.services.GalleryItemFileFilter;
import com.rodriguezcongote.casito.services.GalleryService;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grodriguez
 */
public class GalleryRoom extends GalleryItem {

    public GalleryRoom(GalleryService galleryService,
        GalleryItemFileFilter galleryItemFileFilter,
        DirectoryFileFilter directoryFileFilter,
        File file) {
        super(galleryService, galleryItemFileFilter, directoryFileFilter, file);
        if(file == null || !file.exists() || !file.isDirectory()) {
            throw new IllegalArgumentException("File must be an existing directory.");
        }
    }

    public List<GalleryItem> getGalleryItems() {
        List<GalleryItem> result = new ArrayList<GalleryItem>();

        File[] files = file.listFiles(galleryItemFileFilter);

        for(File f : files) {
            result.add(new GalleryItem(galleryService, galleryItemFileFilter,
                directoryFileFilter, f));
        }

        return result;
    }

    public List<GalleryRoom> getGalleryRooms() {
        List<GalleryRoom> result = new ArrayList<GalleryRoom>();

        File[] directories = file.listFiles(directoryFileFilter);

        for(File directory : directories) {
            result.add(new GalleryRoom(galleryService, galleryItemFileFilter,
                directoryFileFilter, directory));
        }

        return result;
    }
}
