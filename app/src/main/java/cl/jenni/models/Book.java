package cl.jenni.prueba2.models;

import com.orm.SugarRecord;

public class Book extends SugarRecord {

    private String title;
    private String editorial;
    private String review;

    public Book() {
    }

    public Book(String title, String editorial) {
        this.title = title;
        this.editorial = editorial;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}


