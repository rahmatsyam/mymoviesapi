package learning.shinesdev.mymovies2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TVShowModel implements Parcelable {
    public static final Creator<TVShowModel> CREATOR = new Creator<TVShowModel>() {
        @Override
        public TVShowModel createFromParcel(Parcel in) {
            return new TVShowModel(in);
        }

        @Override
        public TVShowModel[] newArray(int size) {
            return new TVShowModel[size];
        }
    };

    private String title;
    private String nextTitle1;
    private String nextTitle2;
    private String nextTitle3;
    private String date;
    private String year;
    private String group;
    private String duration;
    private String genre;
    private String rating;
    private String synopsis;
    private String stars;
    private String votes;
    private String image;
    private String nextImage1;
    private String nextImage2;
    private String nextImage3;

    public TVShowModel() {
    }

    private TVShowModel(Parcel in) {
        title = in.readString();
        nextTitle1 = in.readString();
        nextTitle2 = in.readString();
        nextTitle3 = in.readString();
        date = in.readString();
        year = in.readString();
        group = in.readString();
        duration = in.readString();
        genre = in.readString();
        rating = in.readString();
        synopsis = in.readString();
        stars = in.readString();
        votes = in.readString();
        image = in.readString();

        nextImage1 = in.readString();
        nextImage2 = in.readString();
        nextImage3 = in.readString();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }



    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }



    public String getStars() {
        return stars;
    }

    public void setStars(String stars) {
        this.stars = stars;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeString(title);
        dest.writeString(nextTitle1);
        dest.writeString(nextTitle2);
        dest.writeString(nextTitle3);
        dest.writeString(date);
        dest.writeString(year);
        dest.writeString(group);
        dest.writeString(duration);
        dest.writeString(genre);
        dest.writeString(rating);
        dest.writeString(synopsis);
        dest.writeString(stars);
        dest.writeString(votes);
        dest.writeString(image);
        dest.writeString(nextImage1);
        dest.writeString(nextImage2);
        dest.writeString(nextImage3);
    }

}