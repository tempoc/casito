/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.pages;

import com.rodriguezcongote.casito.gallery.GalleryItem;
import com.rodriguezcongote.casito.gallery.GalleryRoom;
import com.rodriguezcongote.casito.services.GalleryService;
import com.rodriguezcongote.casito.services.DirectoryFileFilter;
import com.rodriguezcongote.casito.services.GalleryItemFileFilter;
import com.rodriguezcongote.casito.services.NameService;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Gabriel
 */
public class Gallery {
    @Inject
    private GalleryService galleryService;

    @Inject
    private Messages messages;

    @Inject
    private NameService nameService;

    @Inject
    private DirectoryFileFilter folderFileFilter;

    @Inject
    private GalleryItemFileFilter galleryItemFileFilter;

    @Property
    private GalleryRoom galleryRoom;

    @Property
    private GalleryItem child;

    public void onActivate() {
        galleryRoom = galleryService.getRoot();
    }

    public boolean onActivate(String galleryItemId) {
        this.galleryRoom = (GalleryRoom) galleryService.getGalleryItem(galleryItemId);
        return true;
    }

    public String getLocalizedDirectoryName() {
        return getLocalizedFileName(galleryRoom);
    }

    public String getLocalizedChildName() {
        return getLocalizedFileName(child);
    }
    
    private String getLocalizedFileName(GalleryItem galleryItem) {
        return nameService.localize(galleryItem, messages);
    }

    public String getTitle() {
        return messages.get("title") + ":" + getLocalizedDirectoryName();
    }
}
