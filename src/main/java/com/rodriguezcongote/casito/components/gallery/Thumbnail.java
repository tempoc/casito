/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.components.gallery;

import com.rodriguezcongote.casito.gallery.GalleryItem;
import com.rodriguezcongote.casito.services.NameService;
import org.apache.tapestry5.Block;
import org.apache.tapestry5.annotations.IncludeStylesheet;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;

/**
 *
 * @author Grodriguez
 */
@IncludeStylesheet("thumbnail.css")
public class Thumbnail {
    @Inject
    private NameService nameService;

    @Inject
    private Messages messages;

    @Inject
    private Request request;

    @Inject
    private Block pictureBlock;

    @Inject
    private Block undefinedBlock;

    @Property
    @Parameter(defaultPrefix="prop", allowNull=false, required=true)
    private GalleryItem galleryItem;

    public String getName() {
        return nameService.localize(galleryItem, messages);
    }

    public String getSource() {
        String result = request.getContextPath();
        result += "/content";
        result += galleryItem.getRelativePath().replaceAll("\\\\", "/");
        return result;
    }

    public Block getThumbnailBlock() {
        switch(galleryItem.getGalleryItemType()) {
            case JPG:
            case PNG:
                return pictureBlock;
            default:
                return undefinedBlock;
        }
    }

}
