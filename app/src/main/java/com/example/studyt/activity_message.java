package com.example.studyt;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import android.text.format.DateFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class activity_message extends AppCompatActivity {

    private static int SIGN_IN_CODE = 1;
    private RelativeLayout activity_message;
    private FirebaseListAdapter<Message> adapter;
    private ImageButton sendButton;
    private DatabaseReference reference;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        activity_message = findViewById(R.id.activity_message);

        sendButton = findViewById(R.id.buttonSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText textField = findViewById(R.id.editText);
                if (textField.getText().toString().equals("")) {
                    return;
                }
                FirebaseDatabase.getInstance().getReference().push().setValue(
                        new Message(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getEmail(), textField.getText().toString()));
                textField.setText("");
            }
        });
        displayMessages();
    }
//    ListView listOfMessages = (ListView)findViewById(R.id.listofmessages);

//    Query query = FirebaseDatabase.getInstance().getReference().child("Chats");
//    public void displayChat() {
//        FirebaseListOptions<Message> options = new FirebaseListOptions.Builder<Message>()
//                .setQuery(query, Message.class)
//                .build();
//
//        FirebaseListAdapter<Message> adapter = new FirebaseListAdapter<Message>(options) {
//            @Override
//            protected void populateView(View v, Message model, int position) {                // Get references to the views of message.xml
//                TextView messageText = (TextView) v.findViewById(R.id.message_text);
//                TextView messageUser = (TextView) v.findViewById(R.id.message_user);
//                TextView messageTime = (TextView) v.findViewById(R.id.message_time);
//
//                // Set their text
//                messageText.setText(model.getTextMessage());
//                messageUser.setText(model.getUserName());
//
//                // Format the date before showing it
//                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)",
//                        model.getMessageTime()));
//            }
//        };
//
//        listOfMessages.setAdapter(adapter);


//    Query query = FirebaseDatabase.getInstance().getReference().child("chats");
//        private void displayAllMessages () {
//        Query query = FirebaseDatabase.getInstance().getReference().child("chats");
////            reference = FirebaseDatabase.getInstance().getReference("Messages");
//            ListView listofmessages = findViewById(R.id.listofmessages);
//            FirebaseListOptions<Message> options = new FirebaseListOptions.Builder<Message>().setQuery(query, Message.class).setLayout(R.layout.list_item).build();
//            adapter = new FirebaseListAdapter<Message>(options) {
//                @Override
//                protected void populateView(@NonNull View v, @NonNull Message model, int position) {
//                    TextView mesUser, mesTime, mesText;
//                    mesUser = v.findViewById(R.id.message_user);
//                    mesTime = v.findViewById(R.id.message_time);
//                    mesText = v.findViewById(R.id.message_text);
//
//                    mesUser.setText(model.getUserName());
//                    mesText.setText(model.getTextMessage());
//                    mesTime.setText(DateFormat.format("dd-MM-yyyy HH:mm:ss", model.getMessageTime()));
//                }
//            };
//            listofmessages.setAdapter(adapter);
//            adapter.startListening();
//        }
////        @Override
////        protected void onStop () {
////            super.onStop();
////            if (adapter != null) adapter.stopListening();
////        }
////
//    }

        public void displayMessages() {
            reference = database.getReference();
            Query query = FirebaseDatabase.getInstance().getReference();
            ListView listOfMessage = (ListView) findViewById(R.id.listofmessages);
            FirebaseListOptions<Message> options = new FirebaseListOptions.Builder<Message>().setQuery(query, Message.class).setLayout(R.layout.list_item).build();
            adapter = new FirebaseListAdapter<Message>(options) {
                @Override
                protected void populateView(@NonNull View v, @NonNull Message model, int position) {
                    TextView messageUser, messageTime, messageText;
                    messageUser = v.findViewById(R.id.message_user);
                    messageTime = v.findViewById(R.id.message_time);
                    messageText = v.findViewById(R.id.message_text);

                    messageUser.setText(model.getUserName());
                    messageText.setText(model.getTextMessage());
                    messageTime.setText(DateFormat.format("dd-MM-yyyy HH:mm:ss", model.getMessageTime()));
                }
            };
            listOfMessage.setAdapter(adapter);
            adapter.startListening();
        }
    }





//            @Override
//            protected void populateView(View v, Message model, int position) {
//                //Get references to the views of list_item.xml
//                TextView messageText, messageUser, messageTime;
//                messageText = (TextView) v.findViewById(R.id.message_text);
//                messageUser = (TextView) v.findViewById(R.id.message_user);
//                messageTime = (TextView) v.findViewById(R.id.message_time);
//                messageText.setText(model.getMessageText());
//                messageUser.setText(model.getMessageUser());
//                messageTime.setText(DateFormat.format("dd-MM-yyyy (HH:mm:ss)", model.getMessageTime()));
//
//            }
//        };
//        listOfMessages.setAdapter(adapter);
//    }
//        ListView listOfMessages = (ListView) findViewById(R.id.listOfMessages);
//        FirebaseListOptions<Message> options = new FirebaseListOptions.Builder<Message>()
//                .setQuery(FirebaseDatabase.getInstance().getReference(), Message.class)
//                .build();
//
//        FirebaseListAdapter<Message> adapter = new FirebaseListAdapter<Message>( Message.class, R.layout.list_item, FirebaseDatabase.getInstance().getReference()) {
//            @Override
//            protected void populateView(@NonNull View v, @NonNull Message model, int position) {
//                // Bind the Chat to the view
//                // ...
//            }
//        };
//        ListView listOfMessages = findViewById(R.id.listOfMessages);
//        FirebaseListOptions.Builder<Message> builder = new FirebaseListOptions.Builder<>();
//        builder.setQuery(FirebaseDatabase.getInstance().getReference(), Message.class).setLayout(R.layout.list_item).build();
//        adapter = new FirebaseListAdapter<Message>(FirebaseListOptions<Message>) {
//            @Override
//            protected void populateView(@NonNull View v, @NonNull Message model, int position) {
//
//            }
//        }
//        adapter = new FirebaseListAdapter<Message>(this, Message.class, R.layout.list_item, FirebaseDatabase.getInstance().getReference(),) {
//            @Override
//            protected void populateView(@NonNull View v, @NonNull Message model, int position) {
//
//            }
//        };
