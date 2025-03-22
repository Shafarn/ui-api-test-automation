@web
  Feature: Dashboard

    Scenario: Show Product Detail Page
      Given user login with username "shafa" and password "shafa"
      When user click product with title "Nexus 6"
      Then user will navigate to product detail

    Scenario: Add product to cart - success
      Given user login with username "shafa" and password "shafa"
      When user click product with title "Nexus 6"
      Then user will navigate to product detail
      When user click add to cart
      Then alert will show "Product added."

    Scenario: Add product to cart - undefined product
      Given user login with username "shafa" and password "shafa"
      When user go to this url "https://www.demoblaze.com/prod.html?idp_=99"
      When user click add to cart
      Then alert will show "Bad parameter, token malformed."