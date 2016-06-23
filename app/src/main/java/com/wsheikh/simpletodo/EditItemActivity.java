package com.wsheikh.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {

  public static final int RESULT_OK = 200;
  private EditText etEditItem;
  private int itemPosition;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_item);
    etEditItem = (EditText) findViewById(R.id.etEditItem);
    itemPosition = getIntent().getIntExtra("itemPosition", 0);
    etEditItem.setText(getIntent().getStringExtra("itemText"));
  }

  public void onSaveItem(View v) {
    Intent data = new Intent();
    data.putExtra("newText", etEditItem.getText().toString());
    data.putExtra("position", itemPosition);
    setResult(RESULT_OK, data);
    finish();
  }
}
