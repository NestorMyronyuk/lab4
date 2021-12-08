import org.testng.annotations.Test;

public class CageValidate {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void badTest(){
       Cage cage = new Cage.Builder().build();
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void badTest1(){
        Cage cage = new Cage.Builder().addCageNumber(-1).addAnimal(new Animal()).addAnimal(new Animal()).addSupervisor(new Worker()).build();
    }
}
