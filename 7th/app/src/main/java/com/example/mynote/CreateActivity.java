package com.example.mynote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;
import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateActivity extends AppCompatActivity {
    EditText editText_title, editText_content;
    TextView textView_time;
    Button btn_delete, btn_back, btn_time;
    private String oldContent = "";
    private String oldTime = "";
    private String oldTitle = "";
    private int openMode = 0;
    private int ID;
    private String Time = "";
    public Intent intent = new Intent();
    private TimePickerView pvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        editText_title = findViewById(R.id.edit_title);
        editText_content = findViewById(R.id.edit_content);
        textView_time = findViewById(R.id.text_time);
        btn_delete = findViewById(R.id.btn_delete);
        btn_back = findViewById(R.id.btn_back);
        btn_time = findViewById(R.id.btn_time);
        Intent getIntent = getIntent();
        openMode = getIntent.getIntExtra("mode", 0);
        if (openMode == 3) {
            //打开已经存在的note
            ID = getIntent.getIntExtra("id", 0);
            oldContent = getIntent.getStringExtra("content");
            oldTime = getIntent.getStringExtra("time");
            oldTitle = getIntent.getStringExtra("title");
            textView_time.setText(oldTime);
            editText_title.setText(oldTitle);
            editText_content.setText(oldContent);
        }
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (openMode == 3) {
                    LitePal.delete(Note.class, ID);
                    finish();
                }
            }
        });
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                autoSetMassage();
                finish();
            }
        });
        btn_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initTimePicker();
            }
        });
    }

    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            autoSetMassage();
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void autoSetMassage() {

        String title = editText_title.getText().toString();
        String time = textView_time.getText().toString();
        String content = editText_content.getText().toString();
        if (openMode == 4) {
            //新建的note
            if (title.length() == 0) {
                //没有改变
            } else {
                Note note = new Note();
                note.setTitle(title);
                note.setTime(time);
                note.setContent(content);
                note.save();
            }

        } else {
            if (title.equals(oldTitle) && time.equals(oldTime) && content.equals(oldContent)) {
                //没有修改
            } else {
                Note note = new Note();
                note.setTime(time);
                note.setTitle(title);
                note.setContent(content);
                note.setId(ID);
                note.update(ID);
            }
        }
    }

    private void initTimePicker() {
        new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Time = getTime(date);
                textView_time.setText(getTime(date));
                Toast.makeText(CreateActivity.this, "" + date.toString(), Toast.LENGTH_SHORT).show();
            }
        })
                .setCancelText("取消")//取消按钮文字
                .setSubmitText("确认")//确认按钮文字
                .setLabel("年", "月", "日", "时", "分", "秒")
                .setType(new boolean[]{true, true, true, true, true, false})
                .build().show();
    }

    private String getTime(Date date) {//截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }
}