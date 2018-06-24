package cl.jenni.prueba2.main;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import cl.jenni.prueba2.R;
import cl.jenni.prueba2.models.Book;

public class MainActivity extends AppCompatActivity {

    private BookListFragment bookListFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bookListFrag = (BookListFragment) getSupportFragmentManager().findFragmentById(R.id.BookListFragment);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(view.getContext());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_insert_book);

                Button addBtn = dialog.findViewById(R.id.dialogButtonOK);
                addBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText namebookEt = dialog.findViewById(R.id.bookEt);
                        EditText editorialbookEt = dialog.findViewById(R.id.bookeditorialEt);
                        String namebook = namebookEt.getText().toString();
                        String editorialbook = editorialbookEt.getText().toString();
                        if(namebook.trim().length() > 0 && editorialbook.trim().length() >0){
                            Book b = new Book();
                            b.setTitle(namebook);
                            b.setEditorial(editorialbook);
                            b.save();
                            bookListFrag.updateList(b);

                        }

                        dialog.dismiss();
                    }
                });

                dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
                dialog.show();
            }
        });
    }

}
