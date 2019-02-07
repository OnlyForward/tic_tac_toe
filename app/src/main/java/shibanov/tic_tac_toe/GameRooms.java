package shibanov.tic_tac_toe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class GameRooms extends Fragment {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager mManager;
    private RecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_all_games,container,false);

        mManager = new LinearLayoutManager(getContext());
        mAdapter = new RecyclerAdapter(getContext());
        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_var_games);

        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(mManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(mRecyclerView.getContext(),
                mManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    class RecyclerHolder extends RecyclerView.ViewHolder {

        private TextView mRoom;
        private TextView mCreator;


        public RecyclerHolder(@NonNull View itemView) {
            super(itemView);
            mCreator = (TextView) itemView.findViewById(R.id.creator);
            mRoom = (TextView) itemView.findViewById(R.id.name_room);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getActivity(),PlayGame.class);
                    startActivity(intent);
                }
            });
        }

    }

    class RecyclerAdapter extends RecyclerView.Adapter<RecyclerHolder> {

        Context context;

        public RecyclerAdapter(Context context) {
            this.context = context;
        }

        @NonNull
        @Override
        public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
            RecyclerHolder holder = new RecyclerHolder(inflater.inflate(R.layout.item_recycler, viewGroup, false));
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerHolder recyclerHolder, int i) {

        }

        @Override
        public int getItemCount() {
            return 2;
        }
    }

}
