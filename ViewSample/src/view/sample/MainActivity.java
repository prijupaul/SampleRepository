package view.sample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button viewBottun;
	private Button surfaceViewBottun;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		viewBottun = (Button) findViewById(R.id.view);
		viewBottun.setOnClickListener(this);

		surfaceViewBottun = (Button) findViewById(R.id.surfaceview);
		surfaceViewBottun.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		Intent viewIntent = null;
		switch (v.getId()) {
			case R.id.view:
				viewIntent = new Intent(this, MyViewActivity.class);
				startActivity(viewIntent);
				break;
			case R.id.surfaceview:
				viewIntent = new Intent(this, MySurfaceViewActivity.class);
				startActivity(viewIntent);
				break;
		}

	}
}