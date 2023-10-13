package nm.vamk.assignment_4_calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String resultToDisplay;
    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num0;
    private Button clear;

    private Button equals;

    private Button addition;

    private int firstNumber;
    private int secondNumber;
    private String operationToBeDone;

    //private StringBuilder stringBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);


        num1 = findViewById(R.id.button_input_1);
        num2 = findViewById(R.id.button_input_2);
        num3 = findViewById(R.id.button_input_3);
        num4 = findViewById(R.id.button_input_4);
        num5 = findViewById(R.id.button_input_5);
        num6 = findViewById(R.id.button_input_6);
        num7 = findViewById(R.id.button_input_7);
        num8 = findViewById(R.id.button_input_8);
        num9 = findViewById(R.id.button_input_9);
        num0 = findViewById(R.id.button_input_0);

        num1.setOnClickListener(ButtonClickListener);
        num2.setOnClickListener(ButtonClickListener);
        num3.setOnClickListener(ButtonClickListener);
        num4.setOnClickListener(ButtonClickListener);
        num5.setOnClickListener(ButtonClickListener);
        num6.setOnClickListener(ButtonClickListener);
        num7.setOnClickListener(ButtonClickListener);
        num8.setOnClickListener(ButtonClickListener);
        num9.setOnClickListener(ButtonClickListener);
        num0.setOnClickListener(ButtonClickListener);

        clear = findViewById(R.id.button_input_clear);
        clear.setOnClickListener(OperationClickListener);

        addition = findViewById(R.id.button_input_addition);
        addition.setOnClickListener(OperationClickListener);

        equals = findViewById(R.id.button_input_equals);
        equals.setOnClickListener(OperationClickListener);



        //stringBuilder = new StringBuilder();
    }

    private View.OnClickListener OperationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button clickedOperationButton = (Button) v;
            //operationToBeDone = clickedOperationButton.getText().toString();


            if (clickedOperationButton.equals(clear)) {
                display.setText("");
            }

            if(clickedOperationButton.equals(equals)) {
                secondNumber = Integer.valueOf(display.getText().toString());
                int result = firstNumber + secondNumber;
                resultToDisplay = String.valueOf(result);
                display.setText(resultToDisplay);
            }

            if(clickedOperationButton.equals(addition)) {
                display.setText("");

            }

        }
    };


    private View.OnClickListener ButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button clickedNumberButton = (Button) v;
            display.setText(clickedNumberButton.getText().toString());
            int numberToSave = Integer.valueOf(display.getText().toString());
            firstNumber = numberToSave;

        }
    };

}