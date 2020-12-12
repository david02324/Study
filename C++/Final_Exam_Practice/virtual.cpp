#include <iostream>
using namespace std;

class Shape
{
	// ������ ���������� �ʾƵ� �⺻������ "Shape"
	virtual void WhatIsMe()
	{
		cout << "Shape" << endl;
	}

	// �������� ���̸� ���ϴ� ����� �ٸ�����
	// ������ �����ؾ� �ϴ� �Լ� getArea()
	virtual double getArea() = 0;
};

class Rectangle : public Shape
{
private:
	double x = 5.1;
	double y = 2.7;

public:
	void WhatIsMe()
	{
		cout << "Rectangle" << endl;
	}

	double getArea()
	{
		return x * y;
	}
};

class Circle : public Shape
{
private:
	double r = 6.1;

public:
	void WhatIsMe()
	{
		cout << "Circle" << endl;
	}

	double getArea()
	{
		return r * r * 3.14;
	}
};

int main()
{
	
}