package com.wsheikh.simpletodo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class DialogTodoActivity extends AppCompatActivity implements EditTodoDialogFragment.EditNameDialogListener {
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

  @Override
  public void onFinishEditDialog(String inputText) {
    Toast.makeText(this, "Hi, " + inputText, Toast.LENGTH_SHORT).show();
  }
}
