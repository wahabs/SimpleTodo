package com.wsheikh.simpletodo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import nl.qbusict.cupboard.QueryResultIterable;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class MainActivity extends AppCompatActivity {

  static SQLiteDatabase db;

  private static final int REQUEST_CODE = 200;

  private ListView lvItems;
  private EditText etNewItem;

  private ArrayList<TodoItem> items;
  private TodoItemsAdapter itemsAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    lvItems = (ListView) findViewById(R.id.lvItems);
    etNewItem = (EditText) findViewById(R.id.etNewItem);

    SimpleTodoDatabaseHelper dbHelper = new SimpleTodoDatabaseHelper(this);
    db = dbHelper.getWritableDatabase();
    populateItems();
    setupListViewListeners();
  }

  public void onAddItem(View v) {
    TodoItem item = new TodoItem(etNewItem.getText().toString(), TodoItem.defaultDueDate());
    cupboard().withDatabase(db).put(item);
    items.add(item);
    itemsAdapter.notifyDataSetChanged();
    etNewItem.setText("");
  }

  private void populateItems() {
    readItems();
    itemsAdapter = new TodoItemsAdapter(this, items);
    lvItems.setAdapter(itemsAdapter);
  }

  private void setupListViewListeners() {
    lvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
      @Override
      public boolean onItemLongClick(AdapterView<?> adapterView, View itemView, int position, long id) {
        TodoItem item = items.get(position);
        cupboard().withDatabase(db).delete(TodoItem.class, item.get_id());
        items.remove(position);
        itemsAdapter.notifyDataSetChanged();
        return true;
      }
    });

    lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View itemView, int position, long id) {
        launchEditView(position);
      }
    });

  }

  public void launchEditView(int position) {
    Intent i = new Intent(this, EditItemActivity.class);
    i.putExtra("itemPosition", position);
    i.putExtra("itemText", items.get(position).getName());
    startActivityForResult(i, REQUEST_CODE);
  }

  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == REQUEST_CODE && resultCode == EditItemActivity.RESULT_OK) {
      String newText = data.getExtras().getString("newText");
      int position = data.getExtras().getInt("position", 0);
      TodoItem item = new TodoItem(newText, TodoItem.defaultDueDate());
      cupboard().withDatabase(db).delete(items.get(position));
      cupboard().withDatabase(db).put(item);
      items.set(position, item);
      itemsAdapter.notifyDataSetChanged();

      Toast.makeText(this, "Saved!", Toast.LENGTH_SHORT).show();
    }
  }

  private void readItems() {

    items = new ArrayList<>();

    final QueryResultIterable<TodoItem> iter = cupboard().withDatabase(db).query(TodoItem.class).query();
    for (TodoItem item : iter) {
      items.add(item);
    }
    iter.close();
  }

}