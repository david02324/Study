//#include <iostream>
//#include <string>
//using namespace std;
//
//class Complex
//{
//	double r;
//	double i;
//
//public:
//	Complex(double r,double i)
//	{
//		this->r = r;
//		this->i = i;
//	}
//
//	Complex operator+(Complex &complex)
//	{
//		double r, i;
//
//		r = this->r + complex.r;
//		i = this->i + complex.i;
//
//		Complex result(r, i);
//		return result;
//	}
//
//	Complex& operator++()
//	{
//		++r;
//		++i;
//		return *this;
//	}
//
//	Complex operator++(int k)
//	{
//		Complex temp = { *this };
//		(this->r)++;
//		(this->i)++;
//		return temp;
//	}
//
//	Complex& operator=(Complex &complex)
//	{
//		this->r = complex.r;
//		this->i = complex.i;
//		return *this;
//	}
//
//	bool operator==(Complex &complex)
//	{
//		if (this->r == complex.r &&
//			this->i == complex.i)
//		{
//			return true;
//		}
//		else return false;
//	}
//
//	friend ostream& operator<<(ostream& os, const Complex& complex)
//	{
//		os << "(" << complex.r << " + " << complex.i << "i)";
//
//		return os;
//	}
//};
//
//int main()
//{
//	Complex c1(2.1, 4.5);
//	Complex c2(1.5, 3.8);
//
//	// ���� ������ =
//	Complex c3 = c1 + c2;
//
//	// << ������
//	cout << c3 << endl;
//
//	Complex c4(3.6, 8.3);
//
//	// �� ������ ==
//	if(c3==c4)
//	{
//		cout << "c3 �� c4�� ���� ����\n";
//	}
//
//	// ���� ++
//	cout << ++c3 << endl;
//
//	// ���� ++
//	cout << c3++ << endl;
//	cout << c3;
//}