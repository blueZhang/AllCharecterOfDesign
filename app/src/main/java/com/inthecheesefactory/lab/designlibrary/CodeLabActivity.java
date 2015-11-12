package com.inthecheesefactory.lab.designlibrary;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.*;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class CodeLabActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    FloatingActionButton fabBtn;
    CoordinatorLayout rootLayout;
    private Toolbar toolbar ;
    TabLayout tabLayout;

    private ListView lilistView;
    private List<String> list;
    private ArrayAdapter adapter;
    CollapsingToolbarLayout collapsingToolbarLayout;
    NavigationView navigation;
    TextInputLayout textInputLayout;

    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_code_lab);
        list = new LinkedList<>();
        lilistView = (ListView) findViewById(R.id.listView);
        for (int i = 0; i < 20; i++) {
            list.add("item -- "+i);
        }
        adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,android.R.id.text1,list);
        lilistView.setAdapter(adapter);

        initInstances();
    }

    private void initInstances() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerToggle = new ActionBarDrawerToggle(CodeLabActivity.this, drawerLayout, R.string.hello_world, R.string.hello_world);
        drawerLayout.setDrawerListener(drawerToggle);

//        getSupportActionBar().setHomeButtonEnabled(true);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("这只是一个测试");


        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingToolbarLayout);
        collapsingToolbarLayout.setTitle("这只是一个测试");

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 1"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 2"));
        tabLayout.addTab(tabLayout.newTab().setText("Tab 3"));

        textInputLayout = (TextInputLayout) findViewById(R.id.textInputLayout);
        textInputLayout.setHint("UsetName");

        editText = (EditText) findViewById(R.id.editText);
        editText.setFocusableInTouchMode(true);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 4) {
                    textInputLayout.setErrorEnabled(true);
                    textInputLayout.setError("姓名长度不能超过4个");
                } else {
                    textInputLayout.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        navigation = (NavigationView) findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.navItem1:
                        Snackbar.make(rootLayout, "OK I'm out!", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.navItem2:
                        Snackbar.make(rootLayout, "OK I'm out!", Snackbar.LENGTH_SHORT).show();
                        break;
                    case R.id.navItem3:
                        Snackbar.make(rootLayout, "OK I'm out!", Snackbar.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        rootLayout = (CoordinatorLayout) findViewById(R.id.rootLayout);
        fabBtn = (FloatingActionButton) findViewById(R.id.fabBtn);
        fabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * make()的第一个参数是一个 View 或者 Layout，
                 * 你想在它的底部位置显示一个 Snackbar。在这个例子中，
                 * 一个 FrameLayout 包裹着一个 FAB 就是其中一个例子。
                 * setAction()方法是用在设置动作显示在 Snackbar 的右侧并有对应的监听。
                 * 这个方法不是必需的，可以移除。
                 */
                Snackbar.make(rootLayout, "OK I'm out!", Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Toast.makeText(CodeLabActivity.this,"没有用的！",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_code_lab, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item))
            return true;

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
}
