using System;
using System.IO;

namespace FileSystemWatcher {

    class FileSystemWatcher {

        private static string mWatchDir;
        private static System.IO.FileSystemWatcher FSWatcher;
        private static Logger log;
        private static bool mIsDir;

        static void Main(string[] args) {
            log = new Logger();
            Run();
        }

        public static void Run() {

            string filePath = getFilePath();

            FSWatcher = new System.IO.FileSystemWatcher();
            FSWatcher.Path = filePath;
            FSWatcher.NotifyFilter = NotifyFilters.CreationTime |
                                     NotifyFilters.LastAccess |
                                     NotifyFilters.LastWrite |
                                     NotifyFilters.DirectoryName |
                                     NotifyFilters.FileName;

            if(mIsDir) {
                FSWatcher.Filter = "";
                FSWatcher.IncludeSubdirectories = true;
            }
            else {
                FSWatcher.Filter = mWatchDir;
            }

            FSWatcher.Created += new FileSystemEventHandler(onCreated);
            FSWatcher.Deleted += new FileSystemEventHandler(onDeleted);
            FSWatcher.Changed += new FileSystemEventHandler(onChanged);
            FSWatcher.Renamed += new RenamedEventHandler(onRenamed);

            FSWatcher.EnableRaisingEvents = true;

            log.SetWatch(mWatchDir);

            Console.WriteLine("Press 'e' to exit.");
            while (Console.Read() != 'e') ;
        }

        private static void onCreated(object obj, FileSystemEventArgs e) {

            string path = e.FullPath;
            DateTime time = DateTime.Now;
            string file = new FileInfo(path).Name;
            string eventType = "File Created";
            Console.WriteLine("File: {0} {1} created on {2}", file, path, time.ToString());
            log.Log(file, path, eventType, time.ToString());
        }

        private static void onDeleted(object obj, FileSystemEventArgs e) {

            string path = e.FullPath;
            DateTime time = DateTime.Now;
            string file = new FileInfo(path).Name;
            string eventType = "File Deleted";
            Console.WriteLine("File: {0} {1} was deleted on {2}", file, path, time.ToString());
            log.Log(file, path, eventType, time.ToString());
        }

        private static void onChanged(object obj, FileSystemEventArgs e) {
            string path = e.FullPath;
            DateTime time = DateTime.Now;
            string file = new FileInfo(path).Name;
            string eventType = "File Changed";
            Console.WriteLine("File: {0} {1} was changed on {2}", file, path, time.ToString());
            log.Log(file, path, eventType, time.ToString());
        }

        private static void onRenamed(object obj, RenamedEventArgs e) {
            string path = e.FullPath;
            DateTime time = DateTime.Now;
            string file = new FileInfo(path).Name;
            string eventType = "File Renamed";
            Console.WriteLine("File: {0} {1} was renamed on {2}", file, path, time.ToString());
            log.Log(file, path, eventType, time.ToString());
        }

        private static string getFilePath() {

            string file = "";
            bool exists = false;

            while(exists == false) {
                Console.Write("Enter file to watch: ");
                file = Console.ReadLine();

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
            return file;
        }
    }
}