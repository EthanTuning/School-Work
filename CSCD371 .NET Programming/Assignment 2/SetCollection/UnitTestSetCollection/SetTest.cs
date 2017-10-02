/*
 * Name: Ethan Tuning
 * 
 * This holds all of the unit tests for
 * the Set class.
 */

using SetCollection;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System;

namespace SetCollection
{
    [TestClass]
    public class SetTest
    {
        const int POPULATE_COUNT = 1000;

        /// <summary>
        /// Tests basic add functionality.
        /// </summary>
        [TestMethod]
        public void TestSet_Add_True()
        {
            Set set = new Set();

            for (int i = 0; i < POPULATE_COUNT; ++i)
                Assert.IsTrue(set.Add(i));
        }

        /// <summary>
        /// Test basic add functionality.
        /// </summary>
        [TestMethod]
        public void TestSet_Add_False()
        {
            Set set = new Set();
            Populate(set, POPULATE_COUNT);

            for(int i = 0; i < POPULATE_COUNT; ++i)
                Assert.IsFalse(set.Add(i));
        }

        /// <summary>
        /// Tests basic remove functionality.
        /// </summary>
        [TestMethod]
        public void TestSet_Remove_True()
        {
            Set set = new Set();
            Populate(set, POPULATE_COUNT);

            for (int i = 0; i < POPULATE_COUNT; ++i)
                Assert.IsTrue(set.Remove(i));
        }

        /// <summary>
        /// Tests basic remove functionality.
        /// </summary>
        [TestMethod]
        public void TestSet_Remove_False()
        {
            Set set = new Set();
            Populate(set, POPULATE_COUNT);

            for (int i = 0; i < POPULATE_COUNT; ++i)
            {
                set.Remove(i);
                Assert.IsFalse(set.Remove(i));
            }
        }

        /// <summary>
        /// Tests that a call to Empty returns false if
        /// the set is not empty.
        /// </summary>
        [TestMethod]
        public void TestSet_Empty_False()
        {
            Set set = new Set();
            set.Add(42);
            Assert.IsFalse(set.Empty);
        }

        /// <summary>
        /// Tests that a call to Empty returns true if
        /// the set is empty.
        /// </summary>
        [TestMethod]
        public void TestSet_Empty_True()
        {
            Set set = new Set();
            Assert.IsTrue(set.Empty);
        }

        /// <summary>
        /// Tests that Count returns the proper value
        /// if the set is not empty.
        /// </summary>
        [TestMethod]
        public void TestSet_Count_Populated()
        {
            Set set = new Set();
            int expected = POPULATE_COUNT;
            Populate(set, POPULATE_COUNT);
            Assert.AreEqual(expected, set.Count);
        }

        /// <summary>
        /// Tests that Count returns 0 if the set is
        /// empty.
        /// </summary>
        [TestMethod]
        public void TestSet_Count_Unpopulated()
        {
            Set set = new Set();
            int expected = 0;
            Assert.AreEqual(expected, set.Count);
        }

        /// <summary>
        /// Tests that a call to the indexer throws an
        /// IndexOutOfRangeException when attempting to
        /// use an invalid index = to the number of items added to the set.
        /// </summary>
        [TestMethod]
        [ExpectedException(typeof(IndexOutOfRangeException))]
        public void TestSet_IndexThrowsOutOfBoundsException_EqualToCount()
        {
            Set set = new Set();
            Populate(set, POPULATE_COUNT);
            int bad = (int)set[POPULATE_COUNT];
        }

        /// <summary>
        /// Tests that indexing can be used with a for loop to touch each
        /// element exactly once.
        /// </summary>
        [TestMethod]
        public void TestSet_ForLoopTouchesEachElementExactlyOnce()
        {
            int[] appeared = new int[POPULATE_COUNT];
            Set set = new Set();

            for (int i = 0; i < POPULATE_COUNT; ++i)
            {
                appeared[i] = 0;
                set.Add(i);
            }

            for (int i = 0; i < POPULATE_COUNT; ++i)
            {
                int position = (int)set[i];
                appeared[position]++;
            }

            for (int i = 0; i < POPULATE_COUNT; ++i)
                Assert.IsTrue(appeared[i] == 1);
        }

