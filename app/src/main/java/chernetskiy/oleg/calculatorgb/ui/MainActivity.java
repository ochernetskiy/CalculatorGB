package chernetskiy.oleg.calculatorgb.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import chernetskiy.oleg.calculatorgb.R;
import chernetskiy.oleg.calculatorgb.domain.CalculatorImpl;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter presenter;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);

        presenter = new MainPresenter(this, new CalculatorImpl());

        HashMap<Integer, Integer> digits = new HashMap<>();

        digits.put(R.id.button_0, 0);
        digits.put(R.id.button_1, 1);
        digits.put(R.id.button_2, 2);
        digits.put(R.id.button_3, 3);
        digits.put(R.id.button_4, 4);
        digits.put(R.id.button_5, 5);
        digits.put(R.id.button_6, 6);
        digits.put(R.id.button_7, 7);
        digits.put(R.id.button_8, 8);
        digits.put(R.id.button_9, 9);

        View.OnClickListener digitsClicked = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyPressed(digits.get(v.getId()));
            }
        };

        findViewById(R.id.button_0).setOnClickListener(digitsClicked);
        findViewById(R.id.button_1).setOnClickListener(digitsClicked);
        findViewById(R.id.button_2).setOnClickListener(digitsClicked);
        findViewById(R.id.button_3).setOnClickListener(digitsClicked);
        findViewById(R.id.button_4).setOnClickListener(digitsClicked);
        findViewById(R.id.button_5).setOnClickListener(digitsClicked);
        findViewById(R.id.button_6).setOnClickListener(digitsClicked);
        findViewById(R.id.button_7).setOnClickListener(digitsClicked);
        findViewById(R.id.button_8).setOnClickListener(digitsClicked);
        findViewById(R.id.button_9).setOnClickListener(digitsClicked);

        findViewById(R.id.button_plus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyPlusPressed();
            }
        });

        findViewById(R.id.button_minus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyMinusPressed();
            }
        });

        findViewById(R.id.button_multiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyMultPressed();
            }
        });

        findViewById(R.id.button_divide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onKeyDivPressed();
            }
        });

    }

    @Override
    public void showResult(String result) {
        resultTextView.setText(result);
    }
}