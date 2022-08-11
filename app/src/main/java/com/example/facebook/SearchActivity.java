package com.example.facebook;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.facebook.Adapter.SearchAdapter;
import com.example.facebook.Obj.Search_itemObj;
import com.example.facebook.Obj.UserV2;
import com.example.facebook.service.ApiService;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private RecyclerView s_listRS;
    private SearchView searchView;
    private ArrayList<Search_itemObj> search_itemObjs;
    private ApiService apiService;
    private SearchAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        apiService = new ApiService();
        s_listRS = findViewById(R.id.s_listRS);
        searchView = findViewById(R.id.s_inputS);

        search_itemObjs = new ArrayList<>();
        s_listRS.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        s_listRS.setLayoutManager(linearLayoutManager);
        adapter = new SearchAdapter(this.getApplicationContext(), search_itemObjs, new ChooseUser() {
            @Override
            public void click(Search_itemObj search_itemObj) {
                Toast.makeText(getApplicationContext(), search_itemObj.getId()+" "+search_itemObj.getItSearch_txtName(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), YourProfileActivity.class);
                intent.putExtra("userId", search_itemObj.getId());
                startActivity(intent);
            }
        });
        s_listRS.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                apiService.findByName(s, adapter, search_itemObjs);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }


    public interface ChooseUser{
        public void click(Search_itemObj search_itemObj);
    }
}