package com.wsheikh.simpletodo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class EditTodoDialogFragment extends DialogFragment implements TextView.OnEditorActionListener {

  private EditText etEditName;

  public EditTodoDialogFragment() {}

  public interface EditNameDialogListener {
    void onFinishEditDialog(String inputText);
  }

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

  @Override
  public boolean onEditorAction(TextView view, int actionId, KeyEvent event) {
    if (actionId == EditorInfo.IME_ACTION_DONE) {
      EditNameDialogListener listener = (EditNameDialogListener) getActivity();
      listener.onFinishEditDialog(etEditName.getText().toString());
      dismiss();
      return true;
  }
    return false;
  }

}
