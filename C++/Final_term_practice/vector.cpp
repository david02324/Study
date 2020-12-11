#include<iostream>
// vector�� ������ �������
#include<vector>
using namespace std;

int main()
{
	int size = 10;
	int defaultInt = 4;
	int i = 0;
	int x = 2;
	int y = 3;

	// �� ���� ���� ����
	vector<int> v1; 
	// size ��ŭ�� ���Ҹ� ������ ���� ����(�⺻��)
	vector<int> v2(size);
	// size ��ŭ�� ���Ҹ� ������ ���� ����(defaultInt�� �ʱ�ȭ)
	vector<int> v3(size, defaultInt);
	// v4�� v3�� �����Ͽ� ����(���� ������ ���)
	vector<int> v4(v3);

	// v3 ������ ���� ������ ��ȯ
	v3.size();
	// v3 ������ i �ε��� ����
	v3.at(i); v3[i];
	// v3 ������ ó��, ������ ����
	v3.front(); v3.back();
	// v3 ������ i �ε����� x ����
	v3.insert(v3.begin()+ i, x);
	// v3 ������ i �ε����� x �� y�� ����
	v3.insert(v3.begin()+ i, y, x);
	// v3 ���Ͱ� ������� Ȯ��
	v3.empty();
	// v3 ������ �������� ���� �߰�, ����
	v3.push_back(x); v3.pop_back();
	

	for(int i = 0; i < v3.size(); i++)
	{
		cout << v3[i] << " ";
	}

	cout << endl;

	for(auto i = v3.begin(); i !=v3.end(); i++)
	{
		cout << *i << " ";
	}
	
}