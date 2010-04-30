/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.components.gallery;

import com.rodriguezcongote.casito.gallery.GalleryItem;
import com.rodriguezcongote.casito.gallery.GalleryRoom;
import com.rodriguezcongote.casito.services.NameService;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Grodriguez
 */
public class RoomView {

    @Inject
    private NameService nameService;
    @Inject
    private Messages messages;
    @Property
    @Parameter(defaultPrefix=BindingConstants.PROP, required=true, allowNull=false)
    private GalleryRoom galleryRoom;
    @Property
    private GalleryItem child;

    public String getLocalizedDirectoryName() {
        return getLocalizedFileName(galleryRoom);
    }

    public String getLocalizedChildName() {
        return getLocalizedFileName(child);
    }

    private String getLocalizedFileName(GalleryItem galleryItem) {
        return nameService.localize(galleryItem, messages);
    }

}
