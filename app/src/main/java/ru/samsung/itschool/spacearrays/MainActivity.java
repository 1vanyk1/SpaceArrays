package ru.samsung.itschool.spacearrays;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {

	private Button start, close;
	private SeekBar stars;
	private Intent intent;
	private int count = 200;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu);
		start = findViewById(R.id.start);
		start.setOnClickListener(this);
		close = findViewById(R.id.close);
		close.setOnClickListener(this);
		stars = findViewById(R.id.count_of_stars);
		stars.setOnSeekBarChangeListener(this);
		TextView text1 = findViewById(R.id.text1);
		text1.setText(getString(R.string.count_of_stars) + " " + Integer.toString(count));
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.start) {
			this.intent = new Intent(MainActivity.this, GameActivity.class);
			Switch yellow = findViewById(R.id.yellow_stars);
			this.intent.putExtra("yellow_stars", yellow.isChecked());
			this.intent.putExtra("count", count);
			startActivity(intent);
		} else if (v.getId() == R.id.close) {
			this.finish();
		}
	}

	@Override
	public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
		if (fromUser) {
			if (seekBar.getId() == R.id.count_of_stars) {
				count = ((int) (progress));
				TextView text1 = findViewById(R.id.text1);
				text1.setText(getString(R.string.count_of_stars) + " " + Integer.toString(count));
			}
		}
	}

	@Override
	public void onStartTrackingTouch(SeekBar seekBar) {}

	@Override
	public void onStopTrackingTouch(SeekBar seekBar) {}
}
