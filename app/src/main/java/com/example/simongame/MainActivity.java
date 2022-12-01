package com.example.simongame;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.simongame.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;
    private ArrayList<String> sequenzaGameList = new ArrayList<>();
    private ArrayList<String> sequenzaUserList = new ArrayList<>();
    private final ArrayList<Integer> buttonIdList = new ArrayList<>(Arrays.asList(2131231206, 2131230819, 2131230823, 2131230820));

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);



/*        Random rand = new Random();
        int randomIdButton = buttonIdList.get(rand.nextInt(buttonIdList.size()));
        sequenzaGameList.add(String.valueOf(randomIdButton));
        btn = findViewById(randomIdButton);
        btn.setBackgroundColor(getColor(R.color.black));*/

        buttonIdList.add(2131231206);
        buttonIdList.add(2131230819);
        buttonIdList.add(2131230823);
        buttonIdList.add(2131231206);

            Random rand = new Random();

            setTimeout(() -> {
                this.runOnUiThread(() -> {
                    for (int i = 0; i < buttonIdList.size(); i++) {
//                        int randomIdButton = buttonIdList.get(rand.nextInt(buttonIdList.size()));
//                        sequenzaGameList.add(String.valueOf(randomIdButton));
                        btn = findViewById(buttonIdList.get(i));
                        btn.setBackgroundColor(getColor(R.color.black));
                    }
                });
            }, 2000);


        binding.buttonBlue.setOnClickListener(view -> {
            Log.d("start-game", "start game button clicked");
            String buttoneId = String.valueOf(binding.buttonBlue.getId());
            sequenzaUserList.add(buttoneId);
        });

        binding.buttonGreen.setOnClickListener(view -> {
            Log.d("start-game", "start game button clicked");
            String buttoneId = String.valueOf(binding.buttonGreen.getId());
            sequenzaUserList.add(buttoneId);
        });
        binding.buttonYellow.setOnClickListener(view -> {
            Log.d("start-game", "start game button clicked");
            String buttoneId = String.valueOf(binding.buttonYellow.getId());
            sequenzaUserList.add(buttoneId);
        });
        binding.buttonRed.setOnClickListener(view -> {
            Log.d("start-game", "start game button clicked");
            String buttoneId = String.valueOf(binding.buttonRed.getId());
            sequenzaUserList.add(buttoneId);
        });

    }

    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try{
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }

}