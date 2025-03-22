@web
  Feature: Cart & Order

    Scenario: Remove product from cart
      Given user login with username "shafa" and password "shafa"
      When user add product "Sony vaio i5" to the cart
      When user navigate to the cart page
      Then user should see product "Sony vaio i5" on the cart page
      Then user remove the first product
      Then user back to home page
      And user navigate to the cart page
      Then user should NOT see "Sony vaio i5" on the cart page

    Scenario: Place Order
      Given user login with username "shafa" and password "shafa"
      When user add product "Nexus 6" to the cart
      When user navigate to the cart page
      Then user should see product "Nexus 6" on the cart page
      Then user click place order button
      And user should see place order modal
      Then user should input order details
      And click purchase button
      Then success purchase modal is shown