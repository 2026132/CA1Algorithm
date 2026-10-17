/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ca1algorithm;

import java.time.LocalDate; //package required to best before product expiration information.
import java.time.LocalDateTime; //package required to storage date information.
import java.time.format.DateTimeFormatter;// //package required to modify the date and time format.
import java.util.Scanner; // Package required to read and capture input data in Java.


public class CA1Algorithm { 
    
    // Start of code using Circular Queue (FIFO)
    
    static class FoodItem {
        //Food Information
        
    private String name; // Remember the name of the food
    private double weight; // Store the weight in grams
    private LocalDate bestBefore; // Store the expiration date
    private LocalDateTime placedTime; // Store the date and time the food was stored
    
    public FoodItem(String itemName, double itemWeight, LocalDate itemBestBefore, LocalDateTime itemPlacedTime) {
    name = itemName; // Save all food information.
    weight = itemWeight;
    bestBefore = itemBestBefore;
    placedTime = itemPlacedTime;
    }
    }
    
    static class FoodQueue {
        //Circula Queue
    private FoodItem[] queue;
    private int front; // Represents the first item add to the queue.
    private int rear; // Represents the last item add to the queue.
    private int capacity; // Represents the capacity total of the queue.
    private int count; // Represents how many itens have in the queue in that moment.
    
    public FoodQueue(int queueCapacity) {
        
    capacity = queueCapacity;
    queue = new FoodItem[capacity];
    front = -1;
    rear = -1;
    count = 0;
    } 
    
    
    public boolean isEmpty() { // Means the count is 0 the queue is empty.
    return count == 0;
    }

    public boolean isFull() { // Means when the count equal the capacity of the queue it is full.
    return count == capacity;
    }
    
    public void add(FoodItem item){
        if (isFull()) {
            System.out.println("Storage is Full!"); //first check if full
        }else {                                    
            if (isEmpty()) {
                front = 0;
            }
        rear = (rear + 1) % capacity;
        queue[rear] = item;
        count++;
            System.out.println(item.name + " added to storage");// If empty add the item to the queue and update the count
        }                                       
    }
    
    public void remove(){ 
        if (isEmpty()){ // First check if empty
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
            System.out.println(item.name + " removed from storage."); // Remove the first item (front) add to the queue (FIFO)
        }
    }
            
    public void peek(){
        if (isEmpty()) {
            System.out.println("Storage is empty!"); // First check if empty
        }else {
            System.out.println("First food item (front) is " + queue[front].name); // It mentions what the first element in the queue is (the first item added).
        }
    }
    
    public void display (){
        if (isEmpty()) {
            System.out.println("Storage is empty!"); // First check if empty
        }else {
            System.out.println("Food items in storage: "); // List all the food items in the queue, in order of addition, along with their information.
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
            System.out.println("Storage is empty!"); // First check if empty
        }else {
            int i = front;
            for (int j = 0; j < count; j++) {
                if (queue[i].name.equalsIgnoreCase(foodName)) {
                System.out.println("Item found: ** " + foodName + " **"); // It mentions that the item was located in the queue.
                System.out.println("  *Weight: " + queue[i].weight + " grams");
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                System.out.println("  *Best-before: " + queue[i].bestBefore.format(dateFormatter));
                System.out.println("  *Placed time: " + queue[i].placedTime.format(formatter));
                return;
            }
            i = (i + 1) % capacity;
        }
            System.out.println(foodName + " not found in storage"); // Displays a message if it is not found in the queue.
        }
    }
    } // End of code using Queue
    
    // Start of code using Stack (LIFO)
    static class FoodStack {
        private FoodItem[] arr;
        private int top;
        private int capacity;

    public FoodStack(int stackCapacity) { // Creates the stack and initializes it empty (top = -1)
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

    public void add(FoodItem item) { // First check if empty
        if (isFull()) {
            System.out.println("Storage is full.");
            return;
        }

        arr[++top] = item;
        System.out.println(item.name + " added to storage."); // Add item to storage
    }

    public FoodItem remove() {
        if (isEmpty()) { // First check if empty
            System.out.println("Storage is empty.");
            return null;
        }

        FoodItem removed = arr[top]; // Remove the last item add to the stack
        arr[top] = null;
        top--;

        System.out.println(removed.name + " removed from storage.");
        return removed;
    }

    public FoodItem peek() {
        if (isEmpty()) { // First check if empty
            System.out.println("Storage is empty.");
            return null;
        }

        return arr[top]; // Indicates the item that is at the top of the stack, the last item added.
    }
    
    public void display() {
        if (isEmpty()) { // First check if empty
        System.out.println("Storage is empty.");
        return;
    }

        System.out.println("Food items in storage:"); // Displays all items in the stack, along with their information.

            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // allows changing the date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"); // allows changing the date format/hour

        for (int i = 0; i <= top; i++) { // Iterate through the entire stack of the array from index 0 to the top.
            System.out.println("** " + arr[i].name + " **");
            System.out.println("  *Weight: " + arr[i].weight + " grams");
            System.out.println("  *Best-before: " + arr[i].bestBefore.format(dateFormatter));
            System.out.println("  *Placed time: " + arr[i].placedTime.format(formatter));
    }
    }
            
    public void search(String itemName) {
        if (isEmpty()) { // First check if empty
        System.out.println("Storage is empty.");
        return;
    }
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            
        for (int i = 0; i <= top; i++) { // Iterate through the entire stack of the array from index 0 to the top.
        if (arr[i].name.equalsIgnoreCase(itemName)) {
            System.out.println("Item found: ** " + arr[i].name + " **");
            System.out.println("  *Weight: " + arr[i].weight + " grams");
            System.out.println("  *Best-before: " + arr[i].bestBefore.format(dateFormatter));
            System.out.println("  *Placed time: " + arr[i].placedTime.format(formatter));
            return;
        }
    }

            System.out.println("Item not found."); // If the item being searched for is not found in the array, the message is displayed.
    }
    }

