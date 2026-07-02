# Bug Report: Invalid Login Handling — Booking.com

| Field | Detail |
|---|---|
| Module | Authentication / Login |
| Prepared By | Senior Test Manager |
| Date Reported | July 2, 2026 |
| Environment | Production / Staging (Web & Mobile App) |
| Build/Release | v.Current |
| Status | Open |

---

## Summary

During functional and security regression testing of the Booking.com login module, multiple defects were identified in how the system handles invalid login attempts. These range from **incorrect error handling and misleading messaging** to **security-relevant gaps** (account lockout, brute-force protection, and information disclosure). This report documents each defect individually with severity, priority, and business impact so they can be triaged and assigned appropriately.

---

## Defect Log Overview

| Bug ID | Title | Severity | Priority |
|---|---|---|---|
| BKG-LOGIN-001 | Generic error message does not distinguish invalid email vs. invalid password | Medium | Medium |
| BKG-LOGIN-002 | No account lockout after repeated failed login attempts | Critical | High |
| BKG-LOGIN-003 | Login succeeds intermittently with invalid password (session token issued) | Critical | Highest |
| BKG-LOGIN-004 | Error message exposes backend stack trace on malformed input | High | High |
| BKG-LOGIN-005 | No CAPTCHA/rate-limiting triggered after multiple failed attempts | High | High |
| BKG-LOGIN-006 | UI does not clear password field after failed login on mobile app | Low | Low |

---

## BKG-LOGIN-001: Generic Error Message Does Not Distinguish Invalid Email vs. Invalid Password

**Environment:** Web — Chrome 126, Firefox 128, Safari 17 | Staging & Production

**Steps to Reproduce:**
1. Navigate to booking.com login page.
2. Enter a registered email with an incorrect password.
3. Click "Sign in."
4. Repeat with an unregistered email and any password.

**Expected Result:** A consistent, generic error message ("Invalid email or password") should be shown in both cases — this is actually the *secure* expected behavior. Note: this bug is logged because current messaging is inconsistent between the two cases (see Actual Result), not because a generic message is wrong in principle.

**Actual Result:** For an unregistered email, the system returns "This account does not exist," while for a registered email with wrong password, it returns "Incorrect password." This inconsistency allows account enumeration.

**Severity:** Medium (functional inconsistency with a security side effect)
**Priority:** Medium

**Business Impact:** Enables attackers to enumerate valid registered email addresses, which can be leveraged for targeted credential-stuffing or phishing campaigns against confirmed Booking.com users. Indirect reputational and compliance risk (GDPR data-minimization expectations).

**Suggested Fix:** Standardize both cases to a single generic message: "Invalid email or password."

---

## BKG-LOGIN-002: No Account Lockout After Repeated Failed Login Attempts

**Environment:** Web & Mobile App (iOS/Android) — Staging & Production

**Steps to Reproduce:**
1. Attempt to log in with a valid registered email and an incorrect password.
2. Repeat the failed attempt 20+ times in quick succession from the same IP/device.
3. Observe system behavior.

**Expected Result:** After a defined threshold (e.g., 5 failed attempts), the account should be temporarily locked, and/or additional verification (CAPTCHA, OTP) should be required.

**Actual Result:** No lockout, throttling, or additional verification is triggered even after 20+ consecutive failed attempts. The system allows unlimited retries.

**Severity:** Critical
**Priority:** High

**Business Impact:** Directly exposes user accounts to brute-force credential attacks. Given Booking.com stores stored payment methods, saved traveler details, and booking history, a successful compromise could lead to fraudulent bookings, financial loss to customers, chargebacks, and significant reputational damage. High risk of regulatory scrutiny (PCI-DSS, GDPR) if exploited at scale.

**Suggested Fix:** Implement progressive lockout (e.g., exponential backoff) and mandatory CAPTCHA after 3–5 failed attempts; alert account owner via email of suspicious login activity.

---

## BKG-LOGIN-003: Login Succeeds Intermittently With Invalid Password (Session Token Issued)

**Environment:** Web — Production (observed on 3 of 50 test attempts); could not reproduce on Staging

**Steps to Reproduce:**
1. Log in with a valid email and a deliberately incorrect password.
2. Repeat the attempt multiple times in a short window (rapid successive submissions).
3. Observe that on intermittent occasions, the system redirects to the authenticated dashboard and issues a valid session cookie/token despite incorrect credentials.

**Expected Result:** Login must fail 100% of the time when the password is incorrect; no session token should ever be issued.

**Actual Result:** In a small but repeatable percentage of rapid-retry attempts, the backend appears to issue a valid session token, granting access to the account dashboard. Suspected race condition between the authentication service and session-issuance service, possibly linked to cached prior successful sessions or a token-reuse bug under concurrent requests.

**Severity:** Critical (authentication bypass)
**Priority:** Highest — recommend immediate hotfix / emergency patch

**Business Impact:** This is the most severe defect in this report. An authentication bypass — even if intermittent — represents a fundamental breach of the security model, potentially allowing unauthorized account access without valid credentials. This carries legal, regulatory (PCI-DSS, GDPR/data breach notification), financial, and reputational risk at the highest level. Should be treated as a security incident and escalated to the security/incident response team in parallel with standard defect triage.

