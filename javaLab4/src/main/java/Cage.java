

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.*;

public class Cage implements Comparable<Cage> {
    @Min(1)
    private int Number;
    @NotNull
    @Min(1)
    private List<Animal> Animals;
    @NotNull
    private Worker Supervisor;

    private Cage(){
        Number = 0;
        Animals = new ArrayList<>();
    }

    @Override
    public int compareTo(Cage o) {
        if(Number>o.Number){
            return 1;
        }else if(Number<o.Number){
            return -1;
        }else {
            return 0;
        }
    }

    public static class Builder{
        private Cage Cage;

        public Builder() {
            Cage = new Cage();
        }
        public Builder addCageNumber(int number){
            Cage.Number = number;
            return this;
        }
        public Builder addSupervisor(Worker worker){
            Cage.Supervisor = worker;
            return this;
        }
        public Builder addAnimal(Animal animal){
            Cage.Animals.add(animal);
            return this;
        }
        public Builder addAnimals(List<Animal> animals){
            Cage.Animals = animals;
            return this;
        }
        public Cage build(){
            validate(Cage);
            return Cage;
        }
    }
    private static <T> void validate(T val) throws IllegalArgumentException {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

        Set<ConstraintViolation<T>> check =  validator.validate(val);
        StringBuilder stringBuilder = new StringBuilder();

        for (ConstraintViolation<T> c : check) {
            stringBuilder.append("Error").append(c.getInvalidValue()).append(" because ").append(c.getMessage()).append("\n");
        }
        if(stringBuilder.length()>0){
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cage cage = (Cage) o;
        return Number == cage.Number && Objects.equals(Animals, cage.Animals) && Objects.equals(Supervisor, cage.Supervisor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Number, Animals, Supervisor);
    }

    @Override
    public String toString() {
        return "Cage{" +
                "Number=" + Number +
                ", Animals=" + Animals +
                ", Supervisor=" + Supervisor +
                '}';
    }

    public int getNumber() {
        return Number;
    }

    public void setNumber(int number) {
        Number = number;
    }

    public List<Animal> getAnimals() {
        return Animals;
    }

    public void setAnimals(List<Animal> animals) {
        Animals = animals;
    }

    public Worker getSupervisor() {
        return Supervisor;
    }

    public void setSupervisor(Worker supervisor) {
        Supervisor = supervisor;
    }
}
