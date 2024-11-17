## **Test Case 1: Verify Homepage Loads Successfully**
- **Test Case ID:** TC001
- **Objective:** Ensure that the homepage loads correctly.
- **Preconditions:**
  - Browser is installed.
  - Application URL (`https://automationexercise.com`) is accessible.
- **Test Steps:**
  1. Launch the browser.
  2. Navigate to the URL `https://automationexercise.com`.
  3. Verify that the homepage is visible by checking the title or a key element (e.g., logo or header).
- **Expected Result:** 
  - The homepage loads successfully, and the title is `"Automation Exercise"`.
- **Postconditions:** 
  - Browser remains open on the homepage.

---

## **Test Case 2: Verify Product Details Page Opens**
- **Test Case ID:** TC002
- **Objective:** Ensure that clicking on a product's "View Product" link navigates to the product details page.
- **Preconditions:**
  - Homepage is loaded successfully (TC001 passed).
- **Test Steps:**
  1. Hover over a product on the homepage.
  2. Click the "View Product" link for the selected product.
  3. Verify that the product details page is displayed.
- **Expected Result:** 
  - The product details page opens, displaying relevant product information such as name, price, and description.
- **Postconditions:** 
  - Browser remains on the product details page.

---

## **Test Case 3: Verify Product Quantity Can Be Increased**
- **Test Case ID:** TC003
- **Objective:** Ensure the product quantity can be adjusted on the product details page.
- **Preconditions:**
  - Product details page is loaded successfully (TC002 passed).
- **Test Steps:**
  1. Locate the quantity input field.
  2. Increase the quantity to 4 using the arrow keys or direct input.
  3. Verify that the quantity field reflects the updated value.
- **Expected Result:** 
  - The quantity field displays the value `4`.
- **Postconditions:** 
  - Browser remains on the product details page.

---

## **Test Case 4: Verify Product Can Be Added to Cart**
- **Test Case ID:** TC004
- **Objective:** Ensure the selected product can be added to the cart.
- **Preconditions:**
  - Product quantity is set correctly (TC003 passed).
- **Test Steps:**
  1. Click the "Add to Cart" button.
  2. Wait for the confirmation modal to appear.
  3. Click the "View Cart" button in the modal.
- **Expected Result:** 
  - The cart page opens, displaying the added product.
- **Postconditions:** 
  - Browser remains on the cart page.

---

## **Test Case 5: Verify Product Quantity in Cart**
- **Test Case ID:** TC005
- **Objective:** Ensure the correct product quantity is displayed in the cart.
- **Preconditions:**
  - Product is added to the cart (TC004 passed).
- **Test Steps:**
  1. Locate the product in the cart.
  2. Check the displayed quantity for the product.
  3. Compare the displayed quantity with the selected quantity.
- **Expected Result:** 
  - The cart displays the correct product with a quantity of `4`.
- **Postconditions:** 
  - Browser remains on the cart page.

---

## **Optional Test Case: Verify Cleanup (Teardown)**
- **Test Case ID:** TC006
- **Objective:** Ensure the test environment is reset after the test run.
- **Preconditions:**
  - All prior test cases are completed.
- **Test Steps:**
  1. Close the browser.
- **Expected Result:** 
  - The browser closes without errors.
- **Postconditions:** 
  - Test environment is clean for the next run.