**Suggested Fix:** Engage backend/security engineering immediately to investigate session-issuance logic and race conditions under concurrent authentication requests. Recommend freezing related deployment changes until root cause is confirmed.

---

## BKG-LOGIN-004: Error Message Exposes Backend Stack Trace on Malformed Input

**Environment:** Web — Production

**Steps to Reproduce:**
1. On the login page, enter a specially crafted string in the email field (e.g., unescaped special characters or an overly long string).
2. Submit the login form.
3. Observe the response returned to the browser.

**Expected Result:** A generic, user-friendly error message should be displayed regardless of input malformation, with no internal system details exposed.

**Actual Result:** The response occasionally renders a raw backend exception/stack trace fragment in the browser, revealing internal service names, a partial file path, and framework version information.

**Severity:** High
**Priority:** High

**Business Impact:** Information disclosure of internal architecture aids attackers in reconnaissance for further exploitation (e.g., targeting known vulnerabilities in the disclosed framework version). Violates secure coding best practices (OWASP A05: Security Misconfiguration) and could affect security audit/compliance certifications.

**Suggested Fix:** Implement global exception handling to catch all malformed input errors and return sanitized, generic error responses. Disable verbose/debug error output in production.

---

## BKG-LOGIN-005: No CAPTCHA/Rate-Limiting Triggered After Multiple Failed Attempts

**Environment:** Web & Mobile App — Production

**Steps to Reproduce:**
1. Use an automated script (or manual rapid submission) to attempt login with random password combinations against a known valid email, at a rate of ~10 requests/second.
2. Monitor whether any CAPTCHA, rate-limiting, or IP-based throttling is triggered.

**Expected Result:** The system should detect abnormal request patterns and trigger CAPTCHA verification or temporarily block the requesting IP/device after a defined threshold.

**Actual Result:** No rate-limiting or bot-detection mechanism was triggered even at sustained high-frequency request rates.

**Severity:** High
**Priority:** High

**Business Impact:** Directly enables automated brute-force and credential-stuffing attacks at scale, compounding the risk identified in BKG-LOGIN-002. Increases infrastructure load/cost from abusive traffic and elevates risk of mass account compromise, which could trigger large-scale customer trust and financial-liability issues.

**Suggested Fix:** Integrate a bot-detection/WAF layer (e.g., rate-limiting per IP/device fingerprint) and CAPTCHA (e.g., reCAPTCHA v3) on the login endpoint.

---

## BKG-LOGIN-006: UI Does Not Clear Password Field After Failed Login on Mobile App

**Environment:** Mobile App — iOS 17, Android 14

**Steps to Reproduce:**
1. Open the Booking.com mobile app.
2. Enter a valid email and an incorrect password.
3. Tap "Sign in" and observe the error state.

**Expected Result:** After a failed login, the password field should be cleared (or at minimum, masked/reset) as per standard UX and security convention, prompting the user to re-enter it.

**Actual Result:** The previously entered (incorrect) password remains populated in the field after the error is shown. Not a security vulnerability, but inconsistent with standard login UX patterns and with the web version's behavior.

**Severity:** Low
**Priority:** Low

**Business Impact:** Minor UX inconsistency; unlikely to cause customer-facing harm but reflects inconsistent cross-platform experience, which can subtly affect user trust and app store review sentiment over time.

**Suggested Fix:** Clear the password field (or re-focus with field cleared) on the mobile app after any failed login attempt, matching web behavior.

---

## Overall Risk Assessment & Recommendation

| Bug ID | Severity | Priority | Recommended Action |
|---|---|---|---|
| BKG-LOGIN-003 | Critical | Highest | Escalate as security incident; hotfix immediately |
| BKG-LOGIN-002 | Critical | High | Fix in next sprint; treat as release blocker |
| BKG-LOGIN-005 | High | High | Fix alongside BKG-LOGIN-002 (related root cause: no throttling) |
| BKG-LOGIN-004 | High | High | Fix before next production release |
| BKG-LOGIN-001 | Medium | Medium | Fix in upcoming regular release cycle |
| BKG-LOGIN-006 | Low | Low | Backlog; fix opportunistically |

**Test Manager's Note:** BKG-LOGIN-003 and BKG-LOGIN-002/005 collectively represent a systemic gap in authentication security controls rather than isolated bugs. I recommend a joint review with the Security and Backend Engineering teams before the next release sign-off, and that BKG-LOGIN-003 be logged simultaneously in the security incident tracker (not just the QA bug tracker) given its severity.

---

## Attachments (to be added by tester)
- Screenshots of error messages (BKG-LOGIN-001, 004)
- HAR file / network trace of session token issuance (BKG-LOGIN-003)
- Load test script and results log (BKG-LOGIN-005)
- Screen recordings (BKG-LOGIN-006)

## Sign-off

| Name | Role | Date |
|---|---|---|
| _____________ | QA/Test Manager | _______ |
| _____________ | Engineering Lead | _______ |
| _____________ | Security Lead | _______ |
