package sql.sample;

import android.app.Activity;
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
	private EditText editId;
	private EditText editName;
	private TextView textView;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mySqlHelper = new MySQLHelper(this);
		
		editId = (EditText) findViewById(R.id.editId);
		editName = (EditText) findViewById(R.id.editName);
		saveButton = (Button) findViewById(R.id.saveBottun);
		textView = (TextView) findViewById(R.id.member);

		saveButton.setOnClickListener(this);
		showMembers();
	}

	@Override
	public void onClick(View v) {
		db = mySqlHelper.getReadableDatabase();
		String id = editId.getText().toString();
		String name = editName.getText().toString();

		if ("".equals(id))
			return;
		try {
			db.execSQL("INSERT INTO MEMBER (ID, NAME) VALUES (" + id + ",'" + name + "');");
		} catch (Exception e) {
			// 
		}

		showMembers();
	}

	private void showMembers() {
		Cursor c = db.query("MEMBER", new String[] { "ID", "NAME" }, null, null, null, null, null);

		StringBuilder sb = new StringBuilder();
		while (c.moveToNext()) {
			sb.append("id:").append(c.getInt(0)).append(" name:").append(c.getString(1)).append("\r\n");
		}
		textView.setText(sb.toString());
		c.close();
		db.close();
	}

}
