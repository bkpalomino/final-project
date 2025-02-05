Readme.md Version# 2023.05.30 (INEW-2330 and INEW-2332 Version)

![BeatBox POS Logo](/Icons/smallLogo.png "Logo Icon for BeatBox POS")

# BeatBoxPOS
A Point of Sales software that centralizes all business procedures, making them easily accessible to staff and customers. The system will have three major roles: customers, employees, and managers. Customers can browse products and make purchases. Employees can manage data and assist customers. Managers can oversee operations, generate reports, and manage promotions.

## Detailed Description

The objective of this project is to create software that consolidates all business operations into a single, accessible platform for both staff and customers. Users can log in or register a new account. Customers can browse products using search and filters, add items to a shopping cart, and checkout, receiving receipts and managing their profiles. Employees and managers can handle sales, payments, order estimates, and manage the checkout process, including applying promo codes. They can also manage customer and product data. Managers have additional capabilities, such as generating detailed reports on products, customers, employees, and inventory statistics.

The scope of this project is to develope software aimed at increasing business efficiency and customer satisfaction. The software will identify and address areas lacking efficiency, provide a user interface to visualize and manage business procedures, and automate tasks such as sales reporting, data updates, and data creation.

There are several limitations, including tight budget and time constraints that may increase errors. Integration issues such as inconsistent data, performance problems, and compatibility conflicts could arise. Technical risks include server overloading, scalability issues, network dependencies, and compatibility with older systems. Environmental and market risks, such as economic fluctuations, new legislation, and market share changes, could impact the project. Additionally, unplanned features or requirement changes, insufficient resources, and unexpected expenses like equipment failure or additional fees may affect the timeline and budget.

### Inventory and Inventory Control

For this project, the inventory will include a wide variety of musical instruments, sheet music/books, and accessories. For each of these items, they will have unique identifiers (IDS), description, price, category, and stock level. In order to avoid an unlimited inventory, the maximum quantities for each product will be set based on storage capacity and demands. Using the inventory management system, safe points will be set to warn about low/high stock, which will ensure stock levels stay at the appropriate level.

Customers will be able to shop from a wide variety of music products. To be more specific these products include guitars, drums, brass instruments, pianos, guitar strings, drumsticks, music stands, and beginner book.

A sample item would be a Guitar with the following elements: Name(Acoustic Guitar), Description(High-quality acoustic guitar), Price($300), Category(Instruments), Stock(15).

At a minimum the inventory will contain the following fields/data: Item ID, Item Name, Description, Price, Category, Stock Level, Reorder Point, Max Stock Level.

#### Acoustic Guitar
Field | Data
------|------
Item Name | Acoustic Guitar
Item Description| A high-quality acoustic guitar
Category| Instruments
Retail Price| $500
Cost| $250
Quantity| 15
Restock Threshold| 3
Image| Blob
Discontinued| False

### Project Introduction

- This project aims to create software that centralizes all business operations for a music store, making it easy for staff and customers to access.
- The goals of the software is to increase business efficiency and customer satisfaction by streamlining inventory managment, sales processes, and customer interactions.
- The software is designed with the user in mind, ensuring ease of use for both staff and customers with easy to use interfaces and straightforward navigation.
- Most innovative features:
  - Customer Experience: Browse products, add to cart, and checkout smoothly.
  - Employee and Manager Tools: Manage product and customer data, process sales, and generate reports seamlessly.
  - Promotional Managment: Create and apply promotional codes.
  - Comprehensive Inventory: Track and manage instruments, accessories, and sheet music.
  - Detailed Reporting: Generate reports on sales, inventory, customer, and employee data.
- **Development Status: Manager View**
- **Screenshots/Demo:** <br>
![Customer View](/Icons/3.png "Screenshot of Manager View")

### Development Plan - Time Table
#### Below is the development time table and planned benchmarks/milestones to accomplish this project by the due date.
Date | Items | Description
-----|-------------|--------------
9/24/24 | Project Proposal submitted | Proposal for consideration.
10/01/24 | Logon View | Initial design and development of the logon view. 
10/15/24 | Customer View | Development of customer view features.
10/29/24 | Manager View | Development of manager view features.
11/12/24 | Polish/Final Submission | Final review and adjustments based on feedback.

### To do's
- [x] Logon View (Complete)
  - [x] Create Logon Page
  - [x] Create Account Creation Page
  - [x] Create Password Reset Forms
- [x] Customer View (Complete)
  - [x] Products/Browsing Page
  - [x] Shopping Cart Page
  - [x] Checkout Page
- [x] Manager View (Up Next)
  - [x] User Management
  - [x] Promotional Code Management
  - [x] Inventory Management
  - [x] Report Management

### Development Environment

Type | Description
-----|-------------
Language | Java
Development Environment | Netbeans
SQL Server Type/Dialect | MySql
Target Environment | Windows 11 <br>Desktop Application
Target Business/Industry | Retail
Help System | Context Sensitive PDF Help Files
Report Methods | HTML Reports
Project Version Control | Git and Course assigned GitHub Repository

### Getting Started/Requirements/Prerequisites/Dependencies
Include any essential instructions for:
- Windows computer
- Java installed on you computer
- Download the software
- Use default manager account to get started

### Videos 
- Project Proposal - [Video Proposal](https://drive.google.com/drive/folders/1nvw3sr5PrDchza6IyEFcyoX6zq8HcLSP?usp=sharing)
- Logon View [Video for Logon View](https://drive.google.com/drive/folders/1tUV2RVaq95zESLRcFANaclcoupHlAHuv?usp=sharing)
- Customer View [Video for Customer View](https://drive.google.com/drive/folders/1u3e3is_nAO31WLQrrr1avaFfdVpSPLAv?usp=sharing)
- Manager View [Video for Manager View](https://drive.google.com/drive/folders/1PtXiuqEscbF2EzWtI_1f34mo5v1YOZR0?usp=sharing)
- Video Resume [Must Update with URL at each Pull Request approval]
- Final Client Demonstration Video [Must Update with URL at each Pull Request approval]
- URL for any other specific videos for this product [Must Update with URL at each Pull Request approval, if applicable]

### Contact

Contact | Information
--------|------
Name | Braeden Palomino
Email | braedenpal09@gmail.com
[Social Media Name] | [Your Social Media link(s) (if applicable)]

### [License](/LICENSE)

GNU General Public License v3.0

Permissions of this strong copyleft license are conditioned on making available complete source code of licensed works and modifications, which include larger works using a licensed work, under the same license. Copyright and license notices must be preserved. Contributors provide an express grant of patent rights.
