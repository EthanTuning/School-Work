using System.ComponentModel;

namespace Pong {
    class Paddle : INotifyPropertyChanged {

        private int mPosition;
        public event PropertyChangedEventHandler PropertyChanged;

        public int Position {

            get { return mPosition; }
            set { mPosition = value; OnPropertyChanged("Position"); }
        }

        protected virtual void OnPropertyChanged(string name) {

            PropertyChanged?.Invoke(this, new PropertyChangedEventArgs(name));

        }
    }
}