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
import org.apache.tapestry5.services.Request;

/**
 *
 * @author Grodriguez
 */
public class GalleryItem {
    protected GalleryService galleryService;
    
    protected DirectoryFileFilter directoryFileFilter;

    protected GalleryItemFileFilter galleryItemFileFilter;

    protected File file;

    protected String galleryItemType;

    public GalleryItem(GalleryService galleryService,
                       GalleryItemFileFilter galleryItemFileFilter,
                       DirectoryFileFilter directoryFileFilter,
                       File file) {
        this.galleryService = galleryService;
        this.directoryFileFilter = directoryFileFilter;
        this.galleryItemFileFilter = galleryItemFileFilter;
        this.file = file;

        if(!file.isDirectory()) {
            String fn = file.getName();
            int lastDotIndex = fn.lastIndexOf(".");
            if(lastDotIndex >= 0 && fn.length() > lastDotIndex+1) {
                galleryItemType = fn.substring(lastDotIndex + 1);
                galleryItemType = galleryItemType.toLowerCase();
            }
        }
    }

    public String getId() {
        String fullPath = file.getPath();
        String path = fullPath.substring(galleryService.getRootPath().length());
        return path;
    }

    public String getRelativePath() {
        String fullPath = file.getPath();
        String path = fullPath.substring(galleryService.getRootPath().length());
        return path;
    }

    public String getUrl(Request request) {
        String result = request.getContextPath();
        result += galleryService.getRootUrl();
        result += getRelativePath().replaceAll("\\\\", "/");
        return result;
    }

    public String getName() {
        return file.getName();
    }

    public File getFile() {
        return file;
    }

    public GalleryRoom getParent() {
        return isRoot() ? null : new GalleryRoom(galleryService,
            galleryItemFileFilter, directoryFileFilter,
            file.getParentFile());
    }

    public boolean isRoot() {
        return galleryService.getRoot().equals(this);
    }

    public List<GalleryRoom> getAncestors() {
        List<GalleryRoom> ancestors = new ArrayList<GalleryRoom>();

        GalleryRoom ancestor = getParent();

        while(ancestor != null) {
            ancestors.add(0, ancestor);
            ancestor = ancestor.getParent();
        }

        return ancestors;
    }

    public String getGalleryItemType() {
        return galleryItemType;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof GalleryItem && file.equals(((GalleryItem) obj).getFile());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.file != null ? this.file.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return getName();
    }

}
