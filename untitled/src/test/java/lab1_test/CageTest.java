package lab1_test;

import lab1.Animal;
import lab1.Cage;
import lab1.Worker;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CageTest {
    Animal animal = new Animal.Builder().addId().addName("a").addAge(1).addSex(true).addType("b").build();
    Animal animal1 = new Animal.Builder().addId().addName("a").addAge(1).addSex(true).addType("b").build();
    Worker worker = new Worker.Builder().addId().addName("a").addSurname("b").addPosition("c").build();

    @Test
    public void GoodCreateTest(){new Cage.Builder().addAnimal(animal).addAnimal(animal1).addCageNumber(1).addSupervisor(worker).build();}
    @Test(expectedExceptions = AssertionError.class)
    public void BadCreateTest1(){
        new Cage.Builder().addCageNumber(1).build();
    }
    @Test(expectedExceptions = AssertionError.class)
    public void BadCreateTest2(){new Cage.Builder().addAnimal(animal1).build();}
    @Test(expectedExceptions = AssertionError.class)
    public void BadCreateTest3(){new Cage.Builder().addSupervisor(worker).addCageNumber(1).build();}
    @Test(expectedExceptions = AssertionError.class)
    public void BadCreateTest4(){new Cage.Builder().addSupervisor(worker).addCageNumber(1).addAnimal(animal1).build();}
    @Test(expectedExceptions = AssertionError.class)
    public void BadCreateTest(){
        new Cage.Builder().addCageNumber(1).addAnimal(animal1).addAnimal(animal).build();
    }

}