
public class Person {
  private String name;
  private String job;

  public Person(String name, String job) {
    this.name = name;
    this.job = job;
  }

  @Override
  public String toString() {
    return "Person [name=" + name + ", job=" + job + "]";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getJob() {
    return job;
  }

  public void setJob(String job) {
    this.job = job;
  }

}
