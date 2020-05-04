package com.example.airaccident.app.network;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;


import com.example.airaccident.app.CollectionUtils;

import java.io.File;
import java.io.IOException;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * OkHttp网络连接封装工具类
 */
public class OkHttpUtils {
    //格式
    private static final MediaType MEDIA_TYPE_JSON = MediaType.parse("application/json; charset=utf-8");

    private static MediaType getMimeType(String filename) {
        FileNameMap filenameMap = URLConnection.getFileNameMap();
        String contentType = filenameMap.getContentTypeFor(filename);
        if (contentType == null) {
            contentType = "application/octet-stream"; //* exe,所有的可执行程序
        }
        return MediaType.parse(contentType);
    }

    //Code码
    public static final int CODE_SUCCESS = 200;              //成功
    public static final int CODE_SERVICE_ERROR = 500;        //服务器开小差了
    public static final int CODE_NO_NET = -200;               //请求失败
    public static final int CODE_DEAL_WITH_FAILURE = -2;    //数据异常


    //存储post请求
    private static ArrayList<String> urls = new ArrayList<>();

    private static OkHttpUtils mInstance;
    private OkHttpClient mOkHttpClient;
    private Handler mDelivery;

    /**
     * 初始化OkHttp
     */
    private OkHttpUtils() {
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .build();

        mDelivery = new Handler(Looper.getMainLooper());
    }

    /**
     * 获取实列
     */
    private synchronized static OkHttpUtils getInstance() {
        if (mInstance == null) {
            mInstance = new OkHttpUtils();
        }
        return mInstance;
    }

    /**********************************************************************************************************
     *******************************************      get请求       ********************************************
     *  @param isToast      是否吐司
     *  @param url          请求网址
     *  @param paramObjects 请求参数
     *  @param callback     回调
     * */
    public static Call get(Context context, boolean isToast, String url, LinkedHashMap<String, Object> paramObjects, ResultCallback<String> callback) {
        return getInstance().getRequest(context, isToast, url, paramObjects, callback);
    }

    public static Call get(Context context, String url, LinkedHashMap<String, Object> paramObjects, ResultCallback<String> callback) {
        return getInstance().getRequest(context, false, url, paramObjects, callback);
    }

    private Call getRequest(Context context, boolean isToast, String url, LinkedHashMap<String, Object> params, final ResultCallback<String> callback) {
        //判断是否有参数
        if (!CollectionUtils.isEmpty(params)) {
            StringBuilder param = new StringBuilder();
            //拼接参数
            int i = 0;
            for (Object o : params.entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                Object key = entry.getKey();
                Object val = entry.getValue();
                if (i == 0) {   //如果没有拼接?  则加上?
                    if (!url.endsWith("?"))
                        param.append("?");
                } else {        //如果不是第一个参数，则需要加&
                    param.append("&");
                }
                param.append(key).append("=").append(val);
                i++;
            }

            url = url + param.toString();
        }
        //请求
        Request request = new Request.Builder().url(url).build();
        return deliveryResult(context, isToast, url, "Get: " + url, callback, request);
    }

    /**********************************************************************************************************
     *******************************************      post 表单请求       ***************************************
     ***********************************************************************************************************/
    public static void post(Context context, boolean isToast, String url, LinkedHashMap<String, Object> params, final ResultCallback<String> callback) {
        getInstance().postRequest(context, isToast, url, params, callback);
    }

    public static void post(Context context, String url, LinkedHashMap<String, Object> params, final ResultCallback<String> callback) {
        getInstance().postRequest(context, false, url, params, callback);
    }

    private void postRequest(Context context, boolean isToast, String url, LinkedHashMap<String, Object> params, final ResultCallback<String> callback) {
        if (urls.contains(url)) {
           // ToastUtils.show(context, R.string.frequent);
            return;
        }
        urls.add(url);

        //请求体
        FormBody.Builder builder = new FormBody.Builder();

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        if (!CollectionUtils.isEmpty(params)) {
            for (Object o : params.entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                String key = String.valueOf(entry.getKey());
                String val = String.valueOf(entry.getValue());
                builder.add(key, val);

                sb.append("\"").append(key).append("\"").append(":").append("\"").append(val).append("\"").append(",");
            }
        }

        RequestBody requestBody = builder.build();
        String string = sb.append("}").toString();

        String newUrl = "Post: " + url + "\nParams: " + string;


        Request request = new Request.Builder().url(url)
                .post(requestBody)
                .build();

        deliveryResult(context, isToast, url, newUrl, callback, request);
    }

