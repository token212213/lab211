/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Đàm Quang Chiến
 */
public class FresherCandidate extends Candidate{
    private int graduatedTime;
    private String rankOfGraduation;
    private String education;
    
    public FresherCandidate(int candidateId, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, int candidateType, int graduatedTime, String rankOfGraduation, String email2) {
        super(candidateId, firstName, lastName, birthDate, address, phoneNumber, email, candidateType);
        this.graduatedTime = graduatedTime;
        this.education = education;
        this.rankOfGraduation = rankOfGraduation;
    }

    public int getGraduatedTime() {
        return graduatedTime;
    }

    public void setGraduatedTime(int graduatedTime) {
        this.graduatedTime = graduatedTime;
    }

    public String getRankOfGraduation() {
        return rankOfGraduation;
    }

    public void setRankOfGraduation(String rankOfGraduation) {
        this.rankOfGraduation = rankOfGraduation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    
}
