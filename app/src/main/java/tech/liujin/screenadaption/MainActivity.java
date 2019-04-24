package tech.liujin.screenadaption;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import tech.liujin.screen.ScreenAdapter;

/**
 * @author liujin
 */
public class MainActivity extends AppCompatActivity implements OnClickListener {

      private LinearLayout mLinearLayout;
      private Button       mButton;
      private TextView     mTextView;
      private LinearLayout mRoot;

      @Override
      protected void onCreate ( Bundle savedInstanceState ) {

            super.onCreate( savedInstanceState );
            View view = ScreenAdapter.inflateView( this, R.layout.activity_main );
            setContentView( view );
            initView();

            String display = getDisplay();
            mTextView.setText( display );

            final View inflateView = ScreenAdapter.inflateView( this, R.layout.item_200dp, mRoot );
            mRoot.addView( inflateView );

            mTextView.post( new Runnable() {

                  @Override
                  public void run ( ) {

                        int width = mButton.getMeasuredWidth();
                        mButton.setText(
                            String.format( "%.2f", ( width * 1f / mRoot.getMeasuredWidth() ) ) + " "
                                + width );

                        width = inflateView.getMeasuredWidth();
                        ( (Button) inflateView ).setText(
                            String.format( "%.2f", ( width * 1f / mRoot.getMeasuredWidth() ) ) + " "
                                + width );
                  }
            } );
      }

      private String getDisplay ( ) {

            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            float density = displayMetrics.density;
            int densityDpi = displayMetrics.densityDpi;
            float scaledDensity = displayMetrics.scaledDensity;
            int heightPixels = displayMetrics.heightPixels;
            int widthPixels = displayMetrics.widthPixels;
            float xdpi = displayMetrics.xdpi;
            float ydpi = displayMetrics.ydpi;

            String display = "density: " + density + "\n" +
                "densityDpi: " + densityDpi + "\n" +
                "scaledDensity: " + scaledDensity + "\n" +
                "heightPixels: " + heightPixels + "\n" +
                "widthPixels: " + widthPixels + "\n" +
                "xdpi: " + xdpi + "\n" +
                "ydpi: " + ydpi;

            return display;
      }

      private void initView ( ) {

            mLinearLayout = findViewById( R.id.linearLayout );
            mButton = findViewById( R.id.button );
            mButton.setOnClickListener( this );
            mTextView = findViewById( R.id.textView );
            mRoot = findViewById( R.id.root );
      }

      @Override
      public void onClick ( View v ) {

            switch( v.getId() ) {
                  case R.id.button:
                        break;
                  default:
                        break;
            }
      }
}
