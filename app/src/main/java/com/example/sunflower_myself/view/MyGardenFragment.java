package com.example.sunflower_myself.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.sunflower_myself.R;

public class MyGardenFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getActivity().getSupportFragmentManager().beginTransaction().add(R.id.my_garden_container, new MyGardenFragment()).commit();
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_my_garden, container, false);
        Button addPlant = rootView.findViewById(R.id.addPlantbtn);
        addPlant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewPager2 viewpager = requireActivity().findViewById(R.id.viewPager);
                viewpager.setCurrentItem(1);
            }
        });



        // Inflate the layout for this fragment
        return rootView;
    }
}