    // Allows the user to select which type of structure they wish to use.
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

            if (option < 1 || option > 3) { // If you choose an option other than those available in the menu, a message will be displayed.
                System.out.println("Invalid option. Choose 1 to 3.");
            }

        } catch (NumberFormatException e) { // If you enter an option that is not an integer, a message will be displayed.
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
        // // Allows the user to define the storage capacity, set between 1 and 8, according to CA.
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
            // 
            if (structure == 1) { 
            stack = new FoodStack(size);
            } else if (structure == 2) {
            queue = new FoodQueue(size);
        }
        
        int choose;
        // Main menu of the system where the user can add, remove, display and search for items.
        // The information presented, as well as the operation of the system, is conditioned by the storage structure selected in the previous menu.
        do {
        System.out.println("Food Storage System");
            System.out.println("1. Add food");
            System.out.println("2. Remove food");
            System.out.println("3. Peek food");
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
         // All cases below will have their functionality affected according to the storage structure selected in the previous menu.   
        switch (choose) {
            case 1:
                String foodName;
                while (true) {
                System.out.println("Enter food name: ");
                foodName = input.nextLine();
                if (foodName.matches("[a-zA-Z]+( [a-zA-Z]+)*")) { // Allow only uppercase and lowercase letters and spaces.
                    break;
                }
                    System.out.println("Food name must contain lettes and space only.");
                    // If a break is not added to the operation, execution does not stop at the corresponding block and continues executing the code for all subsequent cases (even if they do not match the condition) until a break is encountered.
                }
                
                double foodWeight;
                while (true) {
                System.out.println("Enter food weight in grams: ");
                try {
                    foodWeight = Double.parseDouble(input.nextLine());
                    
                    if (foodWeight <= 0) { // Allows onlu numbers greater than 0
                    System.out.println("Food weight must be greater than 0.");
                    continue;
                }
                    break;
                
                }catch (NumberFormatException e) { // Display a message if the selected information is not a number.
                    System.out.println("Invalid weight. Enter a number.");
                    
                }
                }
                
                
                LocalDate bestBefore;
                LocalDate today = LocalDate.now();
                LocalDate maxBestBefore = today.plusWeeks(2);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

                while (true) {
                    System.out.println("Enter best before date (DD/MM/YYYY): ");
                    String dateInput = input.nextLine();

                try {
                     bestBefore = LocalDate.parse(dateInput, formatter);

                if (bestBefore.isBefore(today)) {
                    System.out.println("Best before cannot be in the past.");
                    continue;
                }

                if (bestBefore.isAfter(maxBestBefore)) {
                    System.out.println("Best before cannot be more than two weeks.");
                    continue;
                }

                break;

                } catch (java.time.format.DateTimeParseException e) {
                    System.out.println("Invalid date. Use DD/MM/YYYY.");
                }
                }

                
                LocalDateTime placedTime = LocalDateTime.now(); // Captures the current date and time
                
                FoodItem food = new FoodItem (foodName, foodWeight, bestBefore, placedTime);
                
                if (structure == 1) {
                stack.add(food);
                } else {
                queue.add(food);
                }
                break;
                
            case 2: // Remove item according to the selected structure.
                if (structure == 1) {
                stack.remove();
                } else {
                queue.remove();
                }
                break;
                
            case 3: // Select the item according to the selected structure.
                if (structure == 1) {
                FoodItem item = stack.peek();

                if (item != null) {
                System.out.println("Top food item is " + item.name);
                }
                } else {
                queue.peek();
                }
                break;
                
            case 4: // Display all items according to the selected structure.
                if (structure == 1) {
                stack.display();
                } else {
                queue.display();
                }
                break;
                
            case 5: // Search for the item according to the selected structure.
                System.out.println("Enter food name to search");
                String searchFood = input.nextLine();

                if (structure == 1) {
                stack.search(searchFood);
                } else {
                queue.search(searchFood);
                }
                break;
                
            case 6: // Search for the item according to the selected structure.
                System.out.println("Exit");
                break;
                
            default: // Display a message if you choose an option other than those available in the menu.
                System.out.println("Invalid Option! Choose 1 to 6");
        }
       
        }   while  (choose != 6); // The loop is executed until the condition is true.
        
        input.close();
    }
    }
