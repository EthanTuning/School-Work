using System;
using System.Collections.Generic;
using System.Data.SQLite;
using System.IO;

namespace FileSystemWatcher {

    public class SqlLog {

        private SQLiteConnection mConnection;
        private SQLiteCommand mCommand;
        private string mLogger;

        public SqlLog(string dbName) {

            if (dbName == null || dbName == "") {
                mLogger = "dbo_log.dbo";
            }
            else {
                mLogger = String.Format("dbo_{0}.dbo", dbName);
            }

            CreateDatabase();
        }

        private void CreateDatabase() {

            if (!File.Exists(mLogger))
                SQLiteConnection.CreateFile(mLogger);

            var source = String.Format("Data Source = {0};Version=3", mLogger);
            mConnection = new SQLiteConnection(source);
            mConnection.Open();
            mCommand = new SQLiteCommand(mConnection);
            createTable();
        }

        private void createTable() {

            string query = "CREATE TABLE IF NOT EXISTS Log(Extension TEXT, " +
                                                            "FileName TEXT, " +
                                                            "EventType TEXT," +
                                                            "Path TEXT, " +
                                                            "Time TEXT);";
            mCommand.CommandText = query;
            mCommand.ExecuteNonQuery();
        }

        public void Log(string extension, string file, string path, string eventType, string time) {

            mCommand.CommandText = "INSERT INTO Log(Extension, FileName, Path, EventType, Time) VALUES (@Extension, @FileName, @Path, @EventType, @Time);";
            mCommand.Prepare();

            mCommand.Parameters.AddWithValue("@Extension", extension);
            mCommand.Parameters.AddWithValue("@FileName", file);
            mCommand.Parameters.AddWithValue("@Path", path);
            mCommand.Parameters.AddWithValue("@EventType", eventType);
            mCommand.Parameters.AddWithValue("@Time", time);
            mCommand.ExecuteNonQuery();
        }

        public string queryDB() {

            string query = "SELECT * FROM Log;";
            mCommand.CommandText = query;
            SQLiteDataReader reader = mCommand.ExecuteReader();
            string results = "";

            while (reader.Read()) {
                results += String.Format("{0}{1}{2}{3}{4}\n\n", reader["Extension"], reader["FileName"], reader["Path"], reader["EventType"], reader["Time"]);
            }

            return results;
        }
    }
}