package com.example.myapplication2;
import java.util.Collections;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAppInfo();
        /*String a = "Total:3456 GB\nAvailable:57845784 GB";
        a = a.replaceAll("\n","");
        a = a.replaceAll("Total:","");
        a = a.replaceAll("Available:","");
        String [] fgh = a.split("GB");
        Log.d("zhangrui","fgh[0]="+fgh[0]+"///fgh[1]="+fgh[1]+"bnm="+fgh.length);*/
    }

    private void getAppInfo() {
        PackageManager pm = this.getPackageManager();
        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        List<ResolveInfo> resolveInfos = pm.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        Collections.sort(resolveInfos, new ResolveInfo.DisplayNameComparator(pm));
        for (ResolveInfo resolveInfo : resolveInfos) {
            String appName = resolveInfo.loadLabel(pm).toString();// 获取应用名称
            String packageName = resolveInfo.activityInfo.packageName;// 包名
            String className = resolveInfo.activityInfo.name;// 入口类名
            Log.d("zhangrui","程序名：" + appName + " 包名:" + packageName
                    + " 入口类名：" + className);
        }
    }

}