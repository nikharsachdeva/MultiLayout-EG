package com.nikharsachdeva.multilayout_eg;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nikharsachdeva.multilayout_eg.All.AllResponse;
import com.nikharsachdeva.multilayout_eg.All.PastActivity;
import com.nikharsachdeva.multilayout_eg.All.PendingActivity;
import com.nikharsachdeva.multilayout_eg.All.PinnedNote;
import com.nikharsachdeva.multilayout_eg.All.UnPinnedNote;
import com.nikharsachdeva.multilayout_eg.MultiAdapter.Adapter;
import com.nikharsachdeva.multilayout_eg.MultiList.Item;
import com.nikharsachdeva.multilayout_eg.Network.APIinterface;
import com.nikharsachdeva.multilayout_eg.Network.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "myTag";
    APIinterface apIinterface;
    RecyclerView recyclerView;
    List<Item> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerview);
        apIinterface = Service.getClient().create(APIinterface.class);


        fetchData();
    }

    public void fetchData() {

        Call<AllResponse> call = apIinterface.fetchLeadDetails2("49466", "application/json", "Bearer " + "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJzcmlkaGFyIiwiZXhwIjoxNjAyMDI4NDMzLCJpYXQiOjE2MDIwMTA0MzN9.xAIjvIrLSWBClen0mfP45HyR8pGsdWyyjn5N0DE0Jv3RYDZEueKLsYNWQZP4aZ9iFzeeE_DGi2JsCHu50NYZMw");

        call.enqueue(new Callback<AllResponse>() {
            @Override
            public void onResponse(Call<AllResponse> call, Response<AllResponse> response) {

                if (response.isSuccessful()) {

                    if (response.body() != null) {

                        // 0 = pinned note 1 = unpinned 2 = pending act 3 = past activity
                        for (int i = 0; i < response.body().getAllNotes().getPinnedNotes().size(); i++) {
                            PinnedNote pinnedNote = response.body().getAllNotes().getPinnedNotes().get(i);
                            items.add(new Item(0, pinnedNote));
                        }

                        for (int i = 0; i < response.body().getAllNotes().getUnPinnedNotes().size(); i++) {
                            UnPinnedNote unPinnedNote = response.body().getAllNotes().getUnPinnedNotes().get(i);
                            items.add(new Item(1, unPinnedNote));
                        }

                        for (int i = 0; i < response.body().getAllActivities().getPendingActivities().size(); i++) {
                            PendingActivity pendingActivity = response.body().getAllActivities().getPendingActivities().get(i);
                            items.add(new Item(2, pendingActivity));
                        }

                        for (int i = 0; i < response.body().getAllActivities().getPastActivities().size(); i++) {
                            PastActivity pastActivity = response.body().getAllActivities().getPastActivities().get(i);
                            items.add(new Item(3, pastActivity));
                        }

                        recyclerView.setAdapter(new Adapter(items));


                        Log.d(TAG, "onResponse: " + new Gson().toJson(response.body()));
                    } else {
                        Toast.makeText(MainActivity.this, "Empty Response Received!", Toast.LENGTH_SHORT).show();
                    }


                } else {

                    Toast.makeText(MainActivity.this, "Unsuccessful Response", Toast.LENGTH_SHORT).show();


                }

            }

            @Override
            public void onFailure(Call<AllResponse> call, Throwable t) {

                Log.d(TAG, "onFailure: " + t.getLocalizedMessage());
                if (t instanceof IOException) {
                    Toast.makeText(MainActivity.this, "Please check your internet!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Unhandled Response Encountered!", Toast.LENGTH_SHORT).show();
                    // todo log to some central bug tracking service
                }


            }
        });

    }

}