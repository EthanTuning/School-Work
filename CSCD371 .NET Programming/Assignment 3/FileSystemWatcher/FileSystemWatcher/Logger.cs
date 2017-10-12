using System;
using System.IO;

public class Logger {

    private StreamWriter mStream;

	public Logger() {
        mStream = File.AppendText("log.txt");
	}

    public void Log(string file, string path, string eventType, string time) {
        mStream.WriteLine("File: {0} {1} was "+ eventType +" on {2}", file, path, time.ToString());
        mStream.Flush();
    }

    public void SetWatch(String watchDir) {
        mStream.WriteLine(watchDir);
        mStream.Flush();
    }
}