        /// <summary>
        /// Tests that a call to the indexer throws an
        /// IndexOutOfRangeException when attempting to
        /// use an invalid index > the number of items added to the set.
        /// </summary>
        [TestMethod]
        [ExpectedException(typeof(IndexOutOfRangeException))]
        public void TestSet_IndexThrowsOutOfBoundsException_GreaterThanCount()
        {
            Set set = new Set();
            Populate(set, POPULATE_COUNT);
            int bad = (int)set[POPULATE_COUNT + 100];
        }

        /// <summary>
        /// Tests that a call to the indexer throws an
        /// IndexOutOfRangeException when attempting to
        /// use an invalid index less than zero.
        /// </summary>
        [TestMethod]
        [ExpectedException(typeof(IndexOutOfRangeException))]
        public void TestSet_IndexThrowsOutOfBoundsException_LessThanZero()
        {
            Set set = new Set();
            Populate(set, POPULATE_COUNT);
            int bad = (int)set[-1];
        }

        /// <summary>
        /// Tests that a call to Contains returns true.
        /// </summary>
        [TestMethod]
        public void TestSet_Contains_True()
        {
            Set set = new Set();
            string s1 = "All good men";
            set.Add(s1);
            Assert.IsTrue(set.Contains(s1));
        }

        /// <summary>
        /// Tests that a call to Contains returns false if
        /// the item has been removed from the list.
        /// </summary>
        [TestMethod]
        public void TestSet_Contains_False()
        {
            Set set = new Set();
            string s1 = "All good men";
            set.Add(s1);
            set.Remove(s1);

            Assert.IsFalse(set.Contains(s1));
        }

        /// <summary>
        /// Tests basic functionality for Equals.
        /// </summary>
        [TestMethod]
        public void TestSet_Equals_True()
        {
            Set set1 = new Set();
            Set set2 = new Set();

            Populate(set1, POPULATE_COUNT);
            Populate(set2, POPULATE_COUNT);
            bool expected = true;
            bool actual = set1.Equals(set2);
            Assert.AreEqual(expected, actual);
        }

        /// <summary>
        /// Tests to see if Equals still works if the
        /// order of the values are reversed but the same.
        /// </summary>
        [TestMethod]
        public void TestSet_Equals_True_ReverseOrder()
        {
            int[] array = new int[POPULATE_COUNT];
            int[] arrayR = new int[POPULATE_COUNT];

            for (int i = 0; i < array.Length; ++i)
            {
                array[i] = i;
                arrayR[i] = POPULATE_COUNT - (i + 1);
            }

            Set set1 = new Set();
            Set set2 = new Set();

            PopulateWithArray(set1, array);
            PopulateWithArray(set2, arrayR);

            bool expected = true;
            bool actual = set1.Equals(set2);
            Assert.AreEqual(expected, actual);
        }

        /// <summary>
        /// Tests to see if Equals still works if
        /// the values are randomly shuffled.
        /// </summary>
        [TestMethod]
        public void TestSet_Equals_True_ShuffledOrder()
        {
            int[] array = new int[POPULATE_COUNT];
            for (int i = 0; i < POPULATE_COUNT; ++i)
                array[i] = i;
            Random rand = new Random();
            bool expected = true;
            
            for (int k = 0; k < 100; ++k)
            {
                Set set1 = new Set();
                Set set2 = new Set();

                ShuffleArray(rand, array);
                PopulateWithArray(set1, array);

                ShuffleArray(rand, array);
                PopulateWithArray(set2, array);

                bool actual = set1.Equals(set2);
                Assert.AreEqual(expected, actual);
            }
        }

        /// <summary>
        /// Tests to see that equals returns false
        /// if the sets do not contain the same values.
        /// </summary>
        [TestMethod]
        public void TestSet_Equals_False()
        {
            Set set1 = new Set();
            Set set2 = new Set();

            for (int i = 0; i < POPULATE_COUNT / 2; ++i)
            {
                set1.Add(i);
                set2.Add(i + 500);
            }

            bool expected = false;
            bool actual = set1.Equals(set2);
            Assert.AreEqual(expected, actual);
        }

