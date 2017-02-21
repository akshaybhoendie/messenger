package com.example.android.messenger;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.annotation.Target;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText)findViewById(R.id.sentMessage);
        String message = String.valueOf(messageView.getText());

        //intent for starting second activity
        /*Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra(ReceiveMessageActivity.EXTRA_MESSAGE, message );*/

        //intent for making action to send messeage using other android app that also can send a message
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,message);
        String chooserTitle = getString(R.string.chooseApp);
        Intent chosenIntent =Intent.createChooser(intent,chooserTitle);
        //startActivity(intent);
        startActivity(chosenIntent);



        Toast.makeText(CreateMessageActivity.this,"Message Sent Succesful!",Toast.LENGTH_SHORT).show();


    }
}
