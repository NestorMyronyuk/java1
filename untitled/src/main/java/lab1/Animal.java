package lab1;

import java.util.Objects;
import java.util.UUID;

public class Animal {
    private UUID Id;
    private String Type;
    private String Name;
    private boolean Sex;
    private int Age;

    public static class Builder{
        private Animal Animal;
        private boolean addSex;

        public Builder() {
            Animal = new Animal();
            addSex = false;
        }
        public Builder addId(){
            Animal.Id = UUID.randomUUID();
            return this;
        }
        public Builder addId(UUID id){
            assert(id!=null);
            Animal.Id = id;
            return this;
        }
        public Builder addType(String typeAnimal){
            assert (!Objects.equals(typeAnimal, ""));
            Animal.Type = typeAnimal;
            return this;
        }
        public Builder addName(String name){
            assert (!Objects.equals(name, ""));
            Animal.Name = name;
            return this;
        }
        /**
         * 1 - man, 0 - woman
         * @param sex
         * @return
         */
        public Builder addSex(boolean sex){
            Animal.Sex = sex;
            addSex = true;
            return this;
        }
        public Builder addAge(int age){
            assert (age > 0);
            Animal.Age = age;
            return this;
        }
        public Animal build(){
            assert (Animal.Id!=null);
            assert (!Objects.equals(Animal.Type, ""));
            assert (!Objects.equals(Animal.Name, ""));
            assert (addSex == true);
            assert (Animal.Age != 0);

            return Animal;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Sex == animal.Sex && Age == animal.Age && Objects.equals(Id, animal.Id) && Objects.equals(Type, animal.Type) && Objects.equals(Name, animal.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Type, Name, Sex, Age);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "Id=" + Id +
                ", Type='" + Type + '\'' +
                ", Name='" + Name + '\'' +
                ", Sex=" + Sex +
                ", Age=" + Age +
                '}';
    }
}
