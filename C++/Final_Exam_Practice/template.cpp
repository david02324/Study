//#include<iostream>
//using namespace std;
//
//template <typename T>
//T getMax(T x,T y)
//{
//	if (x >= y) return x;
//	else return y;
//}
//
//template <typename T>
//void addPrint(T a,T b)
//{
//	cout << a + b << endl;
//}
//
//void addPrint(string a,string b)
//{
//	cout << a + " " + b << endl;
//}
//
//int main()
//{
//	string a = "�ȳ�";
//	string b = "�ϼ���";
//	
//	cout << getMax<int>(2, 7) << endl;
//	cout << getMax<double>(9.4, 1.0) << endl;
//
//	addPrint(4, 7);
//	addPrint(a,b);
//}
//
//template <typename T> // Ŭ���� �� ��𼭵� ��밡��
//class TemplateClass
//{
//private:
//	T dataA;
//	T dataB;
//	int dataC;
//
//public:
//	void Method(T a,T b)
//	{
//		...
//	}
//};