
package model;

/**
 *
 * @author Đàm Quang Chiến
 */
public class Storekeeper {
    private String storekeeperId;
    private String storekeeperName;

    public Storekeeper() {
    }

    public Storekeeper(String storekeeperId, String storekeeperName) {
        this.storekeeperId = storekeeperId;
        this.storekeeperName = storekeeperName;
    }

    public String getStorekeeperId() {
        return storekeeperId;
    }

    public void setStorekeeperId(String storekeeperId) {
        this.storekeeperId = storekeeperId;
    }

    public String getStorekeeperName() {
        return storekeeperName;
    }

    public void setStorekeeperName(String storekeeperName) {
        this.storekeeperName = storekeeperName;
    }

    public void print() {
        System.out.printf("%-5s%5s\n",this.storekeeperId,this.storekeeperName);
    }
    
    
}
