/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.services;

import com.rodriguezcongote.casito.gallery.GalleryItem;
import com.rodriguezcongote.casito.gallery.GalleryRoom;

/**
 *
 * @author Gabriel
 */
public interface GalleryService {
    String getRootPath();
    GalleryRoom getRoot();
    GalleryItem getGalleryItem(String path);
}
