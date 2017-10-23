using System;
using System.IO;
using System.Windows.Forms;

namespace FileSystemWatcher {
    public partial class FileSystemWatcherForm : Form {

        private System.IO.FileSystemWatcher FSWatcher;
        private bool mIsDir;
        private string mWatchDir;
        private string mPath;
        private SqlLog mSqlDB;
        private string mFileExFilter;

        public FileSystemWatcherForm() {
            InitializeComponent();
            FSWatcher = new System.IO.FileSystemWatcher();
            StopBtn.Enabled = false;
            queryBtn.Enabled = false;
            toolStripStop.Enabled = false;
            toolStripDB.Enabled = false;
            stopToolStripMenu.Enabled = false;
        }

        private void StartWatcher() {

            FSWatcher.Path = mPath;
            FSWatcher.NotifyFilter = NotifyFilters.CreationTime |
                                     NotifyFilters.LastAccess |
                                     NotifyFilters.LastWrite |
                                     NotifyFilters.DirectoryName |
                                     NotifyFilters.FileName;

            if(!this.fileExtensionSelection.Text.Equals("")) {
                FSWatcher.Filter = this.fileExtensionSelection.Text;
            }

            if (mIsDir) {
                FSWatcher.Filter = "";
                FSWatcher.IncludeSubdirectories = true;
            }
            else {
                FSWatcher.Filter = mWatchDir;
            }

            FSWatcher.Created += new FileSystemEventHandler(OnCreated);
            FSWatcher.Deleted += new FileSystemEventHandler(OnDeleted);
            FSWatcher.Changed += new FileSystemEventHandler(OnChanged);
            FSWatcher.Renamed += new RenamedEventHandler(OnRenamed);

            FSWatcher.EnableRaisingEvents = true;
        }

        private void OnCreated(object obj, FileSystemEventArgs e) {

            string path = e.FullPath;
            DateTime time = DateTime.Now;
            string file = new FileInfo(path).Name;
            string eventType = "File Created";
            WriteLine(String.Format("File: {0} {1} created on {2}", file, path, time.ToString(), '\n'));
            LogToDataBase(mFileExFilter, file, path, eventType, time.ToString());
        }

        private void OnDeleted(object obj, FileSystemEventArgs e) {

            string path = e.FullPath;
            DateTime time = DateTime.Now;
            string file = new FileInfo(path).Name;
            string eventType = "File Deleted";
            WriteLine(String.Format("File: {0} {1} was deleted on {2}", file, path, time.ToString(), '\n'));
            LogToDataBase(mFileExFilter, file, path, eventType, time.ToString());
        }

        private void OnChanged(object obj, FileSystemEventArgs e) {
            string path = e.FullPath;
            DateTime time = DateTime.Now;
            string file = new FileInfo(path).Name;
            string eventType = "File Changed";
            WriteLine(String.Format("File: {0} {1} was changed on {2}", file, path, time.ToString(), '\n'));
            LogToDataBase(mFileExFilter, file, path, eventType, time.ToString());
        }

        private void OnRenamed(object obj, RenamedEventArgs e) {
            string path = e.FullPath;
            DateTime time = DateTime.Now;
            string file = new FileInfo(path).Name;
            string eventType = "File Renamed";
            WriteLine(String.Format("File: {0} {1} was renamed on {2}", file, path, time.ToString(), '\n'));
            LogToDataBase(mFileExFilter, file, path, eventType, time.ToString());
        }

        private bool GetFilePath(String path) {

            string file = path;
            bool exists = false;

            while (exists == false) {

                if (Directory.Exists(file)) {
                    exists = true;
                    mIsDir = true;
                }
                else if (File.Exists(file)) {
                    exists = true;
                    mIsDir = false;
                }
                else {
                    exists = false;
                }
            }
            mPath = file;
            return exists;
        }

        private void LogToDataBase(string extension,string file, string path, string eventType, string time) {
            mSqlDB.Log(extension, file, path, eventType, time);
        }

        private void WriteLine(String str) {
            this.Invoke( new Action( delegate() {
                this.mainDisplay.AppendText(str+'\n');
            }));
        }

//----------------------------------------------------------------------------------------------------------------------------------------

        //Event Handlers
        
        private void StartBtn_Click(object sender, EventArgs e) {
            bool validFile = GetFilePath(this.FileInput.Text);

            if (!validFile) {
                WriteLine("Please enter valid path.");
                return;
            }

            if (this.fileExtensionSelection.Text != "") {
                mFileExFilter = this.fileExtensionSelection.Text;
            }
            else {
                mFileExFilter = "";
            }

            mSqlDB = new SqlLog(this.DatabaseSelection.Text);
            WriteLine("Watcher has started...");
            StartWatcher();
            this.DatabaseSelection.Enabled = false;
            StartBtn.Enabled = false;
            startToolStripMenu.Enabled = false;
            StopBtn.Enabled = true;
            this.queryBtn.Enabled = true;
            toolStripStop.Enabled = true;
            toolStripDB.Enabled = true;
            stopToolStripMenu.Enabled = true;
        }

        private void StopBtn_Click(object sender, EventArgs e) {
            WriteLine("Watcher has stopped...");
            this.DatabaseSelection.Enabled = true;
            StartBtn.Enabled = true;
            FSWatcher.EnableRaisingEvents = false;
            StopBtn.Enabled = false;
            this.queryBtn.Enabled = false;
            toolStripStop.Enabled = false;
            toolStripDB.Enabled = false;
            stopToolStripMenu.Enabled = false;
            startToolStripMenu.Enabled = true;
        }

        private void startToolStripMenu_Click(object sender, EventArgs e) {
            StartBtn_Click(sender, e);
        }

        private void stopToolStripMenu_Click(object sender, EventArgs e) {
            StopBtn_Click(sender, e);
        }

        private void newToolStripMenuItem_Click(object sender, EventArgs e) {
            this.mainDisplay.Text = "New watcher created.\n";
            FSWatcher = new System.IO.FileSystemWatcher();
            StartBtn.Enabled = true;
            StopBtn.Enabled = false;
            queryBtn.Enabled = false;
            toolStripStop.Enabled = false;
            toolStripDB.Enabled = false;
            stopToolStripMenu.Enabled = false;
        }

        private void toolStripStartBtn_Click(object sender, EventArgs e) {
            StartBtn_Click(sender, e);
        }

        private void toolStripStopBtn_Click(object sender, EventArgs e) {
            StopBtn_Click(sender, e);
        }

        private void queryBtn_Click(object sender, EventArgs e) {
            DBqueryForm queryForm = new DBqueryForm(this.DatabaseSelection.Text, mSqlDB);
            queryForm.Show();
        }

        private void queryToolStripMenuItem_Click(object sender, EventArgs e) {
            queryBtn_Click(sender, e);
        }

        private void toolStripDBbtn_Click(object sender, EventArgs e) {
            queryBtn_Click(sender, e);
        }

        private void aboutToolStripMenuItem_Click(object sender, EventArgs e) {
            MessageBox.Show("Written by Ethan Tuning\nVersion 1.0\nThis program watches files using the file system watcher class.");
        }

        private void FileSystemWatcherForm_FormClosing(object sender, FormClosingEventArgs e) {
            if (MessageBox.Show("Are you sure you want to exit?", "File System Watcher",
                MessageBoxButtons.YesNo) == DialogResult.No) {
                e.Cancel = true;
            }

        }
    }
}
