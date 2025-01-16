import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import controller.Management;
import model.SalaryHistory;
import model.Worker;

public class ManagementTest {
    private Management management;
    private ArrayList<Worker> listWorker;
    private ArrayList<SalaryHistory> listHistory;

    @Before
    public void setUp() {
        management = new Management();
        listWorker = new ArrayList<>();
        listHistory = new ArrayList<>();
    }

    @Test
    public void testCheckWorkerExist() {
        Worker worker = new Worker("1", "John", 25, 5000, "New York");
        listWorker.add(worker);
        management.addWorker(worker);
        assertTrue(management.checkWorkerExist("2"));
        assertFalse(management.checkWorkerExist("1"));
    }

    @Test
    public void testAddWorker() {
        Worker worker = new Worker("1", "John", 25, 5000, "New York");
        management.addWorker(worker);
        assertEquals(1, management.listWorker.size());
    }

    @Test
    public void testPrintHistory() {
        SalaryHistory history = new SalaryHistory("UP", "01/01/2022", "1", "John", 25, 6000, "New York");
        listHistory.add(history);
        management.listHistory = listHistory;
        String expected = String.format("%-8s%-15s%-5s%-8s%-8s%-10s \n", "Code", "Name", "Age", "Salary", "Status", "Date") + history.toString() + "\n";
        assertEquals(expected, management.printHistory());
    }

    @Test
    public void testSortList() {
        SalaryHistory history1 = new SalaryHistory("UP", "01/01/2022", "1", "John", 25, 6000, "New York");
        SalaryHistory history2 = new SalaryHistory("DOWN", "01/01/2022", "2", "Jane", 30, 4000, "Los Angeles");
        listHistory.add(history1);
        listHistory.add(history2);
        management.listHistory = listHistory;
        management.sortList();
        assertEquals(history2, management.listHistory.get(0));
        assertEquals(history1, management.listHistory.get(1));
    }

    @Test
    public void testUpSalary() {
        Worker worker = new Worker("1", "John", 25, 5000, "New York");
        management.addWorker(worker);
        management.upSalary("1", 1000);
        assertEquals(6000, worker.getSalary(), 0);
        assertEquals(1, management.listHistory.size());
        assertEquals("UP", management.listHistory.get(0).getStatus());
    }

    @Test
    public void testDownSalary() {
        Worker worker = new Worker("1", "John", 25, 5000, "New York");
        management.addWorker(worker);
        management.downSalary("1", 1000);
        assertEquals(4000, worker.getSalary(), 0);
        assertEquals(1, management.listHistory.size());
        assertEquals("DOWN", management.listHistory.get(0).getStatus());
    }
}