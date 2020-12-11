#include<iostream>
// vector를 포함한 헤더파일
#include<vector>
using namespace std;

int main()
{
	int size = 10;
	int defaultInt = 4;
	int i = 0;
	int x = 2;
	int y = 3;

	// 빈 정수 벡터 생성
	vector<int> v1; 
	// size 만큼의 원소를 가지는 벡터 생성(기본값)
	vector<int> v2(size);
	// size 만큼의 원소를 가지는 벡터 생성(defaultInt로 초기화)
	vector<int> v3(size, defaultInt);
	// v4는 v3을 복사하여 생성(복사 생성자 사용)
	vector<int> v4(v3);

	// v3 벡터의 원소 개수를 반환
	v3.size();
	// v3 벡터의 i 인덱스 참조
	v3.at(i); v3[i];
	// v3 벡터의 처음, 마지막 참조
	v3.front(); v3.back();
	// v3 벡터의 i 인덱스에 x 삽입
	v3.insert(v3.begin()+ i, x);
	// v3 벡터의 i 인덱스에 x 를 y개 삽입
	v3.insert(v3.begin()+ i, y, x);
	// v3 벡터가 비었는지 확인
	v3.empty();
	// v3 벡터의 마지막에 원소 추가, 제거
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