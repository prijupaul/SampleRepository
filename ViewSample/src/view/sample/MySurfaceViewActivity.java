package view.sample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceViewActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MySurfaceView(this));
	}
}

class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

	private boolean isDrawable;
	private Thread thread;
	private Bitmap bitmap;
	private float left;
	private float top;

	public MySurfaceView(Context context) {
		super(context);
		bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
		getHolder().addCallback(this);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		isDrawable = true;
		thread = new Thread(this);
		thread.start();
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		isDrawable = false;
	}

	@Override
	public void run() {
		while (isDrawable) {
			left += 5;
			top += 10;
			left = left > getWidth() ? 0 : left;
			top = top > getHeight() ? 0 : top;
			doDraw(getHolder());
		}
	}

	private void doDraw(SurfaceHolder holder) {
		Canvas canvas = holder.lockCanvas();
		canvas.drawColor(Color.BLACK);
		canvas.drawBitmap(bitmap, left, top, null);
		holder.unlockCanvasAndPost(canvas);
	}

}