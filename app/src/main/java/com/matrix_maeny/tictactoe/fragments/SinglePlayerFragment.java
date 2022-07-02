package com.matrix_maeny.tictactoe.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.matrix_maeny.tictactoe.R;

import java.util.Random;

public class SinglePlayerFragment extends Fragment {


    LinearLayout gameBoard, turnLayout;
    LinearLayout tic1, tic2, tic3, tic4, tic5, tic6, tic7, tic8, tic9, restartGame;
    ImageView tic1View, tic2View, tic3View, tic4View, tic5View, tic6View, tic7View, tic8View, tic9View, turnView;
    // for won dialog
    ImageView trophyView;
    Button playAgain;
    TextView namePlate, resultText, waitView;
    ConstraintLayout wonDialog = null;

    Switch soundSwitch;
    MediaPlayer player = null;
    int i = 0;


    int turnNumber = 1;
    int t1 = 0, t2 = 0, t3 = 0, t4 = 0, t5 = 0, t6 = 0, t7 = 0, t8 = 0, t9 = 0;
    boolean gameStatus = true, winOrLoseStatus = false, playSounds = true, computerTurn = false;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_single_player, container, false);

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
        soundSwitch.setOnCheckedChangeListener(switchListener);


        return root;
    }

    final void setTheIds(@NonNull View root) {
        wonDialog = root.findViewById(R.id.wonDialog);
        trophyView = root.findViewById(R.id.trophyView);
        namePlate = root.findViewById(R.id.namePlate);
        resultText = root.findViewById(R.id.resultText);
        playAgain = root.findViewById(R.id.playAgain);
        soundSwitch = root.findViewById(R.id.soundsSwitch);
        waitView = root.findViewById(R.id.waitView);

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
        soundSwitch.setChecked(true);


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
        waitView.setVisibility(View.VISIBLE);

        restartGame.setVisibility(View.VISIBLE);

        wonDialog.setVisibility(View.GONE);
        waitView.setText("■ ■ ■");

    }

    View.OnClickListener tic1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t1 == 0 && gameStatus && !winOrLoseStatus) {
                if (!computerTurn) {
                    startTic1();
                } else {
                    tempToast2();

                    if (turnNumber == 1) computerTurn = false;
                }

            } else tempToast();
        }
    };
    View.OnClickListener tic2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t2 == 0 && gameStatus && !winOrLoseStatus) {
                if (!computerTurn) {
                    startTic2();
                } else {
                    tempToast2();

                    if (turnNumber == 1) computerTurn = false;
                }
            } else tempToast();


        }
    };
    View.OnClickListener tic3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t3 == 0 && gameStatus && !winOrLoseStatus) {
                if (!computerTurn) {
                    startTic3();
                } else {
                    tempToast2();

                    if (turnNumber == 1) computerTurn = false;
                }
            } else tempToast();


        }
    };
    View.OnClickListener tic4Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t4 == 0 && gameStatus && !winOrLoseStatus) {
                if (!computerTurn) {
                    startTic4();
                } else tempToast2();
            } else tempToast();


        }
    };
    View.OnClickListener tic5Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t5 == 0 && gameStatus && !winOrLoseStatus) {
                if (!computerTurn) {
                    startTic5();
                } else {
                    tempToast2();

                    if (turnNumber == 1) computerTurn = false;
                }
            } else tempToast();


        }
    };
    View.OnClickListener tic6Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t6 == 0 && gameStatus && !winOrLoseStatus) {
                if (!computerTurn) {
                    startTic6();
                } else {
                    tempToast2();

                    if (turnNumber == 1) computerTurn = false;
                }
            } else tempToast();


        }
    };
    View.OnClickListener tic7Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t7 == 0 && gameStatus && !winOrLoseStatus) {
                if (!computerTurn) {
                    startTic7();
                } else {
                    tempToast2();

                    if (turnNumber == 1) computerTurn = false;
                }
            } else tempToast();


        }
    };
    View.OnClickListener tic8Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t8 == 0 && gameStatus && !winOrLoseStatus) {
                if (!computerTurn) {
                    startTic8();
                } else {
                    tempToast2();

                    if (turnNumber == 1) computerTurn = false;
                }
            } else tempToast();


        }
    };
    View.OnClickListener tic9Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (t9 == 0 && gameStatus && !winOrLoseStatus) {
                if (!computerTurn) {
                    startTic9();
                } else {
                    tempToast2();

                    if (turnNumber == 1) computerTurn = false;
                }
            } else tempToast();


        }
    };
    View.OnClickListener restartGameListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (!computerTurn) {
                restartTheWholeGame();
            } else {
                Toast.makeText(getContext(), "Wait 1 second...", Toast.LENGTH_SHORT).show();
                if (turnNumber == 1) computerTurn = false;

            }

        }
    };
    CompoundButton.OnCheckedChangeListener switchListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            playSounds = isChecked;
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
        computerTurn = !computerTurn;
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

        gameStatus = checkAllBoxes();
        winOrLoseStatus = rowCheck || columnCheck || diagonalCheck;

        showResults();
        if (gameStatus && !winOrLoseStatus) {

            changeTurn();
            i = 0;
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    computerTurn = true;
                    String txt = "";
                    for (int j = 0; j <= i; j++) txt += "■ ";
                    waitView.setText(txt);
                    if (i <=4) {
                        i++;
                        handler.postDelayed(this, 300);


                    }

                }
            }, 300);

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    computerTurn = true;
                    takeTurn();
                    waitView.setText("■ ■ ■");


                }
            }, 1850);


        }

    }

    final boolean checkUserWinStatus() {
        boolean rowCheck = ((t1 != 0 && t2 != 0 && t3 != 0) && (t1 == 1 && t1 == t2 && t2 == t3)) || ((t4 != 0 && t5 != 0 && t6 != 0) && (t4 == 1 && t4 == t5 && t4 == t6)) || ((t7 != 0 && t8 != 0 && t9 != 0) && (t7 == 1 && t7 == t8 && t7 == t9));
        boolean columnCheck = ((t1 != 0 && t4 != 0 && t7 != 0) && (t1 == 1 && t1 == t4 && t4 == t7)) || ((t2 != 0 && t5 != 0 && t8 != 0) && (t2 == 1 && t2 == t5 && t5 == t8)) || ((t3 != 0 && t6 != 0 && t9 != 0) && (t3 == 1 && t3 == t6 && t6 == t9));
        boolean diagonalCheck = ((t1 != 0 && t5 != 0 && t9 != 0) && (t1 == 1 && t1 == t5 && t5 == t9)) || ((t3 != 0 && t5 != 0 && t7 != 0) && (t3 == 1 && t3 == t5 && t5 == t7));

        return rowCheck || columnCheck || diagonalCheck;
    }

    final boolean checkComputerWinStatus() {
        boolean rowCheck = ((t1 != 0 && t2 != 0 && t3 != 0) && (t1 == 2 && t1 == t2 && t2 == t3)) || ((t4 != 0 && t5 != 0 && t6 != 0) && (t4 == 2 && t4 == t5 && t4 == t6)) || ((t7 != 0 && t8 != 0 && t9 != 0) && (t7 == 2 && t7 == t8 && t7 == t9));
        boolean columnCheck = ((t1 != 0 && t4 != 0 && t7 != 0) && (t1 == 2 && t1 == t4 && t4 == t7)) || ((t2 != 0 && t5 != 0 && t8 != 0) && (t2 == 2 && t2 == t5 && t5 == t8)) || ((t3 != 0 && t6 != 0 && t9 != 0) && (t3 == 2 && t3 == t6 && t6 == t9));
        boolean diagonalCheck = ((t1 != 0 && t5 != 0 && t9 != 0) && (t1 == 2 && t1 == t5 && t5 == t9)) || ((t3 != 0 && t5 != 0 && t7 != 0) && (t3 == 2 && t3 == t5 && t5 == t7));

        return rowCheck || columnCheck || diagonalCheck;
    }

    final void checkComputerStatus() {

        boolean rowCheck = ((t1 != 0 && t2 != 0 && t3 != 0) && (t1 == t2 && t2 == t3)) || ((t4 != 0 && t5 != 0 && t6 != 0) && (t4 == t5 && t4 == t6)) || ((t7 != 0 && t8 != 0 && t9 != 0) && (t7 == t8 && t7 == t9));
        boolean columnCheck = ((t1 != 0 && t4 != 0 && t7 != 0) && (t1 == t4 && t4 == t7)) || ((t2 != 0 && t5 != 0 && t8 != 0) && (t2 == t5 && t5 == t8)) || ((t3 != 0 && t6 != 0 && t9 != 0) && (t3 == t6 && t6 == t9));
        boolean diagonalCheck = ((t1 != 0 && t5 != 0 && t9 != 0) && (t1 == t5 && t5 == t9)) || ((t3 != 0 && t5 != 0 && t7 != 0) && (t3 == t5 && t5 == t7));

        gameStatus = checkAllBoxes();
        winOrLoseStatus = rowCheck || columnCheck || diagonalCheck;


        showResults();
        changeTurn();
        waitView.setText("■ ■ ■");


    }

    final boolean checkAllBoxes() {
        return !(t1 != 0 && t2 != 0 && t3 != 0 && t4 != 0 && t5 != 0 && t6 != 0 && t7 != 0 && t8 != 0 && t9 != 0);
    }

    final void showResults() {

        if (winOrLoseStatus) {
            // you won
            changeBackground();
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    if (playSounds) {
                        playSound();
                    }
                    showWinnerPoster(winOrLoseStatus, checkUserWinStatus(), checkComputerWinStatus());
                }
            }, 1500);

            gameStatus = true;
        } else {
            if (!checkAllBoxes()) {
                if (playSounds) {
                    playSound();
                }
                showWinnerPoster(winOrLoseStatus, checkUserWinStatus(), checkComputerWinStatus());
            }
        }
    }


    final void takeTurn() { // for the computer to take turn
        if (playSounds) {
            playButtonSound();
        }
        int[][] matrix = {{t1, t2, t3}, {t4, t5, t6}, {t7, t8, t9}};
        int[][] matrixCodes = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        ImageView[][] tempImageView = {{tic1View, tic2View, tic3View}, {tic4View, tic5View, tic6View}, {tic7View, tic8View, tic9View}};
        // checking rows....

        // initially computer side

        for (int i = 0; i < 3; i++) {
            //rows check
            boolean checkZeroStatus = (matrix[i][0] != 0 && matrix[i][1] != 0) || (matrix[i][1] != 0 && matrix[i][2] != 0) || (matrix[i][0] != 0 && matrix[i][2] != 0);
            if (checkZeroStatus) {
                boolean checkRow = matrix[i][0] == matrix[i][1] || matrix[i][1] == matrix[i][2] || matrix[i][0] == matrix[i][2];
                if (checkRow && (matrix[i][0] == 2 || matrix[i][1] == 2 || matrix[i][2] == 2)) {
                    for (int j = 0; j < 3; j++) {
                        if (matrix[i][j] == 0) {
                            tempImageView[i][j].setImageResource(R.drawable.player_2);
                            tempImageView[i][j].setVisibility(View.VISIBLE);

                            switch (matrixCodes[i][j]) {
                                case 1:
                                    t1 = 2;
                                    break;
                                case 2:
                                    t2 = 2;
                                    break;
                                case 3:
                                    t3 = 2;
                                    break;
                                case 4:
                                    t4 = 2;
                                    break;
                                case 5:
                                    t5 = 2;
                                    break;
                                case 6:
                                    t6 = 2;
                                    break;
                                case 7:
                                    t7 = 2;
                                    break;
                                case 8:
                                    t8 = 2;
                                    break;
                                case 9:
                                    t9 = 2;
                                    break;
                            }
                            checkComputerStatus();
                            return;
                        }
                    }
                }
            }
        }// row check

        for (int i = 0; i < 3; i++) { // column check

            boolean checkZeroStatus = (matrix[0][i] != 0 && matrix[1][i] != 0) || (matrix[1][i] != 0 && matrix[2][i] != 0) || (matrix[0][i] != 0 && matrix[2][i] != 0);

            if (checkZeroStatus) {

                boolean checkRow = matrix[0][i] == matrix[1][i] || matrix[1][i] == matrix[2][i] || matrix[0][i] == matrix[2][i];
                if (checkRow && (matrix[0][i] == 2 || matrix[1][i] == 2 || matrix[2][i] == 2)) {

                    for (int j = 0; j < 3; j++) {
                        if (matrix[j][i] == 0) {

                            tempImageView[j][i].setImageResource(R.drawable.player_2);
                            tempImageView[j][i].setVisibility(View.VISIBLE);
                            switch (matrixCodes[j][i]) {
                                case 1:
                                    t1 = 2;
                                    break;
                                case 2:
                                    t2 = 2;
                                    break;
                                case 3:
                                    t3 = 2;
                                    break;
                                case 4:
                                    t4 = 2;
                                    break;
                                case 5:
                                    t5 = 2;
                                    break;
                                case 6:
                                    t6 = 2;
                                    break;
                                case 7:
                                    t7 = 2;
                                    break;
                                case 8:
                                    t8 = 2;
                                    break;
                                case 9:
                                    t9 = 2;
                                    break;
                            }

                            checkComputerStatus();
                            return;
                        }
                    }
                }
            }
        }// column check


        boolean checkZeroStatus1 = (matrix[0][0] != 0 && matrix[1][1] != 0) || (matrix[1][1] != 0 && matrix[2][2] != 0) || (matrix[0][0] != 0 && matrix[2][2] != 0);
        boolean checkZeroStatus2 = (matrix[0][2] != 0 && matrix[1][1] != 0) || (matrix[1][1] != 0 && matrix[2][0] != 0) || (matrix[0][2] != 0 && matrix[2][0] != 0);

        if (checkZeroStatus1) {
            boolean checkDiagonal1 = matrix[0][0] == matrix[1][1] || matrix[1][1] == matrix[2][2] || matrix[0][0] == matrix[2][2];

            if (checkDiagonal1 && (matrix[0][0] == 2 || matrix[1][1] == 2 || matrix[2][2] == 2)) {

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == j && matrix[i][j] == 0) {

                            tempImageView[i][j].setImageResource(R.drawable.player_2);
                            tempImageView[i][j].setVisibility(View.VISIBLE);
                            switch (matrixCodes[i][j]) {
                                case 1:
                                    t1 = 2;
                                    break;
                                case 2:
                                    t2 = 2;
                                    break;
                                case 3:
                                    t3 = 2;
                                    break;
                                case 4:
                                    t4 = 2;
                                    break;
                                case 5:
                                    t5 = 2;
                                    break;
                                case 6:
                                    t6 = 2;
                                    break;
                                case 7:
                                    t7 = 2;
                                    break;
                                case 8:
                                    t8 = 2;
                                    break;
                                case 9:
                                    t9 = 2;
                                    break;
                            }

                            checkComputerStatus();
                            return;
                        }
                    }
                }
            }
        } // diagonal 1 check


        if (checkZeroStatus2) {
            boolean checkDiagonal2 = matrix[0][2] == matrix[1][1] || matrix[1][1] == matrix[2][0] || matrix[0][2] == matrix[2][0];

            if (checkDiagonal2 && (matrix[0][2] == 2 || matrix[1][1] == 2 || matrix[2][0] == 2)) {

                if (matrix[0][2] == 0) {
                    tempImageView[0][2].setImageResource(R.drawable.player_2);
                    tempImageView[0][2].setVisibility(View.VISIBLE);
                    switch (matrixCodes[0][2]) {
                        case 1:
                            t1 = 2;
                            break;
                        case 2:
                            t2 = 2;
                            break;
                        case 3:
                            t3 = 2;
                            break;
                        case 4:
                            t4 = 2;
                            break;
                        case 5:
                            t5 = 2;
                            break;
                        case 6:
                            t6 = 2;
                            break;
                        case 7:
                            t7 = 2;
                            break;
                        case 8:
                            t8 = 2;
                            break;
                        case 9:
                            t9 = 2;
                            break;
                    }
                    checkComputerStatus();
                    return;

                } else if (matrix[1][1] == 0) {
                    tempImageView[1][1].setImageResource(R.drawable.player_2);
                    tempImageView[1][1].setVisibility(View.VISIBLE);

                    switch (matrixCodes[1][1]) {
                        case 1:
                            t1 = 2;
                            break;
                        case 2:
                            t2 = 2;
                            break;
                        case 3:
                            t3 = 2;
                            break;
                        case 4:
                            t4 = 2;
                            break;
                        case 5:
                            t5 = 2;
                            break;
                        case 6:
                            t6 = 2;
                            break;
                        case 7:
                            t7 = 2;
                            break;
                        case 8:
                            t8 = 2;
                            break;
                        case 9:
                            t9 = 2;
                            break;
                    }
                    checkComputerStatus();
                    return;

                } else if (matrix[2][0] == 0) {
                    tempImageView[2][0].setImageResource(R.drawable.player_2);
                    tempImageView[2][0].setVisibility(View.VISIBLE);

                    switch (matrixCodes[2][0]) {
                        case 1:
                            t1 = 2;
                            break;
                        case 2:
                            t2 = 2;
                            break;
                        case 3:
                            t3 = 2;
                            break;
                        case 4:
                            t4 = 2;
                            break;
                        case 5:
                            t5 = 2;
                            break;
                        case 6:
                            t6 = 2;
                            break;
                        case 7:
                            t7 = 2;
                            break;
                        case 8:
                            t8 = 2;
                            break;
                        case 9:
                            t9 = 2;
                            break;
                    }
                    checkComputerStatus();
                    return;

                }


            }
        } // diagonal 2 check


        // this is for user check


        for (int i = 0; i < 3; i++) {
            //rows check
            boolean checkZeroStatus = (matrix[i][0] != 0 && matrix[i][1] != 0) || (matrix[i][1] != 0 && matrix[i][2] != 0) || (matrix[i][0] != 0 && matrix[i][2] != 0);
            if (checkZeroStatus) {

                boolean checkRow = matrix[i][0] == matrix[i][1] || matrix[i][1] == matrix[i][2] || matrix[i][0] == matrix[i][2];
                if (checkRow) {
                    for (int j = 0; j < 3; j++) {
                        if (matrix[i][j] == 0) {

                            tempImageView[i][j].setImageResource(R.drawable.player_2);
                            tempImageView[i][j].setVisibility(View.VISIBLE);

                            switch (matrixCodes[i][j]) {
                                case 1:
                                    t1 = 2;
                                    break;
                                case 2:
                                    t2 = 2;
                                    break;
                                case 3:
                                    t3 = 2;
                                    break;
                                case 4:
                                    t4 = 2;
                                    break;
                                case 5:
                                    t5 = 2;
                                    break;
                                case 6:
                                    t6 = 2;
                                    break;
                                case 7:
                                    t7 = 2;
                                    break;
                                case 8:
                                    t8 = 2;
                                    break;
                                case 9:
                                    t9 = 2;
                                    break;
                            }
                            checkComputerStatus();
                            return;
                        }
                    }
                }
            }
        }// row check


        for (int i = 0; i < 3; i++) { // column check

            boolean checkZeroStatus = (matrix[0][i] != 0 && matrix[1][i] != 0) || (matrix[1][i] != 0 && matrix[2][i] != 0) || (matrix[0][i] != 0 && matrix[2][i] != 0);

            if (checkZeroStatus) {

                boolean checkRow = matrix[0][i] == matrix[1][i] || matrix[1][i] == matrix[2][i] || matrix[0][i] == matrix[2][i];
                if (checkRow) {


                    for (int j = 0; j < 3; j++) {
                        if (matrix[j][i] == 0) {


                            tempImageView[j][i].setImageResource(R.drawable.player_2);
                            tempImageView[j][i].setVisibility(View.VISIBLE);
                            switch (matrixCodes[j][i]) {
                                case 1:
                                    t1 = 2;
                                    break;
                                case 2:
                                    t2 = 2;
                                    break;
                                case 3:
                                    t3 = 2;
                                    break;
                                case 4:
                                    t4 = 2;
                                    break;
                                case 5:
                                    t5 = 2;
                                    break;
                                case 6:
                                    t6 = 2;
                                    break;
                                case 7:
                                    t7 = 2;
                                    break;
                                case 8:
                                    t8 = 2;
                                    break;
                                case 9:
                                    t9 = 2;
                                    break;
                            }

                            checkComputerStatus();
                            return;
                        }
                    }
                }
            }
        }// column check


        if (checkZeroStatus1) {
            boolean checkDiagonal1 = matrix[0][0] == matrix[1][1] || matrix[1][1] == matrix[2][2] || matrix[0][0] == matrix[2][2];

            if (checkDiagonal1) {


                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == j && matrix[i][j] == 0) {

                            tempImageView[i][j].setImageResource(R.drawable.player_2);
                            tempImageView[i][j].setVisibility(View.VISIBLE);
                            switch (matrixCodes[i][j]) {
                                case 1:
                                    t1 = 2;
                                    break;
                                case 2:
                                    t2 = 2;
                                    break;
                                case 3:
                                    t3 = 2;
                                    break;
                                case 4:
                                    t4 = 2;
                                    break;
                                case 5:
                                    t5 = 2;
                                    break;
                                case 6:
                                    t6 = 2;
                                    break;
                                case 7:
                                    t7 = 2;
                                    break;
                                case 8:
                                    t8 = 2;
                                    break;
                                case 9:
                                    t9 = 2;
                                    break;
                            }

                            checkComputerStatus();
                            return;
                        }
                    }
                }
            }
        } // checking diagonals


        if (checkZeroStatus2) {
            boolean checkDiagonal2 = matrix[0][2] == matrix[1][1] || matrix[1][1] == matrix[2][0] || matrix[0][2] == matrix[2][0];

            if (checkDiagonal2) {

                if (matrix[0][2] == 0) {


                    tempImageView[0][2].setImageResource(R.drawable.player_2);
                    tempImageView[0][2].setVisibility(View.VISIBLE);
                    switch (matrixCodes[0][2]) {
                        case 1:
                            t1 = 2;
                            break;
                        case 2:
                            t2 = 2;
                            break;
                        case 3:
                            t3 = 2;
                            break;
                        case 4:
                            t4 = 2;
                            break;
                        case 5:
                            t5 = 2;
                            break;
                        case 6:
                            t6 = 2;
                            break;
                        case 7:
                            t7 = 2;
                            break;
                        case 8:
                            t8 = 2;
                            break;
                        case 9:
                            t9 = 2;
                            break;
                    }
                    checkComputerStatus();
                    return;

                } else if (matrix[1][1] == 0) {
                    tempImageView[1][1].setImageResource(R.drawable.player_2);
                    tempImageView[1][1].setVisibility(View.VISIBLE);
                    switch (matrixCodes[1][1]) {
                        case 1:
                            t1 = 2;
                            break;
                        case 2:
                            t2 = 2;
                            break;
                        case 3:
                            t3 = 2;
                            break;
                        case 4:
                            t4 = 2;
                            break;
                        case 5:
                            t5 = 2;
                            break;
                        case 6:
                            t6 = 2;
                            break;
                        case 7:
                            t7 = 2;
                            break;
                        case 8:
                            t8 = 2;
                            break;
                        case 9:
                            t9 = 2;
                            break;
                    }
                    checkComputerStatus();
                    return;

                } else if (matrix[2][0] == 0) {
                    tempImageView[2][0].setImageResource(R.drawable.player_2);
                    tempImageView[2][0].setVisibility(View.VISIBLE);
                    switch (matrixCodes[2][0]) {
                        case 1:
                            t1 = 2;
                            break;
                        case 2:
                            t2 = 2;
                            break;
                        case 3:
                            t3 = 2;
                            break;
                        case 4:
                            t4 = 2;
                            break;
                        case 5:
                            t5 = 2;
                            break;
                        case 6:
                            t6 = 2;
                            break;
                        case 7:
                            t7 = 2;
                            break;
                        case 8:
                            t8 = 2;
                            break;
                        case 9:
                            t9 = 2;
                            break;
                    }
                    checkComputerStatus();
                    return;

                }


            }
        } // checking diagonal 2


        int row, column;

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            row = random.nextInt(3);
            column = random.nextInt(3);


            if (matrix[row][column] == 0) {
                tempImageView[row][column].setImageResource(R.drawable.player_2);
                tempImageView[row][column].setVisibility(View.VISIBLE);
                switch (matrixCodes[row][column]) {
                    case 1:
                        t1 = 2;
                        break;
                    case 2:
                        t2 = 2;
                        break;
                    case 3:
                        t3 = 2;
                        break;
                    case 4:
                        t4 = 2;
                        break;
                    case 5:
                        t5 = 2;
                        break;
                    case 6:
                        t6 = 2;
                        break;
                    case 7:
                        t7 = 2;
                        break;
                    case 8:
                        t8 = 2;
                        break;
                    case 9:
                        t9 = 2;
                        break;
                }

                checkComputerStatus();
                return;
            }

        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matrix[i][j] == 0) {
                    tempImageView[i][j].setImageResource(R.drawable.player_2);
                    tempImageView[i][j].setVisibility(View.VISIBLE);


                    switch (matrixCodes[i][j]) {
                        case 1:
                            t1 = 2;
                            break;
                        case 2:
                            t2 = 2;
                            break;
                        case 3:
                            t3 = 2;
                            break;
                        case 4:
                            t4 = 2;
                            break;
                        case 5:
                            t5 = 2;
                            break;
                        case 6:
                            t6 = 2;
                            break;
                        case 7:
                            t7 = 2;
                            break;
                        case 8:
                            t8 = 2;
                            break;
                        case 9:
                            t9 = 2;
                            break;
                    }

                    checkComputerStatus();
                    return;
                }
            }
        }


    } // working condition


    final void restartTheWholeGame() {
        playButtonSound2();
        t1 = t2 = t3 = t4 = t5 = t6 = t7 = t8 = t9 = 0;
        gameStatus = true;
        winOrLoseStatus = false;

        setTheVisibility();
        setBackground();

    }

    final void tempToast() {
        Toast.makeText(getContext(), "Already filled", Toast.LENGTH_SHORT).show();
    }

    final void tempToast2() {
        Toast.makeText(getContext(), "It's not your turn... click again", Toast.LENGTH_LONG).show();
    }


    @SuppressLint("SetTextI18n")
    final void showWinnerPoster(boolean winStatus, boolean userWinStatus, boolean computerWinStatus) {
        trophyView.setVisibility(View.VISIBLE);
        resultText.setVisibility(View.VISIBLE);
        namePlate.setVisibility(View.VISIBLE);
        gameBoard.setVisibility(View.INVISIBLE);
        restartGame.setVisibility(View.GONE);
        turnLayout.setVisibility(View.GONE);
        waitView.setVisibility(View.GONE);

        if (winStatus) {
            if (userWinStatus) {
                trophyView.setImageResource(R.drawable.winner);
                resultText.setText("Congratulations...!");
                namePlate.setText("Circle player won...");
                wonDialog.setVisibility(View.VISIBLE);
                return;

            }
            if (computerWinStatus) {

                trophyView.setImageResource(R.drawable.lost_game);
                resultText.setText("You Lost...!");
                namePlate.setText("Cross player won...");
                wonDialog.setVisibility(View.VISIBLE);

            }

        } else {
            trophyView.setImageResource(R.drawable.handshake);
            resultText.setText("Draw..!");
            namePlate.setVisibility(View.GONE);
            wonDialog.setVisibility(View.VISIBLE);
        }


    }

    final void playSound() {

        if (player != null) player.stop();

        if (winOrLoseStatus) {
            if (!checkComputerWinStatus()) {
                player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.game_won);

            } else {
                player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.lost_match);
            }
        } else {
            player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.draw_match);

        }

//        if (computerWinStatus) {
//            player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.lost_match);
//        } else if (winOrLoseStatus) {
//            player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.game_won);
//
//        } else {
//            player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.draw_match);
//
//        }
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

    final void playButtonSound2() {
        stopSound();

        player = MediaPlayer.create(requireContext().getApplicationContext(), R.raw.click2);
        player.start();
    }


}