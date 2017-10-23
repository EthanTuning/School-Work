namespace FileSystemWatcher {
    partial class FileSystemWatcherForm {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing) {
            if (disposing && (components != null)) {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent() {
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FileSystemWatcherForm));
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.fIleToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.newToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.exitToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.watcherToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.startToolStripMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.stopToolStripMenu = new System.Windows.Forms.ToolStripMenuItem();
            this.databaseToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.queryToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.aboutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.toolStrip1 = new System.Windows.Forms.ToolStrip();
            this.toolStripStart = new System.Windows.Forms.ToolStripButton();
            this.toolStripStop = new System.Windows.Forms.ToolStripButton();
            this.toolStripDB = new System.Windows.Forms.ToolStripButton();
            this.toolStripStartBtn = new System.Windows.Forms.ToolStripButton();
            this.toolStripStopBtn = new System.Windows.Forms.ToolStripButton();
            this.toolStripDBbtn = new System.Windows.Forms.ToolStripButton();
            this.mainDisplay = new System.Windows.Forms.TextBox();
            this.FileInput = new System.Windows.Forms.TextBox();
            this.StartBtn = new System.Windows.Forms.Button();
            this.StopBtn = new System.Windows.Forms.Button();
            this.DatabaseSelection = new System.Windows.Forms.TextBox();
            this.statusStrip1 = new System.Windows.Forms.StatusStrip();
            this.toolStripStatusLabel1 = new System.Windows.Forms.ToolStripStatusLabel();
            this.WatchFileExSelect = new System.Windows.Forms.TextBox();
            this.pathDialog = new System.Windows.Forms.Label();
            this.dbDialog = new System.Windows.Forms.Label();
            this.fileExtensionSelection = new System.Windows.Forms.Label();
            this.queryBtn = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.toolStrip1.SuspendLayout();
            this.statusStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.fIleToolStripMenuItem,
            this.watcherToolStripMenuItem,
            this.databaseToolStripMenuItem,
            this.aboutToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(563, 24);
            this.menuStrip1.TabIndex = 0;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // fIleToolStripMenuItem
            // 
            this.fIleToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.newToolStripMenuItem,
            this.exitToolStripMenuItem});
            this.fIleToolStripMenuItem.Name = "fIleToolStripMenuItem";
            this.fIleToolStripMenuItem.Size = new System.Drawing.Size(37, 20);
            this.fIleToolStripMenuItem.Text = "FIle";
            // 
            // newToolStripMenuItem
            // 
            this.newToolStripMenuItem.Name = "newToolStripMenuItem";
            this.newToolStripMenuItem.Size = new System.Drawing.Size(98, 22);
            this.newToolStripMenuItem.Text = "New";
            this.newToolStripMenuItem.Click += new System.EventHandler(this.newToolStripMenuItem_Click);
            // 
            // exitToolStripMenuItem
            // 
            this.exitToolStripMenuItem.Name = "exitToolStripMenuItem";
            this.exitToolStripMenuItem.Size = new System.Drawing.Size(98, 22);
            this.exitToolStripMenuItem.Text = "Exit";
            // 
            // watcherToolStripMenuItem
            // 
            this.watcherToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.startToolStripMenu,
            this.stopToolStripMenu});
            this.watcherToolStripMenuItem.Name = "watcherToolStripMenuItem";
            this.watcherToolStripMenuItem.Size = new System.Drawing.Size(63, 20);
            this.watcherToolStripMenuItem.Text = "Watcher";
            // 
            // startToolStripMenu
            // 
            this.startToolStripMenu.Name = "startToolStripMenu";
            this.startToolStripMenu.Size = new System.Drawing.Size(98, 22);
            this.startToolStripMenu.Text = "Start";
            this.startToolStripMenu.Click += new System.EventHandler(this.startToolStripMenu_Click);
            // 
            // stopToolStripMenu
            // 
            this.stopToolStripMenu.Name = "stopToolStripMenu";
            this.stopToolStripMenu.Size = new System.Drawing.Size(98, 22);
            this.stopToolStripMenu.Text = "Stop";
            this.stopToolStripMenu.Click += new System.EventHandler(this.stopToolStripMenu_Click);
            // 
            // databaseToolStripMenuItem
            // 
            this.databaseToolStripMenuItem.DropDownItems.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.queryToolStripMenuItem});
            this.databaseToolStripMenuItem.Name = "databaseToolStripMenuItem";
            this.databaseToolStripMenuItem.Size = new System.Drawing.Size(67, 20);
            this.databaseToolStripMenuItem.Text = "Database";
            // 
            // queryToolStripMenuItem
            // 
            this.queryToolStripMenuItem.Name = "queryToolStripMenuItem";
            this.queryToolStripMenuItem.Size = new System.Drawing.Size(106, 22);
            this.queryToolStripMenuItem.Text = "Query";
            this.queryToolStripMenuItem.Click += new System.EventHandler(this.queryToolStripMenuItem_Click);
            // 
            // aboutToolStripMenuItem
            // 
            this.aboutToolStripMenuItem.Name = "aboutToolStripMenuItem";
            this.aboutToolStripMenuItem.Size = new System.Drawing.Size(52, 20);
            this.aboutToolStripMenuItem.Text = "About";
            this.aboutToolStripMenuItem.Click += new System.EventHandler(this.aboutToolStripMenuItem_Click);
            // 
            // toolStrip1
            // 
            this.toolStrip1.Dock = System.Windows.Forms.DockStyle.Left;
            this.toolStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStart,
            this.toolStripStop,
            this.toolStripDB,
            this.toolStripStartBtn,
            this.toolStripStopBtn,
            this.toolStripDBbtn});
            this.toolStrip1.Location = new System.Drawing.Point(0, 24);
            this.toolStrip1.Name = "toolStrip1";
            this.toolStrip1.Size = new System.Drawing.Size(24, 594);
            this.toolStrip1.TabIndex = 1;
            this.toolStrip1.Text = "toolStrip1";
            // 
            // toolStripStart
            // 
            this.toolStripStart.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripStart.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripStart.Name = "toolStripStart";
            this.toolStripStart.Size = new System.Drawing.Size(21, 4);
            this.toolStripStart.Text = "toolStripButton1";
            // 
            // toolStripStop
            // 
            this.toolStripStop.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripStop.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripStop.Name = "toolStripStop";
            this.toolStripStop.Size = new System.Drawing.Size(21, 4);
            this.toolStripStop.Text = "toolStripButton2";
            // 
            // toolStripDB
            // 
            this.toolStripDB.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripDB.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripDB.Name = "toolStripDB";
            this.toolStripDB.Size = new System.Drawing.Size(21, 4);
            this.toolStripDB.Text = "toolStripButton3";
            // 
            // toolStripStartBtn
            // 
            this.toolStripStartBtn.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripStartBtn.Image = ((System.Drawing.Image)(resources.GetObject("toolStripStartBtn.Image")));
            this.toolStripStartBtn.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripStartBtn.Name = "toolStripStartBtn";
            this.toolStripStartBtn.Size = new System.Drawing.Size(21, 20);
            this.toolStripStartBtn.Text = "toolStripButton1";
            this.toolStripStartBtn.Click += new System.EventHandler(this.toolStripStartBtn_Click);
            // 
            // toolStripStopBtn
            // 
            this.toolStripStopBtn.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripStopBtn.Image = ((System.Drawing.Image)(resources.GetObject("toolStripStopBtn.Image")));
            this.toolStripStopBtn.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripStopBtn.Name = "toolStripStopBtn";
            this.toolStripStopBtn.Size = new System.Drawing.Size(21, 20);
            this.toolStripStopBtn.Text = "toolStripButton2";
            this.toolStripStopBtn.Click += new System.EventHandler(this.toolStripStopBtn_Click);
            // 
            // toolStripDBbtn
            // 
            this.toolStripDBbtn.DisplayStyle = System.Windows.Forms.ToolStripItemDisplayStyle.Image;
            this.toolStripDBbtn.Image = ((System.Drawing.Image)(resources.GetObject("toolStripDBbtn.Image")));
            this.toolStripDBbtn.ImageTransparentColor = System.Drawing.Color.Magenta;
            this.toolStripDBbtn.Name = "toolStripDBbtn";
            this.toolStripDBbtn.Size = new System.Drawing.Size(21, 20);
            this.toolStripDBbtn.Text = "toolStripButton3";
            this.toolStripDBbtn.Click += new System.EventHandler(this.toolStripDBbtn_Click);
            // 
            // mainDisplay
            // 
            this.mainDisplay.Enabled = false;
            this.mainDisplay.Location = new System.Drawing.Point(44, 279);
            this.mainDisplay.Multiline = true;
            this.mainDisplay.Name = "mainDisplay";
            this.mainDisplay.ReadOnly = true;
            this.mainDisplay.ShortcutsEnabled = false;
            this.mainDisplay.Size = new System.Drawing.Size(483, 294);
            this.mainDisplay.TabIndex = 0;
            // 
            // FileInput
            // 
            this.FileInput.Location = new System.Drawing.Point(262, 108);
            this.FileInput.Name = "FileInput";
            this.FileInput.Size = new System.Drawing.Size(265, 20);
            this.FileInput.TabIndex = 3;
            // 
            // StartBtn
            // 
            this.StartBtn.Location = new System.Drawing.Point(262, 134);
            this.StartBtn.Name = "StartBtn";
            this.StartBtn.Size = new System.Drawing.Size(125, 23);
            this.StartBtn.TabIndex = 4;
            this.StartBtn.Text = "Start";
            this.StartBtn.UseVisualStyleBackColor = true;
            this.StartBtn.Click += new System.EventHandler(this.StartBtn_Click);
            // 
            // StopBtn
            // 
            this.StopBtn.Location = new System.Drawing.Point(405, 134);
            this.StopBtn.Name = "StopBtn";
            this.StopBtn.Size = new System.Drawing.Size(122, 23);
            this.StopBtn.TabIndex = 5;
            this.StopBtn.Text = "Stop";
            this.StopBtn.UseVisualStyleBackColor = true;
            this.StopBtn.Click += new System.EventHandler(this.StopBtn_Click);
            // 
            // DatabaseSelection
            // 
            this.DatabaseSelection.Location = new System.Drawing.Point(262, 211);
            this.DatabaseSelection.Name = "DatabaseSelection";
            this.DatabaseSelection.Size = new System.Drawing.Size(265, 20);
            this.DatabaseSelection.TabIndex = 6;
            // 
            // statusStrip1
            // 
            this.statusStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.toolStripStatusLabel1});
            this.statusStrip1.Location = new System.Drawing.Point(24, 596);
            this.statusStrip1.Name = "statusStrip1";
            this.statusStrip1.Size = new System.Drawing.Size(539, 22);
            this.statusStrip1.TabIndex = 10;
            this.statusStrip1.Text = "statusStrip1";
            // 
            // toolStripStatusLabel1
            // 
            this.toolStripStatusLabel1.Name = "toolStripStatusLabel1";
            this.toolStripStatusLabel1.Size = new System.Drawing.Size(113, 17);
            this.toolStripStatusLabel1.Text = "File System Watcher";
            // 
            // WatchFileExSelect
            // 
            this.WatchFileExSelect.Location = new System.Drawing.Point(156, 108);
            this.WatchFileExSelect.Name = "WatchFileExSelect";
            this.WatchFileExSelect.Size = new System.Drawing.Size(100, 20);
            this.WatchFileExSelect.TabIndex = 11;
            // 
            // pathDialog
            // 
            this.pathDialog.AutoSize = true;
            this.pathDialog.Location = new System.Drawing.Point(320, 92);
            this.pathDialog.Name = "pathDialog";
            this.pathDialog.Size = new System.Drawing.Size(207, 13);
            this.pathDialog.TabIndex = 12;
            this.pathDialog.Text = "Enter a file path to watch. Then press start";
            // 
            // dbDialog
            // 
            this.dbDialog.AutoSize = true;
            this.dbDialog.Location = new System.Drawing.Point(194, 195);
            this.dbDialog.Name = "dbDialog";
            this.dbDialog.Size = new System.Drawing.Size(333, 13);
            this.dbDialog.TabIndex = 13;
            this.dbDialog.Text = "Enter a database name, if nothing is entered a default will be created.";
            // 
            // fileExtensionSelection
            // 
            this.fileExtensionSelection.AutoSize = true;
            this.fileExtensionSelection.Location = new System.Drawing.Point(115, 92);
            this.fileExtensionSelection.Name = "fileExtensionSelection";
            this.fileExtensionSelection.Size = new System.Drawing.Size(141, 13);
            this.fileExtensionSelection.TabIndex = 14;
            this.fileExtensionSelection.Text = "Specify a file type. (Optional)";
            // 
            // queryBtn
            // 
            this.queryBtn.Location = new System.Drawing.Point(262, 237);
            this.queryBtn.Name = "queryBtn";
            this.queryBtn.Size = new System.Drawing.Size(265, 23);
            this.queryBtn.TabIndex = 15;
            this.queryBtn.Text = "Query Database";
            this.queryBtn.UseVisualStyleBackColor = true;
            this.queryBtn.Click += new System.EventHandler(this.queryBtn_Click);
            // 
            // FileSystemWatcherForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoValidate = System.Windows.Forms.AutoValidate.Disable;
            this.ClientSize = new System.Drawing.Size(563, 618);
            this.Controls.Add(this.queryBtn);
            this.Controls.Add(this.fileExtensionSelection);
            this.Controls.Add(this.dbDialog);
            this.Controls.Add(this.pathDialog);
            this.Controls.Add(this.WatchFileExSelect);
            this.Controls.Add(this.statusStrip1);
            this.Controls.Add(this.DatabaseSelection);
            this.Controls.Add(this.StopBtn);
            this.Controls.Add(this.StartBtn);
            this.Controls.Add(this.FileInput);
            this.Controls.Add(this.mainDisplay);
            this.Controls.Add(this.toolStrip1);
            this.Controls.Add(this.menuStrip1);
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "FileSystemWatcherForm";
            this.Text = "File System Watcher";
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.FileSystemWatcherForm_FormClosing);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.toolStrip1.ResumeLayout(false);
            this.toolStrip1.PerformLayout();
            this.statusStrip1.ResumeLayout(false);
            this.statusStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem fIleToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem watcherToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem databaseToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem aboutToolStripMenuItem;
        private System.Windows.Forms.ToolStrip toolStrip1;
        private System.Windows.Forms.ToolStripButton toolStripStart;
        private System.Windows.Forms.ToolStripButton toolStripStop;
        private System.Windows.Forms.ToolStripButton toolStripDB;
        private System.Windows.Forms.TextBox mainDisplay;
        private System.Windows.Forms.TextBox FileInput;
        private System.Windows.Forms.Button StartBtn;
        private System.Windows.Forms.Button StopBtn;
        private System.Windows.Forms.TextBox DatabaseSelection;
        private System.Windows.Forms.StatusStrip statusStrip1;
        private System.Windows.Forms.ToolStripStatusLabel toolStripStatusLabel1;
        private System.Windows.Forms.ToolStripMenuItem startToolStripMenu;
        private System.Windows.Forms.ToolStripMenuItem stopToolStripMenu;
        private System.Windows.Forms.ToolStripMenuItem queryToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem newToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem exitToolStripMenuItem;
        private System.Windows.Forms.TextBox WatchFileExSelect;
        private System.Windows.Forms.ToolStripButton toolStripStartBtn;
        private System.Windows.Forms.ToolStripButton toolStripStopBtn;
        private System.Windows.Forms.ToolStripButton toolStripDBbtn;
        private System.Windows.Forms.Label pathDialog;
        private System.Windows.Forms.Label dbDialog;
        private System.Windows.Forms.Label fileExtensionSelection;
        private System.Windows.Forms.Button queryBtn;
    }
}