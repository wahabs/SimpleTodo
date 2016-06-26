package com.wsheikh.simpletodo;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TodoItem {

  public Long _id;
  public String name;
  public String dueDate;

  public static String defaultDueDate() {
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DATE, 1);
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    return formatter.format(c.getTime());
  }

  public TodoItem() {
    this("untitled", defaultDueDate());
  }

  public TodoItem(String name, String dueDate) {
    this.name = name;
    this.dueDate = dueDate;
  }

  public String getDueDate() {
    return dueDate;
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
