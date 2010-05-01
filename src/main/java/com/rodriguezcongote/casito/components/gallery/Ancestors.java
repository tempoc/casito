/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.components.gallery;

import com.rodriguezcongote.casito.gallery.GalleryItem;
import com.rodriguezcongote.casito.services.NameService;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 *
 * @author Grodriguez
 */
public class Ancestors {
    @Inject
    private NameService nameService;

    @Inject
    private Messages messages;

    @Parameter(allowNull=false, required=true)
    @Property
    private GalleryItem galleryItem;

    @Parameter(allowNull=false, value="true")
    @Property
    private Boolean renderIfRoot;

    @Property
    private GalleryItem ancestor;

    public String getLocalizedItemName() {
        return getLocalizedFileName(galleryItem);
    }

    public String getLocalizedAncestorName() {
        return getLocalizedFileName(ancestor);
    }

    private String getLocalizedFileName(GalleryItem galleryItem) {
        return nameService.localize(galleryItem, messages);
    }
}
