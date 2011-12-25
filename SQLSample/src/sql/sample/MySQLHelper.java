package sql.sample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLHelper extends SQLiteOpenHelper {

	private static final String DB_NAME = "SAMPLE_DB";

	public MySQLHelper(Context context) {
		super(context, DB_NAME, null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE MEMBER (ID INTEGER PRIMARY KEY, NAME TEXT);");
		db.execSQL("INSERT INTO MEMBER (ID, NAME) VALUES (1,'�R�c ���Y');");
		db.execSQL("INSERT INTO MEMBER (ID, NAME) VALUES (2,'�R�c �Ԏq');");
		db.execSQL("INSERT INTO MEMBER (ID, NAME) VALUES (3,'���� ���');");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

}
