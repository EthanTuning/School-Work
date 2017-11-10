using System;
using System.Windows;

namespace Craps {
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window {

        int mDieOneRoll;
        int mDieTwoRoll;
        int mDieTotal;
        int mPoint;
        int mHouseWins;
        int mPlayerWins;
        int mBankTotal;
        bool mIsPointRoll;
        bool mCheckForSeven;

        public MainWindow() {

            InitializeComponent();
            Closing += onClosing;
        }

        private void startBtn_Click(object sender, RoutedEventArgs e) {

            resetBtn.IsEnabled = true;

            rollDiceBtn.IsEnabled = true;
            mHouseWins = 0;
            mPlayerWins = 0;
            mBankTotal = 3000;
            bankText.Text = mBankTotal.ToString();

        }

        private void resetBtn_Click(object sender, RoutedEventArgs e) {

            resetBtn.IsEnabled = false;
            rollDiceBtn.IsEnabled = false;
            playAgainBtn.IsEnabled = false;

            playAgainBtn_Click(sender, e);
            mHouseWins = 0;
            mPlayerWins = 0;
            houseWinsText.Text = null;
            playerWinsText.Text = null;
            mBankTotal = 0;
            bankText.Text = null;

        }

        private void exitBtn_Click(object sender, RoutedEventArgs e) {

            MessageBoxResult result = MessageBox.Show("Do you really want to quit?", "Warning", MessageBoxButton.YesNo, MessageBoxImage.Question);

            if (result == MessageBoxResult.Yes) {
                Application.Current.Shutdown();
            }

        }

        private void onClosing(object sender, System.ComponentModel.CancelEventArgs e) {

            MessageBoxResult result = MessageBox.Show("Do you really want to quit?", "Warning", MessageBoxButton.YesNo, MessageBoxImage.Question);

            if (result == MessageBoxResult.No) {
                e.Cancel = true;
            }

        }

        private void aboutBtn_Click(object sender, RoutedEventArgs e) {

            MessageBox.Show("Written by Ethan Tuning CSCD371, Fall 2017.",
                            "About",
                            MessageBoxButton.OK);

        }

        private void rulesBtn_Click(object sender, RoutedEventArgs e) {

            MessageBox.Show("To start a game click 'start' in the 'game' menu.\n" +
                            "Then you must roll the dice. Good Luck!",
                            "Rules",
                            MessageBoxButton.OK);

        }

        private void rollDiceBtn_Click(object sender, RoutedEventArgs e) {

            playAgainBtn.IsEnabled = true;

            winnerText.Content = null;
            Random random = new Random();
            mDieOneRoll = rollDie(random);
            mDieTwoRoll = rollDie(random);
            dieOneText.Text = mDieOneRoll.ToString();
            dieTwoText.Text = mDieTwoRoll.ToString();
            mDieTotal = mDieOneRoll + mDieTwoRoll;
            dieTotalText.Text = mDieTotal.ToString();
            checkWinLoseOrPoint();

        }

        private void playAgainBtn_Click(object sender, RoutedEventArgs e) {

            mDieOneRoll = 0;
            mDieTwoRoll = 0;
            mDieTotal = 0;
            dieOneText.Text = null;
            dieTwoText.Text = null;
            dieTotalText.Text = null;
            winnerText.Content = null;
            pointText.Text = null;
            playAgainBtn.IsEnabled = false;

        }

        private int rollDie(Random random) {

            int result = random.Next(1, 7);
            return result;

        }

        private void checkWinLoseOrPoint() {

            if ((mDieTotal == 7 || mDieTotal == 11) && !mIsPointRoll) {

                playerWins();
                pointText.Text = null;

            }


            if ((mDieTotal == 2 || mDieTotal == 3 || mDieTotal == 12) && !mIsPointRoll) {

                houseWins();
                pointText.Text = null;
            }

            if ((mDieTotal == 4 || mDieTotal == 5 || mDieTotal == 6 || mDieTotal == 8 || 
                 mDieTotal == 9 || mDieTotal == 10) && !mIsPointRoll) {

                mPoint = mDieTotal;
                pointText.Text = mPoint.ToString();
                mIsPointRoll = true;

            }

            else if ((mDieTotal == mPoint) && mIsPointRoll)
                mCheckForSeven = true;

            else if((mDieTotal != mPoint) && mIsPointRoll)
                houseWins();

            else if ((mDieTotal == 7) && mCheckForSeven)
                playerWins();

            else if((mDieTotal != 7) && mCheckForSeven)
                houseWins();
        }

        private void playerWins() {

            winnerText.Content = "PLAYER WINS! :)";
            mBankTotal *= 2;
            bankText.Text = mBankTotal.ToString();
            mIsPointRoll = false;
            mCheckForSeven = false;
            mPlayerWins++;
            playerWinsText.Text = mPlayerWins.ToString();

        }

        private void houseWins() {

            winnerText.Content = "HOUSE WINS... :(";
            mBankTotal /= 2;
            bankText.Text = mBankTotal.ToString();
            mIsPointRoll = false;
            mCheckForSeven = false;
            mHouseWins++;
            houseWinsText.Text = mHouseWins.ToString();

            if(mBankTotal <= 0) {

                MessageBox.Show("You lost all of your money! Game reset!",
                "The house always wins :)",
                MessageBoxButton.OK);
                resetBtn_Click(null, null);
            }
        }
    }
}