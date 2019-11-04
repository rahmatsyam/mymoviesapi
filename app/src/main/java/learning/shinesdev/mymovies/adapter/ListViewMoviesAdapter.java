package learning.shinesdev.mymovies.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import learning.shinesdev.mymovies.R;
import learning.shinesdev.mymovies.model.Movie;

public class ListViewMoviesAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    public void setMovie(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ListViewMoviesAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int i) {
        return movies.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_list_movies, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);

        Movie movie = (Movie) getItem(i);
        viewHolder.bind(movie);

        return itemView;
    }

    private class ViewHolder {
        private TextView txtNumber;
        private TextView txtTitle;
        private TextView txtYear;
        private TextView txtAgeGroup;
        private TextView txtDuration;
        private TextView txtGenre;
        private TextView txtRate;
        private TextView txtMetascore;
        private TextView txtSynopnsis;
        private TextView txtDirector;
        private TextView txtStars;
        private TextView txtVotes;
        private TextView txtGross;

        private ImageView imgThumb;

        ViewHolder(View view) {
            txtNumber = view.findViewById(R.id.txt_movie_number);
            txtTitle = view.findViewById(R.id.txt_movie_title);
            txtYear = view.findViewById(R.id.txt_movie_year);
            txtYear = view.findViewById(R.id.txt_movie_year);
            txtAgeGroup = view.findViewById(R.id.txt_movie_age_group);
            txtDuration = view.findViewById(R.id.txt_movie_minutes);
            txtRate = view.findViewById(R.id.txt_movie_rating);
            txtMetascore = view.findViewById(R.id.txt_movie_metascore);
            txtSynopnsis = view.findViewById(R.id.txt_movie_sinopsis);
            txtDirector = view.findViewById(R.id.txt_movie_director);
            txtStars = view.findViewById(R.id.txt_movie_stars);
            txtVotes = view.findViewById(R.id.txt_movie_votes);
            txtGross = view.findViewById(R.id.txt_movie_gross);
            imgThumb = view.findViewById(R.id.img_movie_thumb);
        }

        void bind(Movie movie) {
            txtNumber.setText(movie.getNumber());
            txtTitle.setText(movie.getTitle());
            txtYear.setText(movie.getYear());
            txtAgeGroup.setText(movie.getGroup());
            txtDuration.setText(movie.getDuration());
            txtRate.setText(movie.getRating());
            txtMetascore.setText(movie.getMetascore());
            txtSynopnsis.setText(movie.getSynopsis());
            txtDirector.setText(movie.getDirector());
            txtStars.setText(movie.getStars());
            txtVotes.setText(movie.getVotes());
            txtGross.setText(movie.getGross());

            Glide.with(context)
                    .load(movie.getImage())
                    .apply(new RequestOptions().override(100))
                    .into(imgThumb);
        }
    }
}
