namespace FileSystemWatcher {
    partial class DBqueryForm {
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
            this.Query = new System.Windows.Forms.Button();
            this.textBox1 = new System.Windows.Forms.TextBox();
            this.DBname = new System.Windows.Forms.TextBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.results = new System.Windows.Forms.TextBox();
            this.SuspendLayout();
            // 
            // Query
            // 
            this.Query.Location = new System.Drawing.Point(213, 93);
            this.Query.Name = "Query";
            this.Query.Size = new System.Drawing.Size(279, 23);
            this.Query.TabIndex = 1;
            this.Query.Text = "Query Database";
            this.Query.UseVisualStyleBackColor = true;
            this.Query.Click += new System.EventHandler(this.Query_Click);
            // 
            // textBox1
            // 
            this.textBox1.Location = new System.Drawing.Point(107, 95);
            this.textBox1.Name = "textBox1";
            this.textBox1.Size = new System.Drawing.Size(100, 20);
            this.textBox1.TabIndex = 2;
            // 
            // DBname
            // 
            this.DBname.Enabled = false;
            this.DBname.Location = new System.Drawing.Point(213, 67);
            this.DBname.Name = "DBname";
            this.DBname.Size = new System.Drawing.Size(279, 20);
            this.DBname.TabIndex = 3;
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(210, 51);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(56, 13);
            this.label1.TabIndex = 4;
            this.label1.Text = "Database:";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(87, 79);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(120, 13);
            this.label2.TabIndex = 5;
            this.label2.Text = "File Extension (Optional)";
            // 
            // results
            // 
            this.results.Location = new System.Drawing.Point(12, 158);
            this.results.Multiline = true;
            this.results.Name = "results";
            this.results.Size = new System.Drawing.Size(480, 188);
            this.results.TabIndex = 6;
            // 
            // DBqueryForm
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(504, 358);
            this.Controls.Add(this.results);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label1);
            this.Controls.Add(this.DBname);
            this.Controls.Add(this.textBox1);
            this.Controls.Add(this.Query);
            this.Name = "DBqueryForm";
            this.Text = "Query Database";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button Query;
        private System.Windows.Forms.TextBox textBox1;
        private System.Windows.Forms.TextBox DBname;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.TextBox results;
    }
}