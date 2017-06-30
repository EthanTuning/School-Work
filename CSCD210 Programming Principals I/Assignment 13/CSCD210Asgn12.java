import java.util.Scanner;

public class CSCD210Asgn12
{
	public static final int EXAM_POINTS = 100;
	public static final int FINAL_POINTS = 200;

	public static void main(String[] args)
	{
		int numAssignments, assignMax, numLabs, labMax, numQuizzes, quizMax, numExams, finalExam;
		int[] assignScoreArray, labScoreArray, quizScoreArray, examScoreArray;
		String name = "";
		Scanner kb = new Scanner(System.in);

		do
		{
			// read the user's name
			name = MyUtils.readName(kb);

			//=============================================================
			//========================== Assignments ======================
			//=============================================================
			// read the number of assignments
			numAssignments = CSCD210Asgn12Methods.readTotal(kb, "assignments");

			// read the max score for assignments
			assignMax = CSCD210Asgn12Methods.readMaxScore("assignments", kb);

			// make the array
			assignScoreArray = new int[numAssignments];

			// fill the array with the appropriate values
			CSCD210Asgn12Methods.fillArray(kb, "assignments", assignScoreArray, assignMax);
			SortUtil.selectionSort(assignScoreArray);

			// print the mean & median
			CSCD210Asgn12Methods.printMeanMedian("assignments", CSCD210Asgn12Methods.computeMean(assignScoreArray),
			   CSCD210Asgn12Methods.findMedian(assignScoreArray));

		
      
      
      
			//=============================================================
			//========================== Quizzes ==========================
			//=============================================================
			// read the number of quizzes
			numQuizzes = CSCD210Asgn12Methods.readTotal(kb, "quizzes");

			// read the max score for quizzes
			quizMax = CSCD210Asgn12Methods.readMaxScore("quizzes", kb);

			// make the array
			quizScoreArray = new int[numQuizzes];

			// fill the array with the appropriate values
			CSCD210Asgn12Methods.fillArray(kb, "quizzes", quizScoreArray, quizMax);
			SortUtil.selectionSort(quizScoreArray);

			// print the mean & median
			CSCD210Asgn12Methods.printMeanMedian("quizzes", CSCD210Asgn12Methods.computeMean(quizScoreArray),
				CSCD210Asgn12Methods.findMedian(quizScoreArray));




			//=============================================================
			//========================== Exams ============================
			//=============================================================
			// read the number of exams
			numExams = CSCD210Asgn12Methods.readTotal(kb, "exams");

			// make the array
			examScoreArray = new int[numExams];

			// fill the array with the appropriate values
			CSCD210Asgn12Methods.fillArray(kb, "exams", examScoreArray);
			SortUtil.selectionSort(examScoreArray);

			// print the mean & median
			CSCD210Asgn12Methods.printMeanMedian("exams", CSCD210Asgn12Methods.computeMean(examScoreArray),
				CSCD210Asgn12Methods.findMedian(examScoreArray));




			//=============================================================
			//==================== Final Exam =============================
			//=============================================================
			finalExam = CSCD210Asgn12Methods.readFinalScore(kb);




			//=============================================================
			//==================== Display Grade ==========================
			//=============================================================
			CSCD210Asgn12Methods.displayPercentageAndGrade(assignMax, assignScoreArray, quizMax, quizScoreArray, examScoreArray, finalExam);

		}while(MyUtils.goAgain(kb));

	}// end main

}// end class