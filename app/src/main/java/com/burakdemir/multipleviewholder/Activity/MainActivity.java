package com.burakdemir.multipleviewholder.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.burakdemir.multipleviewholder.Adapter.CallSmsAdapter;
import com.burakdemir.multipleviewholder.Model.Call;
import com.burakdemir.multipleviewholder.Model.Sms;
import com.burakdemir.multipleviewholder.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Object> callSmsList;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        recyclerView = findViewById(R.id.recyclerView);

        CallSmsAdapter callSmsAdapter = new CallSmsAdapter(this, callSmsList); // adapter
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false); // layout

        recyclerView.setAdapter(callSmsAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void init() {

        callSmsList = new ArrayList<>();

        callSmsList.add(new Call("John","9:30 AM"));
        callSmsList.add(new Call("Rob","9:40 AM"));
        callSmsList.add(new Sms("Sandy","Hey, what's up?","9:42 AM"));
        callSmsList.add(new Call("Peter","9:45 AM"));
        callSmsList.add(new Sms("John","Are you writing blog?","9:48 AM"));
        callSmsList.add(new Call("Jack","9:50 AM"));
        callSmsList.add(new Call("Bob","9:55 AM"));
        callSmsList.add(new Sms("Kora","Thanks dude","9:57 AM"));
        callSmsList.add(new Call("Sandy","10:00 AM"));
        callSmsList.add(new Call("Kate","10:05 AM"));
        callSmsList.add(new Sms("Nick","Let's hang up","10:10 AM"));
        callSmsList.add(new Call("Roger","10:15 AM"));
        callSmsList.add(new Call("Sid","10:20 AM"));
        callSmsList.add(new Call("Kora","10:25 AM"));
        callSmsList.add(new Call("Nick","10:30 AM"));
        callSmsList.add(new Sms("Rose","Bring me some chocolates","10:10 AM"));
        callSmsList.add(new Call("Mia","10:40 AM"));
        callSmsList.add(new Call("Scott","10:45 AM"));
    }
}
