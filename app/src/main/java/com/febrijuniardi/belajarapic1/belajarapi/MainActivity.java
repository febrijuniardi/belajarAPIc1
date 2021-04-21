package com.febrijuniardi.belajarapic1.belajarapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.febrijuniardi.belajarapic1.R;
import com.febrijuniardi.belajarapic1.model.PhotoData;
import com.febrijuniardi.belajarapic1.services.ApiClient;
import com.febrijuniardi.belajarapic1.services.GetService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("loading");
        progressDialog.show();

        GetService service = ApiClient.getRetrofitInstance().create(GetService.class);
        Call<List<PhotoData>> call = service.getAllPhotos();
        call.enqueue(new Callback<List<PhotoData>>() {
            @Override
            public void onResponse(Call<List<PhotoData>> call, Response<List<PhotoData>> response) {
                progressDialog.dismiss();
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<PhotoData>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Ada yang salah .. tolong coba lagi",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<PhotoData>photoList){
        recyclerView = findViewById(R.id.CsRecyclerView);
        adapter     = new CustomAdapter(this,photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
}