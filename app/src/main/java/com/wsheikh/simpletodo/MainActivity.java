package com.wsheikh.simpletodo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

  private static final int REQUEST_CODE = 200;

  private ListView lvItems;
  private EditText etNewItem;

  private ArrayList<String> items;
  private ArrayAdapter<String> itemsAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    lvItems = (ListView) findViewById(R.id.lvItems);
    etNewItem = (EditText) findViewById(R.id.etNewItem);
    populateItems();
    setupListViewListeners();
  }

  public void onAddItem(View v) {
    String itemText = etNewItem.getText().toString();
    itemsAdapter.add(itemText);
    etNewItem.setText("");
    writeItems();
  }

  private void populateItems() {
    readItems();
    itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
    lvItems.setAdapter(itemsAdapter);
  }

  private void setupListViewListeners() {
    lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(AdapterView<?> adapterView, View item, int position, long id) {
        items.remove(position);
        itemsAdapter.notifyDataSetChanged();
        writeItems();
        return true;
      }
    });

    lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View item, int position, long id) {
        launchEditView(position);
      }
    });

  }

  public void launchEditView(int position) {
    Intent i = new Intent(this, EditItemActivity.class);
    i.putExtra("itemPosition", position);
    i.putExtra("itemText", items.get(position));
    startActivityForResult(i, REQUEST_CODE);
  }

  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CODE && resultCode == EditItemActivity.RESULT_OK) {
      String newText = data.getExtras().getString("newText");
      int position = data.getExtras().getInt("position", 0);
      items.set(position, newText);
      itemsAdapter.notifyDataSetChanged();
      writeItems();
      Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }
  }

  private void readItems() {
    File filesDir = getFilesDir();
    File todoFile = new File(filesDir, "todo.txt");
    try {
      items = new ArrayList<String>(FileUtils.readLines(todoFile));
    } catch (IOException e) {
      items = new ArrayList<String>();
    }
  }

  private void writeItems() {
    File filesDir = getFilesDir();
    File todoFile = new File(filesDir, "todo.txt");
    try {
      FileUtils.writeLines(todoFile, items);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }



}




























//