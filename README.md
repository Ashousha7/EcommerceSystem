# EcommerceSystem
E-Commerce OOP System Design

🛒 E-commerce System
📌 Project Description
A simple E-commerce system designed in Java to:

Define products with name, price, quantity.

Support perishable products (e.g. Cheese, Biscuits) with expiry.

Support shippable products with weight (e.g. Cheese, TV).

Allow customers to add products to cart with quantity limits.

Provide checkout functionality with:

Subtotal calculation

Shipping fees calculation

Paid amount (subtotal + shipping)

Customer balance update

Error handling for:

Empty cart

Insufficient balance

Expired or out of stock products

Integrate with ShippingService to handle shipping for products implementing Shippable interface.

💻 Features
✔️ Define products (name, price, quantity)
✔️ Differentiate between expired/non-expired products
✔️ Differentiate between shippable/non-shippable products
✔️ Cart supports adding items with limited quantity
✔️ Checkout with clear receipt:

Item details

Subtotal

Shipping fees

Total amount

Updated balance
✔️ ShippingService accepts List of Shippable items, prints names & total weight.

🏗️ Design Overview
1. Product Class (Superclass)
Fields: name, price, quantity

Methods: getters

2. ExpiredProduct Class (extends Product)
Additional Field: expiryDate

Method: isExpired() returns true if expired

3. Shippable Interface
Defines:

java
Copy
Edit
String getName();
double getWeight();
4. ShippedProduct Class (extends Product implements Shippable)
Additional Field: weight

Implements getName() and getWeight()

5. CartItem Class
Fields: Product, quantity

6. Cart Class
List of CartItem

Methods:

add(Product, quantity)

getItems()

7. ShippingService Class
Method ship(List<Shippable> items)

Prints each item's name & weight

Calculates total weight

8. Customer Class
Fields: name, balance

9. Checkout Function
Checks:

Empty cart

Expired products

Out of stock

Insufficient balance

Prints:

Shipment notice

Checkout receipt (item x qty, subtotal, shipping, total, balance)
