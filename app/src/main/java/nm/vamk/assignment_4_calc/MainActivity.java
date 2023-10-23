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
    private Button subtraction;
    private Button multiplication;

    private String[] valuesAndOperation;

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

        subtraction = findViewById(R.id.button_input_subtraction);
        subtraction.setOnClickListener(OperationClickListener);

        multiplication = findViewById(R.id.button_input_multiplication);
        multiplication.setOnClickListener(OperationClickListener);

        equals = findViewById(R.id.button_input_equals);
        equals.setOnClickListener(OperationClickListener);

        //Index 0 will contain a value, index 1 will contain the operation to be done
        //index 2 will contain another value
        valuesAndOperation = new String[3];



        //stringBuilder = new StringBuilder();
    }

    private View.OnClickListener ButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button clickedNumberButton = (Button) v;
            String displayedText = display.getText().toString();
            String textToDisplay = displayedText + clickedNumberButton.getText().toString();
            display.setText(textToDisplay);
            /*
            if(clickedButton.equals(addition)) {
                valuesAndOperation[1] = addition.getText().toString();
            }

            Log.d("ValsAndOp", valuesAndOperation[0] + " " + valuesAndOperation[1]);
*/



        }
    };

    private View.OnClickListener OperationClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button clickedOperationButton = (Button) v;
            //operationToBeDone = clickedOperationButton.getText().toString();


            if (clickedOperationButton.equals(clear)) {
                display.setText("");
            }

            if(clickedOperationButton.equals(equals)) {
                valuesAndOperation[2] = display.getText().toString();
                display.setText("");
                //Log.d("ValsAndOp", valuesAndOperation[0] + " " + valuesAndOperation[1] + " " + valuesAndOperation[2]);
                String operation = valuesAndOperation[1];
                double firstValue = Integer.valueOf(valuesAndOperation[0]);
                double secondValue = Integer.valueOf(valuesAndOperation[2]);
                double result = 0;

                switch (operation) {
                    case "+":
                        result = firstValue + secondValue;
                        break;
                    case "-":
                        result = firstValue - secondValue;
                        break;
                    case "*":
                        result = firstValue * secondValue;
                        break;

                }

                display.setText(String.valueOf(result));

                /*
                if(operation.equals(R.string.addition))  {
                    //Log.d("ValsAndOp", valuesAndOperation[0] + " " + valuesAndOperation[1] + " " + valuesAndOperation[2]);
                    double firstValue = Integer.valueOf(valuesAndOperation[0]);
                    double secondValue = Integer.valueOf(valuesAndOperation[2]);

                    double result = firstValue + secondValue;
                    display.setText(String.valueOf(result));
                }
                 */



            }

            if(clickedOperationButton.equals(addition)) {
                valuesAndOperation[0] = display.getText().toString();
                display.setText("");
                valuesAndOperation[1] = clickedOperationButton.getText().toString();
            }

            if(clickedOperationButton.equals(subtraction)) {
                valuesAndOperation[0] = display.getText().toString();
                display.setText("");
                valuesAndOperation[1] = clickedOperationButton.getText().toString();
            }

            if(clickedOperationButton.equals(multiplication)) {
                valuesAndOperation[0] = display.getText().toString();
                display.setText("");
                valuesAndOperation[1] = clickedOperationButton.getText().toString();
            }

        }
    };




}