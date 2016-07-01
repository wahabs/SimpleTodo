package com.wsheikh.simpletodo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

public class EditTodoDialogFragment extends DialogFragment {

  private EditText etEditName;

  public EditTodoDialogFragment() {}

  public static EditTodoDialogFragment newInstance(String name) {
    EditTodoDialogFragment fragment = new EditTodoDialogFragment();
    Bundle args = new Bundle();
    args.putString("name", name);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_edit_todo, container);
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    etEditName = (EditText) view.findViewById(R.id.etEditName);
    String name = getArguments().getString("name", "Enter Name");
    getDialog().setTitle(name);
    etEditName.requestFocus();
    getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
  }

}
