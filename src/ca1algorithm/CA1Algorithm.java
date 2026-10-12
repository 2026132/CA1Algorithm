/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1algorithm;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
        //Stack
    private FoodItem[] queue;
    private int front;
    private int rear;
    private int capacity;
    private int count;
    
    public FoodQueue(int queueCapacity) {
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
            for (int j = 0; j < count; j++); {
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
    }
    
}
