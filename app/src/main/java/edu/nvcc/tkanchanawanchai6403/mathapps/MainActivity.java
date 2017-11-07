package edu.nvcc.tkanchanawanchai6403.mathapps;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView display = (TextView)findViewById(R.id.display);
        Button oddButton = (Button)findViewById(R.id.oddButton);
        Button diamondButton = (Button)findViewById(R.id.diamondButton);
        Button factorialButton = (Button)findViewById(R.id.factorialButton);
        Button fibonacciButton = (Button)findViewById(R.id.fibonacciButton);
        final EditText editText = (EditText) findViewById(R.id.editText);
        final String [] out = {"Hello purple shirt! You are late!"};
        final String[] output = {""};


        fibonacciButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                int n = Integer.parseInt(input);
                Context context = getApplicationContext();
                CharSequence text = input;
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                               int i=0;
                int previous = 0;
                int prePrevious = 0;
                int []outs = new int[n];
                do {
                    if (i==1) {
                        previous = 1;
                    }
                    outs[i] = previous + prePrevious;
                    previous = outs[i];
                    if(i>0) {
                        prePrevious = outs[i - 1];
                    }
                    i++;
                }while(i<n);

                display.setText(Arrays.toString(outs));
            }
        });

        /*Context context = getApplicationContext();
        CharSequence text = input;
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
*/
        factorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = editText.getText().toString();
                int factorial = 1;
                int n = Integer.parseInt(input);

                while(n>1) {
                    factorial = factorial*n;
                    n--;
                }
                out[0] = String.valueOf(factorial);
                display.setText(out[0]);
            }
        });



        oddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = 1;
                while (i <= 200) {
                    output[0] += i + " ";
                    i += 2;
                }
                display.setText(output[0]);
            }
        });

        diamondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n=5;
                for(int row=0; row<n; row++) {
                    for (int col = 0; col < n; col++) {
                        if(row<2)
                        output[0] += " ";
                        if(row==n/2)
                        output[0] += "*";
                    }
                    output[0] += "\n";
                }
                display.setText(output[0]);
            }
        });


    }
}
