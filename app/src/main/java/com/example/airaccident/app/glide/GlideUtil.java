package com.example.airaccident.app.glide;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.airaccident.R;

import androidx.annotation.DimenRes;

/**
 * Glide 图片加载工具类
 */

/**
 * diskCacheStrategy参数补充
 * <p>
 * DiskCacheStrategy.NONE   表示不缓存任何内容。
 * <p>
 * DiskCacheStrategy.DATA   表示只缓存原始图片。
 * <p>
 * DiskCacheStrategy.RESOURCE   表示只缓存转换过后的图片。
 * <p>
 * DiskCacheStrategy.ALL    表示既缓存原始图片，也缓存转换过后的图片。
 * <p>
 * DiskCacheStrategy.AUTOMATIC  表示让Glide根据图片资源智能地选择使用哪一种缓存策略（默认选项）。
 */
public class GlideUtil {
    private static String TAG = "GlideUtil";
    //加载失败 、占位   图片
    private static final int errorImg = R.drawable.a_moren_fang;
    private static final int errorRoundImg = R.drawable.a_moren_yuanjiao;
    private static final int errorCircleImg = R.drawable.a_moren_yuan;

    /**
     * 正常
     */
    public static void load(Context context, String url, @DimenRes int wRes, ImageView imageView) {
        load(context, errorImg, url, wRes, wRes, imageView);
    }

    public static void load(Context context, String url, @DimenRes int wRes, @DimenRes int hRes, ImageView imageView) {
        load(context, errorImg, url, wRes, hRes, imageView);
    }

    public static void load(Context context, int normalRes, String url, @DimenRes int wRes, ImageView imageView) {
        load(context, normalRes, url, wRes, wRes, imageView);
    }

    public static void load(Context context, int normalRes, String url, @DimenRes int wRes,
                            @DimenRes int hRes, ImageView imageView) {
        if (context == null) return;
        if (context instanceof Activity)
            if (((Activity) context).isDestroyed())
                return;

        int w, h;
        try {
            w = (int) context.getResources().getDimension(wRes);
        } catch (Exception e) {
            w = wRes;
        }
        try {
            h = (int) context.getResources().getDimension(hRes);
        } catch (Exception e) {
            h = hRes;
        }
        RequestOptions options = new RequestOptions()
                .error(normalRes)
                .placeholder(normalRes)
                .override(w, h)
                .centerCrop();

        Log.e(TAG, url);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 圆形
     */
    public static void loadCircle(Context context, String url, @DimenRes int wRes, ImageView imageView) {
        if (context == null) return;
        if (context instanceof Activity)
            if (((Activity) context).isDestroyed())
                return;

        int w;
        try {
            w = (int) context.getResources().getDimension(wRes);
        } catch (Exception e) {
            w = wRes;
        }

        RequestOptions options = new RequestOptions()
                .error(errorCircleImg)
                .placeholder(errorCircleImg)
                .override(w)
                .transform(new CircleTransform());

        Log.i(TAG, url);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 加载成圆角
     */




    public static void loadRound(Context context, int normalRes, String url, @DimenRes int wRes,
                                 @DimenRes int hRes, ImageView imageView, @DimenRes int rRes) {
        if (context == null) return;
        if (context instanceof Activity)
            if (((Activity) context).isDestroyed())
                return;

        int w, h, r;
        try {
            w = (int) context.getResources().getDimension(wRes);
        } catch (Exception e) {
            w = wRes;
        }

        try {
            h = (int) context.getResources().getDimension(hRes);
        } catch (Exception e) {
            h = hRes;
        }

        try {
            r = (int) context.getResources().getDimension(rRes);
        } catch (Exception e) {
            r = rRes;
        }
        RequestOptions options = new RequestOptions()
                .error(normalRes)
                .placeholder(normalRes)
                .centerCrop()
                .override(w, h)
                .transform(new RoundTransform(context, r));

        Log.e(TAG, url);
        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 黑白
     */
    public static void loadBlackWhite(Context context, String url, ImageView imageView) {
        if (context == null) return;
        if (context instanceof Activity)
            if (((Activity) context).isDestroyed())
                return;

        RequestOptions options = new RequestOptions()
                .error(errorImg)
                .placeholder(errorImg)
                .transform(new BlackWhiteTransformation());

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    /**
     * 模糊
     */
    public static void loadBlur(Context context, String url, ImageView imageView) {
        loadBlur(context, url, errorImg, imageView);
    }

    /**
     * 模糊
     */
    public static void loadBlur(Context context, String url, int res, ImageView imageView) {
        if (context == null) return;
        if (context instanceof Activity)
            if (((Activity) context).isDestroyed())
                return;

        RequestOptions options = new RequestOptions()
                .error(res)
                .placeholder(res)
                .transform(new BlurTransformation(context, 24));

        Glide.with(context)
                .load(url)
                .apply(options)
                .into(imageView);
    }

    public static void loadGif(Context context, int url, ImageView imageView) {
        if (context == null) return;
        if (context instanceof Activity)
            if (((Activity) context).isDestroyed())
                return;

        RequestOptions options = new RequestOptions()
                .error(errorRoundImg)
                .placeholder(errorRoundImg);

        Glide.with(context)
                .asGif()
                .load(url)
                .apply(options)
                .into(imageView);
    }
}