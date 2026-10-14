/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1algorithm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class CA1Algorithm {
    
    // Start of code using Circular Queue
    static class FoodItem {
        //Food Information
        
    private String name; // Remember the name of the food
    private double weight; // Store the weight in grams
    private LocalDate bestBefore; // Store the expiration date
    private LocalDateTime placedTime; // Store the date and time the food was stored
    
    public FoodItem(String itemName, double itemWeight, LocalDate itemBestBefore, LocalDateTime itemPlacedTime) {
    name = itemName;
    weight = itemWeight;
    bestBefore = itemBestBefore;
    placedTime = itemPlacedTime;
    }
    }
    
    static class FoodQueue {
        //Circula Queue
    private FoodItem[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;
    
    public FoodQueue(int queueCapacity) {
        
    capacity = queueCapacity;
    queue = new FoodItem[capacity];
    front = -1;
    rear = -1;
    count = 0;
    } 
    
    
    public boolean isEmpty() {
    return count == 0;
    }

    public boolean isFull() {
    return count == capacity;
    }
    
    public void add(FoodItem item){
        if (isFull()) {
            System.out.println("Storage is Full!");
        }else {
            if (isEmpty()) {
                front = 0;
            }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
            System.out.println(item.name + " added to storage");
        }
    }
    
    public void remove(){
        if (isEmpty()){
            System.out.println("Storage is empty!");
        }else {
            FoodItem item = queue[front];
            queue[front] = null;
            count--;
            if(isEmpty()){
                front = -1;
                rear = -1;
            }else {
                front = (front + 1) % capacity;
            }
            System.out.println(item.name + " removed from storage.");
        }
    }
            
    public void peek(){
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        }else {
            System.out.println("First food item (front) is " + queue[front].name);
        }
    }
    
    public void display (){
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        }else {
            System.out.println("Food items in storage: ");
            int i = front;            
            for (int j = 0; j < count; j++) {
                
                System.out.println("** " + queue[i].name + " **");
                System.out.println("  *Weight: " + queue[i].weight + " grams");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                System.out.println("  *Best-before: " + queue[i].bestBefore.format(dateFormatter));
                System.out.println("  *Placed time: " + queue[i].placedTime.format(formatter));
                i = (i + 1) % capacity;
            }
        }
    } 
    
    public void search(String foodName) {
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        }else {
            int i = front;
            for (int j = 0; j < count; j++) {
                if (queue[i].name.equalsIgnoreCase(foodName)) {
                System.out.println(foodName + " found in storage");
                return;
            }
            i = (i + 1) % capacity;
        }
            System.out.println(foodName + " not found in storage");
        }
    }
    }
    
    // Start of code using Stack
    static class FoodStack {
        private FoodItem[] arr;
        private int top;
        private int capacity;

    public FoodStack(int stackCapacity) {
        capacity = stackCapacity;
        arr = new FoodItem[capacity];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public void add(FoodItem item) {
        if (isFull()) {
            System.out.println("Storage is full.");
            return;
        }

        arr[++top] = item;
        System.out.println(item.name + " added to storage.");
    }

    public FoodItem remove() {
        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return null;
        }

        FoodItem removed = arr[top];
        arr[top] = null;
        top--;

        System.out.println(removed.name + " removed from storage.");
        return removed;
    }

    public FoodItem peek() {
        if (isEmpty()) {
            System.out.println("Storage is empty.");
            return null;
        }

        return arr[top];
    }
    
    public void display() {
        if (isEmpty()) {
        System.out.println("Storage is empty.");
        return;
    }

        System.out.println("Food items in storage:");

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        for (int i = 0; i <= top; i++) {
            System.out.println("** " + arr[i].name + " **");
            System.out.println("  *Weight: " + arr[i].weight + " grams");
            System.out.println("  *Best-before: " + arr[i].bestBefore.format(dateFormatter));
            System.out.println("  *Placed time: " + arr[i].placedTime.format(formatter));
    }
    }
            
    public void search(String itemName) {
        if (isEmpty()) {
        System.out.println("Storage is empty.");
        return;
    }

        for (int i = 0; i <= top; i++) {
        if (arr[i].name.equalsIgnoreCase(itemName)) {
            System.out.println("Item found: " + arr[i].name);
            return;
        }
    }

            System.out.println("Item not found.");
    }
    }

    
    public static int chooseStructure(Scanner input) {
        int option = 0;

        while (option < 1 || option > 3) {
        System.out.println("\n=== Food Storage System ===");
        System.out.println("1. Stack (LIFO)");
        System.out.println("2. Queue (FIFO)");
        System.out.println("3. Exit");
        System.out.print("Choose a structure: ");

        try {
            option = Integer.parseInt(input.nextLine());

            if (option < 1 || option > 3) {
                System.out.println("Invalid option. Choose 1 to 3.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Enter a number.");
            option = 0;
        }
    }
        return option;
}

        
    // Start of Principal Menu Code
    
    public static void main(String[] args) {
        // Principal Menu
    
        Scanner input = new Scanner(System.in);

        int structure = chooseStructure(input);

        if (structure == 3) {
            System.out.println("Exit");
            input.close();
            return;
        }

        int size = 0;

        while (size <= 0 || size > 8) {
            System.out.print("Enter storage capacity (1-8): ");

        try {
        size = Integer.parseInt(input.nextLine());

        if (size <= 0) {
            System.out.println("Queue size must be greater than 0.");
        } else if (size > 8) {
            System.out.println("Queue size cannot be greater than 8.");
        }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Enter a positive whole number.");
            size = 0;
        }
        }

        FoodStack stack = null;
        FoodQueue queue = null;

            if (structure == 1) {
            stack = new FoodStack(size);
            } else if (structure == 2) {
            queue = new FoodQueue(size);
        }
        
        int choose;
        
        do {
        System.out.println("Food Storage System");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Peek first food");
            System.out.println("4. Display all food");
            System.out.println("5. Search food");
            System.out.println("6. Exit");
           
            
              try {
                System.out.println("Choose an option: ");
                choose = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid option. Enter a number.");
                choose=0;
                continue;
            }
            
        switch (choose) {
            case 1:
                System.out.println("Enter food name: ");
                String foodName = input.nextLine();
                if (!foodName.matches("[a-zA-Z]+( [a-zA-Z]+)*")) {
                    System.out.println("Food name must contain lettes and space only.");
                    break;
                }
                
                System.out.println("Enter food weight in grams: ");
                double foodWeight;
                try {
                    foodWeight = Double.parseDouble(input.nextLine());
                    
                    if (foodWeight <= 0) {
                    System.out.println("Food weight must be greater than 0.");
                    break;
                }
                
                
                }catch (NumberFormatException e) {
                    System.out.println("Invalid weight. Enter a number.");
                    break;
                }
                
                System.out.println("Enter best before date (DD/MM/YYYY)");
                String dateInput = input.nextLine();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate bestBefore;
                
                try {
                    bestBefore = LocalDate.parse(dateInput, formatter);
                } catch (java.time.format.DateTimeParseException e) {
                    System.out.println("Invalid date. Use DD/MM/YYYY.");
                    break;             
                }
                
                LocalDate today = LocalDate.now();
                LocalDate maxBestBefore = today.plusWeeks(2);
                
                if (bestBefore.isBefore(today)) {
                    System.out.println("Best before can not be in the past.");
                    break;
                }
                
                if (bestBefore.isAfter(maxBestBefore)) {
                    System.out.println("Best before can not be more than two weeks.");
                    break;
                }
                
                LocalDateTime placedTime = LocalDateTime.now();
                
                FoodItem food = new FoodItem (foodName, foodWeight, bestBefore, placedTime);
                
                if (structure == 1) {
                stack.add(food);
                } else {
                queue.add(food);
                }
                break;
                
            case 2:
                if (structure == 1) {
                stack.remove();
                } else {
                queue.remove();
                }
                break;
                
            case 3:
                if (structure == 1) {
                FoodItem item = stack.peek();

                if (item != null) {
                System.out.println("Top food item is " + item.name);
                }
                } else {
                queue.peek();
                }
                break;
                
            case 4:
                if (structure == 1) {
                stack.display();
                } else {
                queue.display();
                }
                break;
                
            case 5:
                System.out.println("Enter food name to search");
                String searchFood = input.nextLine();

                if (structure == 1) {
                stack.search(searchFood);
                } else {
                queue.search(searchFood);
                }
                break;
                
            case 6:
                System.out.println("Exit");
                break;
                
            default: 
                System.out.println("Invalid Option! Choose 1 to 6");
        }
       
        }   while  (choose != 6);
        
        input.close();
    }
    }
