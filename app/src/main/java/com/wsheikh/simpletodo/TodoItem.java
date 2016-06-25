package com.wsheikh.simpletodo;

public class TodoItem {

  public Long _id;
  public String name;

  public TodoItem(String name) {
    this.name = name;
  }

  public Long get_id() {
    return _id;
  }

  public String toString() {
    return name;
  }
}
