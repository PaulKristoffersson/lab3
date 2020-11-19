package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ListPopupWindow;


public class MainActivity extends AppCompatActivity {
    EditText editText;
    ListPopupWindow listPopup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.edit_text);
        listPopup = new ListPopupWindow(this);
        InteractiveSearcherTest searcher = new InteractiveSearcherTest(this, editText);
        searcher.Run();
//        searcher.listPopup.show();
    }
}









