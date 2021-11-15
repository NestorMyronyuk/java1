package lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Cage {
    private int Number;
    private List<Animal> Animals;
    private Worker Supervisor;

    private Cage(){
        Number = 0;
        Animals = new ArrayList<>();
    }

    public static class Builder{
        private Cage Cage;

        public Builder() {
            Cage = new Cage();
        }
        public Builder addCageNumber(int number){
            assert (number>=0);
            Cage.Number = number;
            return this;
        }
        public Builder addSupervisor(Worker worker){
            assert (worker!=null);
            Cage.Supervisor = worker;
            return this;
        }
        public Builder addAnimal(Animal animal){
            assert (animal!=null && Cage.Animals.contains(animal)==false);
            Cage.Animals.add(animal);
            return this;
        }
        public Builder addAnimals(List<Animal> animals){
            assert (animals!=null);
            Cage.Animals = animals;
            return this;
        }
        public Cage build(){
            assert (Cage.Animals!=null && Cage.Animals.size()!=0);
            assert (Cage.Number>=0);
            return Cage;
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
}
