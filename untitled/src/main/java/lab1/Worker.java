package lab1;

import java.util.Objects;
import java.util.UUID;

public class Worker {
    private UUID Id;
    private String Name;
    private String Surname;
    private String Position;

    public Worker(){
        Name ="";
        Surname = "";
        Position = "";
    }

    public static class Builder{
        private Worker Worker;

        public Builder() {
            Worker = new Worker();
        }

        public Builder addId(){
            Worker.Id = UUID.randomUUID();
            return this;
        }
        public Builder addId(UUID id){
            assert (id!=null);
            Worker.Id = id;
            return this;
        }
        public Builder addName(String name){
            assert (!Objects.equals(name, ""));
            Worker.Name = name;
            return this;
        }
        public Builder addSurname(String surname){
            assert (!Objects.equals(surname,""));
            Worker.Surname = surname;
            return this;
        }
        public Builder addPosition(String position){
            assert (!Objects.equals(position, ""));
            Worker.Position = position;
            return this;
        }
        public Worker build(){
            assert (Worker.Id!=null);
            assert (!Objects.equals(Worker.Name, ""));
            assert (!Objects.equals(Worker.Surname, ""));
            assert (!Objects.equals(Worker.Position, ""));
            return Worker;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return Objects.equals(Id, worker.Id) && Objects.equals(Name, worker.Name) && Objects.equals(Surname, worker.Surname) && Objects.equals(Position, worker.Position);
    }


    @Override
    public int hashCode() {
        return Objects.hash(Id, Name, Surname, Position);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Surname='" + Surname + '\'' +
                ", Position='" + Position + '\'' +
                '}';
    }
}
