package com.example.sunflower_myself.adpater;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.sunflower_myself.view.MyGardenFragment;
import com.example.sunflower_myself.view.PlantListFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    // 아래 생성자를 써야 하는 경우는 어떤 경우인지 잘 모르겠다.
    // public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity)
    // 이 메소드에서 각 화면에 나타낼 fragment를 생성해서 반환한다.
    @NonNull
    @Override
    public Fragment createFragment(int position) {

        // 액티비티가 구현한 인터페이스를 프래그먼트에 전달.
        if(position ==0){
            return new MyGardenFragment();
        } else {
            return new PlantListFragment();
        }
    }

    // 화면에 나타낼 페이지 수를 반환해준다.
    @Override
    public int getItemCount() {
        return 2;
    }
}