        /// <summary>
        /// Tests to see that if the sets are equal, than the
        /// hash value is equal.
        /// </summary>
        [TestMethod]
        public void TestSet_HashAndEqual_True()
        {
            Set set1 = new Set();
            Set set2 = new Set();

            PopulateWithWords(set1);
            PopulateWithWords(set2);

            bool expected = true;
            bool actual = set1.GetHashCode() == set2.GetHashCode();
            Assert.AreEqual(expected, actual);
        }

        /// <summary>
        /// Tests to see that ToString returns a string that starts and
        /// ends with brackets.
        /// </summary>
        [TestMethod]
        public void TestSet_ToStringStartsAndEndsWithBrackets()
        {
            Set set = new Set();
            PopulateWithWords(set);
            string setString = set.ToString();
            char expectedLeft = '[';
            char expectedRight = ']';

            Assert.AreEqual(expectedLeft, setString[0]);
            Assert.AreEqual(expectedRight, setString[setString.Length - 1]);
        }

        /// <summary>
        /// Tests to make sure that using CopyTo to copy the entire set
        /// to an array will produce an equivalent set if copied back to
        /// another set.
        /// </summary>
        [TestMethod]
        public void TestSet_CopyTo()
        {
            Set set1 = new Set();
            Set set2 = new Set();

            Populate(set1, POPULATE_COUNT);
            int[] copyTarget = new int[POPULATE_COUNT];
            set1.CopyTo(copyTarget, 0);

            for (int i = 0; i < copyTarget.Length; ++i)
                set2.Add(copyTarget[i]);

            bool expected = true;
            bool actual = set1.Equals(set2);
            Assert.AreEqual(expected, actual);
        }

        /// <summary>
        /// Tests to make sure that foreach touches every element exactly once.
        /// </summary>
        [TestMethod]
        public void TestSet_ForEach()
        {
            int[] appeared = new int[POPULATE_COUNT];
            Set set = new Set();

            for (int i = 0; i < POPULATE_COUNT; ++i)
            {
                appeared[i] = 0;
                set.Add(i);
            }

            foreach (int i in set)
            { appeared[i]++; }
            
            for (int i = 0; i < POPULATE_COUNT; ++i)
                Assert.IsTrue(appeared[i] == 1);
        }

        /// <summary>
        /// Helper method to shuffle an array.
        /// </summary>
        /// <param name="rand">An already created random.</param>
        /// <param name="list">An array of ints.</param>
        private void ShuffleArray(Random rand, int[] list)
        {
            int n = list.Length;
            while (n > 1)
            {
                --n;
                int i = rand.Next(n + 1);
                int temp = list[i];
                list[i] = list[n];
                list[n] = temp;
            }
        }

        /// <summary>
        /// Populates a set with text from a classy book.
        /// </summary>
        /// <param name="set">Set to populate.</param>
        private void PopulateWithWords(Set set)
        {
            set.Add("Now is the time");
            set.Add("For all good men");
            set.Add("to come to the defense of their country");
        }

        /// <summary>
        /// Populates a set with an int array.
        /// </summary>
        /// <param name="set">Set to populate.</param>
        /// <param name="array">int array to populate the set with.</param>
        private void PopulateWithArray(Set set, int[] array)
        {
            for (int i = 0; i < array.Length; ++i)
                set.Add(array[i]);
        }

        /// <summary>
        /// Populates the set with the specified number of ints.
        /// </summary>
        /// <param name="set">set to populate</param>
        /// <param name="count">count to populate to.</param>
        private void Populate(Set set, int count)
        {
            for (int i = 0; i < count; ++i)
                set.Add(i);
        }

        /// <summary>
        /// Removes the specified range of ints from the set.
        /// </summary>
        /// <param name="set">set to remove ints from.</param>
        /// <param name="count">count to remove.</param>
        private void UnPopulate(Set set, int count)
        {
            for (int i = 0; i < count; ++i)
                set.Remove(i);
        }
    }
}
