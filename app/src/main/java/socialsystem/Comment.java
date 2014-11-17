package socialsystem;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import edu.depaul.csc472.weathersocial.R;


public class Comment extends ArrayAdapter<Post> {

    private final Activity activity;
    private final LayoutInflater inflater;


    Comment(Activity mainActivity){
        super(mainActivity, R.layout.activity_comment);

        this.activity = mainActivity;
        this.inflater = activity.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        View row = convertView;

        if(row == null){
            row = inflater.inflate(R.layout.activity_comment,null,true);
            holder = new Holder();
            holder.comment = (TextView) row.findViewById(R.id.comment);
            holder.Poster_Detail = (TextView) row.findViewById(R.id.posterDetail);
            holder.profileImage = (ImageView) row.findViewById(R.id.profile);
            row.setTag(holder);
        }else {
            holder = (Holder) row.getTag();
        }

        Post post = (Post)getItem(position);
        holder.Poster_Detail.setText(post.getPosterName());
        holder.comment.setText(post.getComment());

        return row;
    }

    class Holder{
        TextView Poster_Detail;
        TextView comment;
        ImageView profileImage;
    }
}
