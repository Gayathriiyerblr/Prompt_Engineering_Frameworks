**Vague Prompt:**



## Write some tests for the app.

* Role
* Context
* Task | Action
* Constraints
* Format / Output
* Examples (Optional)
* Anti Hallucination
**Write your improved prompt below:**

<<>>

Role-  You are a Senior QA Manager or an Architect with almost 15 years' experience with functional testing as well as known functional testing. The task is to basically test an application which is https://www.bstackdemo.com/, which is the largest A/B testing tool in the world.

Context <<context\_project.md\_bstackdemo.MD>>   I need to test bstack (Ecommerce website) at https://www.bstackdemo.com/ - a comprehensive ecommerce platform. The application includes these core modules: - e-commerce site — a product catalog with login, filters, sorting, cart, favourites, and checkout -  
**Personalize:** Targeted audiance based on visitor segments -
**Conversion (Form Analytics):** Cart Abondoment,Traffic, funnel, conversion tracking  
**Dashboard:** Account management,Address Book, Contact Details,Orders
**Promotions/Coupons/Loyalty Points:** Flash sales, discount codes, cashback, loyalty programs
**Guest Checkout:** B2C buyers want frictionless, fast purchase without mandatory signup
**Wishlist/Favourites:** Personal shopping list for individual consumers
**Personalized Recommendations:** "You may also like," recently viewed — driven by browsing behavior
**Reviews \& Ratings:** Social proof matters heavily for individual buying decisions
**Simple Pricing:** Fixed, publicly visible price per SKU
**Social Login/Share:** Login via Google/Facebook; share products on social media



Key workflows include: - B2C

1. Landing/Browse
→ Homepage, categories, banners, search
2. Product Discovery
→ Search / filter / sort → Product Listing Page (PLP)
3. Product Evaluation
→ Product Detail Page (PDP): images, price, reviews, variants (size/color)
4. Add to Cart
→ Select quantity/variant → Add to cart → Mini-cart preview
5. Cart Review
→ View cart → Apply coupon/promo → Update quantity → Subtotal calc
6. Checkout (often guest-allowed)
→ Login/Guest checkout → Shipping address → Delivery method → Payment
→ Order review → Place order
7. Payment Processing
→ Card/wallet/UPI/COD → Payment gateway → Success/failure handling
8. Order Confirmation
→ Confirmation page/email/SMS → Order ID generated
9. Post-Purchase
→ Order tracking → Delivery → Returns/refund → Review/rating submission
10. Retention Loop
→ Loyalty points, personalized recommendations, re-engagement emails





Task | Action   **Task:** Write a comprehensive test suite covering in the folder src :

1. Smoke tests for critical paths (login, Order creation, Checkout)
2. Functional tests for each major module (Login, Search, PDP,Add To Cart,View Cart,Checkout,Add Discounts,View orders)
3. Integration tests for third-party integrations (Social Login, Payment gateways,Shipping/Logistics,Email/SMS Notifications,Analytics,Search Engine,Chat/Support.)
4. UI/UX validation tests for the campaign editor (WYSIWYG editor functionality)
5. API tests for bstack API endpoints
6. Edge cases: invalid inputs, permission boundaries, concurrent edits





**Constraints:** - Use Playwright as the primary automation framework

* Implement Page Object Model (POM) for maintainability
* Tests must be environment-agnostic (support staging and production configs)
* Handle dynamic elements and async loading states properly
* Include data cleanup in teardown to avoid test pollution
* Do not hardcode credentials;
use environment variables
* Tests should complete within reasonable timeouts (max 30s per test)





**Format:** Organize the test suite in this structure:

* Anti Hallucination - context\_constraints.md `

