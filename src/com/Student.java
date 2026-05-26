/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import javax.swing.ImageIcon;

/**
 *
 * @author luayon
 */
public class Student {

    // Member variables
    private final String studentNumber;
    private final String name;
    private final String course;
    private final String contact;
    private final boolean isStudent;
    private final String entryPermitImage;
    private final String inImage;
    private final String outImage;
    private final String image;

    // Constructor
    public Student(String studentNumber, String name, String course, String contact, boolean isStudent,
            String entryPermitImage, String inImage, String outImage, String image) {
        this.studentNumber = studentNumber;
        this.name = name;
        this.course = course;
        this.contact = contact;
        this.isStudent = isStudent;
        this.entryPermitImage = entryPermitImage;
        this.inImage = inImage;
        this.outImage = outImage;
        this.image = image;
    }

    // Getter methods
    public String getStudentNumber() {
        return studentNumber;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public String getContact() {
        return contact;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public String getEntryPermitImage() {
        return entryPermitImage;
    }

    public String getInImage() {
        return inImage;
    }

    public String getOutImage() {
        return outImage;
    }

    public String getImage() {
        return image;
    }
}
