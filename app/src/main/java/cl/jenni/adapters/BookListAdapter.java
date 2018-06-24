package cl.jenni.prueba2.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cl.jenni.prueba2.OnListFragmentInteractionListener;
import cl.jenni.prueba2.R;
import cl.jenni.prueba2.data.Queries;
import cl.jenni.prueba2.models.Book;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.ViewHolder> {

    private final List<Book> bookList = Queries.getBooks();
    private final OnListFragmentInteractionListener mListener;

    public BookListAdapter(OnListFragmentInteractionListener listener) {
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.book_item_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.titleTv.setText(bookList.get(position).getTitle());
        holder.editorialTv.setText(bookList.get(position).getEditorial());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    //mListener.onListFragmentInteraction(holder.getAdapterPosition());
                }
            }
        });

        holder.titleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Book book = bookList.get(position);

                mListener.onListFragmentInteraction(book.getId());

                /*book.delete();
                bookList.remove(position);

                // Notificar el cambio
                notifyItemRemoved(position);*/
            }
        });
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public TextView titleTv;
        public TextView editorialTv;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            titleTv = (TextView) view.findViewById(R.id.bookTitleTv);
            editorialTv = (TextView) view.findViewById(R.id.bookEditorialTv);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + titleTv.getText() + "'";
        }
    }

    public void updateList(Book b){
        bookList.add(b);
        notifyDataSetChanged();

    }
}
