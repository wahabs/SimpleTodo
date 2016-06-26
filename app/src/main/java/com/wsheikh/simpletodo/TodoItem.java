package com.wsheikh.simpletodo;

public class TodoItem {

  public Long _id;
  public String name;

  public TodoItem() {
    this("untitled");
  }

  public TodoItem(String name) {
    this.name = name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void set_id(Long _id) {
    this._id = _id;
  }

  public Long get_id() {
    return _id;
  }

  public String toString() {
    return name;
  }
}
