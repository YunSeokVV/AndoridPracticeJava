package com.example.sunflower_myself.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.sunflower_myself.R;

import com.example.sunflower_myself.adpater.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity{
    ViewPager2 viewPager2;

    MenuItem toolBarSetting;
    MyGardenFragment myGardenFragment;
    PlantListFragment plantListFragment;

    ViewPagerAdapter adapter;

    boolean filter_visible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        myGardenFragment = new MyGardenFragment();
        plantListFragment = new PlantListFragment();


        // MainActivity가 Activity를 상속받으면 생성자의 매개변수로 두 메소드를 사용할 수 없다. 왜지?
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager2.setAdapter(adapter);

        // 탭레이아웃의 초기 설정을 해주는 함수
        new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy(){
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                if(position == 0){
                    //toolBarSetting.setVisible(false);
                    tab.setText("My garden");
                    tab.setIcon(R.drawable.splash);

                    //todo: 원래 Fragment를 시작시키려고 했던 시점이다. 여기서 시작하면 에러가 나는데 왜 그런 것인지는 잘 모르겠다.
                    //getSupportFragmentManager().beginTransaction().replace(R.id.my_garden_container, new MyGardenFragment()).commit();
                }
                else{
                    tab.setText("Plant list");
                    //todo: 원래 Fragment를 시작시키려고 했던 시점이다. 여기서 시작하면 에러가 나는데 왜 그런 것인지는 잘 모르겠다.
                    //getSupportFragmentManager().beginTransaction().replace(R.id.plant_list_container, new PlantListFragment()).commit();
                }
            }
        }).attach();

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 선택된 탭의 위치
                int position = tab.getPosition();
                // n번째 탭이 눌렀을때 해당 탭에서 해야할 일을 처리
                tabSelected(position);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public void tabSelected(int position){
        switch (position){
            // Mygarden
            case 0:
                //changeMenuItemVisibility();
                // 왜 아래 코드는 안먹히는건지 이해가 안된다.
                // toolBarSetting.setVisible(false);
                break;
            // Plant list
            case 1:
                //changeMenuItemVisibility();
                // 왜 아래 코드는 안먹히는건지 이해가 안된다.
                // toolBarSetting.setVisible(true);
                break;
        }
    }

    // 가시성 변경
    private void changeMenuItemVisibility(boolean filter_visible) {
        if (toolBarSetting != null) {
            toolBarSetting.setVisible(filter_visible); // 가시성 반전
        }

    }

    // 툴바에 있는 뷰들을 건드리기 위해서 존재하는 코드. 이 메소드에서 뷰를 inflate 해야한다.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.top_nav_menu, menu);
        toolBarSetting = menu.findItem(R.id.settings);
        changeMenuItemVisibility(filter_visible);
        filter_visible = !filter_visible;
        return false;
    }

    

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//
//        // 우측상단의 버튼을 눌렀을때 동작
//        if(id == R.id.settings){
//            sendDataToFragment();
//            FragmentManager fragmentManager = getSupportFragmentManager();
//            PlantListFragment fragment = (PlantListFragment) fragmentManager.findFragmentById(R.id.plant_list_container);
//
//            if(fragment != null){
//                Toast.makeText(getApplicationContext(), "filter clicked!!!", Toast.LENGTH_SHORT).show();
//                filterPlants = fragment.filterPlants(filterPlants);
//            }
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

}