package dev.ikhtiyor.learn.payload;

public class ReqAuthor {
    private String fistName;
    private String lastName;

    public String getFistName() {
        return fistName;
    }

    public void setFistName(String fistName) {
        this.fistName = fistName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "ReqAuthor{" +
                "fistName='" + fistName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
