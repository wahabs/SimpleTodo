package com.wsheikh.simpletodo;

public class TodoItem {

  public Long _id;
  public String name;

  public TodoItem(String name) {
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
}
