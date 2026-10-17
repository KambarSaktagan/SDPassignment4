# Assignment 4: Facade Pattern - Online Order Processing
**Author:** Kambar Saktagan  

## Overview
This repository contains a Java implementation of the Facade structural design pattern, fulfilling Option B of the assignment. The system simulates an e-commerce backend where a single `OrderFacade` simplifies client interactions with a complex subsystem

## Architecture
* **Client (`Main.java`):** Interacts solely with the `OrderFacade` to place and cancel orders, remaining completely decoupled from the underlying services.
* **Facade (`facade/OrderFacade.java`):** Provides a unified, simplified API (`placeOrder` and `cancelOrder`). It orchestrates the correct sequence of subsystem operations and handles rollback logic (e.g., releasing reserved stock if payment fails).
* **Subsystems (`subsystem/`):** Contains independent services (`InventoryService`, `PaymentProcessor`, `ShippingService`, `NotificationService`) that execute specific domain logic without any back-references to the Facade
* **Models (`model/`):** Utilizes Java 17 records (`Cart`, `Customer`) for immutable data transfer

## Execution Instructions
1. Clone the repository and open the `SDPassigment4` project folder in IntelliJ IDEA.
2. Ensure the project SDK is set to **Java/JDK 17**
3. Run the `Main.java` file to execute the simulated order placement and cancellation workflows in the console.
