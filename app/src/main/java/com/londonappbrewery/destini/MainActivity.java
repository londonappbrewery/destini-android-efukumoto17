package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    Button mTopButton;
    Button mBottomButton;
    TextView mTextView;
    int [] mStory = {R.string.T1_Story,
            R.string.T2_Story,
            R.string.T3_Story,
            R.string.T4_End,
            R.string.T5_End,
            R.string.T6_End};
    int [] mTop = {R.string.T1_Ans1,
            R.string.T2_Ans1,
            R.string.T3_Ans1};
    int [] mBottom = {R.string.T1_Ans2,
            R.string.T2_Ans2,
            R.string.T3_Ans2};
    int mState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mBottomButton = findViewById(R.id.buttonBottom);
        mTopButton = findViewById(R.id.buttonTop);
        mTextView = findViewById(R.id.storyTextView);
        mState = 1;



        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mBottomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mState == 1){
                    mState = 2;

                }else if (mState == 2){
                    mState = 4;

                }else if (mState == 3){
                    mState = 5;

                }
                updateQuestion();

            }
        });
        mTopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mState == 1){
                    mState = 3;

                }else if (mState == 2){
                    mState = 3;

                }else if (mState == 3){
                    mState = 6;

                }
                updateQuestion();

            }
        });






        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
    }
    private void updateQuestion(){
        mTextView.setText(mStory[mState - 1]);
        if(mState < 4){
            mTopButton.setText(mTop[mState - 1]);
            mBottomButton.setText(mBottom[mState - 1]);
        } else{
            mBottomButton.setText("");
            mTopButton.setText("");
        }
    }
}
