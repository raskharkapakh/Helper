package kr.kaist.helper;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gaspard on 24/11/17.
 */

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SkypeTutorial extends ListActivity{
    ListView list;
    String[] tutorial = {
            "Open skype",
            "Add contact",
            "Call someone",
            "Enable/disable microphone and camera during call",
            "Have a group call"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skype_tutorial);
        list = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(list.getContext(), android.R.layout.simple_list_item_1, tutorial);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    //open skype
                    case 0:
                        break;
                    //add contact
                    case 1:
                        intent = new Intent(SkypeTutorial.this, AddContactTutorial1.class);
                        startActivity(intent);
                        break;
                    //call someone
                    case 2:
                        intent = new Intent(SkypeTutorial.this, CallSomeoneTutorial1.class);
                        startActivity(intent);
                        break;
                    //Enable/disable microphone and camera during call
                    case 3:
                        break;
                    //Have a group call
                    case 4:
                        break;
                    default:
                        break;

                }
            }
        });
    }


}
