package com.wsheikh.simpletodo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public class DialogTodoActivity extends AppCompatActivity {
  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    showEditDialog();
  }

  private void showEditDialog() {
    FragmentManager fm = getSupportFragmentManager();
    EditTodoDialogFragment fragment = EditTodoDialogFragment.newInstance("Some Title");
    fragment.show(fm, "fragment_edit_todo");
  }
}
