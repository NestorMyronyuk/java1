package lab1_test;

import lab1.Worker;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import static org.testng.Assert.*;

public class WorkerTest {

    @Test
    public void goodCreateTest(){
        new Worker.Builder().addId().addName("a").addSurname("b").addPosition("c").build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void badCreateTest(){
        new Worker.Builder().build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void badCreateTest1(){ new Worker.Builder().addId().build(); }
    @Test(expectedExceptions = AssertionError.class)
    public void badCreateTest2(){
        new Worker.Builder().addId().addName("a").build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void badCreateTest3(){
        new Worker.Builder().addId().addSurname("a").addPosition("b").build();
    }

}