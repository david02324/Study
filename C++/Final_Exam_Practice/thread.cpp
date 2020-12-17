#include <iostream>
#include <thread>
using namespace std;

void thread1()
{
	for(int i = 0; i<10; i++)
	cout << "Thread 1" << endl;
}

void thread2()
{
	for (int i = 0; i < 10; i++)
	cout << "Thread 2" << endl;
}

void thread3()
{
	for (int i = 0; i < 10; i++)
	cout << "Thread 3" << endl;
}

int main()
{
	thread t1(thread1);
	thread t2(thread2);
	thread t3(thread3);

	t1.detach();
	t2.detach();
	t3.detach();

	cout << "메인함수 종료" << endl;
}