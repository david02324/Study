#include <iostream>
using namespace std;

int main()
{
	int pizzaSlices = 8;
	int personNum;

	try {
		cout << "���ڸ� ������ ���� ��� ���� �Է��ϼ��� : ";
		cin >> personNum;
		if (personNum == 0)
			throw personNum;

		int slicePerson = pizzaSlices / personNum;

		cout << "�ѻ���� " << slicePerson << "����";
	} catch (int e)
	{
		cout << "��� ���� " << e << "�� �Դϴ�.";
	}
}