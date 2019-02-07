package shibanov.tic_tac_toe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;

import shibanov.tic_tac_toe.fragment.BackCardFragment;

public class PlayGame extends AppCompatActivity {

    private GridView mGridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        mGridView = (GridView)findViewById(R.id.grid_tic_tac);
        mGridView.setAdapter(new GridViewAdapter(this));

    }

    class GridViewAdapter extends BaseAdapter {

        private Context mContext;

        public GridViewAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return 9;
        }

        @Override
        public Object getItem(int i) {
            return i;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View card;
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            if (view == null) {
                // if it's not recycled, initialize some attributes
                card = inflater.inflate(R.layout.item_grid,viewGroup,false);
                card.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT));
                card.setPadding(8, 8, 8, 8);
                final ImageButton btn = (ImageButton) card.findViewById(R.id.image_tic_tac);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        final ObjectAnimator oa1 = ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f);
                        final ObjectAnimator oa2 = ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f);
                        oa1.setInterpolator(new DecelerateInterpolator());
                        oa2.setInterpolator(new AccelerateDecelerateInterpolator());
                        oa1.addListener(new AnimatorListenerAdapter() {
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                super.onAnimationEnd(animation);
                                int resourse = getResources().getIdentifier("ic_close_black","drawable",getPackageName());
                                btn.setImageResource(resourse);
                                oa2.start();
                            }
                        });
                        oa1.start();

//                        btn.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_bright));
//                        btn.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    }
                });

            } else {
                card = (View) view;
            }

            return card;
        }
    }

    private void flipCard() {
//        if (mShowingBack) {
//            getSupportFragmentManager().popBackStack();
//            return;
//        }
//
//        // Flip to the back.
//
//        mShowingBack = true;


        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        R.animator.card_flip_right_in,
                        R.animator.card_flip_right_out,
                        R.animator.card_flip_left_in,
                        R.animator.card_flip_left_out)

                // Replace any fragments currently in the container view with a
                // fragment representing the next page (indicated by the
                // just-incremented currentPage variable).
                .replace(R.id.container_try, BackCardFragment.startFragment(R.drawable.ic_zero_black))

                // Add this transaction to the back stack, allowing users to press
                // Back to get to the front of the card.
                .addToBackStack(null)

                // Commit the transaction.
                .commit();
    }
}