    /**********************************************************************************************************
     *******************************************      post 表单形式 混合参数和文件       *************************
     *  @param isToast      是否吐司
     *  @param url          请求网址
     *  @param params       请求参数
     *  @param fileList     文件路径
     *  @param callback     回调
     *  @param progressListener     进度回调
     * */
    public static Call postFile(Context context, boolean isToast, String url, LinkedHashMap<String, Object> params, LinkedHashMap<String, String> fileList, final ResultCallback<String> callback, ProgressListener progressListener) {
        return getInstance().postRequest(context, isToast, url, params, fileList, callback, progressListener);
    }

    public static Call postFile(Context context, String url, LinkedHashMap<String, Object> params, LinkedHashMap<String, String> fileList, final ResultCallback<String> callback, ProgressListener progressListener) {
        return getInstance().postRequest(context, false, url, params, fileList, callback, progressListener);
    }

    private Call postRequest(Context context, boolean isToast, String url, LinkedHashMap<String, Object> params, LinkedHashMap<String, String> fileNames,
                             final ResultCallback<String> callback, ProgressListener progressListener) {
        if (urls.contains(url)) {
          //  ToastUtils.show(context, R.string.frequent);
            return null;
        }
        urls.add(url);

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        //请求体
        MultipartBody.Builder builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        if (!CollectionUtils.isEmpty(params)) {
            for (Object o : params.entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                String key = String.valueOf(entry.getKey());
                String val = String.valueOf(entry.getValue());
                builder.addFormDataPart(key, val);
                sb.append("\"").append(key).append("\"").append(":").append("\"").append(val).append("\"").append(",");
            }
        } else {
            builder.addFormDataPart("", "");
        }

        if (fileNames != null) {
            if (fileNames.size() > 0) {
                Set<String> keySet = fileNames.keySet();
                for (String key : keySet) {
                    File file = new File(fileNames.get(key)); //生成文件
                    if (file.exists()) {
                        //根据文件的后缀名，获得文件类型
                        builder.addFormDataPart( //给Builder添加上传的文件
                                key,  //请求的名字
                                file.getName(), //文件的文字，服务器端用来解析的
                                RequestBody.create(getMimeType(file.getName()), file) //创建RequestBody，把上传的文件放入
                        );

                        sb.append("\"").append(key).append("\"").append(":").append("\"").append(file.getPath()).append("\"").append(",");
                    }

                  //  Logger.i(file + "\t是否存在" + file.exists());
                }
            }
        }
        RequestBody requestBody = builder.build();
        String string = sb.append("}").toString();
        String newUrl = "Post File: " + url + "\nParams: " + string;

        //请求
        Request request = new Request.Builder().url(url)
                .post(ProgressHelper.addProgressRequestListener(
                        requestBody,
                        progressListener))
                .build();
        return deliveryResult(context, isToast, url, newUrl, callback, request);
    }

    /**********************************************************************************************************
     *******************************************      post Json请求、拼到body里       ***************************
     *  @param isToast      是否吐司
     *  @param url          请求网址
     *  @param params       请求参数
     *  @param callback     回调
     * */
    public static Call postJson(Context context, boolean isToast, String url, LinkedHashMap<String, Object> params, final ResultCallback<String> callback) {
        return getInstance().postRequestObject(context, isToast, url, callback, params);
    }

    public static Call postJson(Context context, String url, LinkedHashMap<String, Object> params, final ResultCallback<String> callback) {
        return getInstance().postRequestObject(context, false, url, callback, params);
    }

