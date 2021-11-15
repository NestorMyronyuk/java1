package lab1_test;

import lab1.Animal;
import lab1.Cage;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class AnimalTest {

    @Test
    public void GoodCreateTest(){
        new Animal.Builder().addId().addName("a").addAge(1).addType("b").addSex(true).build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void BadCreateTest(){
        new Animal.Builder().addId().addName("a").addSex(true).build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void BadCreateTest1(){
        new Animal.Builder().addId().addSex(true).build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void BadCreateTest2(){
        new Animal.Builder().addName("a").addAge(1).addSex(true).build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void BadCreateTest3(){
        new Animal.Builder().build();
    }

}