package pl.coderslab.model;

public class Status {

    private int id;
    private String accepted; //przyjęty
    private String costApproved; //Zatwierdzone koszty naprawy
    private String inProgress; //w naprawie
    private String ready; //gotowy do odbioru
    private String resignation; //rezygnacja

    public Status() {
    }

    public Status(String accepted, String costApproved, String inProgress, String ready, String resignation) {
        this.accepted = accepted;
        this.costApproved = costApproved;
        this.inProgress = inProgress;
        this.ready = ready;
        this.resignation = resignation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccepted() {
        return accepted;
    }

    public void setAccepted(String accepted) {
        this.accepted = accepted;
    }

    public String getCostApproved() {
        return costApproved;
    }

    public void setCostApproved(String costApproved) {
        this.costApproved = costApproved;
    }

    public String getInProgress() {
        return inProgress;
    }

    public void setInProgress(String inProgress) {
        this.inProgress = inProgress;
    }

    public String getReady() {
        return ready;
    }

    public void setReady(String ready) {
        this.ready = ready;
    }

    public String getResignation() {
        return resignation;
    }

    public void setResignation(String resignation) {
        this.resignation = resignation;
    }
}
