# Cards Consolidator

**Cards Consolidator** is a simple yet powerful tool designed to help users keep track of all the plastic payment cards they own, including credit cards, debit cards, and points cards. With this project, users can easily view, manage, and store information about their payment cards in one place.

## Features

- **Track Different Cards:** Easily store details of various types of cards such as credit, debit, and points cards.
- **Secure Card Data:** Securely manage your card details such as card type, cardholder name, expiration date, and more.
- **Manage Data with MySQL:** Store and retrieve card details with MySQL database and JDBC (Java Database Connectivity).
- **Java-Based Application:** Built using Java, making it platform-independent.
- **Simple Interface:** A user-friendly interface to interact with your card data.

## Technologies Used

- **Java:** The main programming language used to build the project.
- **MySQL:** Database used to store and manage card information.
- **JDBC (Java Database Connectivity):** Used to interact with the MySQL database and perform CRUD operations.

## Installation

### Prerequisites

To run the **Cards Consolidator** project, make sure you have the following installed on your system:

- Java 8 or later
- MySQL server
- JDBC driver for MySQL

### Steps to Install

1. **Clone the Repository:**

   Clone the repository to your local machine using the following command:

   ```bash
   git clone https://github.com/your-username/cards-consolidator.git
   ```

2. **Setup MySQL Database:**

   - Create a MySQL database and user for storing card data.
   - Import the database schema from the `cards_consolidator.sql` file located in the repository.

   Example:

   ```sql
   CREATE DATABASE cards_consolidator;
   USE cards_consolidator;

   -- Import the schema or create tables for storing card details
   ```

3. **Configure Database Connection:**

   - Open the `DatabaseConfig.java` file.
   - Update the database URL, username, and password based on your MySQL configuration.

4. **Build and Run the Application:**

   - Compile the Java project.
   - Run the application using your preferred IDE (e.g., IntelliJ IDEA, Eclipse) or from the command line.

   ```bash
   javac -d bin src/*.java
   java -cp bin CardsConsolidator
   ```

   You can now start interacting with the app and track your cards!

## Usage

- **Add a New Card:**
  - Select "Add Card" from the main menu.
  - Enter card details such as card type (credit/debit), cardholder name, card number, expiration date, etc.
  - Click "Save" to store the card details in the database.

- **View Existing Cards:**
  - Select "View Cards" to see a list of all stored cards.
  - Filter the cards by type, expiration date, or cardholder name.

- **Edit or Delete Cards:**
  - Select any card from the list to edit its details.
  - You can also delete a card if it is no longer needed.

## Example

### Adding a New Card:

```text
Card Type: Credit
Cardholder: John Doe
Card Number: 1234-5678-9876-5432
Expiration Date: 12/24
```

Once entered, the card will be saved and visible in your card list.
