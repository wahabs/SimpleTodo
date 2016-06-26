package com.wsheikh.simpletodo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class TodoItemsAdapter extends ArrayAdapter<TodoItem> {
  public TodoItemsAdapter(Context context, ArrayList<TodoItem> todoItems) {
    super(context, 0, todoItems);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    TodoItem item = getItem(position);
    if (convertView == null) {
      convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_todo, parent, false);
    }

    TextView tvTodoName = (TextView) convertView.findViewById(R.id.tvTodoName);
    TextView tvDate = (TextView) convertView.findViewById(R.id.tvDate);

    tvTodoName.setText(item.getName());
    tvDate.setText(item.getDueDate());

    return convertView;
  }

}