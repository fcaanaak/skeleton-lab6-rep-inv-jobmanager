package jobmanager;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

public class CheckRepTests {

    @Test
    public void test_checkRep1() {
        JobManager jm = new JobManager(1);
        jm.n = 0;
        assertThrows(AssertionError.class, () -> {jm.checkRep();});
    }

    @Test
    public void test_checkRep2() {
        JobManager jm = new JobManager(1);
        jm.n = 1;
        jm.unassignedJobs.clear();
        jm.unassignedJobs.add(1);
        jm.robotToJobs.clear();
        assertDoesNotThrow(() -> {jm.checkRep();});
    }

    @Test
    public void test_checkRep3() {
        JobManager jm = new JobManager(1);
        jm.n = 1;
        jm.unassignedJobs.clear();
        jm.robotToJobs.clear();
        jm.robotToJobs.put(new Robot(1), new TreeSet<>());
        jm.robotToJobs.get(new Robot(1)).add(1);
        assertDoesNotThrow(() -> {jm.checkRep();});
    }

    @Test
    public void test_checkRep4() {
        JobManager jm = new JobManager(1);
        jm.n = 1;
        jm.unassignedJobs.clear();
        jm.robotToJobs.clear();
        assertThrows(AssertionError.class, () -> {jm.checkRep();});
    }

    @Test
    public void test_checkRep5() {
        JobManager jm = new JobManager(1);
        jm.n = 1;
        jm.unassignedJobs.clear();
        jm.robotToJobs.clear();
        jm.robotToJobs.put(new Robot(0), new TreeSet<>());
        assertThrows(AssertionError.class, () -> {jm.checkRep();});
    }

    @Test
    public void test_checkRep6() {
        JobManager jm = new JobManager(1);
        jm.n = 1;
        jm.unassignedJobs.clear();
        jm.unassignedJobs.add(1);
        jm.robotToJobs.clear();
        jm.robotToJobs.put(new Robot(1), new TreeSet<>());
        jm.robotToJobs.get(new Robot(1)).add(1);
        assertThrows(AssertionError.class, () -> {jm.checkRep();});
    }

    @Test
    public void test_checkRep7() {
        JobManager jm = new JobManager(1);
        jm.n = 2;
        jm.unassignedJobs.clear();
        jm.unassignedJobs.add(1);
        jm.robotToJobs.clear();
        jm.robotToJobs.put(new Robot(1), new TreeSet<>());
        jm.robotToJobs.get(new Robot(1)).add(1);
        assertThrows(AssertionError.class, () -> {jm.checkRep();});
    }

    @Test
    public void test_checkRep8() {
        JobManager jm = new JobManager(1);
        jm.n = 2;
        jm.unassignedJobs.clear();
        jm.unassignedJobs.add(2);
        jm.robotToJobs.clear();
        jm.robotToJobs.put(new Robot(1), new TreeSet<>());
        jm.robotToJobs.get(new Robot(1)).add(1);
        jm.robotToJobs.put(new Robot(2), new TreeSet<>());
        jm.robotToJobs.get(new Robot(2)).add(1);
        assertThrows(AssertionError.class, () -> {jm.checkRep();});
    }

    @Test
    public void test_checkRep9() {
        JobManager jm = new JobManager(1);
        jm.n = 2;
        jm.unassignedJobs.clear();
        jm.robotToJobs.clear();
        // this initializes the TreeSet to store the integers in non-increasing order
        jm.robotToJobs.put(new Robot(1), new TreeSet<Integer>(new Comparator<Integer>()
        {
            public int compare(Integer i1,Integer i2)
            {
                return i2.compareTo(i1);
            }
        }));
        jm.robotToJobs.get(new Robot(1)).add(1);
        jm.robotToJobs.get(new Robot(1)).add(2);
        assertThrows(AssertionError.class, () -> {jm.checkRep();});

    }

    @Test
    public void test_checkRep10() {
        JobManager jm = new JobManager(1);
        jm.n = 2;
        jm.unassignedJobs.clear();
        jm.robotToJobs.clear();
        jm.unassignedJobs.add(1);
        jm.unassignedJobs.add(2);
        jm.unassignedJobs.add(3);
        assertThrows(AssertionError.class, () -> {jm.checkRep();});
    }

    @Test
    public void test_checkRep11() {
        JobManager jm = new JobManager(1);
        jm.n = 2;
        jm.unassignedJobs.clear();
        jm.robotToJobs.clear();
        jm.unassignedJobs.add(1);
        jm.unassignedJobs.add(2);
        jm.unassignedJobs.add(0);
        assertThrows(AssertionError.class, () -> {jm.checkRep();});
    }

}
