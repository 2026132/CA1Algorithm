/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1algorithm;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

/**
 *
 * @author ander
 */
public class CA1Algorithm {

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
            System.out.println("First food items is " + queue[front].name);
        }
    }
    
    public void display (){
        if (isEmpty()) {
            System.out.println("Storage is empty!");
        }else {
            System.out.println("Food items in storage: ");
            int i = front;            
            for (int j = 0; j < count; j++) {
                System.out.println(queue[i].name);
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
    
    
    
    public static void main(String[] args) {
        // Principal Menu
    
        Scanner input = new Scanner (System.in);
        int size = 0;

        while (size <= 0) {
             System.out.print("Enter queue size: ");

        try {
        size = Integer.parseInt(input.nextLine());

        if (size <= 0) {
            System.out.println("Queue size must be greater than 0.");
        }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Enter a positive whole number.");
        }
        }

        FoodQueue queue = new FoodQueue(size);
        
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
                
                System.out.println("Enter best before date (YYYY-MM-DD)");
                String dateInput = input.nextLine();
                LocalDate bestBefore;
                
                try {
                    bestBefore = LocalDate.parse(dateInput);
                } catch (java.time.format.DateTimeParseException e) {
                    System.out.println("Invalid date. Use YYYY-MM-DD.");
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
                queue.add(food);
                break;
                
            case 2:
                queue.remove();
                break;
                
            case 3:
                queue.peek();
                break;
                
            case 4:
                queue.display();
                break;
                
            case 5:
                System.out.println("Enter food name to search");
                String searchFood = input.nextLine();
                queue.search(searchFood);
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
  
