package ali.test;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.google.gson.internal.LinkedTreeMap;
import com.squareup.picasso.Picasso;

import java.util.List;

import ali.test.appleentities.Movie;


public class Radapter
        extends RecyclerView.Adapter<Radapter.ViewHolder> {

    //Private data members
    private List<Movie> data;
    private Context context;

    //Constructor:
    public Radapter(List<Movie> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.rview_item,
                parent, false);
        View view = LayoutInflater.from(context).inflate(R.layout.moviepage,
                parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        itemView.setOnClickListener(viewHolder);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Movie currentItem = data.get(position);
        holder.tvtitle.setText(currentItem.getImName().getLabel().toString());
        holder.tvplot.setText(currentItem.getSummary().getLabel().toString());
        YoYo.with(Techniques.BounceIn).playOn(holder.view);
        String url = currentItem.getLink().get(0).getAttributes().getHref().toString();
        LinkedTreeMap image = (LinkedTreeMap) currentItem.getImImage().get(0);
        String imageurl = image.get("label").toString();

        if (imageurl.length() != 0)
            Picasso.with(context).load(imageurl).into(holder.ivthumb);

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
            implements RecyclerView.OnClickListener {
        ImageView ivthumb;
        TextView tvtitle;
        TextView tvplot;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            ivthumb = (ImageView) itemView.findViewById(R.id.ivthumb);
            tvtitle = (TextView) itemView.findViewById(R.id.tvtitle);
            tvplot = (TextView) itemView.findViewById(R.id.tvplot);
            view= itemView;
        }

        @Override
        public void onClick(View v) {
            View view1 = LayoutInflater.from(context).inflate(R.layout.moviepage, null, false);
            WebView webview = (WebView) view1.findViewById(R.id.webview);
            int position = getAdapterPosition();
            Movie movie = data.get(position);
            String url = movie.getLink().get(0).getAttributes().getHref().toString();

            webview.loadUrl(url);
            WebViewClient client = new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    view.loadUrl(url);
                    return true;
                }
            };
            webview.setWebViewClient(client);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setView(view1);
            builder.setNegativeButton("Close", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int id) {
                    dialog.dismiss();
                }
            });

            builder.show();
        }
    }
}