package com.example.xiaowu.androidutils;

import static com.example.xiaowu.APP.context;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeoutException;

/**
 * Created by xiaowu on 2016-7-20.
 */
public class CommonUtils {


    //根据文件类型，弹出应用选择列表
    public  static void openFiles(String filesPath) {
        Uri uri = Uri.fromFile(new File(filesPath));
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        String type = getMIMEType(filesPath);
        intent.setDataAndType(uri, type);

//        Log.d(TAG, "openFiles: "+type+"--"+filesPath);
        if (!type.equals("*/*")) {
            try {
                context.startActivity(intent);
            } catch (Exception e) {
//                Log.d(TAG, "openFiles: "+e.toString());
//                Toast.makeText(context,"不支持该文件类型").show();
//                startActivity(showOpenTypeDialog(filesPath));
            }

        }
        else {
            context.startActivity(showOpenTypeDialog(filesPath));
        }
    }
    public static Intent showOpenTypeDialog(String param) {
        Log.e("ViChildError", "showOpenTypeDialog");
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.fromFile(new File(param));
        intent.setDataAndType(uri, "*/*");
        return intent;
    }
    public static String getMIMEType(String filePath) {
        String type = "*/*";
        if (!TextUtils.isEmpty(filePath)) {
            String fName = filePath;
            int dotIndex = fName.lastIndexOf(".");
            if (dotIndex < 0) {
                return type;
            }
            String end = fName.substring(dotIndex, fName.length()).toLowerCase().trim();
            if (end == "") {
                return type;
            }
            for (int i = 0; i < (Constant.MIME_MapTable).length; i++) {
                if (end.equals(Constant.MIME_MapTable[i][0]))
                    type = Constant.MIME_MapTable[i][1];
            }
        }
        return type;
    }





    /**
     * 打开系统安装页面
     * */
    private void openInstallPage(File file)
    {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setDataAndType(Uri.fromFile(file),
                "application/vnd.android.package-archive");
        context.startActivity(intent);
    }



    /**
     * 静默安装app
     *
     * @param context
     * @param fileName
     *            要安装app的文件名
     * @param external
     *            安装的位置
     */
    @SuppressLint({ "WorldReadableFiles", "WorldWriteableFiles" })
    public static void installApp(Context context, String pkgName, String fileName, String path,
                                  boolean external) throws TimeoutException {

        chmod(path);
        Intent intent = new Intent();
//            intent.setAction("com.konka.ACTION.SILENT_INSTALL");
        intent.setAction(Constant.ACTION_SLIENT_INSTALL);
        intent.putExtra("FILE_NAME", path);
        intent.putExtra("INSTALL_LOCATION", external ? 2 : 1);
        intent.putExtra("NEED_HINT_INSTALL_RESULT", true);
        intent.putExtra("installed_packageNmae",pkgName);
        context.sendBroadcast(intent);

    }

    /**
     * 执行命令，修改某个路径的权限
     */
    private static final String CHMOD = "busybox chmod 777";
    public static void chmod(String path) {
        String cmd = CHMOD + " " + path;
        String s;
        Process process;
        //test
        // two commit
        try {
            process = Runtime.getRuntime().exec(cmd);
            BufferedReader buff = new BufferedReader(new InputStreamReader(
                    process.getInputStream()));
            while ((s = buff.readLine()) != null) {
                System.out.println(s);
                process.waitFor();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * SimpleDateFormat一起父类DateFormat是线程不安全的，最好每个线程一个实例
     *
     * 此方法现在线程安全
     * */
    //时间格式化
    public static Date parseStr2Date(String str){
        //方法一:每次都创建实例
        SimpleDateFormat SDF=new SimpleDateFormat("yyyyMMdd");
        try {
            return SDF.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static float divide(int one, int two) {
        return BigDecimal.valueOf(one).divide(BigDecimal.valueOf(two), 2, BigDecimal.ROUND_HALF_UP).floatValue();
    }
}