    private Call postRequestObject(Context context, boolean isToast, String url, final ResultCallback<String> callback, LinkedHashMap<String, Object> params) {
        if (urls.contains(url)) {
         //   ToastUtils.show(context, R.string.frequent);
            return null;
        }
        urls.add(url);

        StringBuilder sb = new StringBuilder();
        //请求体 参数

        if (!CollectionUtils.isEmpty(params)) {
            int i = 0;
            for (Object o : params.entrySet()) {
                Map.Entry entry = (Map.Entry) o;
                String key = String.valueOf(entry.getKey());
                Object value = entry.getValue();

                if (i == 0) {
                    sb.append("{");
                }

                sb.append("\"").append(key).append("\":");
                if (value instanceof String) {
                    if (((String) value).endsWith("}") && ((String) value).startsWith("{")) {
                        sb.append(value);
                    } else if (((String) value).endsWith("]") && ((String) value).startsWith("[")) {
                        sb.append(value);
                    } else {
                        sb.append("\"").append(value).append("\"");
                    }
                } else {
                    sb.append(value);
                }

                if (i == params.size() - 1) {
                    sb.append("}");
                } else {
                    sb.append(",");
                }

                i++;
            }
        }

        RequestBody requestBody = RequestBody.create(MEDIA_TYPE_JSON, sb.toString());
        Request request = new Request.Builder().url(url)
                .post(requestBody)
                .build();

        String newUrl = "Post Json: " + url + "\nParams: " + sb.toString();
        return deliveryResult(context, isToast, url, newUrl, callback, request);
    }


    /**********************************************************************************************************
     *******************************************      处理结果       ********************************************
     *  @param isToast      是否吐司
     *  @param url          请求网址,   用于移除存储post请求列表的url
     *  @param params       请求参数和网址，用于请求结束时打印
     *  @param callback     回调
     *  @param request      请求对象
     * */
    private Call deliveryResult(Context context, boolean isToast, final String url, final String params, final ResultCallback<String> callback, final Request request) {
        if (mOkHttpClient == null) {
            getInstance();
        }
        Call call = mOkHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
                urls.remove(url);

                sendFailCallback(context, isToast, callback, e, params, "onFailure", CODE_NO_NET);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                urls.remove(url);

                String body = "";
                try {
                    //原Code
                    Integer code = response.code();
                    body = response.body().string();
                    String msg = "";


                    //回调
                    if (code == CODE_SUCCESS) {
//                       / Logger.i("成功：" + params +
//                                "\nBody: " + body);
                        sendSuccessCallBack(context, callback, body);
                    } else {
                        sendFailCallback(context, isToast, callback, new Exception(msg), params, body, code);
                    }
                } catch (Exception e) {
                    sendFailCallback(context, isToast, callback, e, params, body, CODE_DEAL_WITH_FAILURE);
                }
            }
        });

        return call;
    }

    /**********************************************************************************************************
     *******************************************      处理结果回调       ********************************************
     ***********************************************************************************************************/
    //请求成功
    private void sendSuccessCallBack(Context context, final ResultCallback<String> callback, final String obj) {
        mDelivery.post(() -> {
            try {
                if (callback != null)
                    callback.onSuccess(obj);
            } catch (Exception e) {
              //  ToastUtils.show(context, R.string.abnormal_data);
                e.printStackTrace();
            }
        });
    }

    //请求失败
    private void sendFailCallback(Context context, boolean isToast, final ResultCallback callback, final Exception e,
                                  String params, String body, final int code) {
//        Logger.e("失败：" + params +
//                "\nCode: " + code +
//                "\nMsg: " + e.getMessage() +
//                "\nBody: " + body);

        String err;
        if (context != null) {
            if (code == CODE_DEAL_WITH_FAILURE) {              //数据异常
               // err = context.getString(R.string.abnormal_data);
            } else if (code == CODE_NO_NET) {
             //   err = context.getString(R.string.no_found_network);
            } else if (code == CODE_SERVICE_ERROR) {              //未知错误
            err = "1111";
            } else {                                                //其他
                err = e.getMessage();
            }
        } else {
            err = e.getMessage();
        }

      //  Logger.e("isToast: " + isToast + "   err: " + err);
//
//        if (isToast && !TextUtils.isEmpty(err)) {
//            //ToastUtils.show(err);
//        }

        mDelivery.post(() -> {
            try {
                if (callback != null)
                    callback.onFailure(code, "1");
            } catch (Exception e1) {
                if (isToast) //ToastUtils.show(context, R.string.abnormal_data);
                e1.printStackTrace();
            }
        });
    }


    /**
     * http请求回调类,回调方法在UI线程中执行
     */
    public static abstract class ResultCallback<T> {

        /**
         * 请求成功回调
         */
        public abstract void onSuccess(String response);

        /**
         * 请求失败回调
         *
         * @param e
         */
        public abstract void onFailure(int code, String e);
    }

}
