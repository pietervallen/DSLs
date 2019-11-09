package net.vallen;

public class AbstractEvent {
  private String name;
  private String code;

  public AbstractEvent(String name, String code) {
    this.name = name;
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public String getCode() {
    return code;
  }
}
