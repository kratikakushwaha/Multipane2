package com.example.multipane;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Fragment1.Shift {

Fragment1 fragment1=new Fragment1();
Fragment2 fragment2=new Fragment2();

FrameLayout f1,f2;

FragmentManager manager;


    boolean isRunningOnTablet = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      /*  TextView textView=findViewById(R.id.txtPhone);
      if(textView.getTag().equals("Phone"))
        {
            isRunningOnTablet = false;
        }
        else if(textView.getTag().equals("Tablet"))
        {
            isRunningOnTablet=true;
        }*/

      manager=getSupportFragmentManager();
      f1=findViewById(R.id.frag_container);
      f2=findViewById(R.id.frag_containerB);

      if(f2!=null)
      {
          isRunningOnTablet = true;

      }
      else
      {
          isRunningOnTablet = false;
      }

        if(isRunningOnTablet==true)
        {
            manager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=manager.beginTransaction();
            fragmentTransaction.add(R.id.frag_container,fragment1);
            fragmentTransaction.add(R.id.frag_containerB,fragment2);
            fragmentTransaction.commit();

        }
        else
        {
            manager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=manager.beginTransaction();
            fragmentTransaction.add(R.id.frag_container,fragment1);
            fragmentTransaction.commit();
        }
    }




    @Override
    public void Button(Fragment fragment) {
        manager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=manager.beginTransaction();
        fragmentTransaction.replace(R.id.frag_container,fragment2);
        fragmentTransaction.commit();
    }

    }

