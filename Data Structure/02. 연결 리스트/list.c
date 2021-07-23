#include <stdio.h>
#define INF 10000

int arr[INF];
int count = 0;

void addBack(int data) {
    arr[count] = data;
    count ++;
}

void addFirst(int data) {
    for (int i = count; i>= 1; i--){
        arr[i] = arr[i - 1];
    }
    arr[0] = data;
    count++;
}

void show() {
    for (int i = 0; i<count; i++) {
        printf("%d ", arr[i]);
    }
}

void removeAt(int index) {
    for (int i = index; i < count - 1; i ++) {
        arr[i] = arr[i + 1];
    }
    count--;
}

int main(void) {
    addBack(5);
    addBack(4);
    addBack(3);
    addFirst(2);
    addFirst(1);
    show();
    return 0;
}