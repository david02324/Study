#include <iostream>
using namespace std;

int main()
{
	int pizzaSlices = 8;
	int personNum;

	try {
		cout << "피자를 나누어 먹을 사람 수를 입력하세요 : ";
		cin >> personNum;
		if (personNum == 0)
			throw personNum;

		int slicePerson = pizzaSlices / personNum;

		cout << "한사람당 " << slicePerson << "조각";
	} catch (int e)
	{
		cout << "사람 수가 " << e << "명 입니다.";
	}
}