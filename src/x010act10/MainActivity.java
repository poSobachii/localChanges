package x010act10;


import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;

public class MainActivity extends Activity {

    private int colorR, colorG, colorB; //colors as integer numbers from 0 to 255
    SeekBar seekBarR, seekBarG, seekBarB; // SeekBars for each color
    LinearLayout mainLayout; // Layout of the screen

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainLayout = findViewById(R.id.mainScreen);

        seekBarR = findViewById(R.id.seekBarR);
        seekBarG = findViewById(R.id.seekBarG);
        seekBarB = findViewById(R.id.seekBarB);

        mainLayout.setBackgroundColor(Color.BLACK);

        seekBarR.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mainLayout.setBackgroundColor(getColor(seekBarR.getProgress(), seekBarG.getProgress(), seekBarB.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBarG.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mainLayout.setBackgroundColor(getColor(seekBarR.getProgress(), seekBarG.getProgress(), seekBarB.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        seekBarB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mainLayout.setBackgroundColor(getColor(seekBarR.getProgress(), seekBarG.getProgress(), seekBarB.getProgress()));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    static int getColor(int R, int G, int B) {
        return 0xff000000 + R * 0x10000 + G * 0x100 + B;
    }

}
