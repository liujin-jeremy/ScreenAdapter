package tech.threekilogram.screenadapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/**
 * @author Liujin 2018-10-30:11:08
 */
public class ScreenAdapter {

      private static final String TAG = ScreenAdapter.class.getSimpleName();

      private ScreenAdapter ( ) { }

      public static void setContentView ( Activity activity, @LayoutRes int layout ) {

            DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
            float old = displayMetrics.density;

            if( displayMetrics.widthPixels < displayMetrics.heightPixels ) {

                  int widthPixels = displayMetrics.widthPixels;
                  displayMetrics.density = widthPixels * 1f / 1080 * 3;
            } else {

                  int widthPixels = displayMetrics.widthPixels;
                  displayMetrics.density = widthPixels * 1f / 1920 * 3;
            }
            activity.setContentView( layout );
            displayMetrics.density = old;
      }

      public static View inflateView ( Context context, @LayoutRes int layout ) {

            return inflateView( context, layout, new FrameLayout( context ) );
      }

      public static View inflateView ( Context context, @LayoutRes int layout, ViewGroup parent ) {

            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            float old = displayMetrics.density;

            if( displayMetrics.widthPixels < displayMetrics.heightPixels ) {

                  int widthPixels = displayMetrics.widthPixels;
                  displayMetrics.density = widthPixels * 1f / 1080 * 3;
            } else {

                  int widthPixels = displayMetrics.widthPixels;
                  displayMetrics.density = widthPixels * 1f / 1920 * 3;
            }

            View result = LayoutInflater.from( context ).inflate( layout, parent, false );
            displayMetrics.density = old;

            Log.e( TAG, "inflateView : " + result.getLayoutParams().width );

            return result;
      }
}
