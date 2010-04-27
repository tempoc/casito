/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.rodriguezcongote.casito.gallery;

import org.apache.tapestry5.ioc.Messages;

/**
 *
 * @author Grodriguez
 */
public enum GalleryItemType {
    JPG,
    PNG,
    UNKNOWN;

    public static final String LOCALIZATION_PREFIX = "gallery.item.type.";

    public String toString(Messages messages) {
        String superString = super.toString();
        String key = LOCALIZATION_PREFIX + superString;
        return messages.contains(key) ? messages.get(key) : superString;
    }
}
