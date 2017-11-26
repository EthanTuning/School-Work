using System;
using System.ComponentModel;
using System.Windows;
using System.Windows.Input;

namespace Pong {
    class ApplicationController : INotifyPropertyChanged {

        Ball mBall = new Ball();
        Paddle mRightPaddle = new Paddle();
        Paddle mLeftPaddle = new Paddle();
        private double mSpeed = 5;
        private int mPaddleSpeed = 12;
        private double mAngle = 155;
        private int mCanvasHeight = 512;
        private int mCanvasWidth = 1024;
        private ICommand mClickCommand;
        public event PropertyChangedEventHandler PropertyChanged;

        public ApplicationController() {

            NewGame();

        }

        public void NewGame() {

            mBall.Y = mCanvasHeight / 2;
            mBall.X = mCanvasWidth / 2;

            mBall.GoingRight = true;

            mBall.RightScore = 0;
            mBall.LeftScore = 0;

            mRightPaddle.Position = mCanvasHeight / 2;
            mLeftPaddle.Position = mCanvasHeight / 2;

            mAngle = 155;
        }

        public Ball Ball {

            get { return mBall; }
            set { mBall = value; OnPropertyChanged("Ball"); }

        }

        public Paddle RightPaddle {

            get { return mRightPaddle; }
            set { mRightPaddle = value; OnPropertyChanged("RightPaddle"); }

        }

        public Paddle LeftPaddle {

            get { return mLeftPaddle; }
            set { mLeftPaddle = value; OnPropertyChanged("LeftPaddle"); }

        }

        public void setSpeed(int speed) {

            mSpeed = speed;

        }

        public void LeftPaddleUp() {

            mLeftPaddle.Position -= mPaddleSpeed;

        }

        public void LeftPaddleDown() {

            mLeftPaddle.Position += mPaddleSpeed;

        }

        public void RightPaddleUp() {

            mRightPaddle.Position -= mPaddleSpeed;

        }

        public void RightPaddleDown() {

            mRightPaddle.Position += mPaddleSpeed; ;

        }

        public void Advance() {

            if (mBall.Y <= 0)
                mAngle = mAngle + (180 - 2 * mAngle);

            if(mBall.Y >= mCanvasHeight - 20)
                mAngle = mAngle + (180 - 2 * mAngle);

            if (CheckCollision()) {

                ChangeAngle();
                ChangeDirection();

            }

            double radians = (Math.PI / 180) * mAngle;
            Vector vector = new Vector { X = Math.Sin(radians), Y = -Math.Cos(radians) };

            mBall.X += vector.X * mSpeed;
            mBall.Y += vector.Y * mSpeed;

            if (mBall.X >= 1022) {

                mBall.LeftScore += 1;
                Reset();

            }

            if (mBall.X <= 2) {

                mBall.RightScore += 1;
                Reset();

            }
        }

        private void Reset() {

            mBall.Y = mCanvasHeight / 2;
            mBall.X = mCanvasWidth / 2;

        }

        private void ChangeAngle() {

            if (mBall.GoingRight == true)
                mAngle = 270 - ((mBall.Y + 10) - (mRightPaddle.Position + 40));

            else if (mBall.GoingRight == false)
                mAngle = 90 + ((mBall.Y + 10) - (mLeftPaddle.Position + 40));

        }

        private bool CheckCollision() {

            bool result = false;

            if (mBall.GoingRight == true)
                result = mBall.X >= 984 && (mBall.Y > mRightPaddle.Position && mBall.Y < mRightPaddle.Position + 80);

            if (mBall.GoingRight == false)
                result = mBall.X <= 20 && (mBall.Y > mLeftPaddle.Position && mBall.Y < mLeftPaddle.Position + 80);

            return result;

        }

        private void ChangeDirection() {

            if (mBall.GoingRight == true)
                mBall.GoingRight = false;

            else if (mBall.GoingRight == false)
                mBall.GoingRight = true;
        
        }

        public ICommand ClickCommand { get { return mClickCommand ?? (mClickCommand = new CommandHandler(() => Action(), CanExecute()));  } }

        private void Action() {

            NewGame();

        }

        private bool CanExecute() {

            return true;

        }

        protected virtual void OnPropertyChanged(string name) {

            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));

        }
    }

    public class CommandHandler : ICommand {

        public event EventHandler CanExecuteChanged;
        private Action mAction;
        private bool mCanExecute;

        public CommandHandler(Action action, bool canExecute) {

            mAction = action;
            mCanExecute = canExecute;

        }

        public bool CanExecute(object parameter) {

            return mCanExecute;

        }

        public void Execute(object parameter) {

            mAction();

        }
    }
}