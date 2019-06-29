package com.example.roomapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.roomapp.adapter.NoteAdapter;
import com.example.roomapp.network.RetrofitClient;
import com.example.roomapp.network.http.Alsultanh;
import com.example.roomapp.network.http.Emp;
import com.example.roomapp.room.Note;
import com.example.roomapp.viewmodel.NoteViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;
    private List<Emp> emp;
    private List<Note> notes;
    public static int TYPE_WIFI = 1;
    public static int TYPE_MOBILE = 2;
    public static int TYPE_NOT_CONNECTED = 0;
    private Snackbar snackbar;
    private CoordinatorLayout coordinatorLayout;
    private boolean internetConnected = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.activity_main);
        final RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        emp = new ArrayList<>();
        notes = new ArrayList<>();
        final NoteAdapter adapter = new NoteAdapter(notes, this);
        recyclerView.setAdapter(adapter);
        noteViewModel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(final List<Note> notes) {
                //update RecyclerView
                //   Toast.makeText(MainActivity.this, "OnChanged", Toast.LENGTH_SHORT).show();
                adapter.setNotes(notes);


            }
        });


        CallApi();

    }

    private void CallApi() {
        Call<Alsultanh> call = RetrofitClient.getInstance().getDate_api().getDate();
        call.enqueue(new Callback<Alsultanh>() {
            @Override
            public void onResponse(Call<Alsultanh> call, Response<Alsultanh> response) {
                if (response.isSuccessful()) {
                    emp.addAll(response.body().getEmps());
                    //   adapter1.setNotes(emp);

                    //   recyclerView.setAdapter(adapter1);
                    SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                    boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
                    if (isFirstRun) {
                        for (int i = 0; i < emp.size(); i++) {
                            String x = emp.get(i).getEmpName();
                            String xi = "http://alsultanh.com/soltan_service/";
                            String xx = xi + emp.get(i).getEmpPicUrl();
                            final Note note = new Note(x, xx);
                            noteViewModel.insert(note);
                            noteViewModel.update(note);
                        }
                        SharedPreferences.Editor editor = wmbPreference.edit();
                        editor.putBoolean("FIRSTRUN", false);
                        editor.commit();
                    }
                    for (int i = 0; i < emp.size(); i++) {
                        String x = emp.get(i).getEmpName();
                        String xi = "http://alsultanh.com/soltan_service/";
                        String xx = xi + emp.get(i).getEmpPicUrl();
                        final Note note = new Note(x, xx);
                        noteViewModel.update(note);
                    }
                    //  Toast.makeText(MainActivity.this, x, Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(MainActivity.this, "logic error ", Toast.LENGTH_SHORT).show();

                }

            }

            @Override
            public void onFailure(Call<Alsultanh> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this, "error:" + t, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    protected void onResume() {
        super.onResume();
        registerInternetCheckReceiver();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    /**
     * Method to register runtime broadcast receiver to show snackbar alert for internet connection..
     */
    private void registerInternetCheckReceiver() {
        IntentFilter internetFilter = new IntentFilter();
        internetFilter.addAction("android.net.wifi.STATE_CHANGE");
        internetFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(broadcastReceiver, internetFilter);
    }

    /**
     * Runtime Broadcast receiver inner class to capture internet connectivity events
     */
    public BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String status = getConnectivityStatusString(context);
            setSnackbarMessage(status, false);
        }
    };

    public static int getConnectivityStatus(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (null != activeNetwork) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI)
                return TYPE_WIFI;

            if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE)
                return TYPE_MOBILE;
        }
        return TYPE_NOT_CONNECTED;
    }

    public static String getConnectivityStatusString(Context context) {
        int conn = getConnectivityStatus(context);
        String status = null;
        if (conn == TYPE_WIFI) {
            status = "Wifi enabled";
        } else if (conn == TYPE_MOBILE) {
            status = "Mobile data enabled";
        } else if (conn == TYPE_NOT_CONNECTED) {
            status = "Not connected to Internet";
        }
        return status;
    }

    private void setSnackbarMessage(String status, boolean showBar) {
        String internetStatus = "";
        if (status.equalsIgnoreCase("Wifi enabled") || status.equalsIgnoreCase("Mobile data enabled")) {
            internetStatus = "Internet Connected";
        } else {
            internetStatus = "Lost Internet Connection";
        }
        snackbar = Snackbar
                .make(coordinatorLayout, internetStatus, Snackbar.LENGTH_LONG)
                .setAction("X", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                });
        // Changing message text color
        snackbar.setActionTextColor(Color.WHITE);
        // Changing action button text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(Color.WHITE);
        if (internetStatus.equalsIgnoreCase("Lost Internet Connection")) {
            if (internetConnected) {
                snackbar.show();
                internetConnected = false;
            }
        } else {
            if (!internetConnected) {
                internetConnected = true;
                snackbar.show();
            }
        }
    }
}
