package cl.jenni.prueba2.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.EditText;
import android.widget.TextView;

import cl.jenni.prueba2.R;
import cl.jenni.prueba2.models.Book;

public class DetailBookActivity extends AppCompatActivity {

    private Book book;
    private EditText reviewEd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_book);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView titleTv = (TextView) findViewById(R.id.titlte_detailTv);
        TextView editTv = (TextView) findViewById(R.id.editorial_detailTv);
        reviewEd = (EditText) findViewById(R.id.review_detailEt);

        Long bookId = getIntent().getLongExtra("BOOK_ID",0);
        book = Book.findById(Book.class,bookId);

        titleTv.setText(book.getTitle());
        editTv.setText(book.getEditorial());
        reviewEd.setText(book.getReview());
    }

    @Override
    protected void onPause() {
        super.onPause();

        book.setReview(reviewEd.getText().toString());
        book.save();

    }
}
