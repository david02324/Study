// 노드의 정보를 담을 구조체
struct Node{
    int data;
    struct Node *next;
};

class MyLinkedList {
public:
    Node *head;
    Node *cur;
    int size;
    
    MyLinkedList() {
        head = NULL;
        cur = NULL;
        size = 0;
    }
    
    int get(int index) {
        if (size == 0 or index >= size)
            return -1;
        if (index == 0)
            return head->data;
        
        cur = head;
        while(index--)
            cur = cur->next;
        return cur->data;
    }
    
    void addAtHead(int val) {
        Node *newNode = new Node();
        newNode->data = val;
        
        if (size != 0)
            newNode->next = head;
        
        head = newNode;
        size++;
    }
    
    void addAtTail(int val) {
        Node *newNode = new Node();
        newNode->data = val;
        
        if (size == 0){
            head = newNode;
        } else{
            cur = head;
            for (int i = size-1; i>0; i--)
                cur = cur->next;
            cur->next = newNode;
        }
        size++;
    }
    
    void addAtIndex(int index, int val) {
        if (index > size)
            return;
        if (index == 0){
            addAtHead(val);
        } else{
            Node *newNode = new Node();
            newNode->data = val;
            
            cur = head;
            for (int i = index-1; i>0; i--)
                cur = cur -> next;
            
            newNode->next = cur->next;
            cur->next = newNode;
            size++;
        }
    }
    
    void deleteAtIndex(int index) {
        if (index >= size)
            return;
        if (index == 0) {
            head = head->next;
            return;
        }
        
        cur = head;
        for (int i = index-1; i>0; i--)
            cur = cur -> next;
        if (index == size-1)
            cur->next = NULL;
        else
            cur->next = cur->next->next;
        
        size--;
    }
};