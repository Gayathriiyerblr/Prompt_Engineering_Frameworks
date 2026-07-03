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


**Company/Organization Accounts:** Multiple users tied to one company account (not just individual profiles)
**Role-Based Access Control (RBAC):** Different permissions: buyer, approver, admin, procurement manager
**Multi-level Approval Workflows:** Purchase requests need manager/finance sign-off before order is placed
**Custom/Contract Pricing:** Negotiated, tiered, or customer-specific pricing (not one price for everyone)
**Bulk Ordering / Quick Order Pad:** Order via SKU/CSV upload, large quantity ordering
**Quote Management (RFQ):** Request for Quote workflow instead of direct buy
**Credit Terms \& Invoicing (Net 30/60/90):** Buy-now-pay-later style billing, not just instant payment
**Multiple Shipping Addresses / Ship-to Locations:** Company may ship to many warehouses/branches
**Account-based Catalogs:** Different companies see different product sets/pricing (catalog segmentation)
**Punchout/ERP Integration:** Integration with buyer's procurement systems (e.g., SAP Ariba, Coupa)
**Minimum Order Quantity (MOQ) Rules:** Enforce bulk-order thresholds
**Account Management / Sales Rep Assignment:** Dedicated rep tied to a company account
**Tax Exemption Handling:** Business buyers often exempt from certain taxes (resale certificates)
**Contract \& SLA Management:** Long-term agreements, delivery SLAs
**Reports \& Analytics:** Integration with 3rd Part systems





B2B Key Workflow (Business Buying Journey)

1. Account Setup / Onboarding
→ Company registration → Verification (business docs/tax ID) → Approval
→ Assign roles (buyer, approver, admin)
2. Login (Company Account)
→ User logs in under organization account → Role-based dashboard/catalog view
3. Product Discovery
→ Account-specific catalog → Contract/tiered pricing shown → Bulk search (SKU/CSV)
4. Quote Request (optional path)
→ Request for Quote (RFQ) → Vendor/sales rep responds → Negotiation → Quote approval
5. Cart / Bulk Order
→ Add items (often via quick-order pad or bulk upload)
→ MOQ(Minimum Order Quantity) validation → Contract pricing applied automatically
6. Approval Workflow
→ Order routed to approver(s) based on value/threshold
→ Manager/finance approves or rejects → Escalation if needed
7. Checkout
→ Choose ship-to location (from multiple addresses)
→ Choose payment terms: credit (Net 30/60/90), PO number, or direct payment
→ Tax exemption handling (if applicable)
8. Order Processing
→ PO(Purchase Order) generation → ERP/punchout sync (SAP Ariba, Coupa, etc.)
→ Order confirmation sent to buyer + procurement team
9. Fulfillment \& Invoicing
→ Delivery to multiple locations → Invoice generation → Payment reconciliation
10. Post-Purchase / Account Management
→ Order history per user/company → Reorder → Dedicated account manager/sales rep
→ Contract renewal, SLA tracking, dispute resolution



Task | Action   **Task:** Write a comprehensive test suite covering in the folder src :

1. Smoke tests for critical paths (login, RFQ,Checkout)
2. Functional tests for each major module (Login, )RFQ, Approval Workflow,Checkout,Order Processing,FulFillment \& Invoicing)
3. Integration tests for third-party integrations (Social Login, Payment gateways,Shipping/Logistics,Tax Calculation,Email/SMS Notifications,Analytics,Search Engine,Chat/Support.)
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

