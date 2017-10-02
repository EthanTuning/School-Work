/*
 * Name: Ethan Tuning
 * 
 * This is an implementation of the common
 * data structure, the "set".
 * 
 */

using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;

namespace SetCollection {
    public class Set : ICollection, IEnumerable{

        private HashSet<object> mData;
        public Set() {
            mData = new HashSet<object>();
        }

        public int Count {
            get {
                return mData.Count;
            }
        }

        public bool Empty {
            get {
                return mData.Count.Equals(0);
            }
        }

        public object this[int index] {
            get {
                object[] array = new object[mData.Count];
                CopyTo(array, 0);
                return array[index];
            }
        }

        public bool Contains(Object obj) {
            return mData.Contains(obj);
        }

        public bool Add(Object obj) {
            bool result = false;

            if(!mData.Contains(obj)) {
                mData.Add(obj);
                result = true;
            }
            return result;
        }

        public bool Remove(Object obj) {
            bool result = false;

            if(mData.Contains(obj)) {
                mData.Remove(obj);
                result = true;
            }
            return result;
        }

        public override bool Equals(Object obj) {
            if(obj.GetType() != GetType() || obj == null) {
                return false;
            }
            Set set = (Set)obj;
            return set.ToString().Equals(ToString());
        }

        public override int GetHashCode() {
            return mData.ToString().GetHashCode();
        }

        public override string ToString() {
            return "["+mData.ToString()+"]";
        }

        public void CopyTo(Array array, int index) {
            array = mData.ToArray();
        }

        public IEnumerator GetEnumerator() {
           return mData.GetEnumerator();
        }

        public bool IsSynchronized => throw new NotImplementedException();

        public object SyncRoot => throw new NotImplementedException();
    }
}