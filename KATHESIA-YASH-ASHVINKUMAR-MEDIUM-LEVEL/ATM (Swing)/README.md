# ATM Project using Java Swing

## Overview
This project is a simulation of an Automated Teller Machine (ATM) using Java Swing. It allows users to perform basic banking operations such as querying account information, withdrawing and depositing money, and transferring funds between accounts.

## Features
- **Account Query:** Check the balance of your account.
- **Withdrawal:** Withdraw money from your account.
- **Deposit:** Deposit money into your account.
- **Fund Transfer:** Transfer money to another account.

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yash-kathesia/CSEdge-Java-Programming-Internship.git
   ```
2. Navigate to the `ATM (Swing)\dist\` directory.
3. Execute the jar file: `java -jar ATMInterface.jar`.

## Usage
1. Launch the application.
2. Enter your ATM PIN to start.
3. Use the provided buttons to perform various banking operations.
   - **Query Account:** Click on the 'View Balance' button to check your account balance.
   - **Withdraw:** Click on the 'Withdraw' button, enter the amount, and confirm to withdraw money.
   - **Deposit:** Click on the 'Deposit' button, enter the amount, and confirm to deposit money.
   - **Fund Transfer:** Click on the 'Transfer' button, enter the recipient's account number and the amount, and confirm to transfer money.


## Video Explanation
For a detailed explanation of the project, please refer to the [video]().

## Code Overview
### Main Classes
- `ATMInterface.java`: The main class that initializes the GUI and handles user interactions.
- `Account.java`: A class representing a bank account with methods to deposit, withdraw, and transfer funds.
- `Bank.java`: A class managing multiple accounts and handling operations like login and account lookup.

### GUI Components
- **Frames:** Used for the main application window.
- **Panels:** Organized the layout of different sections.
- **Labels:** Displayed text information.
- **Text Fields:** Allowed user input.
- **Action Listeners:** Responded to user actions like button clicks.

### Basic Flow
1. User logs into their account by entering their ATM PIN.
2. The main menu displays options for different banking operations.
3. User selects an operation, performs it, and the application updates the account information accordingly.

## Contributing
Contributions are welcome! If you have suggestions or improvements, please fork the repository and submit a pull request.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact
For any inquiries or issues, please contact me at [yashkathesia@gmail.com](mailto:yashkathesia@gmail.com).

---

Thank you for checking out my ATM project using Java Swing!

```