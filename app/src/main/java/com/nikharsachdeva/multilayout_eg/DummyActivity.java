package com.nikharsachdeva.multilayout_eg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.nikharsachdeva.multilayout_eg.Adapterss.OnlyNotesPinnedAdapter;
import com.nikharsachdeva.multilayout_eg.All.AllResponse;
import com.nikharsachdeva.multilayout_eg.All.PastActivity;
import com.nikharsachdeva.multilayout_eg.All.PendingActivity;
import com.nikharsachdeva.multilayout_eg.All.PinnedNote;
import com.nikharsachdeva.multilayout_eg.All.UnPinnedNote;
import com.nikharsachdeva.multilayout_eg.MultiAdapter.Adapter;
import com.nikharsachdeva.multilayout_eg.MultiAdapter.DummyAdapter;
import com.nikharsachdeva.multilayout_eg.MultiList.DummyItem;
import com.nikharsachdeva.multilayout_eg.MultiList.Item;
import com.nikharsachdeva.multilayout_eg.Network.APIinterface;
import com.nikharsachdeva.multilayout_eg.Network.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DummyActivity extends AppCompatActivity {

    private static final String TAG = "myTag";
    APIinterface apIinterface;
    RecyclerView dummy_recyclerview;
    List<DummyItem> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        dummy_recyclerview = findViewById(R.id.dummy_recyclerview);
        apIinterface = Service.getClient().create(APIinterface.class);


        fetchData();
    }

    private void fetchData() {

        Call<AllResponse> call = apIinterface.fetchLeadDetails2("55214", "application/json", "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzcmlkaGFyIiwiZXhwIjoxNjAyNzE5NzAwLCJpYXQiOjE2MDI3MDE3MDB9._5LyHSYMQ0WcQMeba922Xhj3SB5N2yq7fNOc0uEcd-1HXByMZANBV8L55QFnnbXGL9A4m4eyIkxI1QXev0JOlQ");

        call.enqueue(new Callback<AllResponse>() {
            @Override
            public void onResponse(Call<AllResponse> call, Response<AllResponse> response) {

                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        // 0 = pinned note 1 = unpinned 2 = pending act 3 = past activity
                        List<DummyItem> itemsList = new ArrayList<>();
                        itemsList.add(new DummyItem(0, response.body()));
                        itemsList.add(new DummyItem(1, response.body()));
                        itemsList.add(new DummyItem(2, response.body()));
                        itemsList.add(new DummyItem(3, response.body()));

                        Log.d(TAG, "onResponse: " + new Gson().toJson(itemsList));


                        DummyAdapter adapter = new DummyAdapter(itemsList);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(DummyActivity.this, LinearLayoutManager.VERTICAL, false);
                        dummy_recyclerview.setLayoutManager(layoutManager);
                        dummy_recyclerview.setAdapter(adapter);

                        Log.d(TAG, "onResponse: " + new Gson().toJson(response.body()));
                    } else {
                        Toast.makeText(DummyActivity.this, "Empty Response Received!", Toast.LENGTH_SHORT).show();
                    }


                } else {

                    Toast.makeText(DummyActivity.this, "Unsuccessful Response", Toast.LENGTH_SHORT).show();


                }

            }

            @Override
            public void onFailure(Call<AllResponse> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                if (t instanceof IOException) {
                    Toast.makeText(DummyActivity.this, "Please check your internet!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DummyActivity.this, "Unhandled Response Encountered!", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }


            }
        });


    }
}