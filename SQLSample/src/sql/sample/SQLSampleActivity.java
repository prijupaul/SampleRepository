package sql.sample;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLSampleActivity extends Activity implements OnClickListener {

	private MySQLHelper mySqlHelper;
	private SQLiteDatabase db;
	private Button saveButton;
	private Button deleteButton;
	private EditText editAge;
	private EditText editName;
	private TextView textView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mySqlHelper = new MySQLHelper(this);

		editAge = (EditText) findViewById(R.id.edit_age);
		editName = (EditText) findViewById(R.id.editName);
		saveButton = (Button) findViewById(R.id.save_bottun);
		deleteButton = (Button) findViewById(R.id.delete_bottun);
		textView = (TextView) findViewById(R.id.member);

		saveButton.setOnClickListener(this);
		deleteButton.setOnClickListener(this);

		showMembers();
	}

	@Override
	protected void onDestroy() {
		if (mySqlHelper != null)
			mySqlHelper.close();
	}

	@Override
	public void onClick(View v) {

		// èëÇ´çûÇ›ópÇÃDBÇéÊìæ
		db = mySqlHelper.getWritableDatabase();
		switch (v.getId()) {
			case R.id.save_bottun:
				String age = editAge.getText().toString();
				String name = editName.getText().toString();
				ContentValues values = new ContentValues();
				values.put("AGE", age);
				values.put("NAME", name);
				db.insert("MEMBER", null, values);
				break;
			case R.id.delete_bottun:
				db.delete("member", null, null);
				break;
			default:
				break;
		}
		db.close();
		showMembers();
	}

	private void showMembers() {
		// ì«Ç›éÊÇËópÇÃDBÇéÊìæ
		db = mySqlHelper.getReadableDatabase();
		Cursor c = db.query("MEMBER", new String[] { "AGE", "NAME" }, null, null, null, null, null);

		StringBuilder sb = new StringBuilder();
		while (c.moveToNext()) {
			sb.append("Age:").append(c.getInt(0)).append(" Name:").append(c.getString(1)).append("\r\n");
		}
		textView.setText(sb.toString());
		c.close();
		db.close();
	}

}
