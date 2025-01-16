
package model;

import java.util.ArrayList;


public class ExperienceCandidate extends Candidate{
    private int expInYear;
    private String proSkill;


    public ExperienceCandidate(int candidateId, String firstName, String lastName, String address, String phoneNumber, String email, String email1, int birthDate, int candidateType, String skill) {
        super(candidateId, firstName, lastName, birthDate, address, phoneNumber, email, candidateType);
    }

  
    public ExperienceCandidate(int candidateId, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, int candidateType, int expInYear, String proSkill) {
        super(candidateId, firstName, lastName, birthDate, address, phoneNumber, email, candidateType);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
    
}
