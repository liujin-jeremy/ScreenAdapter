package tech.liujin.screen;

import android.content.Context;
import android.support.annotation.DimenRes;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * 获取屏幕尺寸
 *
 * @author: Liujin
 * @version: V1.0
 * @date: 2018-08-22
 * @time: 10:17
 */
public class ScreenSize {

      private static int   sWidth  = -1;
      private static int   sHeight = -1;
      private static float s1DpPx  = -1;

      /**
       * 初始化变量
       */
      public static void init ( Context context ) {

            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            sWidth = displayMetrics.widthPixels;
            sHeight = displayMetrics.heightPixels;

            s1DpPx = TypedValue.applyDimension( TypedValue.COMPLEX_UNIT_DIP, 1f, displayMetrics );
      }

      /**
       * 屏幕宽度
       */
      public static int getWidth ( ) {

            return sWidth;
      }

      /**
       * 屏幕高度
       */
      public static int getHeight ( Context context ) {

            return sHeight;
      }

      /**
       * 获取屏幕百分比宽度
       */
      public static int getWidth ( float percent ) {

            return (int) ( sWidth * percent );
      }

      /**
       * 获取屏幕百分比高度
       */
      public static int getHeight ( float percent ) {

            return (int) ( sHeight * percent );
      }

      /**
       * 转换dp为px
       */
      public static float dpToPx ( float dpSize ) {

            return dpSize * s1DpPx;
      }

      /**
       * 获取一个资源的px
       */
      public static int resToPx ( Context context, @DimenRes int dimenRes ) {

            return context.getResources().getDimensionPixelSize( dimenRes );
      }
}
