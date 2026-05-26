/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author luayon
 */
public class StudentInfo {
    private static final String HIGHSCORE_FILE = "highest_score.dat";

    private static int score;
    private static int highestScore;
    private static int highScore;
    private static int mistakes;
    
    private static final Random random = new Random();
    private static final List<String> imageNames = Arrays.asList("BLOOM", "STELLA", "FLORA", "MUSA", "STORMY", "AISHA", "DIASPRO", "ICY", "DARCY", "STORMY");
    private static final List<String> studentCourses = Arrays.asList("BS HRM", "BS ASTRONOMY", "BS ENVI SCI", "BA in Music", "BS IT", "BS FAR", "BS MINERALOGY", "BS MET", "BS ASTRONOMY", "BS MET");
    private static final List<String> studentNumbers = Arrays.asList("2014-21", "2014-22", "2014-23", "2014-24", "2014-25", "2014-26", "5623-31", "5623-32", "5623-33", "5623-34");
    private static final List<String> studentContacts = Arrays.asList("09876543212", "09785634123", "09132548769", "09786645321", "09567843219", "09987123456", "094563278192", "09897865432", "09132456782", "09890768541");
    private static final List<String> nonStudentNames = Arrays.asList("DIASPRO", "ICY", "DARCY", "STORMY");

    private static final String IMAGE_FOLDER = "src/RESIZED CHARACTERS/";
    private static final String ENTRY_PERMIT_FOLDER = "src/ENTRY PERMIT/";
    private static final String IMAGE_EXTENSION = ".png";

    public static Student generateRandomStudent() {
        String imageName = getRandomElement(imageNames);
        String inImage = IMAGE_FOLDER + imageName + " IN" + IMAGE_EXTENSION;
        String outImage = IMAGE_FOLDER + imageName + " OUT" + IMAGE_EXTENSION;
        String name = imageName;
        String studentNum = getRandomElement(studentNumbers);
        String course = getRandomElement(studentCourses);
        String contact = getRandomElement(studentContacts);
        boolean isStudent = !nonStudentNames.contains(imageName);
        String image = IMAGE_FOLDER + imageName + IMAGE_EXTENSION;

        return new Student(studentNum, name, course, contact, isStudent, ENTRY_PERMIT_FOLDER + imageName + IMAGE_EXTENSION, inImage, outImage, image);
    }

    private static String getRandomElement(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }

    public static void updateScoreFile(int amount) {
        score += amount;
        if (score > highestScore) {
            highestScore = score;
            saveHighestScore(); // Save the new highest score
        }
    }

    public static void updateScore(int amount) {
        score += amount;
        if (score > highScore) {
            highScore = score;
        }
        if (score > highestScore) {
            highestScore = score;
            saveHighestScore();
        }
    }

    public static void updateMistakes() {
        int deduction = getRandomDeduction();
        score -= deduction;
        mistakes++;
    }

    private static int getRandomDeduction() {
        int[] deductions = {1, 3, 5};
        return deductions[random.nextInt(deductions.length)];
    }

    public static int getScore() {
        return score;
    }

    public static int getHighScore() {
        return highScore;
    }

    public static int getHighestScore() {
        return highestScore;
    }

    public static int getMistakes() {
        return mistakes;
    }

    public static String getScoreAsString() {
        return "" + score;
    }

    public static String getHighestScoreAsString() {
        return "" + highestScore;
    }

    public static String getHighScoreAsString() {
        return "" + highScore;
    }

    public static String getRandomDeductionAsString() {
        return "-" + getRandomDeduction();
    }

    public static void reset() {
        score = 0;
        highScore = 0; // Reset highScore as well
        mistakes = 0;
    }

    private static void saveHighestScore() {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(HIGHSCORE_FILE))) {
            dos.writeInt(highestScore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadHighestScore() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(HIGHSCORE_FILE))) {
            highestScore = dis.readInt();
        } catch (FileNotFoundException e) {
            // If the file doesn't exist yet, set highest score to 0
            highestScore = 0;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void initialize() {
        loadHighestScore();
    }
}