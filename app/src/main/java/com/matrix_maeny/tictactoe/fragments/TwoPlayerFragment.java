package com.matrix_maeny.tictactoe.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.matrix_maeny.tictactoe.R;

public class TwoPlayerFragment extends Fragment {


    LinearLayout gameBoard, turnLayout;
    LinearLayout tic1, tic2, tic3, tic4, tic5, tic6, tic7, tic8, tic9, restartGame;
    ImageView tic1View, tic2View, tic3View, tic4View, tic5View, tic6View, tic7View, tic8View, tic9View, turnView;
    // for won dialog
    ImageView trophyView, winnerView;
    AppCompatButton playAgain;
    TextView namePlate, resultText;
    ConstraintLayout wonDialog = null;
    Switch soundsSwitch;
    MediaPlayer player = null;

    int turnNumber = 1;
    int t1 = 0, t2 = 0, t3 = 0, t4 = 0, t5 = 0, t6 = 0, t7 = 0, t8 = 0, t9 = 0;
    boolean gameStatus = true, winOrLoseStatus = false, playSounds = true;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_two_player, container, false);

        setTheIds(root);

        setTheVisibility();

        tic1.setOnClickListener(tic1Listener);
        tic2.setOnClickListener(tic2Listener);
        tic3.setOnClickListener(tic3Listener);
        tic4.setOnClickListener(tic4Listener);
        tic5.setOnClickListener(tic5Listener);
        tic6.setOnClickListener(tic6Listener);
        tic7.setOnClickListener(tic7Listener);
        tic8.setOnClickListener(tic8Listener);
        tic9.setOnClickListener(tic9Listener);
        restartGame.setOnClickListener(restartGameListener);
        playAgain.setOnClickListener(restartGameListener);
        soundsSwitch.setOnCheckedChangeListener(switchListener);



        return root;
    }

    final void setTheIds(@NonNull View root) {



        wonDialog = root.findViewById(R.id.wonDialog);
        trophyView = root.findViewById(R.id.trophyView);
        winnerView = root.findViewById(R.id.winnerView);
        namePlate = root.findViewById(R.id.namePlate);
        resultText = root.findViewById(R.id.resultText);
        playAgain = root.findViewById(R.id.playAgain);
        soundsSwitch = root.findViewById(R.id.soundsSwitch);

        gameBoard = root.findViewById(R.id.gameBoard);
        turnLayout = root.findViewById(R.id.turnLayout);
        tic1 = root.findViewById(R.id.tic1);
        tic2 = root.findViewById(R.id.tic2);
        tic3 = root.findViewById(R.id.tic3);
        tic4 = root.findViewById(R.id.tic4);
        tic5 = root.findViewById(R.id.tic5);
        tic6 = root.findViewById(R.id.tic6);
        tic7 = root.findViewById(R.id.tic7);
        tic8 = root.findViewById(R.id.tic8);
        tic9 = root.findViewById(R.id.tic9);// for layouts

        tic1View = root.findViewById(R.id.tic1View);
        tic2View = root.findViewById(R.id.tic2View);
        tic3View = root.findViewById(R.id.tic3View);
        tic4View = root.findViewById(R.id.tic4View);
        tic5View = root.findViewById(R.id.tic5View);
        tic6View = root.findViewById(R.id.tic6View);
        tic7View = root.findViewById(R.id.tic7View);
        tic8View = root.findViewById(R.id.tic8View);
        tic9View = root.findViewById(R.id.tic9View);// for views

        restartGame = root.findViewById(R.id.restartGame);
        turnView = root.findViewById(R.id.turnView);
        winnerView.setVisibility(View.VISIBLE);
        soundsSwitch.setChecked(true);


    }

    final void setTheVisibility() {
        turnLayout.setVisibility(View.VISIBLE);
        gameBoard.setVisibility(View.VISIBLE);
        tic1View.setVisibility(View.INVISIBLE);
        tic2View.setVisibility(View.INVISIBLE);
        tic3View.setVisibility(View.INVISIBLE);
        tic4View.setVisibility(View.INVISIBLE);
        tic5View.setVisibility(View.INVISIBLE);
        tic6View.setVisibility(View.INVISIBLE);
        tic7View.setVisibility(View.INVISIBLE);
        tic8View.setVisibility(View.INVISIBLE);
        tic9View.setVisibility(View.INVISIBLE);

        restartGame.setVisibility(View.VISIBLE);

        wonDialog.setVisibility(View.GONE);

    }


    View.OnClickListener tic1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t1 == 0 && gameStatus && !winOrLoseStatus) {
                startTic1();
            } else tempToast();
        }
    };
    View.OnClickListener tic2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t2 == 0 && gameStatus && !winOrLoseStatus) {
                startTic2();
            } else tempToast();


        }
    };
    View.OnClickListener tic3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t3 == 0 && gameStatus && !winOrLoseStatus) {
                startTic3();
            } else tempToast();


        }
    };
    View.OnClickListener tic4Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t4 == 0 && gameStatus && !winOrLoseStatus) {
                startTic4();
            } else tempToast();


        }
    };
    View.OnClickListener tic5Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t5 == 0 && gameStatus && !winOrLoseStatus) {
                startTic5();
            } else tempToast();


        }
    };
    View.OnClickListener tic6Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t6 == 0 && gameStatus && !winOrLoseStatus) {
                startTic6();
            } else tempToast();


        }
    };
    View.OnClickListener tic7Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t7 == 0 && gameStatus && !winOrLoseStatus) {
                startTic7();
            } else tempToast();


        }
    };
    View.OnClickListener tic8Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t8 == 0 && gameStatus && !winOrLoseStatus) {
                startTic8();
            } else tempToast();


        }
    };
    View.OnClickListener tic9Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t9 == 0 && gameStatus && !winOrLoseStatus) {
                startTic9();
            } else tempToast();


        }
    };
    View.OnClickListener restartGameListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            restartTheWholeGame();

        }
    };
    CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            playSounds = isChecked;
        }
    };
    MediaPlayer.OnCompletionListener playerListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            mp.release();
        }
    };


    final void startTic1() {
        if (turnNumber == 1) {
            tic1View.setImageResource(R.drawable.player_1);
        } else {
            tic1View.setImageResource(R.drawable.player_2);
        }

        t1 = turnNumber;
        tic1View.setVisibility(View.VISIBLE);
        checkGameStatus();
    }

    final void startTic2() {
        if (turnNumber == 1) {
            tic2View.setImageResource(R.drawable.player_1);

        } else {
            tic2View.setImageResource(R.drawable.player_2);

        }

        t2 = turnNumber;
        tic2View.setVisibility(View.VISIBLE);
        checkGameStatus();
    }

    final void startTic3() {
        if (turnNumber == 1) {
            tic3View.setImageResource(R.drawable.player_1);
        } else {
            tic3View.setImageResource(R.drawable.player_2);

        }

        t3 = turnNumber;
        tic3View.setVisibility(View.VISIBLE);
        checkGameStatus();

    }

    final void startTic4() {
        if (turnNumber == 1) {
            tic4View.setImageResource(R.drawable.player_1);

        } else {
            tic4View.setImageResource(R.drawable.player_2);

        }

        t4 = turnNumber;
        tic4View.setVisibility(View.VISIBLE);
        checkGameStatus();


    }

    final void startTic5() {
        if (turnNumber == 1) {
            tic5View.setImageResource(R.drawable.player_1);

        } else {
            tic5View.setImageResource(R.drawable.player_2);

        }
        t5 = turnNumber;
        tic5View.setVisibility(View.VISIBLE);
        checkGameStatus();


    }

    final void startTic6() {
        if (turnNumber == 1) {
            tic6View.setImageResource(R.drawable.player_1);

        } else {
            tic6View.setImageResource(R.drawable.player_2);

        }

        t6 = turnNumber;
        tic6View.setVisibility(View.VISIBLE);
        checkGameStatus();


    }

    final void startTic7() {
        if (turnNumber == 1) {
            tic7View.setImageResource(R.drawable.player_1);

        } else {
            tic7View.setImageResource(R.drawable.player_2);

        }
        t7 = turnNumber;
        tic7View.setVisibility(View.VISIBLE);
        checkGameStatus();


    }

    final void startTic8() {
        if (turnNumber == 1) {
            tic8View.setImageResource(R.drawable.player_1);

        } else {
            tic8View.setImageResource(R.drawable.player_2);

        }
        t8 = turnNumber;
        tic8View.setVisibility(View.VISIBLE);
        checkGameStatus();


    }

    final void startTic9() {
        if (turnNumber == 1) {
            tic9View.setImageResource(R.drawable.player_1);

        } else {
            tic9View.setImageResource(R.drawable.player_2);

        }
        t9 = turnNumber;
        tic9View.setVisibility(View.VISIBLE);
        checkGameStatus();

    }


    final void changeTurn() {
        if (turnNumber == 1) {

            turnNumber = 2;
            turnView.setImageResource(R.drawable.player_2);
        } else {
            turnNumber = 1;
            turnView.setImageResource(R.drawable.player_1);
        }
    }

    final void checkGameStatus() {
        if (playSounds) {
            playButtonSound();
        }
        boolean rowCheck = ((t1 != 0 && t2 != 0 && t3 != 0) && (t1 == t2 && t2 == t3)) || ((t4 != 0 && t5 != 0 && t6 != 0) && (t4 == t5 && t4 == t6)) || ((t7 != 0 && t8 != 0 && t9 != 0) && (t7 == t8 && t7 == t9));
        boolean columnCheck = ((t1 != 0 && t4 != 0 && t7 != 0) && (t1 == t4 && t4 == t7)) || ((t2 != 0 && t5 != 0 && t8 != 0) && (t2 == t5 && t5 == t8)) || ((t3 != 0 && t6 != 0 && t9 != 0) && (t3 == t6 && t6 == t9));
        boolean diagonalCheck = ((t1 != 0 && t5 != 0 && t9 != 0) && (t1 == t5 && t5 == t9)) || ((t3 != 0 && t5 != 0 && t7 != 0) && (t3 == t5 && t5 == t7));

        gameStatus = !(t1 != 0 && t2 != 0 && t3 != 0 && t4 != 0 && t5 != 0 && t6 != 0 && t7 != 0 && t8 != 0 && t9 != 0);
        winOrLoseStatus = rowCheck || columnCheck || diagonalCheck;

        showResults();
        if (!winOrLoseStatus) {
            changeTurn();
        }

    }

    final void showResults() {

        if (winOrLoseStatus) {
            changeBackground();

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (playSounds) {
                        playSound(true);
                    }
                    showWinnerPoster(winOrLoseStatus);
                }
            }, 1500);
            gameStatus = true;


        } else {
            if (!gameStatus) {
                if (playSounds) {
                    playSound(false);
                }
                showWinnerPoster(winOrLoseStatus);
            }
        }
    }


    final void restartTheWholeGame() {
       playButtonSound2();
        t1 = t2 = t3 = t4 = t5 = t6 = t7 = t8 = t9 = 0;
        gameStatus = true;
        winOrLoseStatus = false;
        turnNumber = 1;
        setTheVisibility();
        setBackground();

    }

    final void tempToast() {
        Toast.makeText(getContext(), "Already filled", Toast.LENGTH_LONG).show();

    }

    @SuppressLint("SetTextI18n")
    final void showWinnerPoster(boolean status) {
        trophyView.setVisibility(View.VISIBLE);
        resultText.setVisibility(View.VISIBLE);
        namePlate.setVisibility(View.VISIBLE);
        gameBoard.setVisibility(View.INVISIBLE);
        restartGame.setVisibility(View.GONE);
        turnLayout.setVisibility(View.GONE);
        if (status) {

            trophyView.setImageResource(R.drawable.winner);
            resultText.setText("Congratulations...!");
            if (turnNumber == 1) {
                winnerView.setImageResource(R.drawable.player_1);
                namePlate.setText("Circle player won...");
            } else {
                winnerView.setImageResource(R.drawable.player_2);
                namePlate.setText("Cross player won...");

            }
        } else {
            trophyView.setImageResource(R.drawable.handshake);
            winnerView.setVisibility(View.GONE);
            resultText.setText("Draw..!");
            namePlate.setVisibility(View.GONE);
        }
        wonDialog.setVisibility(View.VISIBLE);
    }

    final void playSound(boolean won) {
      stopSound();

        if (won) {
            player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.game_won);
        } else {
            player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.draw_match);
        }
        player.start();

    }

    final void stopSound() {
        try {
            if (player != null) {
                player.stop();
                player.release();
            }
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

    final void playButtonSound() {
        stopSound();

        player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.click);
        player.start();
    }
    final void playButtonSound2(){
        stopSound();

        player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.click2);
        player.start();
    }


    final void changeBackground() {
        boolean checkRow1 = (t1 == t2 && t2 == t3);
        boolean checkRow2 = (t4 == t5 && t5 == t6);
        boolean checkRow3 = (t7 == t8 && t8 == t9);

        boolean checkColumn1 = (t1 == t4 && t4 == t7);
        boolean checkColumn2 = (t2 == t5 && t5 == t8);
        boolean checkColumn3 = (t3 == t6 && t6 == t9);

        boolean diagonal1 = (t1 == t5 && t5 == t9);
        boolean diagonal2 = (t3 == t5 && t5 == t7);

        if (checkRow1) {
            tic1View.setBackgroundResource(R.color.boxBackground);
            tic2View.setBackgroundResource(R.color.boxBackground);
            tic3View.setBackgroundResource(R.color.boxBackground);
            return;
        }
        if (checkRow2) {
            tic4View.setBackgroundResource(R.color.boxBackground);
            tic5View.setBackgroundResource(R.color.boxBackground);
            tic6View.setBackgroundResource(R.color.boxBackground);
            return;
        }
        if (checkRow3) {
            tic7View.setBackgroundResource(R.color.boxBackground);
            tic8View.setBackgroundResource(R.color.boxBackground);
            tic9View.setBackgroundResource(R.color.boxBackground);
            return;
        }
        if (checkColumn1) {
            tic1View.setBackgroundResource(R.color.boxBackground);
            tic4View.setBackgroundResource(R.color.boxBackground);
            tic7View.setBackgroundResource(R.color.boxBackground);
            return;
        }
        if (checkColumn2) {
            tic2View.setBackgroundResource(R.color.boxBackground);
            tic5View.setBackgroundResource(R.color.boxBackground);
            tic8View.setBackgroundResource(R.color.boxBackground);
            return;
        }
        if (checkColumn3) {
            tic3View.setBackgroundResource(R.color.boxBackground);
            tic6View.setBackgroundResource(R.color.boxBackground);
            tic9View.setBackgroundResource(R.color.boxBackground);
            return;
        }
        if (diagonal1) {
            tic1View.setBackgroundResource(R.color.boxBackground);
            tic5View.setBackgroundResource(R.color.boxBackground);
            tic9View.setBackgroundResource(R.color.boxBackground);
            return;
        }
        if (diagonal2) {
            tic3View.setBackgroundResource(R.color.boxBackground);
            tic5View.setBackgroundResource(R.color.boxBackground);
            tic7View.setBackgroundResource(R.color.boxBackground);
        }


    }

    final void setBackground() {
        tic1View.setBackgroundColor(Color.TRANSPARENT);
        tic2View.setBackgroundColor(Color.TRANSPARENT);
        tic3View.setBackgroundColor(Color.TRANSPARENT);
        tic4View.setBackgroundColor(Color.TRANSPARENT);
        tic5View.setBackgroundColor(Color.TRANSPARENT);
        tic6View.setBackgroundColor(Color.TRANSPARENT);
        tic7View.setBackgroundColor(Color.TRANSPARENT);
        tic8View.setBackgroundColor(Color.TRANSPARENT);
        tic9View.setBackgroundColor(Color.TRANSPARENT);
    }

}