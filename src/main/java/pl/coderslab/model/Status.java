package pl.coderslab.model;

public class Status {

    private int id;
    private String name;


//    accepted; //przyjęty
//    costApproved; //Zatwierdzone koszty naprawy
//    inProgress; //w naprawie
//    ready; //gotowy do odbioru
//    resignation; //rezygnacja

    public Status() {
    }

    public Status(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}