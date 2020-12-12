#include <iostream>
using namespace std;

class Shape
{
	// 무조건 재정의하지 않아도 기본적으로 "Shape"
	virtual void WhatIsMe()
	{
		cout << "Shape" << endl;
	}

	// 도형마다 넓이를 구하는 방법이 다르지만
	// 무조건 포함해야 하는 함수 getArea()
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