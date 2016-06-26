package com.wsheikh.simpletodo;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TodoItem {

  private static final String DATE_FORMAT = "MM/dd";
  private static final String DEFAULT_NAME = "Untitled";

  public Long _id;
  public String name;
  public long dueDate; // in milliseconds from Unix epoch

  public static long defaultDueDate() {
    Calendar c = Calendar.getInstance();
    c.add(Calendar.DATE, 1);
    return c.getTimeInMillis();
  }

  public static String dateStringFromTime(long time) {
    SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);
    return formatter.format(time);
  }

  public static long timeFromDateString(String dateStr) {
    Calendar c = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat(DATE_FORMAT);

    try {
      c.setTime(formatter.parse(dateStr));
    } catch (ParseException e) {
      e.printStackTrace();
    }

    return c.getTimeInMillis();
  }

  public String getDueDate() {
    return dateStringFromTime(dueDate);
  }

  public TodoItem() {
    this(DEFAULT_NAME, defaultDueDate());
  }

  public TodoItem(String name, long dueDate) {
    this.name = name;
    this.dueDate = dueDate;
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
