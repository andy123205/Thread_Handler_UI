package com.example.andylab.thread_handler_ui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private MyThread thread;
    private MyHandler handler;
    private TextView txv;
    private Button btn,btn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);

        handler = new MyHandler();
        thread = new MyThread();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handler.post(thread);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                handler.removeCallbacks(thread);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyThread extends Thread{
        @Override
        public void run() {
            handler.sendMessage(new Message());

            handler.postDelayed(thread,1000);
        }
    }

    private class MyHandler extends Handler {
        private int i;
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            txv.setText(""+(i++));

        }
    }
}
