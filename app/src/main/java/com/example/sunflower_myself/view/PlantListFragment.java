package com.example.sunflower_myself.view;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.sunflower_myself.R;
import com.example.sunflower_myself.adpater.PlantAdapter;

import java.util.ArrayList;
import java.util.List;

public class PlantListFragment extends Fragment {
    private RecyclerView recyclerView;
    private PlantAdapter plantAdapter;

    // 목록에 모든 식물을 보여준다
    private boolean filter_all = true;

    List<String> data;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.plant_list_container, new PlantListFragment()).commit();
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_plant_list, container, false);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        int numberOfColumns = 2;

        //recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        //내가 알던 기존의 방식과 2열로 리사이클러뷰를 출력하기 위해서 GridLayout 사용.
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), numberOfColumns));

        data = new ArrayList<>();
        for(int i=0; i<17; i++){
            data.add("Item "+i);
        }

        plantAdapter = new PlantAdapter(data);
        recyclerView.setAdapter(plantAdapter);

        plantAdapter.setOnItemClickListener(new PlantAdapter.OnItemClickListener() {
            @Override
            public void onItemCLick(View v, int position) {
                System.out.println("hello!!!!");
                Intent intent = new Intent(getContext(), PlantDetailActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    public void filterPlants(boolean filter_all){

        // 모든 식물을 목록에 보여준다.
        if(filter_all){
            //data.clear();
            for(int i=4; i<17; i++){
                data.add("Item "+i);
            }
        }

        // 필터 과정을 하게되면 4개 빼고 전부 없앤다.
        else{
            System.out.println("filter on");
            for(int i = data.size()-1; i>=4; i--){
                //System.out.println("data.size "+data.size());
                data.remove(i);
            }
        }

        plantAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        // 우측상단의 버튼을 눌렀을때 동작
        if(id == R.id.settings){
            filterPlants(!filter_all);
            filter_all = !filter_all;
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}