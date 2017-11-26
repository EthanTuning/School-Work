using System.ComponentModel;

namespace Pong {
    class Ball : INotifyPropertyChanged {

        private double mX;
        private double mY;
        private bool mGoingRight;
        private int mRightScore;
        private int mLeftScore;
        public event PropertyChangedEventHandler PropertyChanged;

        public double X {

            get { return mX; }
            set { mX = value; OnPropertyChanged("X"); }

        }

        public double Y {

            get { return mY; }
            set { mY = value; OnPropertyChanged("Y"); }

        }

        public int RightScore {

            get { return mRightScore; }
            set { mRightScore = value; OnPropertyChanged("RightScore"); }

        }

        public int LeftScore {

            get { return mLeftScore; }
            set { mLeftScore = value; OnPropertyChanged("LeftScore"); }

        }

        public bool GoingRight {

            get { return mGoingRight; }
            set { mGoingRight = value; OnPropertyChanged("GoingRight"); }

        }

        protected virtual void OnPropertyChanged(string name) {

            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));

        }
    }
}