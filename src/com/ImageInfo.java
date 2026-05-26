/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

/**
 *
 * @author luayon
 */
public class ImageInfo {

    private final String imageName;
    private final String name;
    private final String entryId;
    private final boolean isStudent;

    public ImageInfo(String imageName, String name, String entryId, boolean isStudent) {
        this.imageName = imageName;
        this.name = name;
        this.entryId = entryId;
        this.isStudent = isStudent;
    }

    // Getter methods
    public String getImageName() {
        return imageName;
    }

    public String getName() {
        return name;
    }

    public String getEntryId() {
        return entryId;
    }

    public boolean isStudent() {
        return isStudent;
    }
}
