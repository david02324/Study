#include <iostream>
using namespace std;

class PQ{
  int max_size;
  int size;
  int* q = nullptr;

public:
  PQ(int max_size){
    this->size = 0;
    this->max_size = max_size;
    q = new int[max_size+1];
  }

  bool insert(int value){
    if (size >= max_size){
      return false;
    }
    int ptr = ++size;
    q[ptr] = value;

    while (ptr/2>0 && q[ptr/2] > q[ptr]){
      swap(q[ptr],q[ptr/2]);
      ptr /= 2;
    }

    return true;
  }

  int pop(){
    if (size == 0){
      return -1;
    }

    int val = q[1];
    q[1] = q[size];
    size--;

    int parent = 1;
    int child = parent * 2;
    if (child + 1 <= size) {
      child = (q[child] < q[child + 1]) ? child : child + 1;
    }

    while (child <= size && q[parent] > q[child]) {
      swap(q[parent],q[child]);

      parent = child;
      child = child * 2;
      if (child + 1 <= size) {
        child = (q[child] < q[child + 1]) ? child : child + 1;
      }
    }

    return val;
  }

  int Size() { return size; }

  bool isEmpty() { return size == 0; }

  int top() { if (size == 0) return -1; else return q[1]; }

  void print() {
    if (size == 0){
      cout << -1 << endl;
      return;
    }
    for (int i = 1; i <= size; i++)
      cout << q[i] << " ";
    cout << endl;
  }
};
