import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
  private final StringProperty name = new SimpleStringProperty("");
  private final StringProperty job = new SimpleStringProperty("");

  public Person(String name, String job) {
    setName(name);
    setJob(job);
  }

  @Override
  public String toString() {
    return "Person [name=" + getName() + ", job=" + getJob() + "]";
  }

  public String getName() {
    return name.get();
  }

  public void setName(String name) {
    this.name.set(name);
    ;
  }

  public String getJob() {
    return job.get();
  }

  public void setJob(String job) {
    this.job.set(job);
    ;
  }

}
