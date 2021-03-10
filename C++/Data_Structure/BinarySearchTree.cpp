#include <iostream>
#include <vector>
using namespace std;

struct Node{
  Node* left;
  Node* right;
  Node* par;
  int value;

  Node(){
    left = NULL;
    right = NULL;
    par = NULL;
  }
};

class BinarySearchTree{
  Node* root;
  int size;

public:
  BinarySearchTree(){
    root = NULL;
    size = 0;
  }

  void insert(int value){
    Node* newNode = new Node();
    newNode->value = value;

    if (root == NULL){
      root = newNode;
    } else {
      Node* cur = root;
      Node* par = NULL;

      while (cur){
        par = cur;
        if (value > cur->value) cur = cur->right;
        else cur = cur->left;
      }

      newNode->par = par;
      if (value > par->value) par->right = newNode;
      else par->left = newNode;
    }

    size++;
  }

  Node* search(int value){
    Node* ptr = root;
    while (ptr){
      if (value > ptr->value) ptr = ptr->right;
      else if (value < ptr->value) ptr = ptr->left;
      else return ptr;
    }

    return NULL;
  }

  int getDepth(int value){
    Node* ptr = root;
    int depth = 0;

    while (ptr){
      if (value > ptr->value) ptr = ptr->right;
      else if (value < ptr->value) ptr = ptr->left;
      else break;
      depth++;
    }

    return depth;
  }

  void del(int value){
    Node* target = search(value);
    Node* par = target->par;
    if (!target->left && !target->right){
      if (target != root){
        par->left == target ? par->left = NULL : par->right = NULL;
      } else {
        root = NULL;
      }
    } else if (!target->left){
      if (target != root){
        par->left == target ? par->left = target->right : par->right = target->right;

        target->right->par = par;
      } else {
        root = root->right;
      }
    } else if (!target->right){
      if (target != root){
        par->left == target ? par->left = target->left : par->right = target->left;

        target->left->par = par;
      } else {
        root = root->left;
      }
    } else {
      Node* ptr = target->right;
      while(ptr->left) ptr = ptr->left;
      del(ptr->value);
      size++;
      target->value = ptr->value;
    }
    size--;
  }

  void inOrder(Node* node,vector<int>* v){
    if (node->left) inOrder(node->left,v);
    v->push_back(node->value);
    if (node->right) inOrder(node->right,v);
  }

  Node* getRoot() { return this->root; }
  int getSize() {return size;}
};
