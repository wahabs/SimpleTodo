package com.wsheikh.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

  public static final int RESULT_OK = 200;
  private EditText etEditName;
  private EditText etEditDate;
  private int itemPosition;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_item);
    etEditName = (EditText) findViewById(R.id.etEditName);
    etEditDate = (EditText) findViewById(R.id.etEditDate);
    itemPosition = getIntent().getIntExtra("itemPosition", 0);
    etEditName.setText(getIntent().getStringExtra("itemText"));
    etEditDate.setText(getIntent().getStringExtra("itemDate"));
  }

  public void onSaveItem(View v) {
    Intent data = new Intent();
    data.putExtra("newText", etEditName.getText().toString());
    data.putExtra("newDate", etEditDate.getText().toString());
    data.putExtra("position", itemPosition);
    setResult(RESULT_OK, data);
    finish();
  }
}
