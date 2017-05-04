package com.bigademo.tony.signin;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.provider.Contacts;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bigademo.datetimepicker.wheel.view.TYSingleCheckWheel2;
import com.bigademo.tony.signin.httputil.HttpUtil;
import com.bigademo.tony.signin.httputil.NetListener;
import com.bigademo.tony.signin.utils.AppInfoUtils;
import com.bigademo.tony.signin.utils.MD5Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private static final String LONGITUDE = "116.471989";
    private static final String LATITUDE = "39.914646";
    private static final String USERNAME = "AB054865";
    private static final String PASSWORD = "123456";
    private static final String CURRENT_ANDROID_ID = "b33bccb5d904a25f";
    private String CURRENT_POHONE_ANDROID_ID = "";


    private static final String FG = "------------------->\n";
    private Button btnLogin;

    private Button btnCheckIn;
    private EditText edLongitude;
    private EditText edLatitude;
    private EditText edAndroidId;
    private TextView tvPhoneAndrId;
    private TextView tvMsg;


    private StringBuilder sb;
    private static final int GET_IPM_CHOOSE = 0x100;
    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GET_IPM_CHOOSE:
                    getIpmChoose();
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        sb = new StringBuilder();
    }

    private void initView() {
        edLatitude = (EditText) findViewById(R.id.et_latitude);
        edLongitude = (EditText) findViewById(R.id.et_longitude);
        edAndroidId = (EditText) findViewById(R.id.tv_andoridid);
        tvPhoneAndrId = (TextView) findViewById(R.id.tv_phone_id);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnCheckIn = (Button) findViewById(R.id.btn_checkIn);
        tvMsg = (TextView) findViewById(R.id.tv_msg);


        edLongitude.setText(LONGITUDE);
        edLatitude.setText(LATITUDE);

        btnLogin.setOnClickListener(this);
        btnCheckIn.setOnClickListener(this);
        btnCheckIn.setClickable(false);
        btnCheckIn.setVisibility(View.INVISIBLE);
        edLatitude.setOnLongClickListener(this);
        edLongitude.setOnLongClickListener(this);


        tvPhoneAndrId.setText(getCurrentPhoneAndroidID());
        edAndroidId.setText(CURRENT_ANDROID_ID);
    }

    private String getCurrentPhoneAndroidID() {
        CURRENT_POHONE_ANDROID_ID = "" + android.provider.Settings.Secure.getString(getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
        return CURRENT_POHONE_ANDROID_ID;
    }

    private void login() {
        HttpUtil.getInstance().add("sourceType", "app")
                .add("userName", USERNAME.toUpperCase())
                .add("password", MD5Util.MD5(PASSWORD.toUpperCase()).toUpperCase())
                .add("mobileType", "ANDROID")
                .add("version", AppInfoUtils.getAppVersionName(MainActivity.this))
                .add("macAddr", CURRENT_ANDROID_ID)
                .add("authkey", MD5Util.MD5("anbang" + USERNAME))
                .postData(HttpURL.LOGIN, new NetListener() {
                    @Override
                    public void success(String msg) {
                        sb.append(msg);
                        sb.append("\n");
                        sb.append(FG);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "登陆", Toast.LENGTH_SHORT).show();
                                tvMsg.setText("");
                                tvMsg.setText(sb.toString());
                            }
                        });
                        mHandler.sendEmptyMessageDelayed(GET_IPM_CHOOSE, 200);
                    }

                    @Override
                    public void failure() {

                    }
                });
    }


    private void getIpmChoose() {
        HttpUtil.getInstance().add("abnumber", USERNAME)
                .add("key", MD5Util.MD5(PASSWORD.toUpperCase()).toUpperCase())
                .add("authkey", MD5Util.MD5("anbang" + USERNAME).toUpperCase())
                .postData(HttpURL.GET_IPM, new NetListener() {

                    @Override
                    public void success(String msg) {
                        sb.append(msg);
                        sb.append("\n");
                        sb.append(FG);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "接口二", Toast.LENGTH_SHORT).show();
                                btnCheckIn.setClickable(true);
                                btnCheckIn.setVisibility(View.VISIBLE);
                                tvMsg.setText("");
                                tvMsg.setText(sb.toString());
                            }
                        });

                    }

                    @Override
                    public void failure() {

                    }
                });
    }


    private void checkIn(String longitude, String latitude) {
        HttpUtil.getInstance().getInstance().add("sourceType", "app")
                .add("userName", USERNAME.toUpperCase())
                .add("mapType", "baidu")
                .add("longitude", longitude)
                .add("latitude", latitude)
                .add("macAddr", CURRENT_ANDROID_ID)
                .add("city", "110100")
                .add("password", MD5Util.MD5(PASSWORD.toUpperCase()))
                .add("authkey", MD5Util.MD5("anbang" + USERNAME))
                .postData(HttpURL.SIGNIN, new NetListener() {
                    @Override
                    public void success(String msg) {
                        sb.append(msg);
                        sb.append("\n");
                        sb.append(FG);
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(MainActivity.this, "登陆", Toast.LENGTH_SHORT).show();
                                tvMsg.setText("");
                                tvMsg.setText(sb.toString());
                            }
                        });

                    }

                    @Override
                    public void failure() {

                    }
                });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_login:
                login();
                break;

            case R.id.btn_checkIn:
//                Toast.makeText(MainActivity.this, "可以打卡", Toast.LENGTH_SHORT).show();
                checkIn(edLongitude.getText().toString(), edLatitude.getText().toString());
                break;
        }
    }


    @Override
    public boolean onLongClick(View v) {
        switch (v.getId()) {
            case R.id.et_longitude:
                selectLongitude();
                break;
            case R.id.et_latitude:
                setLatutide();
                break;
        }

        return false;
    }

    private void selectLongitude() {
        String[] xList = getResources().getStringArray(R.array.x_list);
        final List<String> longitudeList = Arrays.asList(xList);

        final TYSingleCheckWheel2 singleCheckWheel2 = new TYSingleCheckWheel2(this);
        singleCheckWheel2.setData(longitudeList);
        singleCheckWheel2.show();
        singleCheckWheel2.setJobSelectListener2(new TYSingleCheckWheel2.OnJobSelectListener2() {
            @Override
            public void onJobSelect(int index) {
                edLongitude.setText(longitudeList.get(index));
            }
        });
    }

    private void setLatutide() {
        String[] yList = getResources().getStringArray(R.array.y_list);
        final List<String> latutideList = Arrays.asList(yList);

        final TYSingleCheckWheel2 singleCheckWheel2 = new TYSingleCheckWheel2(this);
        singleCheckWheel2.setData(latutideList);
        singleCheckWheel2.show();
        singleCheckWheel2.setJobSelectListener2(new TYSingleCheckWheel2.OnJobSelectListener2() {
            @Override
            public void onJobSelect(int index) {
                edLatitude.setText(latutideList.get(index));
            }
        });
    }
}
