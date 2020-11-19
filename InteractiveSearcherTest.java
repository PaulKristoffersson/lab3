package com.example.lab4;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ListPopupWindow;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
public class InteractiveSearcherTest extends View {


    ListPopupWindow listPopup;
    MyAdapter adapter;
    EditText editText;
    Context context;
    int idCounter = 0;
    String url;
    String written;
    int numberOfLinks = 8;
    public InteractiveSearcherTest(final Context context, final EditText editText ){
        super(context);
        this.context = context;
        this.editText = editText;
    }
    public void Run(){
        listPopup = new ListPopupWindow(context);
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(final CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                if(s.length()==0){
                    listPopup.dismiss();
                }
                listPopup.setAnchorView(editText);
                if(s.length()>0){
                    String searchString = s.toString();
                    written = searchString;
                    idCounter++;
                    MyTask task = new MyTask();
                    task.execute(url);
                }

            }
        });
    }

    public class MyTask extends AsyncTask<String, String, JSONObject> {
        ConnectionTest connectionTest = new ConnectionTest();
        JSONObject myResponse;

        @Override
        protected JSONObject doInBackground(String... strings) {
            try{
                myResponse = connectionTest.makeConnection(idCounter, written);

            }catch(Exception e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(JSONObject jsonObject) {

            try{
                JSONArray array  = (JSONArray)myResponse.get("result");
                System.out.println(array);
                ArrayList<String> list = new ArrayList<String>();

                if (array.length()!=0) {
                    int len = array.length();
                    if(len>numberOfLinks){
                        for (int i = 0; i < numberOfLinks; i++) {
                            list.add(array.get(i).toString());
                        }
                    }else{
                        for (int i = 0; i < len; i++) {
                            list.add(array.get(i).toString());
                        }
                    }

                }else{
                    listPopup.dismiss();
                }

                String [] resultToStringed = new String [list.size()];
                for(int i = 0; i<resultToStringed.length;i++){
                    resultToStringed[i] = list.get(i);
                }
                adapter = new MyAdapter(context,resultToStringed);
                adapter.notifyDataSetChanged();
                listPopup.setAdapter(adapter);
                listPopup.show();
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }

}