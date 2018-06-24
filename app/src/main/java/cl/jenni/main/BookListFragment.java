package cl.jenni.prueba2.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.jenni.prueba2.OnListFragmentInteractionListener;
import cl.jenni.prueba2.R;
import cl.jenni.prueba2.adapters.BookListAdapter;
import cl.jenni.prueba2.models.Book;

public class BookListFragment extends Fragment implements OnListFragmentInteractionListener{
    /*
    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;*/
    private BookListAdapter adapter;
    private RecyclerView recyclerView;

    public BookListFragment() {
    }

    /*public static BookListFragment newInstance(int columnCount) {
        BookListFragment fragment = new BookListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }*/

    /*@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.list);

        LinearLayoutManager lManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(lManager);
        recyclerView.setHasFixedSize(true);

        adapter = new BookListAdapter(this);
        recyclerView.setAdapter(adapter);

        //Book b = new Book("Camino","Libreria Proa");
        //b.save();
    }

    @Override
    public void onListFragmentInteraction(long pos) {

        Intent intent = new Intent(getActivity(), DetailBookActivity.class);
        intent.putExtra("BOOK_ID",pos);
        startActivity(intent);

    }

    public void updateList(Book b){
        adapter.updateList(b);
        recyclerView.smoothScrollToPosition(adapter.getItemCount()-1);
    }

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }*/

}
