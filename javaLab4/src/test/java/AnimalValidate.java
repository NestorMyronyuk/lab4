import org.testng.annotations.Test;

public class AnimalValidate {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void badTest(){
        Animal animal = new Animal.Builder().build();
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void badTest1(){
        Animal animal = new Animal.Builder().addName("123").addType("1213").addAge(-1).build();
    }

}
