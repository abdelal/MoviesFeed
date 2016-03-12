package ali.test;

import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;



public class myWebClient extends WebViewClient
{
    private ProgressBar progressBar;

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {

          super.onPageStarted(view, url, favicon);
        progressBar= (ProgressBar)view.findViewById(R.id.progressBar);

    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {


        progressBar.setVisibility(View.VISIBLE);
        view.loadUrl(url);
        return true;

    }

    @Override
    public void onPageFinished(WebView view, String url) {
        // TODO Auto-generated method stub
        super.onPageFinished(view, url);

        progressBar.setVisibility(View.GONE);
    }
}


