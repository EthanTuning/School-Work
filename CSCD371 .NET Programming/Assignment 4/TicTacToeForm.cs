using System;
using System.Drawing;
using System.Windows.Forms;

namespace TicTacToe {
    public partial class TicTacToeForm : Form {

        Graphics graphicsContext;
        private bool isPlayer1Turn = false;
        private bool isPlayer2Turn = false;
        private bool isPlayer2TheComputer = false;
        private bool[] player1Move = new bool[9] { true, true, true, true, true, true, true, true, true };
        private bool[] hasBeenDrawnIn = new bool[9] { false, false, false,
                                                      false, false, false,
                                                      false, false, false };

        public TicTacToeForm() {

            InitializeComponent();

            this.CenterToScreen();
            this.FormBorderStyle = FormBorderStyle.FixedSingle; //make form not resizable
            this.endBtn.Enabled = false;
            this.endToolStripMenuItem.Enabled = false;
            this.coinTossBtn.Enabled = false;
            this.coinTossToolStripMenuItem.Enabled = false;
            this.startBtn.Enabled = false;
            this.startToolStripMenuItem.Enabled = false;

            canvas.Hide();
        }

        private void OnPaint(Object sender, PaintEventArgs e) {

            drawGameBoard(sender, e);

        }

        private void coinToss() {

            string message;
            string caption = "Game has started!";

            this.coinTossBtn.Enabled = false;
            this.coinTossToolStripMenuItem.Enabled = false;

            Random coinToss = new Random();
            int result = coinToss.Next(1, 3);

            if(result == 1) {

                isPlayer1Turn = true;
                isPlayer2Turn = false;

                message = "Player 1 goes first!";
                var alert = MessageBox.Show(message, caption, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
            if(result == 2) {

                isPlayer2Turn = true;
                isPlayer1Turn = false;

                message = "Player 2 goes first!";
                var alert = MessageBox.Show(message, caption, MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            }
        }

        private void gameOver(Object sender, EventArgs e) {

            if (player1Move[0] == player1Move[3] &&
                     player1Move[0] == player1Move[6] &&
                     hasBeenDrawnIn[0] &&
                     hasBeenDrawnIn[3] &&
                     hasBeenDrawnIn[6]) {

                if (player1Move[0])
                    overAlert(sender, e, "Player One Wins!");

                else if (isPlayer2TheComputer)
                    overAlert(sender, e, "Computer Wins!");

                else
                    overAlert(sender, e, "Player Two Wins!");

            }

            else if (player1Move[1] == player1Move[4] &&
                     player1Move[1] == player1Move[7] &&
                     hasBeenDrawnIn[1] &&
                     hasBeenDrawnIn[4] &&
                     hasBeenDrawnIn[7]) {

                if (player1Move[1])
                    overAlert(sender, e, "Player One Wins!");

                else if (isPlayer2TheComputer)
                    overAlert(sender, e, "Computer Wins!");

                else
                    overAlert(sender, e, "Player Two Wins!");

            }

            else if (player1Move[2] == player1Move[5] &&
                     player1Move[2] == player1Move[8] &&
                     hasBeenDrawnIn[2] &&
                     hasBeenDrawnIn[5] &&
                     hasBeenDrawnIn[8]) {

                if (player1Move[2])
                    overAlert(sender, e, "Player One Wins!");

                else if (isPlayer2TheComputer)
                    overAlert(sender, e, "Computer Wins!");

                else
                    overAlert(sender, e, "Player Two Wins!");
            }

            else if (player1Move[0] == player1Move[1] && 
                     player1Move[0] == player1Move[2] && 
                     hasBeenDrawnIn[0] && hasBeenDrawnIn[1] && 
                     hasBeenDrawnIn[2]) {

                if (player1Move[0])
                    overAlert(sender, e, "Player One Wins!");

                else if (isPlayer2TheComputer)
                    overAlert(sender, e, "Computer Wins!");

                else
                    overAlert(sender, e, "Player Two Wins!");

            }

            else if (player1Move[3] == player1Move[4] && 
                     player1Move[3] == player1Move[5] && 
                     hasBeenDrawnIn[3] && 
                     hasBeenDrawnIn[4] && 
                     hasBeenDrawnIn[5]) {

                if (player1Move[3])
                    overAlert(sender, e, "Player One Wins!");

                else if (isPlayer2TheComputer)
                    overAlert(sender, e, "Computer Wins!");

                else
                    overAlert(sender, e, "Player Two Wins!");
            }

            else if (player1Move[6] == player1Move[7] && 
                     player1Move[6] == player1Move[8] && 
                     hasBeenDrawnIn[6] && 
                     hasBeenDrawnIn[7] && 
                     hasBeenDrawnIn[8]) {

                if (player1Move[6])
                    overAlert(sender, e, "Player One Wins!");

                else if (isPlayer2TheComputer)
                    overAlert(sender, e, "Computer Wins!");

                else
                    overAlert(sender, e, "Player Two Wins!");

            }

            else if (player1Move[0] == player1Move[4] && 
                     player1Move[0] == player1Move[8] && 
                     hasBeenDrawnIn[0] && 
                     hasBeenDrawnIn[4] && 
                     hasBeenDrawnIn[8]) {

                if (player1Move[0])
                    overAlert(sender, e, "Player One Wins!");

                else if (isPlayer2TheComputer)
                    overAlert(sender, e, "Computer Wins!");

                else
                    overAlert(sender, e, "Player Two Wins!");

            }

            else if (player1Move[2] == player1Move[4] && 
                     player1Move[2] == player1Move[6] && 
                     hasBeenDrawnIn[2] && 
                     hasBeenDrawnIn[4] && 
                     hasBeenDrawnIn[6]) {

                if (player1Move[2])
                    overAlert(sender, e, "Player One Wins!");

                else if (isPlayer2TheComputer)
                    overAlert(sender, e, "Computer Wins!");

                else
                    overAlert(sender, e, "Player Two Wins!");
            }
        }

        private void overAlert(Object sender, EventArgs e, string message) {

            var alert = MessageBox.Show(message, "Game Over!", MessageBoxButtons.OK, MessageBoxIcon.Exclamation);
            endBtn_Click(sender, e);

        }

        private void onClickBoard(Object sender, EventArgs e) {

            int[,] squareLocations = new int[9, 2] { {0, 0},   {176, 0 },  {353, 0},
                                                     {0, 176}, {176, 176}, {353, 176},
                                                     {0, 353}, {176, 353}, {353, 353} };


            int location = 0;
            int squareDims = 176;

            int x = this.PointToClient(Cursor.Position).X;
            int y = this.PointToClient(Cursor.Position).Y;

            while(location < 9) {

                gameOver(sender, e);

                if(x >= squareLocations[location, 0] && x <= (squareLocations[location, 0] + squareDims) 
                                                     && y >= squareLocations[location, 1] 
                                                     && y <= (squareLocations[location, 1]) + squareDims) {

                    if ((isPlayer1Turn) && (!hasBeenDrawnIn[location])) {

                        hasBeenDrawnIn[location] = true;
                        player1Move[location] = true;
                        this.statusLabel.Text = "Player 2's turn.";
                        drawX(location);
                        isPlayer2Turn = true;
                        isPlayer1Turn = false;

                    }
                    else if ((isPlayer2Turn) && (isPlayer2TheComputer) && (!hasBeenDrawnIn[location])) {


                        Random coinToss = new Random();
                        int result = 0;

                        while (hasBeenDrawnIn[result]) {

                            result = coinToss.Next(1, 9);

                        }

                        hasBeenDrawnIn[result] = true;
                        player1Move[result] = false;
                        this.statusLabel.Text = "Player 1's turn.";
                        drawO(result);
                        isPlayer1Turn = true;
                        isPlayer2Turn = false;

                    }
                    else if ((isPlayer2Turn) && (!isPlayer2TheComputer) && (!hasBeenDrawnIn[location])) {

                        hasBeenDrawnIn[location] = true;
                        player1Move[location] = false;
                        this.statusLabel.Text = "Player 1's turn.";
                        drawO(location);
                        isPlayer1Turn = true;
                        isPlayer2Turn = false;

                    }
                    else {

                        var alert = MessageBox.Show("You cannot go here!", "ERROR", MessageBoxButtons.OK, MessageBoxIcon.Error);

                    }
                    
                }
                
                location++;
                
            }
            gameOver(sender, e);
        }

        private void drawX(int boardPosition) {

            Pen pen = new Pen(Color.Red, 5);

            if (boardPosition == 0) {

                graphicsContext.DrawLine(pen, 0, 0, 176, 176);
                graphicsContext.DrawLine(pen, 176, 0, 0, 176);
            }

            if (boardPosition == 1) {

                graphicsContext.DrawLine(pen, 176, 0, 353, 176);
                graphicsContext.DrawLine(pen, 353, 0, 176, 176);
            }

            if (boardPosition == 2) {

                graphicsContext.DrawLine(pen, 353, 176, 530, 0);
                graphicsContext.DrawLine(pen, 530, 176, 353, 0);
            }

            if (boardPosition == 3) {

                graphicsContext.DrawLine(pen, 0, 176, 176, 353);
                graphicsContext.DrawLine(pen, 0, 353, 176, 176);
            }

            if (boardPosition == 4) {

                graphicsContext.DrawLine(pen, 176, 176, 353, 353);
                graphicsContext.DrawLine(pen, 176, 353, 353, 176);
            }

            if (boardPosition == 5) {

                graphicsContext.DrawLine(pen, 353, 176, 530, 353);
                graphicsContext.DrawLine(pen, 353, 353, 530, 176);
            }

            if (boardPosition == 6) {

                graphicsContext.DrawLine(pen, 0, 530, 176, 353);
                graphicsContext.DrawLine(pen, 176, 530, 0, 353);
            }

            if (boardPosition == 7) {

                graphicsContext.DrawLine(pen, 176, 530, 353, 353);
                graphicsContext.DrawLine(pen, 353, 530, 176, 353);
            }
            if (boardPosition == 8) {

                graphicsContext.DrawLine(pen, 353, 353, 530, 530);
                graphicsContext.DrawLine(pen, 353, 530, 530, 353);
            }
        }

        private void drawO(int boardPosition) {

            Pen pen = new Pen(Color.Blue, 5);

            if (boardPosition == 0)
                graphicsContext.DrawEllipse(pen, 0, 0, 176, 176);

            if (boardPosition == 1)
                graphicsContext.DrawEllipse(pen, 176, 0, 176, 176);

            if (boardPosition == 2)
                graphicsContext.DrawEllipse(pen, 353, 0, 176, 176);

            if (boardPosition == 3)
                graphicsContext.DrawEllipse(pen, 0, 176, 176, 176);

            if (boardPosition == 4)
                graphicsContext.DrawEllipse(pen, 176, 176, 176, 176);

            if (boardPosition == 5)
                graphicsContext.DrawEllipse(pen, 353, 176, 176, 176);

            if (boardPosition == 6)
                graphicsContext.DrawEllipse(pen, 0, 353, 176, 176);

            if (boardPosition == 7)
                graphicsContext.DrawEllipse(pen, 176, 353, 176, 176);

            if (boardPosition == 8)
                graphicsContext.DrawEllipse(pen, 353, 353, 176, 176);
        }

        private void drawGameBoard(Object sender, PaintEventArgs e) {

            graphicsContext = canvas.CreateGraphics();

            Pen pen = new Pen(Color.Black, 5);

            e.Graphics.DrawLine(pen, 176, 0,  176,  530);
            e.Graphics.DrawLine(pen, 353,  0,  353, 530);
            e.Graphics.DrawLine(pen, 0, 176, 530, 176);
            e.Graphics.DrawLine(pen, 0, 353, 530, 353);

        }
        
        /*
         * Form event handlers
         */

        private void endBtn_Click(object sender, EventArgs e) {

            canvas.Hide();
            this.startBtn.Enabled = true;
            this.startToolStripMenuItem.Enabled = true;
            this.coinTossBtn.Enabled = false;
            this.coinTossToolStripMenuItem.Enabled = false;
            this.endBtn.Enabled = false;
            this.endToolStripMenuItem.Enabled = false;
            this.player1ToolStripMenuItem.Enabled = true;
            this.player2ToolStripMenuItem1.Enabled = true;
            this.statusLabel.Text = "Game ended, start a new game!";
            this.helper.Text = "Press Start and then toss the coin!";

            hasBeenDrawnIn = new bool[9] { false, false, false,
                                           false, false, false,
                                           false, false, false };
        }

        private void startBtn_Click(object sender, EventArgs e) {

            
            this.endBtn.Enabled = true;
            this.endToolStripMenuItem.Enabled = true;
            this.coinTossBtn.Enabled = true;
            this.coinTossToolStripMenuItem.Enabled = true;
            this.statusLabel.Text = "Game started!";
            this.player1ToolStripMenuItem.Enabled = false;
            this.player2ToolStripMenuItem1.Enabled = false;
        }

        private void coinTossBtn_Click(object sender, EventArgs e) {

            canvas.Show();
            coinToss();
            this.startBtn.Enabled = false;
            this.startToolStripMenuItem.Enabled = false;
            this.statusLabel.Text = "Coin has been tossed!";
            this.helper.Hide();
            this.coinTossBtn.Enabled = false;
            this.coinTossToolStripMenuItem.Enabled = false;
        }

        private void player1ToolStripMenuItem_Click(object sender, EventArgs e) {

            this.startBtn.Enabled = true;
            this.startToolStripMenuItem.Enabled = true;
            this.player1ToolStripMenuItem.Enabled = false;
            this.player2ToolStripMenuItem1.Enabled = false;
            this.statusLabel.Text = "1 Player Mode.";
            this.helper.Text = "Press Start and then toss the coin!";
            isPlayer2TheComputer = true;
        }

        private void player2ToolStripMenuItem1_Click(object sender, EventArgs e) {

            this.startBtn.Enabled = true;
            this.startToolStripMenuItem.Enabled = true;
            this.player1ToolStripMenuItem.Enabled = false;
            this.player2ToolStripMenuItem1.Enabled = false;
            this.statusLabel.Text = "2 Player Mode.";
            this.helper.Text = "Press Start and then toss the coin!";
            isPlayer2TheComputer = false;
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e) {

            var alert = MessageBox.Show("Developed by Ethan Tuning for CSCD371", "About", MessageBoxButtons.OK, MessageBoxIcon.Information);

        }

        private void ruleToolStripMenuItem_Click(object sender, EventArgs e) {

            var alert = MessageBox.Show("To start the game you must choose either 1 or 2 players.\nThen you must start the game and toss the coin\n" +
                                        "Finally, you must than see who's turn it is, then play the game.\n(Note: with 1 player you must click for" +
                                        "the computer even though the computer picks where to actually move)", 
                                        "Game Over!", 
                                        MessageBoxButtons.OK, 
                                        MessageBoxIcon.Information);

        }

        private void startToolStripMenuItem_Click(object sender, EventArgs e) {

            startBtn_Click(sender, e);

        }

        private void endToolStripMenuItem_Click(object sender, EventArgs e) {

            endBtn_Click(sender, e);

        }

        private void exitToolStripMenuItem_Click(object sender, EventArgs e) {

            Application.Exit();

        }

        private void coinTossToolStripMenuItem_Click(object sender, EventArgs e) {

            coinTossBtn_Click(sender, e);

        }
    }
}
