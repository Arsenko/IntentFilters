package com.example.sync;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init(){
        Button btnSync=findViewById(R.id.btnSync);
        btnSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_SYNC);
                Date currentDate=new Date();
                int hour=currentDate.getHours();
                if(6<hour && hour<14){
                    intent.setData(Uri.parse("http://morning"));
                }else if(14<hour && hour<22){
                    intent.setData(Uri.parse("http://evening"));
                }else if((22<hour && hour<24) || (hour>0 && hour<6)){
                    intent.setData(Uri.parse("http://afternoon"));
                }
                startActivity(intent);
            }
        });
    }
}
