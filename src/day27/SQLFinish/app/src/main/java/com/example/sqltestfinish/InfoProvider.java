package com.example.sqltestfinish;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class InfoProvider extends ContentProvider {
    private static final String AUTHORITY = "com.example.sqltestfinish";
    private static final String BASE_PATH = "info";
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" + BASE_PATH );

    private static final int INFOS = 1;
    private static final int INFO_ID = 2;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static {
        uriMatcher.addURI(AUTHORITY, BASE_PATH, INFOS);
        uriMatcher.addURI(AUTHORITY, BASE_PATH + "/#", INFO_ID);
    }

    private SQLiteDatabase database;

    @Override
    public boolean onCreate() {
        DBHelper helper = new DBHelper(getContext());
        database = helper.getWritableDatabase();

        return true;
    }

    /* 이 부분은 MainActivity 의
       getContentResolver().query(uri, columns, null, null, "name ASC");
       에 해당하는 부분이다.
       인자로 넘어온 name ASC 는 이름을 기준으로 오름차순 정렬을 의미한다. */
    @Nullable
    @Override
    public Cursor query(Uri uri, String[] strings, String s, String[] strings1, String s1) {
        Cursor cursor;
        switch (uriMatcher.match(uri)) {
            case INFOS:
                /* 첫 번째는 테이블 이름,
                   두 번째는 테이블내의 모든 컬럼,
                   세 번째는 s 인데 결국 Query 이므로 없음
                   네 번째도 null, 5 번째도 null, 6 번째도 null,
                   마지막은 정렬 기준을 적으면 됨
                   (현재 우리 입장에서 정렬 기준은 name ASC 로
                   이름을 기준으로 오름차순 작업을 진행한다) */
                cursor =  database.query(DBHelper.TABLE_NAME, DBHelper.ALL_COLUMNS,
                        s, null, null, null, DBHelper.INFO_NAME + " ASC");
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        cursor.setNotificationUri(getContext().getContentResolver(), uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case INFOS:
                return "vnd.android.cursor.dir/infos";
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
    }

    /* MainActivity 의
       getContentResolver().insert(uri, values) 은
       아래 코드에 해당한다.
     */
    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        /* 첫 번째 인자는 테이블 이름
           두 번째 인자는 null,
           세 번째 인자가 contentValues 로
           실제 컬럼과 각 컬럼에 들어갈 데이터에 해당한다. */
        long id = database.insert(DBHelper.TABLE_NAME, null, contentValues);

        if (id > 0) {
            /* CONTENT_URI 라는 것은 결국
               "content://com.example.sqltestfinish/info" 을 의미한다.
               아래 부분에선 몇 번 바뀌었는지를 볼 수 있다 판단하면 되겠다. */
            Uri _uri = ContentUris.withAppendedId(CONTENT_URI, id);
            getContext().getContentResolver().notifyChange(_uri, null);
            return _uri;
        }

        throw new SQLException("Add Fail -> URI :" + uri);
    }

    /* 여기 있는 delete() 코드는
       MainActivity 에 있는
       getContentResolver().delete() 에 해당한다. */
    @Override
    public int delete(Uri uri, String s, String[] strings) {
        int count = 0;
        /* DB 가 "content://com.example.sqltestfinish/info" 에
           존재한다면 무조건 uriMatcher.match 결과는 1 이다. */
        switch (uriMatcher.match(uri)) {
            case INFOS:
                /* 실제 DB 를 delete 하는 작업이 여기서 진행된다.
                   그리고 단순히 첫 번째 인자가 TABLE_NAME,
                   두 번째(name) 인자는 무엇을 기반으로 지울 것인지
                   세 번째(Jessica) 인자는 무엇이 되는 대상
                   즉, 이름이 Jessica 인 모든 정보를 지워라! */
                count =  database.delete(DBHelper.TABLE_NAME, s, strings);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return count;
    }

    /* MainActivity 에 있는
       getContentResolver().update(uri, updateValue, selection, selectionArgs)
       은 여기 있는 update 에 해당한다. */
    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        int count = 0;
        switch (uriMatcher.match(uri)) {
            case INFOS:
                /* 첫 번째 인자는 테이블 이름(info)
                   두 번째 인자는 "mobile", "010-3377-2473" 으로
                   폰 번호를 010-3377-2473 으로 바꿀려하는 것
                   세 번째 인자는 무엇(mobile)을 update 하려고 하는가
                   네 번째 세 번째 인자의 세부 사항
                   즉 mobile 인데 010-3333-7777 인 것을 변경하겠다는 의미 */
                count =  database.update(DBHelper.TABLE_NAME, contentValues, s, strings);
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }
        getContext().getContentResolver().notifyChange(uri, null);

        return count;
    }
}
