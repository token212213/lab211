
package model;

import java.util.ArrayList;

/**
 *
 * @author Đàm Quang Chiến
 */
public class CandidateList {
    private ArrayList<ExperienceCandidate> listExp;
    private ArrayList<FresherCandidate> listFresher;
    private ArrayList<InternCadidate> listIntern;

    public CandidateList() {
        this.listExp = new ArrayList<ExperienceCandidate>();
        this.listFresher = new ArrayList<FresherCandidate>();
        this.listIntern = new ArrayList<InternCadidate>();
    }

    public CandidateList(ArrayList<ExperienceCandidate> listExp, ArrayList<FresherCandidate> listFresher, ArrayList<InternCadidate> listIntern) {
        this.listExp = listExp;
        this.listFresher = listFresher;
        this.listIntern = listIntern;
    }

    public ArrayList<ExperienceCandidate> getListExp() {
        return listExp;
    }

    public void setListExp(ArrayList<ExperienceCandidate> listExp) {
        this.listExp = listExp;
    }

    public ArrayList<FresherCandidate> getListFresher() {
        return listFresher;
    }

    public void setListFresher(ArrayList<FresherCandidate> listFresher) {
        this.listFresher = listFresher;
    }

    public ArrayList<InternCadidate> getListIntern() {
        return listIntern;
    }

    public void setListIntern(ArrayList<InternCadidate> listIntern) {
        this.listIntern = listIntern;
    }
    
    public void printExpList(){
        for(ExperienceCandidate expCan : listExp){
            System.out.println(expCan.getFirstName()+" "+ expCan.getLastName());
        }
    }
    
    public void printFresherList(){
        for(FresherCandidate fresherCan : listFresher){
            System.out.println(fresherCan.getFirstName()+" "+ fresherCan.getLastName());
        }
    }
    
    public void printInternList(){
        for(InternCadidate internCan : listIntern){
            System.out.println(internCan.getFirstName()+" "+ internCan.getLastName());
        }
    }
    
    

}
