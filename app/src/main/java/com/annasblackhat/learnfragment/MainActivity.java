package com.annasblackhat.learnfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Fragment menu1 = new Menu1Fragment();
    private Fragment menu2 = new Menu2Fragment();
    private Fragment menu3 = new Menu3Fragment();
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        findViewById(R.id.btn_menu1).setOnClickListener(this);
        findViewById(R.id.btn_menu2).setOnClickListener(this);
        findViewById(R.id.btn_menu3).setOnClickListener(this);
    }

    void replaceData(){
        fragmentManager.beginTransaction()
                .replace(R.id.container, new Menu1DetailFragment())
                .addToBackStack("TAG_MENU_1")
                .commit();
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        if(v.getId() == R.id.btn_menu1){
            if(fragmentManager.getBackStackEntryCount() > 0){
                fragmentManager.popBackStackImmediate();
            }else{
                fragment = menu1;
            }
        }else if(v.getId() == R.id.btn_menu2){
            fragment = menu2;
        }else if(v.getId() == R.id.btn_menu3){
            fragment = menu3;
        }

        if(fragment != null){
             FragmentTransaction transaction = fragmentManager.beginTransaction();
             transaction.replace(R.id.container, fragment);
            if(fragmentManager.getBackStackEntryCount() > 0){
                transaction.addToBackStack("TAG_DETAIL_MENU_1");
            }
            transaction.commit();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if(fragmentManager.getBackStackEntryCount() > 0){
            fragmentManager.popBackStackImmediate();
        }
    }
}
