package kr.kaist.helper;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.content.Intent;

/**
 * Created by gaspard on 24/11/17.
 */

public class SkypeTutorial extends AppCompatActivity {
    /*
    ListView list;
    String[] tutorial = {
            //"Open skype",
            "전화번호를 추가하기",
            "통화를 시작하기",
            "통화중 카메라와 마이크 키고 끄기"
            //"Have a group call"
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skype_tutorial);

        Button addButton = findViewById(R.id.addbutton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(SkypeTutorial.this, AddContactTutorial1.class);
            startActivity(intent);
            }
        });

        Button callButton = findViewById(R.id.callbutton);

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkypeTutorial.this, CallSomeoneTutorial1.class);
                startActivity(intent);
            }
        });

        Button micButton = findViewById(R.id.miccambutton);

        micButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SkypeTutorial.this,MicCamTutotorialStep1.class);
                startActivity(intent);
            }
        });
        /*
        list = getListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(list.getContext(), android.R.layout.simple_list_item_1, tutorial);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent;
                switch (i) {
                    //open skype
                    //case 0:
                        //break;
                    //add contact
                    case 0:
                        intent = new Intent(SkypeTutorial.this, AddContactTutorial1.class);
                        startActivity(intent);
                        break;
                    //call someone
                    case 1:
                        intent = new Intent(SkypeTutorial.this, CallSomeoneTutorial1.class);
                        startActivity(intent);
                        break;
                    //Enable/disable microphone and camera during call
                    case 2:
                        intent = new Intent(SkypeTutorial.this,MicCamTutotorialStep1.class);
                        startActivity(intent);
                        break;
                    //Have a group call
                    //case 4:
                        //break;
                    default:
                        break;

                }
            }
        });
        */
    }


}
