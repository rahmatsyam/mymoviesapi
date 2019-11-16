package learning.shinesdev.mymoviesapi;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import learning.shinesdev.mymoviesapi.R;
import learning.shinesdev.mymoviesapi.adapter.ListTVShowAdapter;
import learning.shinesdev.mymoviesapi.model.TVShowModel;
import learning.shinesdev.mymoviesapi.model.TVShowData;
import learning.shinesdev.mymoviesapi.utils.GlobVar;


/**
 * A simple {@link Fragment} subclass.
 */
public class TVShowFragment extends Fragment {
    private RecyclerView rvTVShow;
    private final ArrayList<TVShowModel> list = new ArrayList<>();

    public TVShowFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvTVShow = view.findViewById(R.id.rv_tvshow);
        rvTVShow.setHasFixedSize(true);

        TVShowData data = new TVShowData(getContext());
        list.addAll(data.getArrListData());
        showRecyclerList();
    }

    private void showRecyclerList(){
        rvTVShow.setLayoutManager(new LinearLayoutManager(getContext()));
        ListTVShowAdapter listAdapter = new ListTVShowAdapter(getContext(),list);
        rvTVShow.setAdapter(listAdapter);

        listAdapter.setOnItemClickCallback((data, idx) -> showSelectedTVShow(data,idx));
    }

    private void showSelectedTVShow(TVShowModel tv, int idx) {
        Intent intent = new Intent(getContext(), DetailTVShowActivity.class);
        intent.putExtra(GlobVar.EX_TV, tv);
        intent.putExtra(GlobVar.EX_IDX, idx);
        startActivity(intent);
    }
}