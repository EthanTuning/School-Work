using System;
using System.IO;
using System.Security.Permissions;
using FileSystemWatcher.SQL;

namespace FileSystemWatcher {
    class FileSystemWatcher {

        private static string watchFile;
        private static System.IO.FileSystemWatcher FSWatcher;
        private static SqlDatabaseLogger log;

        static void Main(string[] args) {

        }

        [PermissionSet(SecurityAction.Demand, Name = "FullTrust")]
        public static void Run() {

            string filePath = getFilePath();

            FSWatcher = new System.IO.FileSystemWatcher();
            FSWatcher.Path = filePath;
            FSWatcher.NotifyFilter = NotifyFilters.CreationTime | 
                                     NotifyFilters.LastAccess | 
                                     NotifyFilters.LastWrite | 
                                     NotifyFilters.DirectoryName | 
                                     NotifyFilters.FileName;

            FSWatcher.Changed += FileSystemEventHandler(onCreated);
            FSWatcher.Changed += FileSystemEventHandler(onDeleted);
            FSWatcher.Changed += FileSystemEventHandler(onChanged);
            FSWatcher.Changed += RenamedEventHandler(onRemaned);

            FSWatcher.EnableRaisingEvents = true;
            Console.WriteLine("Press 'e' to exit.");
            while (Console.Read() != 'e');
        }

        private static string getFilePath() {
            return "";
        }
    }
}