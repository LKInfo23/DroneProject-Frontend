package de.grb.grbvektortool;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import de.grb.grbvektortool.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
        EditText roomCode = findViewById(R.id.roomCodeEditText);
        TextWatcher tw = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() == 3){
                    // TODO:
                    // SERVER SHIT
                    CharSequence text = "Trying to connect to room #" + s;
                    Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                    switchActivities();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        roomCode.addTextChangedListener(tw);
    }
    private void switchActivities() {
        Intent switchActivity = new Intent(this,RoomActivity.class);
        startActivity(switchActivity);
    }


    public void openGitHubLink(View view) {
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/LKInfo23/DroneProject")));
    }

}