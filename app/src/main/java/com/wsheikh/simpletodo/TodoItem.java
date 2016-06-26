package com.wsheikh.simpletodo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TodoItem {

  public Long _id;
  public String name;
  public Calendar dueDate;

  public TodoItem(String name, Calendar dueDate) {
    this.name = name;
    this.dueDate = dueDate;
  }

  public TodoItem(String name) {
    Calendar dueDate = Calendar.getInstance();
    dueDate.add(Calendar.DATE, 1);
    this.name = name;
    this.dueDate = dueDate;
  }

  public Long get_id() {
    return _id;
  }

  public String toString() {
    return name;
  }

  public String getName() {
    return name;
  }

  public String getDueDate() {
    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    return formatter.format(dueDate.getTime());
  }
}
