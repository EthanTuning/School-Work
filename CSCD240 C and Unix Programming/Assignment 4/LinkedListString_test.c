#include <stdio.h>
#include <stdlib.h>
#include <string.h>


struct node
{
        char data[40];
        struct node* next;
};

void push(struct node** head_ref, char* new_data)
{
        struct node* new_node = malloc(sizeof(struct node));
        strcpy(new_node->data, new_data);
        new_node->next = (*head_ref);
        (*head_ref) = new_node;
}

void printList(struct node *head)
{
        struct node *temp = head;
        while (temp != NULL)
        {
                printf("%s  ", temp->data);
                temp = temp->next;
        }
}

int listCount(struct node *head);
void listDelete(struct node **head, char *name);
void reverseList(struct node **head);
void listAllDelete(struct node **start);

int main()
{
        struct node* head = NULL;

        push(&head, "Tom");
        push(&head, "Dick");
        push(&head, "Harry");
        push(&head, "Paul");
        push(&head, "Chris");
        push(&head, "Stuart");
        push(&head, "Rob");

        printf("Linked list after insertion: \n");
        printList(head);
        printf("\n");

	printf("Number of elements in the list: %d\n", listCount(head));
	printf("\n");

	listDelete(&head, "Tom");
	listDelete(&head, "Paul");
	printf("Linked list after deletion: \n");
	printList(head);
	printf("\n");
	printf("Number of elements in the list after deletion: %d\n", listCount(head));
	printf("\n");

	reverseList(&head);
	printf("Reversed Linked List \n");
	printList(head);
	printf("\n");

	listAllDelete(&head);
	printf("Number of elements in the after deletion: %d\n", listCount(head));
	printf("\n");

        return 0;
}

int listCount(struct node *head){
	struct node *curr = head;
	int count = 0;
	puts("");

	while(curr != NULL){
		count++;
		curr = curr->next;
	}
	return count;
}

void listAllDelete(struct node **start){
	struct node *curr = *start;
	struct node *temp;

	while(curr != NULL){
		temp = curr->next;
		free(curr);
		curr = temp;
	}
	*start = NULL;
}

void reverseList(struct node **head){
	struct node *prev = NULL;
	struct node *curr = *head;
	struct node *next;

	while(curr != NULL){
		next = curr->next;
		curr->next = prev;
		prev = curr;
		curr = next;
	}
	*head = prev;
}

void listDelete(struct node **head, char name[]){
	struct node *curr = *head;
	struct node *prev = NULL;

	while(strcmp(curr->data, name) != 0){
		prev = curr;
		curr = curr->next;
	}
	if(curr == *head){
		*head = curr->next;
		free(head);
	}
	else{
		prev->next = curr->next;
		free(curr);
	}
}
