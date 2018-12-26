package thamen.om;

import thamen.om.josn.Movie;

/**
 * Created by sasmob on 11/27/2018.
 */

public class SupportItimes extends Movie {
    private String name, year,rate;
    private  int imageView;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getYear() {

        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public int getImageView(){
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
