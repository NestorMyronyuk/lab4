import org.testng.annotations.Test;

public class WorkerValidate {
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void badTest(){
        Worker worker = new Worker.Builder().build();
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void badTest1(){
    Worker worker = new Worker.Builder().addSurname("-assd").addName("23423").addId(-1).addPosition("345345").build();
    }

}
