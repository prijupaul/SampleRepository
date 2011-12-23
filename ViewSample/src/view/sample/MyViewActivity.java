package view.sample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.View;

public class MyViewActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MyView(this));
	}
}

class MyView extends View {

	private Bitmap bitmap;
	private float left;
	private float top;

	public MyView(Context context) {
		super(context);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
	}

	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawBitmap(bitmap, left, top, null);

		left += 5;
		top += 10;
		left = left > getWidth() ? 0 : left;
		top = top > getHeight() ? 0 : top;

		invalidate();
	}

}