package com.example.gaming;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    ImageView b1,b2,b3,b4,b5,b6,b7;
    TextView t5,t6,t7;
    String choice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1=findViewById(R.id.remote_button1);
        b2=findViewById(R.id.remote_button2);
        b3=findViewById(R.id.remote_button3);
        b4=findViewById(R.id.remote_button4);
        b5=findViewById(R.id.remote_button5);
        b6=findViewById(R.id.remote_button6);
        b7=findViewById(R.id.remote_button7);

        t5=findViewById(R.id.remote_text5);
        t6=findViewById(R.id.remote_text6);
        t7=findViewById(R.id.remote_text7);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);

        b1.setOnLongClickListener(this);
        b2.setOnLongClickListener(this);
        b3.setOnLongClickListener(this);
        b4.setOnLongClickListener(this);
        b5.setOnLongClickListener(this);
        b6.setOnLongClickListener(this);
        b7.setOnLongClickListener(this);

        SharedPreferences preferences5 = getSharedPreferences("pref5", MODE_PRIVATE);
        t5.setText(preferences5.getString("attack", "Attack with hands"));
        SharedPreferences preferences6 = getSharedPreferences("pref6", MODE_PRIVATE);
        t6.setText(preferences6.getString("attack", "Attack with leg"));
        SharedPreferences preferences7 = getSharedPreferences("pref7", MODE_PRIVATE);
        t7.setText(preferences7.getString("attack", "Attack with gun"));

    }

    @Override
    public void onClick(View v) {
        if(v == b1)
        {
            Toast.makeText(this, "up", Toast.LENGTH_LONG).show();
        }if(v == b2)
        {
            Toast.makeText(this, "down", Toast.LENGTH_LONG).show();
        } if(v == b3)
        {
            Toast.makeText(this, "right", Toast.LENGTH_LONG).show();
        } if(v == b4)
        {
            Toast.makeText(this, "left", Toast.LENGTH_LONG).show();
        } if(v == b5)
        {
            Toast.makeText(this, ""+t5.getText().toString(), Toast.LENGTH_LONG).show();
        } if(v == b6)
        {
            Toast.makeText(this, ""+t6.getText().toString(), Toast.LENGTH_LONG).show();
        } if(v == b7)
        {
            Toast.makeText(this, ""+t7.getText().toString(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(v == b1)
        {
            Toast.makeText(this, "running upword", Toast.LENGTH_LONG).show();
        }if(v == b2)
        {
            Toast.makeText(this, "running downword", Toast.LENGTH_LONG).show();
        } if(v == b3)
        {
            Toast.makeText(this, "running right", Toast.LENGTH_LONG).show();
        } if(v == b4)
        {
            Toast.makeText(this, "running left", Toast.LENGTH_LONG).show();
        }if(v == b5)
        {
            final String oldchoice=t5.getText().toString().trim();
            final Dialog dialog=new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.popup);
            dialog.show();

            Button save=dialog.findViewById(R.id.save);
            Button cancel=dialog.findViewById(R.id.cancel);

            Spinner spinner=dialog.findViewById(R.id.choice);
            final String[] arraySpinner = new String[]{"Attack with gun", "Attack with leg","Attack with hands"};
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner, arraySpinner);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);


            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                                  @Override
                                                  public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                                                      choice = arraySpinner[position];
                                                  }

                                                  @Override
                                                  public void onNothingSelected(AdapterView<?> parent) {

                                                  }
                                              });

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    SharedPreferences.Editor editor = getSharedPreferences("pref5", MODE_PRIVATE).edit();
                    editor.putString("attack", choice);
                    editor.commit();
                    t5.setText(choice);

                    if(t6.getText().toString().equals(choice))
                    {
                        t6.setText(oldchoice);
                        editor = getSharedPreferences("pref6", MODE_PRIVATE).edit();
                        editor.putString("attack", oldchoice);
                        editor.commit();
                    }
                    else {
                        t7.setText(oldchoice);
                        editor = getSharedPreferences("pref7", MODE_PRIVATE).edit();
                        editor.putString("attack", oldchoice);
                        editor.commit();
                    }
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        } if(v == b6)
        {
            final String oldchoice=t6.getText().toString().trim();
            final Dialog dialog=new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.popup);
            dialog.show();

            Button save=dialog.findViewById(R.id.save);
            Button cancel=dialog.findViewById(R.id.cancel);

            Spinner spinner=dialog.findViewById(R.id.choice);
            final String[] arraySpinner = new String[]{"Attack with gun", "Attack with leg","Attack with hands"};
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner, arraySpinner);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);


            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    choice = arraySpinner[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    SharedPreferences.Editor editor = getSharedPreferences("pref6", MODE_PRIVATE).edit();
                    editor.putString("attack", choice);
                    editor.commit();
                    t6.setText(choice);
                    if(t5.getText().toString().equals(choice))
                    {
                        t5.setText(oldchoice);
                        editor = getSharedPreferences("pref5", MODE_PRIVATE).edit();
                        editor.putString("attack", oldchoice);
                        editor.commit();
                    }
                    else {
                        t7.setText(oldchoice);
                        editor = getSharedPreferences("pref7", MODE_PRIVATE).edit();
                        editor.putString("attack", oldchoice);
                        editor.commit();
                    }
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });

        } if(v == b7)
        {
            final String oldchoice=t7.getText().toString().trim();
            final Dialog dialog=new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.popup);
            dialog.show();

            Button save=dialog.findViewById(R.id.save);
            Button cancel=dialog.findViewById(R.id.cancel);

            Spinner spinner=dialog.findViewById(R.id.choice);
            final String[] arraySpinner = new String[]{"Attack with gun", "Attack with leg","Attack with hands"};
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,R.layout.spinner, arraySpinner);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinner.setAdapter(adapter);


            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    choice = arraySpinner[position];
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    SharedPreferences.Editor editor = getSharedPreferences("pref7", MODE_PRIVATE).edit();
                    editor.putString("attack", choice);
                    editor.commit();
                    t7.setText(choice);

                    if(t6.getText().toString().equals(choice))
                    {
                        editor = getSharedPreferences("pref6", MODE_PRIVATE).edit();
                        editor.putString("attack", oldchoice);
                        editor.commit();
                        t6.setText(oldchoice);
                    }
                    else {
                        editor = getSharedPreferences("pref5", MODE_PRIVATE).edit();
                        editor.putString("attack", oldchoice);
                        editor.commit();
                        t5.setText(oldchoice);
                    }
                }
            });
            cancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                }
            });
        }
        return false;
    }
}