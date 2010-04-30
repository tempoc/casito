/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.pages;

import com.rodriguezcongote.casito.gallery.GalleryItem;
import com.rodriguezcongote.casito.gallery.GalleryRoom;
import com.rodriguezcongote.casito.services.GalleryService;
import com.rodriguezcongote.casito.services.NameService;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Gabriel
 */
public class Gallery {
    @Inject
    private Messages messages;
    @Inject
    private NameService nameService;
    @Inject
    private GalleryService galleryService;
    @Inject
    private Block roomViewBlock;
    @Inject
    private Block defaultViewBlock;
    @Property
    private GalleryItem galleryItem;

    public void onActivate() {
        galleryItem = galleryService.getRoot();
    }

    public boolean onActivate(String galleryItemId) {
        galleryItem = galleryService.getGalleryItem(galleryItemId);
        return true;
    }

    public String getTitle() {
        return messages.get("title") + ":" + getLocalizedDirectoryName();
    }

    public String getLocalizedDirectoryName() {
        return getLocalizedFileName(galleryItem);
    }

    public Block getViewBlock() {
        if(galleryItem instanceof GalleryRoom) {
            return roomViewBlock;
        }

        return defaultViewBlock;
    }

    private String getLocalizedFileName(GalleryItem gi) {
        return nameService.localize(gi, messages);
    }
}
