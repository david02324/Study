struct Node
{
    int val;
    Node *prev, *next;
    Node() : val(0), prev(NULL), next(NULL) {}
    Node(int x) : val(x), prev(NULL), next(NULL) {}
    Node(int x, Node *prev, Node *next) : val(x), prev(prev), next(next) {}
};

class MyLinkedList
{
public:
    Node *head;
    int size = -1;

    MyLinkedList()
    {
        head = NULL;
    }
    
    ~MyLinkedList(){
        if(head) delete head;
    }
    
    int get(int index)
    {
        if (index > size)
            return -1;

        Node *it = head;
        for (int i = 0; i < index; i++) it = it->next;
        return it->val;
    }

    void addAtHead(int val)
    {
        if (head)
        {
            Node *newHead = new Node(val, NULL, head);
            head->prev = newHead;
            head = newHead;
        }
        else
        {
            head = new Node(val);
        }
        size++;
    }

    void addAtTail(int val)
    {
        if (!head)
        {
            addAtHead(val);
            return;
        }
        else{
            Node *it = head;
            while (it->next) it = it->next;
            Node *newTail = new Node(val, it, NULL);
            it->next = newTail;
        }
        size++;
    }

    void addAtIndex(int index, int val)
    {
        if(index == size + 1){
            addAtTail(val);
        }
        else if (index > size)
            return;
        else if (index == 0)
        {
            addAtHead(val);
        }
        else
        {
            Node *it = head;
            for (int i = 0; i < index; i++) it = it->next;
            Node *newNode = new Node(val, it->prev, it);
            it->prev->next = newNode;
            it->prev = newNode;
            size++;
        }
    }

    void deleteAtIndex(int index)
    {
        if (index > size)
            return;

        if (index == 0)
        {
            head = head->next;
        }
        else
        {
            Node *it = head;

            for (int i = 0; i < index; i++) it = it->next;

            Node *temp = it;

            if (index == size)
            {
                it->prev->next = NULL;
            }
            else
            {
                it->prev->next = it->next;
                it->next->prev = it->prev;
            }
            delete temp;
        }
        size--;
    }
};