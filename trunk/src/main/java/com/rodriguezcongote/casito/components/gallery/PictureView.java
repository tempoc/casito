/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.components.gallery;

import com.rodriguezcongote.casito.gallery.GalleryItem;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

/**
 *
 * @author Grodriguez
 */
@IncludeStylesheet("pictureView.css")
public class PictureView {
    @Property
    @Parameter(allowNull=false, required=true)
    private GalleryItem galleryItem;
    
    @Inject
    private Request request;

    public String getUrl() {
        return galleryItem.getUrl(request);
    }

}
