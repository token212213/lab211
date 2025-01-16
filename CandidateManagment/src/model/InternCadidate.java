
package model;

import java.util.ArrayList;

/**
 *
 * @author Đàm Quang Chiến
 */
public class InternCadidate extends Candidate{
    private String major;
    private int semester;
    private String uniName;

    public InternCadidate(int candidateId, String firstName, String lastName, int birthDate, String address, String phoneNumber, String email, int candidateType,String major, int semester, String uniName) {
        super(candidateId, firstName, lastName, birthDate, address, phoneNumber, email, candidateType);
        this.major = major;
        this.semester = semester;
        this.uniName = uniName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getUniName() {
        return uniName;
    }

    public void setUniName(String uniName) {
        this.uniName = uniName;
    }
  
}
