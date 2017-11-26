using System;
using System.Windows;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Threading;

namespace Pong {
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window {

        DispatcherTimer animationTimer = new DispatcherTimer();
        int spaceCtr = 1;
        bool mIsTwoPlayer;

        public MainWindow() {

            InitializeComponent();

            RightPaddle.Visibility = Visibility.Hidden;
            LeftPaddle.Visibility = Visibility.Hidden;
            GameBall.Visibility = Visibility.Hidden;

            ResetMenuBtn.IsEnabled = false;
            DifficultyMenuBtn.IsEnabled = false;
        }

        private void Start() {

            RightPaddle.Visibility = Visibility.Visible;
            LeftPaddle.Visibility = Visibility.Visible;
            GameBall.Visibility = Visibility.Visible;

            this.DataContext = new ApplicationController();
            animationTimer.Interval = TimeSpan.FromMilliseconds(7);
            animationTimer.Tick += Advance;


        }

        private void Advance(object sender, EventArgs e) {

            ApplicationController controller = (ApplicationController)this.DataContext;
            controller.Advance();

            if (!mIsTwoPlayer) {

                controller.LeftPaddle.Position = (int)controller.Ball.Y - 10;

            }

        }

        private void Window_KeyDown(object sender, KeyEventArgs e) {

            ApplicationController controller = (ApplicationController) this.DataContext;

            if (Keyboard.IsKeyDown(Key.W) && mIsTwoPlayer)
                controller.LeftPaddleUp();

            if (Keyboard.IsKeyDown(Key.S) && mIsTwoPlayer)
                controller.LeftPaddleDown();

            if (Keyboard.IsKeyDown(Key.Up))
                controller.RightPaddleUp();

            if (Keyboard.IsKeyDown(Key.Down))
                controller.RightPaddleDown();

            if (Keyboard.IsKeyDown(Key.Space) && spaceCtr == 0) {

                animationTimer.Stop();
                spaceCtr = 1;
            }

            else if (Keyboard.IsKeyDown(Key.Space) && spaceCtr == 1) {

                animationTimer.Start();
                spaceCtr = 0;
            }
        }

        private void AboutMenuBtn_Click(object sender, RoutedEventArgs e) {

            MessageBox.Show("Written by Ethan Tuning",
                            "About",
                            MessageBoxButton.OK);

        }

        private void RulesMenuBtn_Click(object sender, RoutedEventArgs e) {

            MessageBox.Show("To start a game click 'New' in the 'Game' menu and choose either one or two player mode.\n\n" +
                            "Player 1 uses 'W' and 'S' to go up and down, Player 2 uses the 'UP' arrow and the 'DOWN' arrow.\n\n" +
                            "Spacebar pauses and un-pauses the game.\n\n" +
                            "You can also change the colors by going to the 'Theme' menu under 'Options' or change the difficulty under 'Difficulty'.",
                            "Rules",
                            MessageBoxButton.OK);

        }

        private void ResetMenuBtn_Click(object sender, RoutedEventArgs e) {

            RightPaddle.Visibility = Visibility.Hidden;
            LeftPaddle.Visibility = Visibility.Hidden;
            GameBall.Visibility = Visibility.Hidden;

            animationTimer.Stop();
            animationTimer.Tick -= Advance;

            ResetMenuBtn.IsEnabled = false;
            DifficultyMenuBtn.IsEnabled = false;
            NewMenuBtn.IsEnabled = true;

        }

        private void FileMenuQuitBtn_Click(object sender, RoutedEventArgs e) {

            Application.Current.Shutdown();

        }

        private void _1PlayerMenuBtn_Click(object sender, RoutedEventArgs e) {

            ResetMenuBtn.IsEnabled = true;
            DifficultyMenuBtn.IsEnabled = true;
            NewMenuBtn.IsEnabled = false;

            mIsTwoPlayer = false;
            Start();

        }

        private void _2PlayerMenuBtn_Click(object sender, RoutedEventArgs e) {

            ResetMenuBtn.IsEnabled = true;
            DifficultyMenuBtn.IsEnabled = true;
            NewMenuBtn.IsEnabled = false;

            mIsTwoPlayer = true;
            Start();

        }

        private void EasyMenuBtn_Click(object sender, RoutedEventArgs e) {

            ApplicationController controller = (ApplicationController)this.DataContext;
            controller.setSpeed(2);

        }

        private void MediumMenuBtn_Click(object sender, RoutedEventArgs e) {

            ApplicationController controller = (ApplicationController)this.DataContext;
            controller.setSpeed(5);

        }

        private void HardMenuBtn_Click(object sender, RoutedEventArgs e) {

            ApplicationController controller = (ApplicationController)this.DataContext;
            controller.setSpeed(9);

        }

        private void DefaultThemeBtn_Click(object sender, RoutedEventArgs e) {

            var bc = new BrushConverter();

            Scene.Background = Brushes.White;
            GameBoard.Background = (Brush)bc.ConvertFrom("#FFAEAEAE");
            LeftPaddle.Fill = Brushes.White;
            LeftPaddle.Stroke = Brushes.White;
            RightPaddle.Fill = Brushes.White;
            RightPaddle.Stroke = Brushes.White;
            GameBall.Fill = Brushes.White;
            GameBall.Stroke = Brushes.White;

        }

        private void InvertedThemeBtn_Click(object sender, RoutedEventArgs e) {

            var bc = new BrushConverter();

            Scene.Background = (Brush)bc.ConvertFrom("#FFAEAEAE");
            GameBoard.Background = Brushes.White;
            LeftPaddle.Fill = (Brush)bc.ConvertFrom("#FFAEAEAE");
            LeftPaddle.Stroke = (Brush)bc.ConvertFrom("#FFAEAEAE");
            RightPaddle.Fill = (Brush)bc.ConvertFrom("#FFAEAEAE");
            RightPaddle.Stroke = (Brush)bc.ConvertFrom("#FFAEAEAE");
            GameBall.Fill = (Brush)bc.ConvertFrom("#FFAEAEAE");
            GameBall.Stroke = (Brush)bc.ConvertFrom("#FFAEAEAE");

        }

        private void PurpleThemeBtn_Click(object sender, RoutedEventArgs e) {

            var bc = new BrushConverter();

            Scene.Background = (Brush)bc.ConvertFrom("#FFD496FF");
            GameBoard.Background = (Brush)bc.ConvertFrom("#FF995FD3");
            LeftPaddle.Fill = (Brush)bc.ConvertFrom("#FFD496FF");
            LeftPaddle.Stroke = (Brush)bc.ConvertFrom("#FFD496FF");
            RightPaddle.Fill = (Brush)bc.ConvertFrom("#FFD496FF");
            RightPaddle.Stroke = (Brush)bc.ConvertFrom("#FFD496FF");
            GameBall.Fill = (Brush)bc.ConvertFrom("#FFD496FF");
            GameBall.Stroke = (Brush)bc.ConvertFrom("#FFD496FF");
        }

        private void BlueThemeBtn_Click(object sender, RoutedEventArgs e) {

            var bc = new BrushConverter();

            Scene.Background = (Brush)bc.ConvertFrom("#FF93B4D4");
            GameBoard.Background = (Brush)bc.ConvertFrom("#FF3F85BF");
            LeftPaddle.Fill = (Brush)bc.ConvertFrom("#FF93B4D4");
            LeftPaddle.Stroke = (Brush)bc.ConvertFrom("#FF93B4D4");
            RightPaddle.Fill = (Brush)bc.ConvertFrom("#FF93B4D4");
            RightPaddle.Stroke = (Brush)bc.ConvertFrom("#FF93B4D4");
            GameBall.Fill = (Brush)bc.ConvertFrom("#FF93B4D4");
            GameBall.Stroke = (Brush)bc.ConvertFrom("#FF93B4D4");
        }

        private void GreenThemeBtn_Click(object sender, RoutedEventArgs e) {

            var bc = new BrushConverter();

            Scene.Background = (Brush)bc.ConvertFrom("#FF79A883");
            GameBoard.Background = (Brush)bc.ConvertFrom("#FFBBE0B3");
            LeftPaddle.Fill = (Brush)bc.ConvertFrom("#FF79A883");
            LeftPaddle.Stroke = (Brush)bc.ConvertFrom("#FF79A883");
            RightPaddle.Fill = (Brush)bc.ConvertFrom("#FF79A883");
            RightPaddle.Stroke = (Brush)bc.ConvertFrom("#FF79A883");
            GameBall.Fill = (Brush)bc.ConvertFrom("#FF79A883");
            GameBall.Stroke = (Brush)bc.ConvertFrom("#FF79A883");
        }
    }
}