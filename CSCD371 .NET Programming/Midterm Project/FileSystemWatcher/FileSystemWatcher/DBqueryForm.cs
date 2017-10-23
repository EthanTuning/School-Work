using System;
using System.Windows.Forms;

namespace FileSystemWatcher {
    public partial class DBqueryForm : Form {

        private SqlLog mSqlDB;

        public DBqueryForm(string DBName, SqlLog sqlDB) {
            InitializeComponent();

            if (DBName != "")
                this.DBname.Text = "dbo_"+DBName+".dbo";
            else
                this.DBname.Text = "dbo_log.db";

            mSqlDB = sqlDB;
        }

        private void Query_Click(object sender, EventArgs e) {
            string results = mSqlDB.queryDB();
            this.results.Text = results;
        }
    }
}
